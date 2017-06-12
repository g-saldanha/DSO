package br.ufsc.ine5605.grupo3.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import br.ufsc.ine5605.grupo3.entidades.Funcionario;

public class FuncionarioDAO {
	private HashMap<Integer, br.ufsc.ine5605.grupo3.entidades.Funcionario> cacheFuncionarios;
	private String fileName = "funcionarios.cla";

	public FuncionarioDAO() {
		this.cacheFuncionarios = new HashMap<>();
	}

	public void put(Funcionario funcionario){
		this.cacheFuncionarios.put(funcionario.getNumeroMatricula(), funcionario);
		this.persist();
	}

	private void persist() {
		// TODO Auto-generated method stub

	}

	public Funcionario get(Integer matricula){
		return this.cacheFuncionarios.get(matricula);
	}

	public void remove(Integer numeroMatricula) {
		// TODO Auto-generated method stub

	}

	public Collection<Funcionario> getList() {
		return this.cacheFuncionarios.values();
	}

	public ArrayList<Funcionario> getFuncionarios(){
		return new ArrayList<Funcionario>(this.getList());
	}

    public boolean isEmpty() {
        return false;
    }
}
