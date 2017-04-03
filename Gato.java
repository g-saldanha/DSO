/*
 * Universidade Federal de Santa Catarina.
 * CTC - Centro Tecnologico - http://ctc.ufsc.br
 * INE - Departamento de Informatica e Estatistica - http://inf.ufsc.br
 */

public class Gato extends Mamifero{
	public Gato(){
		super(2,2);
	}

	public String miar(){
		String gatoMia = this.produzirSom();
		return gatoMia + " SOM: MIAU";
	}

}
