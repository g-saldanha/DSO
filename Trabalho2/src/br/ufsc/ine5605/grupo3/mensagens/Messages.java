package br.ufsc.ine5605.grupo3.mensagens;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {

	private static final String BUNDLE_NAME = "/home/gabriel/workspaceJava/DSO/Trabalho2/src/main/resources/messages.properties"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(Messages.BUNDLE_NAME, new Locale("pt", "BR"));
/*********************************************************************************************************************
										* MENSAGENS *
\*********************************************************************************************************************/


	/*============================================================
									GERAL
	=============================================================*/
	public static final String JOPINPUT_MATRICULA = "JOPINPUT_MATRICULA";
	public static final String MATRICULA_INEXISTENTE = "MATRICULA_INEXISTENTE";

	/*============================================================
						ACTION COMMAND - LISTENER
	=============================================================*/
	public static final String DEVOLVER = "DEVOLVER";
	public static final String REMOVER = "REMOVER";
	public static final String PEGAR = "PEGAR";
	public static final String VOLTAR = "VOLTAR";
	public static final String SAIR = "SAIR";
	public static final String VER = "VER" ;

	/*============================================================
								TELA CHAVES
	 =============================================================*/
	public static final String CHAVE_LIBERADA = "CHAVE_LIBERADA";
	public static final String CHAVE_ALUGADA = "CHAVE_ALUGADA";
	public static final String CHAVE_SELECIONAR_PEGAR = "CHAVE_SELECIONAR_PEGAR";
	public static final String SELECIONE_CHAVE = "SELECIONE_CHAVE";
















	/** para ajustar **/

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static String formatString(String key, Object... args) {
		return String.format(getString(key), args);
	}

}
