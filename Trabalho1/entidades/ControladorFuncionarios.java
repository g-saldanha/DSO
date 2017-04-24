package Trabalho1.entidades;

import java.util.ArrayList;

import Trabalho1.entidades.Funcionario.Cargo;

public class ControladorFuncionarios {
	private ArrayList<Funcionario> funcionarios;
	
	
	public void addFuncionario(int numeroMatricula, String nome, int dataNascimento, int telefone, Cargo cargo, ArrayList<Veiculo> carros){
		Funcionario temp = new Funcionario(numeroMatricula, nome, dataNascimento, telefone, cargo, carros);
		if(!checkExists(temp)){
			funcionarios.add(temp);
		}
	}
	
	public void removeFuncionario(int numeroMatricula){
		int pos = 0;
		for (Funcionario funcionario : funcionarios) {
			if(funcionario.getNumeroMatricula() == numeroMatricula){
				funcionarios.remove(pos);
				return;
			} else {
				pos++;
			}
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
	
	public boolean checkExists(Funcionario funcionario){
		for(Funcionario f : funcionarios){
			if (f.getNumeroMatricula() == funcionario.getNumeroMatricula()) {
				return true;
			}
			
		}
		return false;
	}
	
}
