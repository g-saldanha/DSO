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

	/******************************
	 		* PERSISTÊNCIA *
	 ******************************/

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
	public static final String JOPDIALOG_MATRICULA = getString("JOPDIALOG_MATRICULA");
	public static final String MATRICULA_INEXISTENTE = getString("MATRICULA_INEXISTENTE");
	public static final String JOPDIALOG_REGISTRO = "JOPDIALOG_REGISTRO";
	public static final String PERMISSAO = "PERMISSAO";
	public static final String NEGACAO = "NEGACAO";
	public static final String NAO = "NAO";
	public static final String SIM = "SIM";


	/*============================================================
						ACTION COMMAND - LISTENER
	=============================================================*/

	public static final String DEVOLVER = getString("DEVOLVER");
	public static final String REMOVER = getString("REMOVER");
	public static final String PEGAR = getString("PEGAR");
	public static final String VOLTAR = getString("VOLTAR");
	public static final String SAIR = getString("SAIR");
	public static final String VER = getString("VER") ;
	public static final String ADICIONAR = getString("ADICIONAR");
	public static final String EDITAR = getString("EDITAR");
	public static final String CADASTRAR = getString("CADASTRAR");
	public static final String CANCELAR = getString("CANCELAR");
	public static final String CONFIRMAR = getString("CONFIRMAR");

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
	public static final String FUNCIONARIOS_BT5 = getString("FUNCIONARIOS_BT5");
	public static final String FUNCIONARIOS_BT6 = getString("FUNCIONARIOS_BT6");
	public static final String FUNCIONARIOS_BT7 = getString("FUNCIONARIOS_BT7");
	public static final String TELA_FUNCIONARIOS = getString("TELA_FUNCIONARIOS");
	public static final String FUNCIONARIOS_LB1 = getString("FUNCIONARIOS_LB1");
	public static final String FUNCIONARIOS_LB2 = getString("FUNCIONARIOS_LB2");
	public static final String FUNCIONARIOS_LB3 = getString("FUNCIONARIOS_LB3");
	public static final String FUNCIONARIOS_LB4 = getString("FUNCIONARIOS_LB4");
	public static final String FUNCIONARIOS_LB5 = getString("FUNCIONARIOS_LB5");
	public static final String FUNCIONARIOS_LB6 = getString("FUNCIONARIOS_LB6");
	public static final String FUNCIONARIOS_LB7_1 = getString("FUNCIONARIOS_LB7_1");
	public static final String FUNCIONARIOS_LB7_2 = getString("FUNCIONARIOS_LB7_2");
	public static final String FUNCIONARIOS_LB8 = getString("FUNCIONARIOS_LB8");
	public static final String FUNCIONARIOS_LB9 = getString("FUNCIONARIOS_LB9");
	public static final String FUNCIONARIOS_LB10 = getString("FUNCIONARIOS_LB10");
	public static final String FUNCIONARIOS_LB11 = getString("FUNCIONARIOS_LB11");
	public static final String FUNCIONARIOS_LB12 = getString("FUNCIONARIOS_LB12");
	public static final String FUNCIONARIOS_LB13 = getString("FUNCIONARIOS_LB13");
	public static final String FUNCIONARIOS_LB14 = getString("FUNCIONARIOS_LB14");

	public static final String FUNCIONARIOS_COL1 = getString("FUNCIONARIOS_COL1");
	public static final String FUNCIONARIOS_COL2 = getString("FUNCIONARIOS_COL2");
	public static final String FUNCIONARIOS_COL3 = getString("FUNCIONARIOS_COL3");
	public static final String FUNCIONARIOS_COL4 = getString("FUNCIONARIOS_COL4");
	public static final String FUNCIONARIOS_COL5 = getString("FUNCIONARIOS_COL5");
	public static final String FUNCIONARIOS_MSG1 = getString("FUNCIONARIOS_MSG1");
	public static final String FUNCIONARIOS_MSG2 = getString("FUNCIONARIOS_MSG2");
	public static final String FUNCIONARIOS_MSG3 = getString("FUNCIONARIOS_MSG3");
	public static final String FUNCIONARIOS_MSG4 = getString("FUNCIONARIOS_MSG4");

	/*============================================================
						TELA VEÍCULOS
	=============================================================*/

	public static final String TITULO_CADVEICULOS = getString("TITULO_CADVEICULOS");
	public static final String TITULO_EDVEICULOS = getString("TITULO_EDVEICULOS");

	public static final String VEICULOS_LB1 = getString("VEICULOS_LB1");
	public static final String VEICULOS_LB2 = getString("VEICULOS_LB2");
	public static final String VEICULOS_LB3 = getString("VEICULOS_LB3");
	public static final String VEICULOS_LB4 = getString("VEICULOS_LB4");
	public static final String VEICULOS_LB5 = getString("VEICULOS_LB5");
	public static final String VEICULOS_LB6 = getString("VEICULOS_LB6");
	public static final String VEICULOS_LB7 = getString("VEICULOS_LB7");
	public static final String VEICULOS_LB8 = getString("VEICULOS_LB8");
	public static final String VEICULOS_LB9 = getString("VEICULOS_LB9");
	public static final String VEICULOS_LB10 = getString("VEICULOS_LB10");
	public static final String VEICULOS_LB11 = getString("VEICULOS_LB11");
	public static final String VEICULOS_LB12 = getString("VEICULOS_LB12");
	public static final String VEICULOS_LB13 = getString("VEICULOS_LB13");
	public static final String VEICULOS_LB14 = getString("VEICULOS_LB14");
	public static final String VEICULOS_LB15 = getString("VEICULOS_LB15");


	public static final String VEICULOS_BT1 = getString("VEICULOS_BT1");
	public static final String VEICULOS_BT2 = getString("VEICULOS_BT2");
	public static final String VEICULOS_BT3 = getString("VEICULOS_BT3");
	public static final String VEICULOS_BT4 = getString("VEICULOS_BT4");

	public static final String VEICULOS_MSG1 = getString("VEICULOS_MSG1");
	public static final String VEICULOS_MSG2 = getString("VEICULOS_MSG2");
	public static final String VEICULOS_MSG3 = getString("VEICULOS_MSG3");
	public static final String VEICULOS_MSG4 = getString("VEICULOS_MSG4");
	public static final String VEICULOS_MSG5 = getString("VEICULOS_MSG5");
	public static final String VEICULOS_MSG6 = getString("VEICULOS_MSG6");

	public static final String VEICULOS_COL1 = getString("VEICULOS_COL1");
	public static final String VEICULOS_COL2 = getString("VEICULOS_COL2");
	public static final String VEICULOS_COL3 = getString("VEICULOS_COL3");
	public static final String VEICULOS_COL4 = getString("VEICULOS_COL4");
	public static final String VEICULOS_COL5 = getString("VEICULOS_COL5");
	public static final String VEICULOS_COL6 = getString("VEICULOS_COL6");
	public static final String TITULO_PERMISSAO = getString("TITULO_PERMISSAO");

	/*============================================================
						TELA REGISTROS
	=============================================================*/
	public static final String REGISTROS_LB1 = getString("REGISTROS_LB1");
	public static final String REGISTROS_LB2 = getString("REGISTROS_LB2");
	public static final String REGISTROS_LB3 = getString("REGISTROS_LB3");
	public static final String REGISTROS_LB4 = getString("REGISTROS_LB4");
	public static final String REGISTROS_LB5 = getString("REGISTROS_LB5");
	public static final String REGISTROS_LB6 = getString("REGISTROS_LB6");
	public static final String REGISTROS_LB7 = getString("REGISTROS_LB7");



	public static final String REGISTROS_BT1 = getString("REGISTROS_BT1");
	public static final String REGISTROS_BT2 = getString("REGISTROS_BT2");
	public static final String REGISTROS_BT3 = getString("REGISTROS_BT3");
	public static final String REGISTROS_BT4 = getString("REGISTROS_BT4");
	public static final String REGISTROS_BT5 = getString("REGISTROS_BT5");
	public static final String REGISTROS_BT6 = getString("REGISTROS_BT6");


	public static final String REGISTROS_MSG1 = getString("REGISTROS_MSG1");
	public static final String REGISTROS_MSG2 = getString("REGISTROS_MSG2");
	public static final String REGISTROS_MSG3 = getString("REGISTROS_MSG3");
	public static final String REGISTROS_MSG4 = getString("REGISTROS_MSG4");
	public static final String REGISTROS_MSG5 = getString("REGISTROS_MSG5");
	public static final String REGISTROS_MSG6 = getString("REGISTROS_MSG6");

	public static final String REGISTROS_COL1 = getString("REGISTROS_COL1");
	public static final String REGISTROS_COL2 = getString("REGISTROS_COL2");
	public static final String REGISTROS_COL3 = getString("REGISTROS_COL3");
	public static final String REGISTROS_COL4 = getString("REGISTROS_COL4");
	public static final String REGISTROS_COL5 = getString("REGISTROS_COL5");
	public static final String REGISTROS_COL6 = getString("REGISTROS_COL6");
	public static final String REGISTROS_COL7 = getString("REGISTROS_COL7");
	public static final String REGISTROS_COL8 = getString("REGISTROS_COL8");




	/** MÉTODOS **/

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
