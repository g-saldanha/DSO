package br.ine5605.ufsc.controladores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import br.ine5605.ufsc.apresentacao.TelaChave;
import br.ufsc.ine5605.entidades.Chave;
import br.ufsc.ine5605.entidades.Funcionario;
import br.ufsc.ine5605.entidades.Veiculo;
import br.ufsc.ine5605.entidades.Funcionario.Cargo;

public class ControladorChave {
	private static ControladorChave instance;
	private static ArrayList<Chave> chaves;
	private TelaChave telaChave;

	private ControladorChave() {
		this.chaves = new ArrayList<>();
		telaChave = new TelaChave(this);
	}

	public static ControladorChave getInstance() {
		if (instance == null)
			instance = new ControladorChave();

		return instance;
	}

	public void adicionarChave(String placa) {
		if (checkExists(placa) == -1) {
			chaves.add(new Chave(placa));
		}
	}

	public void deletarChave(String placa) {
		int index = checkExists(placa);

		if (index != -1) {
			chaves.remove(index);
		}
	}

	public void exibirChaves() {
		int index = 0;
		for (Chave c : chaves) {
			telaChave.exibeTelaExibicao(c, index);
			index++;
		}
	}

	public ArrayList<Chave> getChaves() {
		return chaves;
	}

	public int checkExists(String placa) {
		int index = 0;
		for (Chave c : chaves) {
			if (c.getPlaca().equals(placa)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public Chave getChave(String placa) {
		int index = checkExists(placa);

		return index != -1 ? chaves.get(index) : null;
	}

	public void exibeTelaChave() {
		telaChave.exibirTela();
	}

	public Funcionario pegaFuncionario(int matricula) {
		return ControladorPrincipal.getInstance().pegaFuncionario(matricula);
	}

	public int cederChave(Funcionario f, Chave c) {
		if (f.getBloqueado()) {
			adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(),
					Calendar.getInstance().getTime().getHours(), f, null, false, "Retirada : Usuario Bloqueado");
			return -3;
		}

		if (f.getChave() == null) {
			if (f.checaPlacas(c) || f.getCargo() == Cargo.DIRETORIA) {
				f.setChave(c);
				c.setAlugada(true);
				adicionarRegistro(Calendar.getInstance().getTime().getDate(),
						Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
						ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), true,
						"Retirada : Acesso Permitido ao Veiculo");
				return 0;
			} else {
				adicionarRegistro(Calendar.getInstance().getTime().getDate(),
						Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getHours(), f,
						ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), false,
						" Retirada : Funcionario nào possui acesso ao veiculo escolhido");
				return -1;
			}
		} else {
			adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(),
					Calendar.getInstance().getTime().getHours(), f,
					ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), false,
					"Retirada : Funcionario já possui uma chave alugada");
			return -2;
		}
	}

	public int devolverChave(Funcionario f, Chave c) {
		if (f.getBloqueado()) {
			adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(),
					Calendar.getInstance().getTime().getHours(), f, null, false, "Retirada : Usuario Bloqueado");
			return -2;
		}

		if (f.getChave() != null) {
			f.setChave(null);
			c.setAlugada(false);
			adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(),
					Calendar.getInstance().getTime().getHours(), f,
					ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), true,
					"Devolucao : Chave devolvida com sucesso");
			return 0;
		} else {
			adicionarRegistro(Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getMonth(),
					Calendar.getInstance().getTime().getHours(), f,
					ControladorPrincipal.getInstance().pegaVeiculo(c.getPlaca()), false,
					"Devolucao : Funcionario nào possui chave");
			return -1;
		}
	}

	public void adicionarRegistro(int date, int mes, int hours, Funcionario f, Veiculo v, boolean b, String string) {
		ControladorPrincipal.getInstance().adicionarRegistro(date, mes, hours, f, v, b, string);
	}

	public void bloquearFuncionario(Funcionario f) {
		ControladorPrincipal.getInstance().bloquearFuncionario(f);

	}
}
