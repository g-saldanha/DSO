package br.ine5605.ufsc.controladores;

import java.util.ArrayList;

import br.ine5605.ufsc.apresentacao.TelaChave;
import br.ufsc.ine5605.entidades.Chave;
import br.ufsc.ine5605.entidades.Funcionario;

public class ControladorChave {
	private static ControladorChave instance;
	private static ArrayList<Chave> chaves;
	private TelaChave telaChave;
	
	private ControladorChave (){
    	this.chaves = new ArrayList<>();
    	telaChave = new TelaChave(this);
    }
    
    public static ControladorChave getInstance(){
        if(instance == null)
            instance = new ControladorChave();
        
        return instance;
    }
	
	public void adicionarChave(String placa){
		if(checkExists(placa) == -1){
			chaves.add(new Chave(placa));
		}
	}
	
	public void deletarChave(String placa){
		int index = checkExists(placa);
		
		if(index != -1){
			chaves.remove(index);
		}
	}
	
	public void exibirChaves(){
		int index = 0;
		for(Chave c : chaves){
			telaChave.exibeTelaExibicao(c, index);
			index++;
		}
	}
	
	public ArrayList<Chave> getChaves() {
		return chaves;
	}
	
	public int checkExists(String placa){
		int index = 0;
		for (Chave c : chaves) {
			if(c.getPlaca().equals(placa)){
				return index;
			}
			index++;
		}
		return -1;
	}
	
	public Chave getChave(String placa){
		int index = checkExists(placa);
		
		return index != -1 ? chaves.get(index) : null;
	}
	
	public void exibeTelaChave() {
        telaChave.exibeTelaChave();    
    }

	public Funcionario pegaFuncionario(int matricula) {
		return ControladorPrincipal.getInstance().pegaFuncionario(matricula);		
	}
	
	public int cederChave(Funcionario f, Chave c){
		if(f.getChave() == null){
			if(f.checaPlacas(c)){
				f.setChave(c);
				c.setAlugada(true);
				return 0;
			} else {
				return -1;
			}
		} else {
			return -2;
		}
	}
}
