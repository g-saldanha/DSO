package exercicio04;

import java.util.ArrayList;

public class Biblioteca {

	private ArrayList<Livro> livros;

	public void incluirLivro(Livro livro){
		//tratar equivalencia
		this.livros.add(livro);

	}

	public void excluirLivro(Livro livro){
		//tratar null
		this.livros.remove(livro);

	}
}