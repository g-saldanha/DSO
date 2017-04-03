/*
 * Universidade Federal de Santa Catarina.
 * CTC - Centro Tecnologico - http://ctc.ufsc.br
 * INE - Departamento de Informatica e Estatistica - http://inf.ufsc.br
 */

public abstract class Animal {
	protected int tamanhoPasso;


	public Animal (int tamanhoPasso){
		this.tamanhoPasso = tamanhoPasso;
	}

	public int getTamanhoPasso() {
		return this.tamanhoPasso;
	}

	public void setTamanhoPasso(int tamanhoPasso) {
		this.tamanhoPasso = tamanhoPasso;
	}

	public String mover(){
		String mover = "ANIMAL: DESLOCOU "+this.tamanhoPasso;
		return mover;
	}

	public abstract String produzirSom();
}


