/*
 * Universidade Federal de Santa Catarina.
 * CTC - Centro Tecnologico - http://ctc.ufsc.br
 * INE - Departamento de Informatica e Estatistica - http://inf.ufsc.br
 */

public class Canarinho extends Ave{
	public Canarinho(int tamahoPasso, int alturaVoo){
		super(alturaVoo, tamahoPasso);
		this.tamanhoPasso = tamahoPasso;
		this.alturaVoo = alturaVoo;
	}

	public String Cantar(){
		return "cantata";
	}
}

