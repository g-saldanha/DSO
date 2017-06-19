package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import java.awt.Checkbox;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.ufsc.ine5605.grupo3.entidades.Funcionario;

public class TelaPermissaoVeiculos extends JFrame implements ActionListener{
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel bemVindo;
	private JLabel escolha;
	private JButton bCancelar;
	private JButton bConfirmar;
	private List<Checkbox> veiculosPermitidos;
	
	
	
	public TelaPermissãoVeiculos() {
		super("Tela de Permissões de Veículos");
		this.inic();
	    List<Checkbox> checkboxes = new ArrayList<Checkbox>();
	    String labels[] = {"A", "B", "C", "D", "E", "F"};
	    for (int i = 0; i < labels.length; i++) {
	        Checkbox checkbox = new Checkbox(labels[i]);
	        checkboxes.add(checkbox); //for further use you add it to the list
	    }
	}


	public void inic() {
//		configurando
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
//		instanciando componentes
		bemVindo = new JLabel("Escolha o veículo que os Funcionario terá acesso");
		escolha = new JLabel("Lista de Veículos");
		
		
		
		
		
		
//		
		
    }


    public static void inic(Funcionario funcionario) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
