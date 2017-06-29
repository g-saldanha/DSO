package br.ufsc.ine5605.grupo3.mensagens;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.Properties;

public class Messages {
	private File arquivo;
	private Enumeration eKey;
	private static Properties propriedades;

	public Messages(){
		try{
			this.arquivo = new File("/home/gabriel/workspaceJava/DSO/Trabalho2/src/main/resources/messages.properties");
			FileInputStream entradaDoArquivo = new FileInputStream(this.arquivo);
			this.propriedades = new Properties();
			this.propriedades.load(entradaDoArquivo);
			entradaDoArquivo.close();



			this.eKey = this.propriedades.keys();




		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

/*********************************************************************************************************************
										* MENSAGENS *
\*********************************************************************************************************************/


	/*============================================================
									GERAL
	=============================================================*/

	public static final String JOPINPUT_MATRICULA = getString("JOPINPUT_MATRICULA");
	public static final String MATRICULA_INEXISTENTE = getString("MATRICULA_INEXISTENTE");

	/*============================================================
						ACTION COMMAND - LISTENER
	=============================================================*/

	public static final String DEVOLVER = getString("DEVOLVER");
	public static final String REMOVER = getString("REMOVER");
	public static final String PEGAR = getString("PEGAR");
	public static final String VOLTAR = getString("VOLTAR");
	public static final String SAIR = getString("SAIR");
	public static final String VER = getString("VER") ;

	/*============================================================
								TELA CHAVES
	 =============================================================*/

	public static final String CHAVE_LIBERADA = getString("CHAVE_LIBERADA");
	public static final String CHAVE_ALUGADA = getString("CHAVE_ALUGADA");
	public static final String CHAVE_SELECIONAR_PEGAR = getString("CHAVE_SELECIONAR_PEGAR");
	public static final String SELECIONE_CHAVE = getString("SELECIONE_CHAVE");
	public static final String CHAVES_COL1 = getString("CHAVES_COL1");
	public static final String CHAVES_COL2 = getString("CHAVES_COL2");
	public static final String CHAVES_COL3 = getString("CHAVES_COL3");
	public static final String CHAVES_COL4 = getString("CHAVES_COL4");
	public static final String CHAVES_BT1 = getString("CHAVES_BT1");
	public static final String CHAVES_BT2 = getString("CHAVES_BT2");
	public static final String CHAVES_BT3 = getString("CHAVES_BT3");
	public static final String CHAVES_LB1 = getString("CHAVES_LB1");
	public static final String CHAVES_LB2 = getString("CHAVES_LB2");
	public static final String CHAVES_R2 = getString("CHAVES_R2");
	public static final String CHAVES_R1 = getString("CHAVES_R1");
	public static final String TITULO_CHAVES = getString("TITULO_CHAVES");


	/*============================================================
							TELA PRINCIPAL
	=============================================================*/

	public static final String TITULO_INICIO = getString("TITULO_INICIO");
	public static final String PRINCIPAL_BT1 = getString("PRINCIPAL_BT1");
	public static final String PRINCIPAL_BT2 = getString("PRINCIPAL_BT2");;
	public static final String PRINCIPAL_BT3 = getString("PRINCIPAL_BT3");;
	public static final String PRINCIPAL_BT4 = getString("PRINCIPAL_BT4");

	/*============================================================
							TELA FUNCIONARIOS
	=============================================================*/

	public static final String FUNCIONARIOS_BT1 = getString("FUNCIONARIOS_BT1");
	public static final String FUNCIONARIOS_BT2 = getString("FUNCIONARIOS_BT2");
	public static final String FUNCIONARIOS_BT3 = getString("FUNCIONARIOS_BT3");
	public static final String FUNCIONARIOS_BT4 = getString("FUNCIONARIOS_BT4");
	public static final String TELA_FUNCIONARIOS = getString("TELA_FUNCIONARIOS");
	public static final String FUNCIONARIOS_LB1 = getString("FUNCIONARIOS_LB1");
	public static final String FUNCIONARIOS_LB2 = getString("FUNCIONARIOS_LB2");
	public static final String FUNCIONARIOS_LB3 = getString("FUNCIONARIOS_LB3");
	public static final String FUNCIONARIOS_LB4 = getString("FUNCIONARIOS_LB4");
	public static final String FUNCIONARIOS_LB5 = getString("FUNCIONARIOS_LB5");
	public static final String FUNCIONARIOS_LB6 = getString("FUNCIONARIOS_LB6");
	public static final String ADICIONAR = getString("ADICIONAR");
	public static final String EDITAR = getString("EDITAR");
	public static final String FUNCIONARIOS_COL1 = getString("FUNCIONARIOS_COL1");
	public static final String FUNCIONARIOS_COL2 = getString("FUNCIONARIOS_COL2");
	public static final String FUNCIONARIOS_COL3 = getString("FUNCIONARIOS_COL3");
	public static final String FUNCIONARIOS_COL4 = getString("FUNCIONARIOS_COL4");
	public static final String FUNCIONARIOS_COL5 = getString("FUNCIONARIOS_COL5");
	public static final String FUNCIONARIOS_MSG1 = getString("FUNCIONARIOS_MSG1");
	public static final String FUNCIONARIOS_MSG2 = getString("FUNCIONARIOS_MSG2");
	public static final String FUNCIONARIOS_MSG3 = getString("FUNCIONARIOS_MSG3");










	/** para ajustar **/

	private static String getString(String key) {
		try {
			return propriedades.getProperty(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static String formatString(String key, Object... args) {
		return String.format(getString(key), args);
	}

}
