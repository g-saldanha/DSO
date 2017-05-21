/*
 * Universidade Federal de Santa Catarina.
 * CTC - Centro Tecnologico - http://ctc.ufsc.br
 * INE - Departamento de Informatica e Estatistica - http://inf.ufsc.br
 */

 public abstract class Mamifero extends Animal {
	 private int volumeSom;

	 public Mamifero(int tamanhoPasso, int volumeSom){
		super(tamanhoPasso);
		this.volumeSom = volumeSom;
	 }

	 @Override
	 public String produzirSom(){
		 return "som";
	 }

	 public int getVolumeSom() {
		return this.volumeSom;
	 }

	 public void setVolumeSom(int volumeSom) {
		this.volumeSom = volumeSom;
	 }

}
