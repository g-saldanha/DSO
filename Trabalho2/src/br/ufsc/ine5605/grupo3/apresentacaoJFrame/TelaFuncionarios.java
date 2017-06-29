package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.ufsc.ine5605.grupo3.controladores.ControladorFuncionario;
import br.ufsc.ine5605.grupo3.controladores.ControladorPrincipal;
import br.ufsc.ine5605.grupo3.entidades.Cargo;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;
import br.ufsc.ine5605.grupo3.mensagens.Messages;

/**
 *
 * @author Caio & Gabriel
 */
public class TelaFuncionarios extends JFrame implements Tela, ActionListener {

	private JLabel bemVindo;
	private JLabel lMatricula;
	private JLabel lNome;
	private JLabel lDataNasc;
	private JLabel lTelefone;
	private JLabel lCargo;
	private JLabel lTipos;
	private JTextField tMatricula;
	private JTextField tNome;
	private JTextField tDataNasc;
	private JTextField tTelefone;
	private JComboBox<Cargo> cCargo;
	private JComboBox<Veiculo> cTipo;
	private JButton bAdicionar;
	private JButton bEditar;
	private JButton bRemover;
	private JButton bVoltar;
	private JButton bSair;
	private JTable tbFuncionarios;
	private JScrollPane scrollPane;
	private JButton bVerVeiculos;


	public TelaFuncionarios() {
		super(Messages.TELA_FUNCIONARIOS);
		inic();
	}

	@Override
	public void inic() {
//	Configurando Container e tipo de layout
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

//		Instanciando os componentes
		this.bemVindo = new JLabel(Messages.FUNCIONARIOS_LB1);
		this.lMatricula = new JLabel(Messages.JOPINPUT_MATRICULA);
		this.tMatricula = new JTextField();
		this.lNome = new JLabel(Messages.FUNCIONARIOS_LB2);
		this.tNome = new JTextField();
		this.lDataNasc = new JLabel(Messages.FUNCIONARIOS_LB3);
		this.tDataNasc = new JTextField();
		this.lTelefone = new JLabel(Messages.FUNCIONARIOS_LB4);
		this.tTelefone = new JTextField();
		this.lCargo = new JLabel(Messages.FUNCIONARIOS_LB5);
		this.cCargo = new JComboBox<>();
		this.lTipos = new JLabel(Messages.FUNCIONARIOS_LB6);
		this.cTipo = new JComboBox<>();
		this.bAdicionar = new JButton(Messages.FUNCIONARIOS_BT1);
		this.bRemover = new JButton(Messages.REMOVER);
		this.bVoltar = new JButton(Messages.VOLTAR);
		this.bEditar = new JButton(Messages.FUNCIONARIOS_BT2);
		this.bSair = new JButton(Messages.SAIR);
		this.tbFuncionarios = new JTable();
		this.bVerVeiculos = new JButton(Messages.FUNCIONARIOS_BT3);


//		Colocando as ações nos botões
		this.bAdicionar.setActionCommand(Messages.ADICIONAR);
		this.bAdicionar.addActionListener(this);

		this.bEditar.setActionCommand(Messages.EDITAR);
		this.bEditar.addActionListener(this);

		this.bRemover.setActionCommand(Messages.REMOVER);
		this.bRemover.addActionListener(this);

		this.bVoltar.setActionCommand(Messages.VOLTAR);
		this.bVoltar.addActionListener(this);

		this.bSair.setActionCommand(Messages.SAIR);
		this.bSair.addActionListener(this);

		this.bVerVeiculos.setActionCommand(Messages.VER);
		this.bVerVeiculos.addActionListener(this);

//        Adicionando e instanciando na Tela os componentes
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 0;
		container.add(this.bemVindo, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 0;
		container.add(this.bVerVeiculos, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(this.bAdicionar, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 1;
		container.add(this.bEditar, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 2;
		constraints.gridy = 1;
		container.add(this.bRemover, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 4;
		container.add(this.bSair, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 2;
		constraints.gridy = 4;
		container.add(this.bVoltar, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 2;
		container.add(this.tbFuncionarios, constraints);
//        tabela
		this.tbFuncionarios.setFillsViewportHeight(true);
		this.tbFuncionarios.setPreferredScrollableViewportSize(new Dimension(300, 100));
		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridy = 3;
		constraints.gridheight = 6;
		constraints.gridheight = 5;
		this.scrollPane = new JScrollPane(this.tbFuncionarios);
		container.add(this.scrollPane, constraints);
//        Fim tabela

		this.setSize(800,600);

//		Botão de Fechar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void atualizaLista() {
		DefaultTableModel tModelo = new DefaultTableModel();
		tModelo.addColumn(Messages.FUNCIONARIOS_COL1);
		tModelo.addColumn(Messages.FUNCIONARIOS_COL2);
		tModelo.addColumn(Messages.FUNCIONARIOS_COL3);
		tModelo.addColumn(Messages.FUNCIONARIOS_COL4);
		tModelo.addColumn(Messages.FUNCIONARIOS_COL5);

		for (Funcionario f : ControladorFuncionario.getInstance().getListaFuncionarios()){
			tModelo.addRow(new Object[]{f.getNumeroMatricula(), f.getNome(), f.getDataNascimento(), f.getTelefone(), f.getCargo()});
		}

		this.tbFuncionarios.setModel(tModelo);
		this.repaint();

	}

	@Override
	public void sair() {
		dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(Messages.ADICIONAR)){
			ControladorFuncionario.getInstance().exibeTelaCadastroFuncionario();
		}
		if (e.getActionCommand().equals(Messages.EDITAR)){
			try {
				Funcionario f = ControladorFuncionario.getInstance().getFuncionario((Integer) this.tbFuncionarios.getValueAt(this.tbFuncionarios.getSelectedRow(), 0));
				ControladorFuncionario.getInstance().exibeTelaCadastroFuncionario(f);
			} catch (ArrayIndexOutOfBoundsException e2) {
				JOptionPane.showMessageDialog(null, Messages.FUNCIONARIOS_MSG1);
			}

		}
		if (e.getActionCommand().equals(Messages.REMOVER)){
			Integer m = (Integer) this.tbFuncionarios.getValueAt(this.tbFuncionarios.getSelectedRow(),0);
			ControladorFuncionario.getInstance().excluiFuncionario(ControladorFuncionario.getInstance().getFuncionario(m));
		}
		if (e.getActionCommand().equals(Messages.VOLTAR)){

			setVisible(false);
			try {
				ControladorPrincipal.getInstance().voltarMenuPrincipal();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getActionCommand().equals(Messages.SAIR)){
			sair();
		}
		if (e.getActionCommand().equals(Messages.VER)) {
			Cargo c = (Cargo) this.tbFuncionarios.getValueAt(this.tbFuncionarios.getSelectedRow(), 4);
			if(c.equals(Cargo.DIRETORIA)){
				JOptionPane.showMessageDialog(null, Messages.FUNCIONARIOS_MSG2);
			} else {
				try {
					String msg = "";
					for (Veiculo v :
						ControladorFuncionario.getInstance().getFuncionario((Integer) this.tbFuncionarios.getValueAt(this.tbFuncionarios.getSelectedRow(), 0)).getTiposDeVeiculo()) {
						msg += Messages.formatString(Messages.FUNCIONARIOS_MSG4, v.getPlaca(), v.getModelo());
					}
					JOptionPane.showMessageDialog(null, msg);
				} catch (ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, Messages.FUNCIONARIOS_MSG3);
				}
			}
		}
	}
}
