package Trabalho1.entidades;

import java.util.ArrayList;

public class ControladorGaragem {
	public ArrayList<Veiculo> veiculos;
	
	public void addVeiculo(String placa, String modelo, String marca, int ano, int km){
		Veiculo novo = new Veiculo(placa, modelo, marca, ano, km);
		if(!checkExists(placa)){
			veiculos.add(novo);
		}
		
	}
	
	public void removeVeiculo(String Placa){
		// Remove o veículo se houver dentro da ArrayList
		for(Veiculo velho : veiculos){
			if(velho.getPlaca() == Placa){
				veiculos.remove(velho);
			}
		}
		
	}
	
	public Veiculo getVeiculo(String Placa){
		for(Veiculo v : veiculos){
			if(v.getPlaca() == Placa){
				return v;
			}
		}
		return null;
	}
	
	public boolean checkExists(String Placa){
		for(Veiculo v : veiculos){
			if(v.getPlaca().equals(Placa)){
				return true;
			}
		}
		return false;
	}
}
