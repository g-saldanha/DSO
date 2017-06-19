package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


	public TelaFuncionarios() {
		super("Tela de Funcionarios");
		this.inic();
	}

	@Override
	public void inic() {
//	Configurando Container e tipo de layout
		Container container = this.getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

//		Instanciando os componentes
		this.bemVindo = new JLabel();
		this.lMatricula = new JLabel();
		this.tMatricula = new JTextField();
		this.lNome = new JLabel();
		this.tNome = new JTextField();
		this.lDataNasc = new JLabel();
		this.tDataNasc = new JTextField();
		this.lTelefone = new JLabel();
		this.tTelefone = new JTextField();
		this.lCargo = new JLabel();
		this.cCargo = new JComboBox<>();
		this.lTipos = new JLabel();
		this.cTipo = new JComboBox<>();
		this.bAdicionar = new JButton();
		this.bRemover = new JButton();
		this.bVoltar = new JButton();
		this.bEditar = new JButton();
		this.bSair = new JButton();
		this.tbFuncionarios = new JTable();

//		Colocando os textos nos componentes
		this.bemVindo.setText("Bem vindo a Tela de Funcionários");
		this.bSair.setText("Sair");
		this.bEditar.setText("Texto");
		this.bVoltar.setText("Voltar");
		this.bRemover.setText("Remover");
		this.bAdicionar.setText("Adicionar");
		this.lMatricula.setText("Digite a Matricula");
		this.lNome.setText("Digite o nome");
		this.lDataNasc.setText("Digite a Data de Nascimento");
		this.lTelefone.setText("Digite o Telefone");
		this.lCargo.setText("Escolha o Cargo");
		this.lTipos.setText("Escolha o tipo de Veículo");
		this.bAdicionar.setText("Adicionar Funcionário");
		this.bEditar.setText("Editar Funcionário");
		this.bVoltar.setText("Voltar");
		this.bSair.setText("Sair");

//		Colocando as ações nos botões
		this.bAdicionar.setActionCommand("Adicionar");
		this.bAdicionar.addActionListener(this);

		this.bEditar.setActionCommand("Editar");
		this.bEditar.addActionListener(this);

		this.bRemover.setActionCommand("Remover");
		this.bRemover.addActionListener(this);

		this.bVoltar.setActionCommand("Voltar");
		this.bVoltar.addActionListener(this);

		this.bSair.setActionCommand("Sair");
		this.bSair.addActionListener(this);

//        Adicionando e instanciando na Tela os componentes
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 0;
		container.add(this.bemVindo, constraints);
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
		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridy = 3;
		constraints.gridheight = 6;
		constraints.gridheight = 5;
		this.scrollPane = new JScrollPane(this.tbFuncionarios);
		container.add(this.scrollPane, constraints);
//        Fim tabela

		this.setSize(800,600);

//		Botão de Fechar
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void atualizaLista() {
		DefaultTableModel tModelo = new DefaultTableModel();
		tModelo.addColumn("Matricula");
		tModelo.addColumn("Nome");
		tModelo.addColumn("Nascimento");
		tModelo.addColumn("Telefone");
		tModelo.addColumn("Cargo");
//		tModelo.addColumn("Tipo");

		for (Funcionario f : ControladorFuncionario.getInstance().getListaFuncionarios()){
			tModelo.addRow(new Object[]{f.getNumeroMatricula(), f.getNome(), f.getDataNascimento(), f.getTelefone(), f.getCargo()});
		}

		this.tbFuncionarios.setModel(tModelo);
		this.repaint();

	}

	@Override
	public void sair() {
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Adicionar")){
			ControladorFuncionario.getInstance().exibeTelaCadastroFuncionario();
		}
		if (e.getActionCommand().equals("Editar")){
			try {
				Funcionario f = ControladorFuncionario.getInstance().getFuncionario((Integer) this.tbFuncionarios.getValueAt(this.tbFuncionarios.getSelectedRow(), 0));
				ControladorFuncionario.getInstance().exibeTelaCadastroFuncionario(f);
			} catch (ArrayIndexOutOfBoundsException e2) {
				JOptionPane.showMessageDialog(null, "Selecione um Funcionário");
			}

		}
		if (e.getActionCommand().equals("Remover")){
			Integer m = (Integer) this.tbFuncionarios.getValueAt(this.tbFuncionarios.getSelectedRow(),0);
			ControladorFuncionario.getInstance().excluiFuncionario(ControladorFuncionario.getInstance().getFuncionario(m));
		}
		if (e.getActionCommand().equals("Voltar")){

			this.setVisible(false);
			ControladorPrincipal.getInstance().voltarMenuPrincipal();
		}
		if (e.getActionCommand().equals("Sair")){
			this.sair();
		}
	}
}
