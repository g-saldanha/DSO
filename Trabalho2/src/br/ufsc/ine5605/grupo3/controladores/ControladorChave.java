package br.ufsc.ine5605.grupo3.controladores;

import java.util.ArrayList;
import java.util.Calendar;

import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaChaves;
import br.ufsc.ine5605.grupo3.apresentacaoJFrame.Exception.CadastroBloqueadoException;
import br.ufsc.ine5605.grupo3.entidades.Cargo;
import br.ufsc.ine5605.grupo3.entidades.Chave;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

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
		if (!this.checkExists(placa)) {
			this.chaves.botar(new Chave(placa));
		}
	}

	public void deletarChave(Long id) {
		if (this.pegaChavePorId(id) != null && !this.pegaChavePorId(id).isAlugada()) {
			chaves.remove(this.pegaChavePorId(id));
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

	public Funcionario pegaFuncionario(Integer matricula) {
		return ControladorPrincipal.getInstance().pegaFuncionario(matricula);
	}

	public int cederChave(Funcionario f, Chave c) throws CadastroBloqueadoException {
		if (f.getBloqueado()) {
			this.adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f, null,
					false, "Retirada : Usuario Bloqueado");
			throw new CadastroBloqueadoException("Usuario");
		}

		if (f.getChave() == null) {
			if (f.getCargo() == Cargo.DIRETORIA || f.checaPlacas(c)) {
				if (c.isAlugada()) {
					this.adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
							ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), false, "Retirada : Acesso a chave previamente alugada");
					return -4;
				}

				f.setChave(c);
				c.setAlugada(true);
				this.chaves.persiste();
				this.adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
						ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), true, "Retirada : Acesso Permitido ao Veiculo");
				f.resetCounter();
				return 0;
			} else {
				this.adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
						ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), false, " Retirada : Funcionario nào possui acesso ao veiculo escolhido");
				f.addCounter();
				return -1;
			}
		} else {
			this.adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
					ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), false, "Retirada : Funcionario já possui uma chave alugada");
			return -2;
		}
	}

	public int devolverChave(Funcionario f, Chave c) {
		f.setChave(null);
		c.setAlugada(false);
		this.adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
				ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), true, "Devolucao : Chave devolvida com sucesso");
		return 0;

	}

	public void adicionarRegistro(Integer date, Integer mes, Integer hours, Funcionario f, Veiculo v, boolean b, String string) {
		ControladorPrincipal.getInstance().adicionarRegistro(GeradorId.getNextRegisterID(), date, mes, hours, f, v, b, string);
	}

	public void bloquearFuncionario(Funcionario f) {
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
