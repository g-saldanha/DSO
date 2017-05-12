/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ine5605.ufsc.controladores;

import java.util.Calendar;

import br.ine5605.ufsc.apresentacao.TelaPrincipal;
import br.ufsc.ine5605.entidades.Chave;
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
    private ControladorRegistro CR;
    private TelaPrincipal telaPrincipal;
    
    
    private ControladorPrincipal() {
        this.controladorFuncionario = ControladorFuncionario.getInstance();
        this.CV = ControladorVeiculos.getInstance();
        this.CC = ControladorChave.getInstance();
        this.CR = ControladorRegistro.getInstance();
        this.telaPrincipal = new TelaPrincipal(this);
    }
    
     public static ControladorPrincipal getInstance(){
        if(instance == null)
            instance = new ControladorPrincipal();
        
        return instance;
    }
    
    public void inicia(){
        telaPrincipal.exibirTela();
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

	public void exibeTelaRegistro() {
		CR.exibeTelaRegistro();
		
	}
	
	public Chave pegaChave(String placa){
		return CC.getChave(placa);
	}

	public void adicionarRegistro(int date, int mes, int hours, Funcionario f, Veiculo v, boolean b, String string) {
		ControladorRegistro.getInstance().adicionarRegistro(date, mes, hours, f, v,b, string);
		
	}

	public void bloquearFuncionario(Funcionario f) {
		ControladorFuncionario.bloquearFuncionario(f);
		
	}
	
	

    
    
}
