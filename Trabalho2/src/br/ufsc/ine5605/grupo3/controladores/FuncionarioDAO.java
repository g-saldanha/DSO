package br.ufsc.ine5605.grupo3.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO {
	private HashMap<Integer, Funcionario> cacheFuncionarios = new HashMap<>();
	private String fileName = "funcionarios.cla";

	public FuncionarioDAO() {
            try{
                FileInputStream fin = new  FileInputStream(fileName); // tenta abrir fluxo de dados
                fin.close();
            } catch(FileNotFoundException ex) {
                //se deu ruim
                new File(this.fileName);
                this.persist();
            } catch (IOException ex) {
                System.out.println(ex);
              //Logger.getLogger(MapeadorEleitor.class.getName()).log(Level.SEVERE, null, ex);  
            }
            this.load();
	}

	public void put(Funcionario funcionario){
		this.cacheFuncionarios.put(funcionario.getNumeroMatricula(), funcionario);
		this.persist();
	}

	private void persist() {
            try{
                FileOutputStream fOutStream = new FileOutputStream(fileName);
                ObjectOutputStream obOutStream = new ObjectOutputStream(fOutStream);
                
                obOutStream.writeObject(this.cacheFuncionarios);
                
                obOutStream.flush();
                fOutStream.flush();
                
                obOutStream.close();
                fOutStream.close();
            } catch(FileNotFoundException ex) {
                System.out.println(ex);
                //Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch(IOException ex) {
                System.out.println(ex);
                //Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }   
	}
        
        private void load() {
            try{
                FileInputStream fin = new FileInputStream(fileName);
                ObjectInputStream oi = new ObjectInputStream(fin);
                
                this.cacheFuncionarios = (HashMap<Integer, Funcionario>) oi.readObject();
                
                oi.close();
                fin.close();
                
            } catch(ClassNotFoundException ex) {
                System.out.println(ex);
            } catch(FileNotFoundException ex) {
                System.out.println(ex);
                //Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch(IOException ex) {
                System.out.println(ex);
                //Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }   
            
        }

	public Funcionario get(Integer matricula){
		return this.cacheFuncionarios.get(matricula);
	}

	public void remove(Funcionario funcionario) {
		this.cacheFuncionarios.remove(funcionario.getNumeroMatricula(), funcionario);
                this.persist();

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
