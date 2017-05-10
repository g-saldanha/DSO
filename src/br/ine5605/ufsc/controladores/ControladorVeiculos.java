package br.ine5605.ufsc.controladores;

import java.util.ArrayList;

import br.ine5605.ufsc.apresentacao.TelaVeiculo;
import br.ufsc.ine5605.entidades.Caminhonete;
import br.ufsc.ine5605.entidades.Carro;
import br.ufsc.ine5605.entidades.Moto;
import br.ufsc.ine5605.entidades.Veiculo;

public class ControladorVeiculos {
	public final ControladorPrincipal owner;
	private ArrayList<Veiculo> veiculos;
	private TelaVeiculo telaVeiculo;
	
	
	public ControladorVeiculos (ControladorPrincipal owner){
		this.owner = owner;
		this.veiculos = new ArrayList<>();
		this.telaVeiculo = new TelaVeiculo(this);
	}
	
	public void cadastraVeiculo(String placa, String modelo, String marca, int ano, int km, int tipo){
		if(!checkExists(placa)){
			Veiculo novo = null;
			if(tipo == 1){
				novo = new Moto(placa, modelo, marca, ano, km);
			} else if(tipo == 2){
				novo = new Carro(placa, modelo, marca, ano, km);
			} else if(tipo == 3){
				novo = new Caminhonete(placa, modelo, marca, ano, km);
			}
			veiculos.add(novo);
			ControladorChave.adicionarChave(placa);
		}
	}
	
	public void removeVeiculo(String placa){
		if(checkExists(placa)){
			veiculos.remove(pegaVeiculo(placa));
		}
	}
	
	public Veiculo pegaVeiculo(String placa){
		for (Veiculo v : veiculos) {
			if(checkExists(placa)){
				return v;
			}
		}
		return null;
	}
	
	public boolean checkExists(String placa){
		for (Veiculo v : veiculos) {
			if(v.getPlaca().equals(placa)){
				return true;
			}
		}
		return false;
	}
}
