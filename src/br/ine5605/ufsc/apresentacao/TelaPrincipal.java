/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ine5605.ufsc.apresentacao;

import java.util.Scanner;

import br.ine5605.ufsc.controladores.ControladorPrincipal;

/**
 *
 * @author Caio
 */
public class TelaPrincipal {
    private final ControladorPrincipal owner;
    private Scanner sc;

    public TelaPrincipal(ControladorPrincipal owner) {
        this.owner = owner;
        this.sc = new Scanner(System.in);
    }

    public void exibeMenuPrincipal() {
        int opcao = 0;        
        do{
            System.out.println("\nBem vindo ao sistema claviculario");;
            System.out.println("Digite 1 para menu do funcionario");
            System.out.println("Digite 2 para menu do Veículo");
            System.out.println("Digite 3 para menu da ");
            System.out.println("Digite 4 para menu do ");            
            System.out.println("Digite 0 para encerrar");
            opcao = sc.nextInt();
            trataOpcao(opcao);
        } while(opcao != 0);     
       
        System.exit(0);
        
    }
    public void trataOpcao(int opcao){
        switch(opcao){
        case 1:
            ControladorPrincipal.exibeTelaFuncionario();
            break;
        case 2:
            ControladorPrincipal.exibeTelaVeiculo();
        case 3:
                 
        case 4:
            
        case 5:
            
        }
    }
    
}
