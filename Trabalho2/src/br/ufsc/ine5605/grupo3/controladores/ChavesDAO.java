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

import br.ufsc.ine5605.grupo3.entidades.Chave;

public class ChavesDAO {
	private HashMap<Long, Chave> cacheChaves;
	private String nomeArquivo;

	public ChavesDAO(){
		this.cacheChaves = new HashMap<>();
		this.nomeArquivo = "chaves.cla";
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

			this.cacheChaves = (HashMap<Long, Chave>) objectInputStream.readObject();

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

			objectOutputStream.writeObject(this.cacheChaves);

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

	public void botar(Chave chave){
		this.cacheChaves.put(chave.getID(), chave);
		this.persiste();
	}

	public Chave get(Integer chaveID){
		return this.cacheChaves.get(chaveID);
	}

	public void remove(Chave chave){
		this.cacheChaves.remove(chave.getID(), chave);
		this.persiste();
	}

	public Collection<Chave> getList(){
		return this.cacheChaves.values();
	}

	public ArrayList<Chave> getChaves(){
		return new ArrayList<>(this.getList());
	}
}
