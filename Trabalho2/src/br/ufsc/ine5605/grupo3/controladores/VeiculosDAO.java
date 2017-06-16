package br.ufsc.ine5605.grupo3.controladores;

import br.ufsc.ine5605.grupo3.entidades.Veiculo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by gabriel on 16/06/17.
 */
public class VeiculosDAO {
    private HashMap<String, Veiculo> cacheVeiculos;
    private String nomeArquivo;

    public VeiculosDAO() {
        this.cacheVeiculos = new HashMap<>();
        this.nomeArquivo = "veiculos.cla";
        try {
//            Tenta abrir fluxo de dados
            FileInputStream fin = new FileInputStream(nomeArquivo);
            fin.close();
        } catch (FileNotFoundException e) {
//            o famoso deu ruim;
            new File(this.nomeArquivo);
            this.persist();
        } catch (IOException e) {
            System.out.println(e);
        }
        this.load();
    }

    private void load() {
        try {
            FileInputStream fileInputStream = new FileInputStream(nomeArquivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            this.cacheVeiculos = (HashMap<String, Veiculo>) objectInputStream.readObject();

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

    private void persist() {
        try{
            FileOutputStream arquivoOutSt = new FileOutputStream(nomeArquivo);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(arquivoOutSt);

            objectOutputStream.writeObject(this.cacheVeiculos);

            arquivoOutSt.flush();
            objectOutputStream.flush();

            arquivoOutSt.close();
            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void put(Veiculo veiculo){
        this.cacheVeiculos.put(veiculo.getPlaca(), veiculo);
        this.persist();
    }

    public Veiculo get(String placa){
        return cacheVeiculos.get(placa);
    }


    public void remove(Veiculo veiculo){
        this.cacheVeiculos.remove(veiculo.getPlaca(), veiculo);
                this.persist();
    }

    public Collection<Veiculo> getList(){
        return this.cacheVeiculos.values();
    }

    public ArrayList<Veiculo> getVeiculos() {
        return new ArrayList<Veiculo>(this.getList());
    }

}
