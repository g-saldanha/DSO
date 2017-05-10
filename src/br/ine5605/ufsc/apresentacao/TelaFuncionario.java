/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ine5605.ufsc.apresentacao;

import java.util.Scanner;

import br.ine5605.ufsc.apresentacao.Exception.CadastroIncorretoException;
import br.ine5605.ufsc.controladores.ControladorFuncionario;
import br.ufsc.ine5605.entidades.Funcionario;

/**
 *
 * @author Caio
 */
public class TelaFuncionario {
    
    private ControladorFuncionario owner;
    private Scanner sc;
    
    public TelaFuncionario(ControladorFuncionario owner) {
        this.owner = owner;
        sc = new Scanner(System.in);
    }
    
    public void exibeTelaFuncionario(){
        int opcao = 0;
        do {
        System.out.println("\nBem vindo a tela do funcionario");
        System.out.println("Digite 1 para cadastrar funcionario");
        System.out.println("Digite 2 para alterar funcionario");
        System.out.println("Digite 3 para excluir funcionario");
        System.out.println("Digite 4 para listar funcionarios cadastrados");
        System.out.println("Digite 0 para retornar ao menu principal");
        opcao = sc.nextInt();
        try {
        	trataOpcao(opcao);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        }while(opcao != 0);
    }

    public void trataOpcao(int opcao) throws CadastroIncorretoException{
        switch(opcao) {
            case 1:
                telaCadastroFuncionario();
                break;
            case 2:
                telaAlteraFuncionario();  //fazer
                break;
            case 3:
                telaRemoveFuncionario();
                break;
            case 4: 
                owner.exibeFuncionariosCadastrados();
        }
    }

    public void telaCadastroFuncionario() throws CadastroIncorretoException{
        System.out.println("\nBem vindo a tela de cadastro de funcionario");      
        sc.nextLine();
        
        System.out.println("\nInsira o nome do funcionario");
        String nome = sc.nextLine();
        
        System.out.println("\nInsira o numero de matricula do funcionario");
        int matricula = sc.nextInt();
        sc.nextLine();
        
        System.out.println("\nInsira a data de nascimento do funcionario");
        int dataNascimento = sc.nextInt();
        sc.nextLine();
        
        System.out.println("\nInsira o telefone do funcionario");
        int telefone = sc.nextInt();
        sc.nextLine();
        
        System.out.println("\nInsira o cargo do funcionario");
        String cargo = sc.nextLine();
        
        owner.cadastraFuncionario(matricula, nome, dataNascimento, telefone, cargo);
    }

    public void telaAlteraFuncionario() {
        if(owner.haFuncionarios() ==  false){
            return;
        }
        
        System.out.println("\nBem vindo a tela de alteracao de funcionario");
        System.out.println("Digite 2 para alterar o numero de matricula do funcionario");
        System.out.println("Digite 3 para alterar o nomeo do funcionario");
        System.out.println("Digite 4 para alterar a data de nascimento do funcionario");
        System.out.println("Digite 5 para alterar o telefone do funcionario");
        System.out.println("Digite 6 para alterar o cargo do funcionario");
        System.out.println("Digite 7 para voltar");
        sc.nextLine();
        this.trataOpcaoAlteracao(sc.nextInt());
    }

    public void telaRemoveFuncionario() {
        if(!owner.haFuncionarios()) {
            return;
        }    
        System.out.println("\nBem vindo a tela de remocao de funcionario");
        System.out.println("\nInsira a matricula do funcionario a ser removido");
        int matricula = sc.nextInt();
        Funcionario funcionarioARemover = owner.getFuncionario(matricula);
        if(funcionarioARemover != null) {
            owner.excluiFuncionario(funcionarioARemover);
        } else {
            System.out.println("Erro ao excluir funcionario");
        }
       
        
    }
    
    public void mensagemNaoHaFuncionarios() {
        System.out.println("Nao ha funcionarios cadastrados\n");
    }
    
     public void exibeFuncionario(Funcionario funcionario) {
        System.out.println("Nome do funcionario: " + funcionario.getNome() + " \nNumero de matricula: " + funcionario.getNumeroMatricula() + "\n");
    }

    private void trataOpcaoAlteracao(int opcao) {
        
        switch(opcao) {
            
        }
        
    }
    
    
    
}
