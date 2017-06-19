package br.ufsc.ine5605.grupo3.controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import br.ufsc.ine5605.grupo3.entidades.Registro;

public class RegistrosDAO {
	private HashMap<Long, Registro> cacheRegistros;
	private String nomeArquivo;

	public RegistrosDAO(){
		this.cacheRegistros = new HashMap<>();
		this.nomeArquivo = "registros.cla";
		try {
//			Tenta Abrir fluxo de dados
			FileInputStream fileInputStream = new FileInputStream(this.nomeArquivo);
			fileInputStream.close();
		} catch (FileNotFoundException e) {
//			Deu ruim
			new File(this.nomeArquivo);
			this.persiste();
		} catch (IOException e) {
			System.out.println(e);
		}
		this.carrega();
	}

	private void carrega(){
		try {
			FileInputStream fileInputStream = new FileInputStream(this.nomeArquivo);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			this.cacheRegistros = (HashMap<Long, Registro>) objectInputStream.readObject();

			objectInputStream.close();
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}

	public void persiste(){
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(this.nomeArquivo);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(this.cacheRegistros);

			fileOutputStream.flush();
			objectOutputStream.flush();

			fileOutputStream.close();
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	public void botar(Registro registro){
		this.cacheRegistros.put(registro.getId(), registro);
		this.persiste();
	}

	public Registro get(Long registroID){
		return this.cacheRegistros.get(registroID);
	}

	public void remove(Registro registro){
		this.cacheRegistros.remove(registro.getId(), registro);
		this.persiste();
	}

	public Collection<Registro> getList(){
		return this.cacheRegistros.values();
	}

	public ArrayList<Registro> getRegistros(){
		return new ArrayList<>(this.getList());
	}
}
