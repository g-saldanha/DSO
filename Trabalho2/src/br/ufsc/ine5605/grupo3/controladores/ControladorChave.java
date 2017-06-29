package br.ufsc.ine5605.grupo3.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaChaves;
import br.ufsc.ine5605.grupo3.apresentacaoJFrame.Exception.CadastroBloqueadoException;
import br.ufsc.ine5605.grupo3.entidades.Cargo;
import br.ufsc.ine5605.grupo3.entidades.Chave;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;
import br.ufsc.ine5605.grupo3.mensagens.Messages;

public class ControladorChave {
	private static ControladorChave instance;
	private static ChavesDAO chaves;
	private TelaChaves telaChaves;

	private ControladorChave() {
		this.telaChaves = new TelaChaves();
		this.chaves = new ChavesDAO();
	}

	public static ControladorChave getInstance() {
		if (instance == null) {
			instance = new ControladorChave();
		}

		return instance;
	}

	public void adicionarChave(String placa) {
		if (!checkExists(placa)) {
			this.chaves.botar(new Chave(placa));
		}
	}
// Arrumar método
	public void deletarChave(Long id, Integer m) {
		if (pegaChavePorId(id) != null && !pegaChavePorId(id).isAlugada()) {
			chaves.remove(pegaChavePorId(id));
		}
	}

	private Chave pegaChavePorId(Long id) {
		for (Chave c : chaves.getChaves()
		     ) {
			if (c.getID().equals(id)){
				return c;
			}
		}
		return null;
	}

	public ArrayList<Chave> getChaves() {
		return chaves.getChaves();
	}

	public boolean checkExists(String placa) {
		for (Chave c : chaves.getChaves()) {
			if (c.getPlaca().equals(placa)) {
				return true;
			}
		}
		return false;
	}

	public Chave getChave(Long id) {
		for (Chave c: chaves.getChaves()
		     ) {
			if (c.getID().equals(id)) {
				return c;
			}

		}
		return null;
	}

	public void exibeTelaChave() {
		this.telaChaves.atualizaLista();
		this.telaChaves.setVisible(true);
	}

	public Funcionario pegaFuncionario(Integer matricula) throws IOException {
		return ControladorPrincipal.getInstance().pegaFuncionario(matricula);
	}

	public String cederChave(Funcionario f, Chave c) throws CadastroBloqueadoException, IOException {
		if (f.getBloqueado()) {
			adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f, null,
					false, "Retirada : Usuario Bloqueado");
			throw new CadastroBloqueadoException("Usuario");
		}

		if (f.getChave() == null) {
			if (f.getCargo() == Cargo.DIRETORIA || f.checaPlacas(c)) {
				if (c.isAlugada()) {
					adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
							ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), false, "Retirada : Acesso a chave previamente alugada");
					return  Messages.CHAVE_ALUGADA;
				}

				f.setChave(c);
				c.setAlugada(true);
				this.chaves.persiste();
				adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
						ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), true, "Retirada : Acesso Permitido ao Veiculo");
				f.resetCounter();
				return  Messages.CHAVE_LIBERADA;
			} else {
				adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
						ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), false, " Retirada : Funcionario nào possui acesso ao veiculo escolhido");
				f.addCounter();
				return Messages.formatString(Messages.CHAVES_R1, f.getNome());
			}
		} else {
			adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
					ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), false, "Retirada : Funcionario já possui uma chave alugada");
			return Messages.formatString(Messages.CHAVES_R2, f.getNome());
		}

	}

	public int devolverChave(Funcionario f, Chave c) throws IOException {
		f.setChave(null);
		c.setAlugada(false);
		adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
				ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), true, "Devolucao : Chave devolvida com sucesso");
		return 0;

	}

	public void adicionarRegistro(Integer date, Integer mes, Integer hours, Funcionario f, Veiculo v, boolean b, String string) throws IOException {
		ControladorPrincipal.getInstance().adicionarRegistro(GeradorId.getNextRegisterID(), date, mes, hours, f, v, b, string);
	}

	public void bloquearFuncionario(Funcionario f) throws IOException {
		ControladorPrincipal.getInstance().bloquearFuncionario(f);

	}

	public void voltarMenuPrincipal() {
		ControladorPrincipal.getInstance().voltarMenuPrincipal();
	}


	public Chave getChave(String placa) {
		for (Chave c : chaves.getChaves()){
			if(c.getPlaca().equals(placa)){
				return c;
			}
		}
		return null;
	}
}
