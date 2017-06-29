package br.ufsc.ine5605.grupo3.controladores;

import java.io.IOException;
import java.util.ArrayList;

import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaRegistros;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.entidades.Registro;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

public class ControladorRegistro {
	private RegistrosDAO registros;
	private static ControladorRegistro instance;
	private TelaRegistros telaRegistros;

	private ControladorRegistro(){
		this.telaRegistros = new TelaRegistros();
		this.registros = new RegistrosDAO();
	}

	public static ControladorRegistro getInstance(){
		if(instance == null){
			instance = new ControladorRegistro();
		}
		return instance;
	}

	public void exibeTelaRegistro(){
		this.telaRegistros.atualizaLista();
		this.telaRegistros.setVisible(true);
	}

	public void exibTelaRegistrosPorFiltro(Integer matricula) {
		for (Registro registro : this.registros.getRegistros()) {
			if(matricula == registro.getFuncionario().getNumeroMatricula()){
//				telaRegistro.exibeRegistros(registro);
			}
		}
	}

	public void exibTelaRegistrosPorFiltro(String placa) {
		for (Registro registro : this.registros.getRegistros()) {
			if(placa.equals(registro.getVeiculo().getPlaca())){
//				telaRegistro.exibeRegistros(registro);
			}
		}
	}

	public void exibTelaRegistrosPorFiltro(boolean motivo) {
		for (Registro registro : this.registros.getRegistros()) {
			if(motivo == registro.getMotivo()){
//				telaRegistro.exibeRegistros(registro);
			}
		}
	}

	public void adicionarRegistro(Long id, Integer date, Integer mes, Integer hours, Funcionario f, Veiculo v, boolean b, String string) {
		Registro r = new Registro(id, date, mes, hours, f, v, b, string);
		this.registros.botar(r);
	}

	public ArrayList<Registro> getTodosRegistros(){
		return this.registros.getRegistros();
	}

	public ArrayList<String> getPlacas() throws IOException{
		return ControladorPrincipal.getInstance().getPlacas();
	}

	public ArrayList<Integer> getMatriculas() throws IOException {
		return ControladorPrincipal.getInstance().getMatriculas();
	}

	public Registro getRegistro(Long id) {
		return this.registros.get(id);
	}


}
