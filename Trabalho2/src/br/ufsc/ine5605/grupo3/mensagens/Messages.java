package br.ufsc.ine5605.grupo3.mensagens;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	
	private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$
	
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(Messages.BUNDLE_NAME, new Locale("pt", "BR"));
/*********************************************************************************************************************
										* MENSAGENS *
\*********************************************************************************************************************/
	
	/*============================================================
								TELA CHAVES
	 =============================================================*/
	public static final String CHAVE_LIBERADA = "CHAVE_LIBERADA";
	public static final String CHAVE_ALUGADA = "CHAVE_ALUGADA";
	public static final String CHAVE_SELECIONAR_PEGAR = "CHAVE_SELECIONAR_PEGAR";
	
	
	
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
