/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.grupo3.apresentacaoJFrame.Exception;

/**
 *
 * @author Caio
 */
public class CadastroIncorretoException extends Exception {
    
    public CadastroIncorretoException(String erro){
        super(erro);
    }
}
