package br.ine5605.ufsc.controladores;

import java.util.ArrayList;

import br.ine5605.ufsc.apresentacao.TelaRegistro;
import br.ufsc.ine5605.entidades.Registro;

public class ControladorRegistro {
	private ArrayList<Registro> registros;
	private static ControladorRegistro instance;
	private TelaRegistro telaRegistro;
	
	private ControladorRegistro(){
		this.registros = new ArrayList<>();
		this.telaRegistro = new TelaRegistro(this);
	}
	
	public static ControladorRegistro getInstance(){
		if(instance == null){
			instance = new ControladorRegistro();
		}
		return instance;
	}
	
	public void exibeTelaRegistro(){
		for (Registro registro : registros) {
			telaRegistro.exibeRegistros(registro);
		}
		telaRegistro.exibeTelaRegistro();
	}

	public void exibTelaRegistrosPorFiltro(int matricula) {
		for (Registro registro : registros) {
			if(matricula == registro.getMatricula()){
				telaRegistro.exibeRegistros(registro);
			}
		}	
	}
	
	public void exibTelaRegistrosPorFiltro(String placa) {
		for (Registro registro : registros) {
			if(placa.equals(registro.getVeiculo().getPlaca())){
				telaRegistro.exibeRegistros(registro);
			}
		}	
	}
	
	public void exibTelaRegistrosPorFiltro(boolean motivo) {
		for (Registro registro : registros) {
			if(motivo == registro.getMotivo()){
				telaRegistro.exibeRegistros(registro);
			}
		}	
	}
	
	

}
