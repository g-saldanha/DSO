/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.grupo3.controladores;

import br.ufsc.ine5605.grupo3.entidades.Chave;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

/**
 *
 * @author Caio
 */
public class ControladorPrincipal {
    
    private static ControladorPrincipal instance;
    private br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaPrincipal telaPrincipal;

    private ControladorPrincipal() {
        this.telaPrincipal = new br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaPrincipal();
    }
    
     public static ControladorPrincipal getInstance(){
        if(instance == null)
            instance = new ControladorPrincipal();
        
        return instance;
    }

    
    public void adicionarChave(String Placa){
    	ControladorChave.getInstance().adicionarChave(Placa);
    }
    
    public void deletarChave(String Placa){
    	ControladorChave.getInstance().deletarChave(Placa);
    }

	public Veiculo pegaVeiculo(String opt) {
		return ControladorVeiculos.getInstance().pegaVeiculo(opt);
	}

	public Funcionario pegaFuncionario(int matricula) {
		return ControladorFuncionario.getInstance().getFuncionario(matricula);
	}
	
	public Chave pegaChave(String placa){
		return ControladorChave.getInstance().getChave(placa);
	}

	public void adicionarRegistro(int date, int mes, int hours, Funcionario f, Veiculo v, boolean b, String string) {
		ControladorRegistro.getInstance().adicionarRegistro(date, mes, hours, f, v,b, string);
		
	}

	public void bloquearFuncionario(Funcionario f) {
		ControladorFuncionario.bloquearFuncionario(f);
		
	}

	public void fechaTelaPrincipal(){
	    telaPrincipal.setVisible(false);
    }


    public void voltarMenuPrincipal() {
        telaPrincipal.setVisible(true);
    }

    public void exibeTelaVeiculos() {
        fechaTelaPrincipal();
	    ControladorVeiculos.getInstance().exibeTelaVeiculos();
    }

    public void exibeTelaChaves(){
        fechaTelaPrincipal();
        ControladorChave.getInstance().exibeTelaChave();
    }

    public void exibeTelaRegistros(){
        fechaTelaPrincipal();
        ControladorRegistro.getInstance().exibeTelaRegistro();
    }

    public void exibeTelaFuncionarios(){
        fechaTelaPrincipal();
        ControladorFuncionario.getInstance().exibeTelaFuncionario();
    }
}
