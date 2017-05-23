/*
 * Universidade Federal de Santa Catarina.
 * CTC - Centro Tecnologico - http://ctc.ufsc.br
 * INE - Departamento de Informatica e Estatistica - http://inf.ufsc.br
 */

/**
 *
 * @author Jean Hauck
 */
public class ControladorElevador implements IControladorElevador {
	private Elevador elevador;

	@Override
	public String subir() {
		if(this.elevador.getAndarAtual() >= this.elevador.getTotalAndaresPredio() ){

			return "Não foi possível";
		}
		this.elevador.setAndarAtual(this.elevador.getAndarAtual() + 1);
		return this.elevador.subir();
	}

	@Override
	public String descer() {
		if(this.elevador.getAndarAtual() == 0){
			return "Não foi possível";
		}
		this.elevador.setAndarAtual(this.elevador.getAndarAtual() -1);
		return this.elevador.descer();
	}

	@Override
	public String entraPessoa() {
		if(this.elevador.getTotalPessoas() 	>= this.elevador.getCapacidade()) {
			return "Não foi possível";
		}
		this.elevador.setTotalPessoas(this.elevador.getTotalPessoas() + 1);
		return this.elevador.entraPessoa();
	}

	@Override
	public String saiPessoa() {
		if(this.elevador.getTotalPessoas() == 0) {
			return "Não foi Possível";
		}
		this.elevador.setTotalPessoas(this.elevador.getTotalPessoas() - 1);
		return this.elevador.saiPessoa();
	}

	@Override
	public Elevador getElevador() {

		return this.elevador;
	}

	@Override
	public IElevador inicializarElevador(int andarAtual, int totalAndaresPredio, int capacidade, int totalPessoas) {
		this.elevador = new Elevador(andarAtual, totalAndaresPredio, capacidade, totalPessoas);
		return this.elevador;
	}


}