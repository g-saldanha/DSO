/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ine5605.ufsc.controladores;

import br.ine5605.ufsc.apresentacao.TelaPrincipal;
import br.ufsc.ine5605.entidades.Funcionario;
import br.ufsc.ine5605.entidades.Veiculo;

/**
 *
 * @author Caio
 */
public class ControladorPrincipal {
    
    private static ControladorPrincipal instance;
    
    private ControladorFuncionario controladorFuncionario;
    private ControladorChave CC;
    private ControladorVeiculos CV;
    private TelaPrincipal telaPrincipal;
    
    
    private ControladorPrincipal() {
        this.controladorFuncionario = ControladorFuncionario.getInstance();
        this.CV = ControladorVeiculos.getInstance();
        this.CC = ControladorChave.getInstance();
        this.telaPrincipal = new TelaPrincipal(this);
    }
    
     public static ControladorPrincipal getInstance(){
        if(instance == null)
            instance = new ControladorPrincipal();
        
        return instance;
    }
    
    public void inicia(){
        telaPrincipal.exibeMenuPrincipal();
    }
    
    public void exibeTelaFuncionario() {
        controladorFuncionario.exibeTelaFuncionario();
    }
    
    public void exibeTelaVeiculos(){
    	CV.exibeTelaVeiculos();
    }
    
    public void adicionarChave(String Placa){
    	CC.adicionarChave(Placa);
    }
    
    public void deletarChave(String Placa){
    	CC.deletarChave(Placa);
    }
    
    public void exibeTelaChave(){
    	CC.exibeTelaChave();
    }

	public Veiculo pegaVeiculo(String opt) {
		return ControladorVeiculos.getInstance().pegaVeiculo(opt);
	}

	public Funcionario pegaFuncionario(int matricula) {
		return ControladorFuncionario.getInstance().getFuncionario(matricula);
	}
    
    
}
