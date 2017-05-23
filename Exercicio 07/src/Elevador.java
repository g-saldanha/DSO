/*
 * Universidade Federal de Santa Catarina.
 * CTC - Centro Tecnologico - http://ctc.ufsc.br
 * INE - Departamento de Informatica e Estatistica - http://inf.ufsc.br
 */

/**
 *
 * @author Jean Hauck
 */
public class Elevador implements IElevador {
	private int capacidade;
	private int totalPessoas;
	private String descer;
	private String entraPessoa;
	private String saiPessoa;
	private String subir;
	private int totalAndaresPredio;
	private int andarAtual;

	public Elevador(int andarAtual, int totalAndaresPredio, int capacidade, int totalPessoas){
		this.andarAtual = andarAtual;
		this.totalAndaresPredio = totalAndaresPredio;
		this.capacidade = capacidade;
		this.totalPessoas = totalPessoas;
	}

	@Override
	public int getCapacidade() {
		// TODO Auto-generated method stub
		return this.capacidade;
	}

	@Override
	public int getTotalPessoas() {
		// TODO Auto-generated method stub
		return this.totalPessoas;
	}

	@Override
	public String descer() {
		// TODO Auto-generated method stub
		return "Descendo";
	}

	@Override
	public String entraPessoa() {
		// TODO Auto-generated method stub
		return "Entrando";
	}

	@Override
	public String saiPessoa() {
		// TODO Auto-generated method stub
		return "Saindo";
	}

	@Override
	public String subir() {
		// TODO Auto-generated method stub
		return "Subindo";
	}

	@Override
	public void setTotalAndaresPredio(int totalAndaresPredio) {
		this.totalAndaresPredio = totalAndaresPredio;

	}

	@Override
	public int getTotalAndaresPredio() {
		// TODO Auto-generated method stub
		return this.totalAndaresPredio;
	}

	@Override
	public int getAndarAtual() {
		// TODO Auto-generated method stub
		return this.andarAtual;
	}

	public String getDescer() {
		return this.descer;
	}

	public void setDescer(String descer) {
		this.descer = descer;
	}

	public String getEntraPessoa() {
		return this.entraPessoa;
	}

	public void setEntraPessoa(String entraPessoa) {
		this.entraPessoa = entraPessoa;
	}

	public String getSaiPessoa() {
		return this.saiPessoa;
	}

	public void setSaiPessoa(String saiPessoa) {
		this.saiPessoa = saiPessoa;
	}

	public String getSubir() {
		return this.subir;
	}

	public void setSubir(String subir) {
		this.subir = subir;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public void setTotalPessoas(int totalPessoas) {
		this.totalPessoas = totalPessoas;
	}

	public void setAndarAtual(int andarAtual) {
		this.andarAtual = andarAtual;
	}





}