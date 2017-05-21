package exercicio04;

import java.util.ArrayList;
import java.util.List;

public class Livro {
	private int codigo;
	private String titulo;
	private int ano;
	private Editora editora;
	private List<Autor> autores = new ArrayList<>();

	private ArrayList<Capitulo> capitulos = new ArrayList<>();

	public Livro(int codigo, String titulo, Editora editora, Autor autor, int numeroCapitulo, String tituloCapitulo, int ano){
		this.codigo = codigo;
		this.titulo = titulo;
		this.ano = ano;
		this.editora = editora;
		this.autores.add(autor);
		Capitulo capitulo = new Capitulo(numeroCapitulo, tituloCapitulo);
		this.capitulos.add(capitulo);


	}

	public int getCodigo(){
		return this.codigo;
	}

	public String getTitulo(){
		return this.titulo;
	}

	public int getAno(){
		return this.ano;
	}

	public Editora getEditora(){
		return this.editora;
	}

	public List<Autor> getAutores(){
		return this.autores;
	}


	public void setCodigo(int codigo){
		this.codigo = codigo;
	}

	public void setTitulo(String titulo){
		this.titulo = titulo;
	}

	public void setAno(int ano){
		this.ano = ano;
	}

	public void setEditora(Editora editora){
		this.editora = editora;
	}

	public void incluirAutor(Autor autor){
		//tratar igualdade
		if(!autores.contains(autor)){
			autores.add(autor);
		}

	}

	public void excluirAutor(Autor autor){
		//tratar null
		if(autores.contains(autor)){
			autores.remove(autor);
		}

	}

	public void excluiCapitulo(String tituloCapitulo){
		//tratar null
		Capitulo capituloExcluir = findCapituloByTitulo(tituloCapitulo);
		if (capituloExcluir != null) {
			capitulos.remove(capituloExcluir);
		}
	}

	public void incluiCapitulo(int numero, String tituloCapitulo) {
		//tratar igualdade
		Capitulo capituloIncluir = findCapituloByTitulo(tituloCapitulo);
		if(capituloIncluir == null){
			capitulos.add(new Capitulo(numero, tituloCapitulo));
		}

	}

	public Capitulo findCapituloByTitulo(String capitulo){
		Capitulo capituloEncontrado = null;
		for (Capitulo capituloProcurado : this.capitulos) {
			if(capitulo.equals(capituloProcurado.getTitulo())){
				capituloEncontrado = capituloProcurado;
			}
		}
		return capituloEncontrado;

	}


}