package br.ufsc.ine5605.grupo3.controladores;

import br.ufsc.ine5605.grupo3.entidades.Veiculo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gabriel on 16/06/17.
 */
public class VeiculosDAO {
    private HashMap<String, Veiculo> cacheVeiculos;
    private String nomeArquivo;
    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;


    public VeiculosDAO() throws IOException {
        this.cacheVeiculos = new HashMap<>();
        this.nomeArquivo = "veiculos.cla";
        try {
//            Tenta abrir fluxo de dados
            FileInputStream fin = new FileInputStream(nomeArquivo);
            fin.close();
        } catch (FileNotFoundException e) {
//            o famoso deu ruim
            new File(this.nomeArquivo);
            this.persist();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.load();
    }

    private void load() throws IOException {
        try {
             fileInputStream = new FileInputStream(nomeArquivo);
             objectInputStream = new ObjectInputStream(fileInputStream);

            this.cacheVeiculos = (HashMap<String, Veiculo>) objectInputStream.readObject();


        } catch (ClassNotFoundException|IOException e) {
            e.printStackTrace();
        } finally {
            objectInputStream.close();
            fileInputStream.close();
        }
    }

    private void persist() throws IOException {
        try{
            fileOutputStream = new FileOutputStream(nomeArquivo);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(this.cacheVeiculos);

            fileOutputStream.flush();
            objectOutputStream.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileOutputStream.close();
            objectOutputStream.close();

        }

    }

    public void put(Veiculo veiculo) throws IOException {
        this.cacheVeiculos.put(veiculo.getPlaca(), veiculo);
        this.persist();
    }

    public Veiculo get(String placa){
        return cacheVeiculos.get(placa);
    }


    public void remove(Veiculo veiculo) throws IOException {
        this.cacheVeiculos.remove(veiculo.getPlaca(), veiculo);
                this.persist();
    }

    public Collection<Veiculo> getList(){
        return this.cacheVeiculos.values();
    }

    public List<Veiculo> getVeiculos() {
        return new ArrayList<>(this.getList());
    }

}
