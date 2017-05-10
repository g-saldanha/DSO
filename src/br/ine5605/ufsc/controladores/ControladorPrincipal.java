/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ine5605.ufsc.controladores;

import br.ine5605.ufsc.apresentacao.TelaPrincipal;

/**
 *
 * @author Caio
 */
public class ControladorPrincipal {
    
    private static ControladorPrincipal instance;
    
    private ControladorFuncionario controladorFuncionario;
    private TelaPrincipal telaPrincipal;
    
    
    private ControladorPrincipal() {
        this.controladorFuncionario = new ControladorFuncionario(this);
        this.telaPrincipal = new TelaPrincipal(this);
    }
    
     public static ControladorPrincipal getIntance(){
        if(instance == null)
            instance = new ControladorPrincipal();
        
        return instance;
    }
    
    public void inicia(){
        telaPrincipal.exibeMenuPrincipal();
    }
    
    public static void exibeTelaFuncionario() {
        controladorFuncionario.exibeTelaFuncionario();
    }
    
}
