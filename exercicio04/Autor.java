package exercicio04;

public class Autor {
	private int codigo;
	private String nome;

	public Autor(int codigo, String nome){
		this.codigo = codigo;
		this.nome = nome;
	}

	public String getNome(){
		return this.nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public int getCOdigo(){
		return this.codigo;
	}

	public void setCodigo(int codigo){
		this.codigo = codigo;
	}
}