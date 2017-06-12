/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.grupo3.apresentacao;

import java.util.Scanner;

import br.ufsc.ine5605.grupo3.controladores.ControladorPrincipal;

/**
 *
 * @author Caio
 */
public class TelaPrincipal implements Tela{
    private final ControladorPrincipal owner;
    private Scanner sc;

    public TelaPrincipal(ControladorPrincipal owner) {
        this.owner = owner;
        this.sc = new Scanner(System.in);
    }

    public void exibirTela() {
        int opcao = 0;        
        do{
            System.out.println("\nBem vindo ao sistema claviculario");;
            System.out.println("-----------------------------------");
            System.out.println("Digite 1 para menu do Funcionario");
            System.out.println("Digite 2 para menu do Veículo");
            System.out.println("Digite 3 para menu da Chave");
            System.out.println("Digite 4 para menu de Relatórios");            
            System.out.println("Digite 0 para encerrar");
            opcao = sc.nextInt();
            trataOpcao(opcao);
        } while(opcao != 0);     
        System.exit(0);
        
    }
    public void trataOpcao(int opcao){
        switch(opcao){
        case 1:
            ControladorPrincipal.getInstance().exibeTelaFuncionario();
            break;
        case 2:
            ControladorPrincipal.getInstance();
            break;
        case 3:
            ControladorPrincipal.getInstance().exibeTelaChave();
            break;
        case 4:
            ControladorPrincipal.getInstance().exibeTelaRegistro();
            break;
        default:
            break;
        }
    }
    
}
