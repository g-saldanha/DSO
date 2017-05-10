package br.ine5605.ufsc.controladores;

import java.util.ArrayList;

import br.ufsc.ine5605.entidades.Chave;

public class ControladorChave {
	private static ArrayList<Chave> chaves;
	
	private ControladorChave(){
		this.chaves = new ArrayList<>();
	}
	
	public static void adicionarChave(String placa){
		if(!checkExists(placa)){
			chaves.add(new Chave(placa));
		}
	}
	
	public ArrayList<Chave> getChaves() {
		return chaves;
	}
	
	public static boolean checkExists(String placa){
		for (Chave c : chaves) {
			if(c.getPlaca().equals(placa)){
				return true;
			}
		}
		return false;
	}

}
