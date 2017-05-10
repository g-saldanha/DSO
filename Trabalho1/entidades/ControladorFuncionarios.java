package br.ine5605.ufsc.controladores;

import br.ine5605.ufsc.apresentacao.Exception.CadastroIncorretoException;
import br.ufsc.ine5605.entidades.Funcionario;
import java.util.ArrayList;
import br.ine5605.ufsc.apresentacao.TelaFuncionario;
import Enum.Cargo;
import static Enum.Cargo.DIRETOR;
import static Enum.Cargo.ESTAGIARIO;
import static Enum.Cargo.PROGRAMADOR;
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
    
    public void cadastraFuncionario(int numeroMatricula, String nome, int dataNascimento, int telefone, Cargo cargo) throws CadastroIncorretoException {
        
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
        if(funcionarios.isEmpty() == true){
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
     
     
     public void alteraMatricula(int matriculaAntiga, int matriculaNova) {
         for(Funcionario funcionario : funcionarios) {
             if(funcionario.getNumeroMatricula() == matriculaAntiga) {
                 funcionario.setNumeroMatricula(matriculaNova);
                 break;
             }
         }
     }
     
     public void alteraNome(Funcionario funcionario, String nome) {
         funcionario.setNome(nome);
     }
     
     public void alteraData(Funcionario funcionario, int data) {
         funcionario.setDataNascimento(data);
     }
     
     public void alteraTelefone(Funcionario funcionario, int telefone) {
         funcionario.setTelefone(telefone);
     }
     
     public void alteraCargo(Funcionario funcionario, int digito) throws CadastroIncorretoException {
         if(digito == 1) {
             funcionario.setCargo(ESTAGIARIO);
         }
         if(digito == 2) {
             funcionario.setCargo(PROGRAMADOR);
         }
         if(digito == 3) {
             funcionario.setCargo(DIRETOR);
         }
	 
	 if(digito > 3) {
             throw new CadastroIncorretoException("cargo nao existente!!") ;
         }    
     }
     

    
    
    }
