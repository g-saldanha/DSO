package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ufsc.ine5605.grupo3.controladores.ControladorFuncionario;
import br.ufsc.ine5605.grupo3.controladores.ControladorVeiculos;
import br.ufsc.ine5605.grupo3.entidades.Cargo;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

public class TelaPermissaoVeiculos extends JFrame implements ActionListener{


    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JLabel bemVindo;
	private JLabel escolha;
	private JButton bCancelar;
	private JButton bConfirmar;
	private JTable veiculosPermitidos;
	private JScrollPane scrollPane;
	private Integer i;
	private String string;
	private Integer j;
	private Integer k;
	private Cargo cargo;



	public TelaPermissaoVeiculos(Integer i, String string, Integer j, Integer k, Cargo cargo) {
		super("Tela de Permissões de Veículos");
		this.i = i;
		this.string = string;
		this.j = j;
		this.k = k;
		this.cargo = cargo;
		this.inic();
	}


	public void inic() {
//		configurando
		Container container = this.getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

//		instanciando componentes
		this.bemVindo = new JLabel("Escolha o veículo que os Funcionario terá acesso");
		this.escolha = new JLabel("Lista de Veículos");
		this.bCancelar = new JButton("Cancelar");
		this.bConfirmar = new JButton("Confirmar");
		this.veiculosPermitidos = new JTable();


//		configuração dos botoes
		this.bCancelar.setActionCommand("Cancelar");
		this.bCancelar.addActionListener(this);

		this.bConfirmar.setActionCommand("Confirmar");
		this.bConfirmar.addActionListener(this);

		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridx = 1;
		constraints.gridy = 0;
		container.add(this.bemVindo, constraints);
		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridx = 1;
		constraints.gridy = 1;
		container.add(this.escolha, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 2;
		container.add(this.bCancelar, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 2;
		constraints.gridy = 2;
		container.add(this.bConfirmar, constraints);
//      tabela
		this.veiculosPermitidos.setFillsViewportHeight(true);
		this.veiculosPermitidos.setPreferredScrollableViewportSize(new Dimension(400, 70));
		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 3;
		constraints.gridheight = 4;
		DefaultTableModel tModelo = new DefaultTableModel();
		tModelo.addColumn("Placa");
		tModelo.addColumn("Modelo");
		tModelo.addColumn("Tipo");
		for (Veiculo v : ControladorVeiculos.getInstance().getVeiculos()) {
			tModelo.addRow(new Object[]{v.getPlaca(),v.getModelo(),v.getTipo()});
		}
		this.veiculosPermitidos.setModel(tModelo);
		this.scrollPane = new JScrollPane(this.veiculosPermitidos);
		container.add(this.scrollPane, constraints);
//      Fim tabela

		this.setSize(800,600);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getActionCommand().equals("Confirmar")){
    		ArrayList<Veiculo> veiculos = new ArrayList<>();
    		int[] linhas = this.veiculosPermitidos.getSelectedRows();
    		for (int i : linhas) {
				String placa = (String) this.veiculosPermitidos.getValueAt(i, 0);
				 veiculos.add(ControladorVeiculos.getInstance().pegaVeiculo(placa));
			}
    		String msg = ControladorFuncionario.getInstance().cadastraFuncionario(this.i, this.string, this.j, this.k, this.cargo, veiculos);
			JOptionPane.showMessageDialog(null, msg);
			ControladorFuncionario.getInstance().exibeTelaFuncionario();
    	}
    	if(e.getActionCommand().equals("Cancelar")){
    		this.setVisible(false);
    		ControladorFuncionario.getInstance().exibeTelaCadastroFuncionario();
    	}
    }

}