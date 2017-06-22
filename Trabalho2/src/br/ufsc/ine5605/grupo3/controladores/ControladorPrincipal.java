/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.grupo3.controladores;

import java.util.ArrayList;

import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaPrincipal;
import br.ufsc.ine5605.grupo3.entidades.Chave;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

/**
 *
 * @author Caio
 */
public class ControladorPrincipal {

    private static ControladorPrincipal instance;
    private TelaPrincipal telaPrincipal;

    private ControladorPrincipal() {
        this.telaPrincipal = new TelaPrincipal();
    }

     public static ControladorPrincipal getInstance(){
        if(instance == null) {
			instance = new ControladorPrincipal();
		}

        return instance;
    }


    public void adicionarChave(String Placa){
    	ControladorChave.getInstance().adicionarChave(Placa);
    }

    public void deletarChave(Long id, Integer matricula){
    	ControladorChave.getInstance().deletarChave(id, matricula);
    }

	public Veiculo pegaVeiculo(String opt) {
		return ControladorVeiculos.getInstance().pegaVeiculo(opt);
	}

	public Funcionario pegaFuncionario(Integer matricula) {
		return ControladorFuncionario.getInstance().getFuncionario(matricula);
	}

	public Chave pegaChave(String placa){
		return ControladorChave.getInstance().getChave(placa);
	}

	public void adicionarRegistro(Long id, Integer date, Integer mes, Integer hours, Funcionario f, Veiculo v, boolean b, String string) {
		ControladorRegistro.getInstance().adicionarRegistro(id, date, mes, hours, f, v,b, string);

	}

	public void bloquearFuncionario(Funcionario f) {
		ControladorFuncionario.bloquearFuncionario(f);

	}

	public void fechaTelaPrincipal(){
	    this.telaPrincipal.setVisible(false);
    }


    public void voltarMenuPrincipal() {
        this.telaPrincipal.setVisible(true);
    }

    public void exibeTelaVeiculos() {
        this.fechaTelaPrincipal();
	    ControladorVeiculos.getInstance().exibeTelaVeiculos();
    }

    public void exibeTelaChaves(){
        this.fechaTelaPrincipal();
        ControladorChave.getInstance().exibeTelaChave();
    }

    public void exibeTelaRegistros(){
        this.fechaTelaPrincipal();
        ControladorRegistro.getInstance().exibeTelaRegistro();
    }

    public void exibeTelaFuncionarios(){
        this.fechaTelaPrincipal();
        ControladorFuncionario.getInstance().exibeTelaFuncionario();
    }

	public ArrayList<String> getPlacas() {
		return ControladorVeiculos.getInstance().getPlacas();

	}

	public ArrayList<Integer> getMatriculas() {
		return ControladorFuncionario.getInstance().getMatriculas();
	}
}
