/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ine5605.ufsc.controladores;

import br.ine5605.ufsc.apresentacao.Exception.CadastroIncorretoException;
import br.ufsc.ine5605.entidades.Funcionario;
import java.util.ArrayList;
import br.ine5605.ufsc.apresentacao.TelaFuncionario;
/**
 *
 * @author Caio
 */
public class ControladorFuncionario {
    
    private final ControladorPrincipal owner;
    private TelaFuncionario telaFuncionario;
    private ArrayList<Funcionario> funcionarios;
    
    
    public ControladorFuncionario(ControladorPrincipal owner) {
        this.owner = owner;
        this.telaFuncionario = new TelaFuncionario(this);
        this.funcionarios = new ArrayList<>();
    }
    
    public void cadastraFuncionario(int numeroMatricula, String nome, int dataNascimento, int telefone, String cargo) throws CadastroIncorretoException {
        
        verificaMatricula(numeroMatricula);
        
        
        Funcionario novoFuncionario = new Funcionario(numeroMatricula, nome, dataNascimento, telefone, cargo);

            funcionarios.add(novoFuncionario);
        
        
    }
    
    public void excluiFuncionario(Funcionario funcionario) {
        if(funcionario != null && funcionarios.contains(funcionario)) {
            funcionarios.remove(funcionario);
        }
    }
    
    public Funcionario getFuncionario(int numeroMatricula){
	for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNumeroMatricula() == numeroMatricula) {
		return funcionario;
	    }
	}
	return null;
    }
    
    public boolean haFuncionarios(){
        if(funcionarios.isEmpty()){
            telaFuncionario.mensagemNaoHaFuncionarios();
            return false;
        }
        return true;
    }

    public void exibeFuncionariosCadastrados() {
         if(funcionarios.isEmpty()){
            telaFuncionario.mensagemNaoHaFuncionarios();
            return;
        }
        for(Funcionario funcionario : this.funcionarios){
            telaFuncionario.exibeFuncionario(funcionario);
        }
    }
    
    public void exibeTelaFuncionario() {
        telaFuncionario.exibeTelaFuncionario();    
    }
    
     public void verificaMatricula(int matricula) throws CadastroIncorretoException{
        for(Funcionario funcionario : funcionarios){
            if(funcionario.getNumeroMatricula() == (matricula)){
                 throw new CadastroIncorretoException("matricula existente!") ;
            }
        }
    }
}
    
    
        
        
    
    
    
    
    

