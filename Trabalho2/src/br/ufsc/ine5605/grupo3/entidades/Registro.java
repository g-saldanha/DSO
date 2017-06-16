package br.ufsc.ine5605.grupo3.entidades;

public class Registro {
	private int data;
	private int mes;
	private int hora;
	private Funcionario funcionario;
	private Veiculo veiculo;
	private boolean motivo;
	private int kmAndados;
	private String mensagem;
	
	public Registro(int data, int mes, int hora, Funcionario funcionario, Veiculo veiculo, boolean motivo, String mensagem) {
		
		this.data = data;
		this.mes = mes;
		this.hora = hora;
		this.funcionario = funcionario;
		this.veiculo = veiculo;
		this.motivo = motivo;
		this.mensagem = mensagem;
	}


	public int getData() {
		return data;
	}
	
	public int getMes(){
		return mes;
	}


	public void setData(int data) {
		this.data = data;
	}


	public int getHora() {
		return hora;
	}


	public void setHora(int hora) {
		this.hora = hora;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario f) {
		this.funcionario = f;
	}


	public Veiculo getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}


	public boolean getMotivo() {
		return motivo;
	}


	public void setMotivo(boolean motivo) {
		this.motivo = motivo;
	}


	public int getKmAndados() {
		return kmAndados;
	}


	public void setKmAndados(int kmAndados) {
		this.kmAndados = kmAndados;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
