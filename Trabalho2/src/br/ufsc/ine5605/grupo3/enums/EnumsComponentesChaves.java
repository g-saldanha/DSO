package br.ufsc.ine5605.grupo3.enums;

public enum EnumsComponentesChaves {
	COLUNA1("Chave ID"),
	COLUNA2("Placa"),
	COLUNA3("Veiculo"),
	COLUNA4("Alugada");

	private final String mensagens;

	private EnumsComponentesChaves(final String mensagens){
		this.mensagens = mensagens;
	}

	@Override
	public String toString() {
		return this.mensagens;
	}

}