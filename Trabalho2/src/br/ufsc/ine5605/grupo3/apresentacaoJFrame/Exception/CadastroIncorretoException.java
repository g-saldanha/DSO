/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.grupo3.apresentacaoJFrame.Exception;

import br.ufsc.ine5605.grupo3.mensagens.Messages;

/**
 *
 * @author Caio
 */
public class CadastroIncorretoException extends Exception {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public CadastroIncorretoException(String erro){
        super(erro);
    }

    @Override
    public String getMessage() {
    	return Messages.MATRICULA_INEXISTENTE;
    }

}