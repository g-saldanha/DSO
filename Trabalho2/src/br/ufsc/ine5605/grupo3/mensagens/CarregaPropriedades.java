package br.ufsc.ine5605.grupo3.mensagens;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;


public class CarregaPropriedades {

	public CarregaPropriedades() throws IOException{
		try{
			File arquivo = new File("messages.properties");
			FileInputStream entradaDoArquivo = new FileInputStream(arquivo);
			Properties propriedades = new Properties();
			propriedades.load(entradaDoArquivo);
			entradaDoArquivo.close();

			Enumeration enumDasKeys = propriedades.keys();
			while(enumDasKeys.hasMoreElements()) {
				String key = (String) enumDasKeys.nextElement();
				String valor = propriedades.getProperty(key);
				System.out.println(key + ":" + valor);

			}

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
