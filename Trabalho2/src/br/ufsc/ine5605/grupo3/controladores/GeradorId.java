package br.ufsc.ine5605.grupo3.controladores;

public class GeradorId {
	private static Long ID = 1L;

	public static Long getNextID() {
		if (!ControladorChave.getInstance().getChaves().isEmpty()) {
			return ID = ControladorChave.getInstance().getChaves().size() + 1L;
		}
		return ID++;
	}
}
