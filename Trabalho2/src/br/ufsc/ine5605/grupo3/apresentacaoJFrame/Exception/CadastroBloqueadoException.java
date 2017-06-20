package br.ufsc.ine5605.grupo3.apresentacaoJFrame.Exception;

public class CadastroBloqueadoException extends Exception {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public CadastroBloqueadoException(String erro){
		super(erro);
	}

	@Override
	public String getMessage() {
		return "Usuário Bloqueado";
	}
}
