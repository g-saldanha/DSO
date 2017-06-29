package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ufsc.ine5605.grupo3.apresentacaoJFrame.Exception.CadastroBloqueadoException;
import br.ufsc.ine5605.grupo3.apresentacaoJFrame.Exception.CadastroIncorretoException;
import br.ufsc.ine5605.grupo3.controladores.ControladorChave;
import br.ufsc.ine5605.grupo3.controladores.ControladorFuncionario;
import br.ufsc.ine5605.grupo3.controladores.ControladorPrincipal;
import br.ufsc.ine5605.grupo3.entidades.Chave;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;
import br.ufsc.ine5605.grupo3.mensagens.Messages;;


public class TelaChaves extends JFrame implements Tela, ActionListener {
	// Atributos
	private JLabel bemVindo; //LB1
	private JLabel lista; //LB2
	private JTable tChaves;
	private JScrollPane scrollPane;
	private JButton pegar; //BT1
	private JButton bDevolver; //BT2
	private JButton bFiltroPorMatricula; //BT3
	private JButton bRemover;
	private JButton bVoltar;
	private JButton bSair;
	DefaultTableModel tModelo;


	public TelaChaves() {
		super(Messages.TITULO_CHAVES);
		inic();
	}

	@Override
	public void inic() {
		// Instanciar Container e Layout
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		// Instanciando os componentes
		this.bemVindo = new JLabel();
		this.lista = new JLabel();
		this.tChaves = new JTable();
		this.pegar = new JButton();
		this.bDevolver = new JButton();
		this.bFiltroPorMatricula = new JButton(Messages.CHAVES_BT3);
		this.bVoltar = new JButton();
		this.bSair = new JButton();
		this.bRemover = new JButton();

		// Colocando os textos nos componentes
		this.bemVindo.setText(Messages.CHAVES_LB1);
		this.lista.setText(Messages.CHAVES_LB2);
		this.pegar.setText(Messages.CHAVES_BT1);
		this.bDevolver.setText(Messages.CHAVES_BT2);
		this.bRemover.setText(Messages.REMOVER);
		this.bVoltar.setText(Messages.VOLTAR);
		this.bSair.setText(Messages.SAIR);

		// Configurando ações dos botões
		this.pegar.setActionCommand (Messages.PEGAR);
		this.pegar.addActionListener(this);

		this.bDevolver.setActionCommand (Messages.DEVOLVER);
		this.bDevolver.addActionListener(this);

		this.bRemover.setActionCommand (Messages.REMOVER);
		this.bRemover.addActionListener(this);

		this.bSair.setActionCommand (Messages.SAIR);
		this.bSair.addActionListener(this);

		this.bVoltar.setActionCommand (Messages.VOLTAR);
		this.bVoltar.addActionListener(this);

		this.bFiltroPorMatricula.setActionCommand (Messages.VER);
		this.bFiltroPorMatricula.addActionListener(this);

		// Adicionando e instanciando na Tela os componentes
		constraints.gridx = 1;
		constraints.gridy = 0;
		container.add(this.bemVindo, constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(this.pegar, constraints);
		constraints.gridx = 1;
		constraints.gridy = 1;
		container.add(this.bDevolver, constraints);
		constraints.gridx = 2;
		constraints.gridy = 1;
		container.add(this.bRemover, constraints);
		constraints.gridx = 0;
		constraints.gridy = 4;
		container.add(this.bSair, constraints);
		constraints.gridx = 2;
		constraints.gridy = 4;
		container.add(this.bVoltar, constraints);
		constraints.gridx = 0;
		constraints.gridy = 2;
		container.add(this.bFiltroPorMatricula, constraints);
		constraints.gridx = 1;
		constraints.gridy = 2;
		container.add(this.lista, constraints);
		// tabela
		this.tChaves.setFillsViewportHeight(true);
		this.tChaves.setPreferredScrollableViewportSize(new Dimension(300,100));
		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridy = 3;
		constraints.gridheight = 5;
		constraints.gridheight = 5;
		this.scrollPane = new JScrollPane(this.tChaves);
		container.add(this.scrollPane, constraints);
		// Fim tabela

		// Configurando o Layout
		this.setSize(800, 600);

		// Botão de fechar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void criaColuna(){
		this.tModelo = new DefaultTableModel();
		this.tModelo.addColumn (Messages.CHAVES_COL1);
		this.tModelo.addColumn (Messages.CHAVES_COL2);
		this.tModelo.addColumn (Messages.CHAVES_COL3);
		this.tModelo.addColumn (Messages.CHAVES_COL4);
	}

	@Override
	public void atualizaLista() {
		criaColuna();

		for (Chave c : ControladorChave.getInstance().getChaves()) {
			try {
				this.tModelo.addRow(new Object[] { c.getID(), c.getPlaca(), c.getModelo(), c.getEstado() });
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		this.tChaves.setModel(this.tModelo);
		this.repaint();

	}

	public void atualizaLista(Funcionario f) {
		criaColuna();

		for (Chave c : ControladorChave.getInstance().getChaves()) {
			for(Veiculo v : f.getTiposDeVeiculo()){
			if(c.getPlaca().equals(v.getPlaca())){
				try {
					this.tModelo.addRow(new Object[] { c.getID(), c.getPlaca(), c.getModelo(), c.getEstado() });
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}


		this.tChaves.setModel(this.tModelo);
		this.repaint();
		}

	}

	@Override
	public void sair() {
		dispose();
	}
	private void onClickPegar(){
		String m;
		try {
			Long id = (Long) this.tChaves.getValueAt(this.tChaves.getSelectedRow(), 0);
			Integer j = Integer.parseInt(JOptionPane.showInputDialog(Messages.JOPINPUT_MATRICULA));
			Funcionario f = ControladorPrincipal.getInstance().pegaFuncionario(j);
			m = ControladorChave.getInstance().cederChave(f, ControladorChave.getInstance().getChave(id));
			JOptionPane.showMessageDialog(null, m);
		} catch (ArrayIndexOutOfBoundsException e2) {
			m = Messages.CHAVE_SELECIONAR_PEGAR;
			JOptionPane.showMessageDialog(null, m);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (CadastroBloqueadoException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(Messages.PEGAR)){
			onClickPegar();
		}

		if (e.getActionCommand().equals(Messages.DEVOLVER)) {
			onClickDevolver();

		}

		if (e.getActionCommand().equals (Messages.REMOVER)) {
			onClickRemover();
		}

		if (e.getActionCommand().equals (Messages.VOLTAR)) {
			onClickVoltar();
		}

		if (e.getActionCommand().equals (Messages.SAIR)) {
			sair();
		}

		if (e.getActionCommand().equals (Messages.VER)) {
			onClickVer();
		}

	}

	private void onClickVoltar() {
		setVisible(false);
			ControladorChave.getInstance().voltarMenuPrincipal();

	}

	private void onClickRemover() {
		Integer m = Integer.parseInt(JOptionPane.showInputDialog (Messages.JOPINPUT_MATRICULA));
		Long id = (Long) this.tChaves.getValueAt(this.tChaves.getSelectedRow(), 0);

		ControladorChave.getInstance().deletarChave(id, m);

	}

	private void onClickDevolver() {
		try {
			String i = JOptionPane.showInputDialog(Messages.JOPINPUT_MATRICULA);
			Integer m = Integer.parseInt(i != null? i : "0");
			Long id = (Long) this.tChaves.getValueAt(this.tChaves.getSelectedRow(), 0);
			ControladorChave.getInstance().devolverChave(ControladorChave.getInstance().pegaFuncionario(m), ControladorChave.getInstance().getChave(id));
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, Messages.SELECIONE_CHAVE);
			throw new ArrayIndexOutOfBoundsException();
		}

	}

	private void onClickVer() throws IOException {
		String mat =  JOptionPane.showInputDialog (Messages.JOPINPUT_MATRICULA);
		Funcionario f;
		try {
			f = ControladorFuncionario.getInstance().getFuncionario(Integer.parseInt(mat));
			atualizaLista(f);
		} catch (CadastroIncorretoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}



	}
}
