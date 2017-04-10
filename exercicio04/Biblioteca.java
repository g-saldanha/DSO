package exercicio04;

import java.util.ArrayList;

public class Biblioteca {

	private ArrayList<Livro> livros;
	
	public Biblioteca(){
		this.livros = new ArrayList<>();
	}

	public void incluirLivro(Livro livro){
		//tratar equivalencia
		if(!livros.contains(livro)) {
			this.livros.add(livro);
		}
	}

	public void excluirLivro(Livro livro){
		//tratar null
		if(livros.contains(livro)){
			this.livros.remove(livro);
		}
	}
}