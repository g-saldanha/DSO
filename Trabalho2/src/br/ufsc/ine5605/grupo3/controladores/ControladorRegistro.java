package br.ufsc.ine5605.grupo3.controladores;

import java.util.ArrayList;

import br.ufsc.ine5605.grupo3.apresentacao.TelaRegistro;
import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaRegistros;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.entidades.Registro;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

public class ControladorRegistro {
	private ArrayList<Registro> registros;
	private static ControladorRegistro instance;
	private TelaRegistros telaRegistros;
	
	private ControladorRegistro(){
		this.telaRegistros = new TelaRegistros();
	}
	
	public static ControladorRegistro getInstance(){
		if(instance == null){
			instance = new ControladorRegistro();
		}
		return instance;
	}
	
	public void exibeTelaRegistro(){
		telaRegistros.setVisible(true);
	}

	public void exibTelaRegistrosPorFiltro(int matricula) {
		for (Registro registro : registros) {
			if(matricula == registro.getFuncionario().getNumeroMatricula()){
//				telaRegistro.exibeRegistros(registro);
			}
		}	
	}
	
	public void exibTelaRegistrosPorFiltro(String placa) {
		for (Registro registro : registros) {
			if(placa.equals(registro.getVeiculo().getPlaca())){
//				telaRegistro.exibeRegistros(registro);
			}
		}	
	}
	
	public void exibTelaRegistrosPorFiltro(boolean motivo) {
		for (Registro registro : registros) {
			if(motivo == registro.getMotivo()){
//				telaRegistro.exibeRegistros(registro);
			}
		}	
	}

	public void adicionarRegistro(int date, int mes, int hours, Funcionario f, Veiculo v, boolean b, String string) {
		Registro r = new Registro(date, mes, hours, f, v, b, string);
		registros.add(r);
	}
	
	

}
