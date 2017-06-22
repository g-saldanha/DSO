package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ufsc.ine5605.grupo3.apresentacaoJFrame.Exception.CadastroBloqueadoException;
import br.ufsc.ine5605.grupo3.controladores.ControladorChave;
import br.ufsc.ine5605.grupo3.controladores.ControladorFuncionario;
import br.ufsc.ine5605.grupo3.controladores.ControladorPrincipal;
import br.ufsc.ine5605.grupo3.entidades.Chave;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;
import br.ufsc.ine5605.grupo3.enums.EnumsChaves;
import br.ufsc.ine5605.grupo3.mensagens.Messages;

public class TelaChaves extends JFrame implements Tela, ActionListener {
	// Atributos
	private JLabel bemVindo;
	private JLabel lista;
	private JTable tChaves;
	private JScrollPane scrollPane;
	private JButton pegar;
	private JButton bDevolver;
	private JButton bRemover;
	private JButton bVoltar;
	private JButton bSair;
	private JButton bFiltroPorMatricula;

	public TelaChaves() {
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
		this.bRemover = new JButton();
		this.bVoltar = new JButton();
		this.bSair = new JButton();
		this.bFiltroPorMatricula = new JButton("Ver Chaves por Matricula");

		// Colocando os textos nos componentes
		this.bemVindo.setText("Bem vindo ao Claviculário");
		this.lista.setText("Lista de Chaves");
		this.pegar.setText("Pegar Chave");
		this.bDevolver.setText("Devolver Chave");
		this.bRemover.setText(Messages.getString(Messages.REMOVER));
		this.bVoltar.setText(Messages.getString(Messages.VOLTAR));
		this.bSair.setText(Messages.getString(Messages.SAIR));

		// Configurando ações dos botões
		this.pegar.setActionCommand(Messages.getString(Messages.PEGAR));
		this.pegar.addActionListener(this);

		this.bDevolver.setActionCommand(Messages.getString(Messages.DEVOLVER));
		this.bDevolver.addActionListener(this);

		this.bRemover.setActionCommand(Messages.getString(Messages.REMOVER));
		this.bRemover.addActionListener(this);

		this.bSair.setActionCommand(Messages.getString(Messages.SAIR));
		this.bSair.addActionListener(this);

		this.bVoltar.setActionCommand(Messages.getString(Messages.VOLTAR));
		this.bVoltar.addActionListener(this);

		this.bFiltroPorMatricula.setActionCommand(Messages.getString(Messages.VER));
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

	@Override
	public void atualizaLista() {
		DefaultTableModel tModelo = new DefaultTableModel();
		tModelo.addColumn(EnumsChaves.COLUNA1.toString());
		tModelo.addColumn(EnumsChaves.COLUNA2.toString());
		tModelo.addColumn(EnumsChaves.COLUNA3.toString());
		tModelo.addColumn(EnumsChaves.COLUNA4.toString());

		for (Chave c : ControladorChave.getInstance().getChaves()) {
			tModelo.addRow(new Object[] { c.getID(), c.getPlaca(), c.getModelo(), c.getEstado() });
		}

		this.tChaves.setModel(tModelo);
		this.repaint();

	}

	public void atualizaLista(Funcionario f) {
		DefaultTableModel tModelo = new DefaultTableModel();
		tModelo.addColumn(EnumsChaves.COLUNA1.toString());
		tModelo.addColumn(EnumsChaves.COLUNA2.toString());
		tModelo.addColumn(EnumsChaves.COLUNA3.toString());
		tModelo.addColumn(EnumsChaves.COLUNA4.toString());

		for (Chave c : ControladorChave.getInstance().getChaves()) {
			for(Veiculo v : f.getTiposDeVeiculo()){
			if(c.getPlaca().equals(v.getPlaca())){
				tModelo.addRow(new Object[] { c.getID(), c.getPlaca(), c.getModelo(), c.getEstado() });
			}
		}


		this.tChaves.setModel(tModelo);
		this.repaint();
		}

	}

	@Override
	public void sair() {
		dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e){

		if (e.getActionCommand().equals(Messages.getString(Messages.PEGAR))){
			try {
				Long id = (Long) this.tChaves.getValueAt(this.tChaves.getSelectedRow(), 0);
				Integer j = Integer.parseInt(JOptionPane.showInputDialog(Messages.getString(Messages.JOPINPUT_MATRICULA)));
				Funcionario f = ControladorPrincipal.getInstance().pegaFuncionario(j);
				if (f != null) {
					String m;
					try {
						int result = ControladorChave.getInstance().cederChave(ControladorChave.getInstance().pegaFuncionario(j), ControladorChave.getInstance().getChave(id));
						if (result == 0) {
							m = Messages.getString(Messages.CHAVE_LIBERADA) + f.getNome();
						} else if (result == -1) {
							m = "Usuario " + f.getNome() + " nao possui acesso a chave";
						} else if (result == -2) {
							m = "Usuario " + f.getNome() + " já possui chave";
						} else {
							m = Messages.getString(Messages.CHAVE_ALUGADA);
						}
					} catch (CadastroBloqueadoException ex) {
						m = ex.getMessage();
					}
					JOptionPane.showMessageDialog(null, m);

				} else {
					JOptionPane.showMessageDialog(null, Messages.getString(Messages.MATRICULA_INEXISTENTE));
				}
			} catch (ArrayIndexOutOfBoundsException e2) {
				String msg = Messages.getString(Messages.CHAVE_SELECIONAR_PEGAR);
				JOptionPane.showMessageDialog(null, msg);
			}

		}

		if (e.getActionCommand().equals(Messages.getString(Messages.DEVOLVER))) {
			try {
				String i = JOptionPane.showInputDialog(Messages.getString(Messages.JOPINPUT_MATRICULA));
				Integer m = Integer.parseInt(i != null? i : "0");
				Long id = (Long) this.tChaves.getValueAt(this.tChaves.getSelectedRow(), 0);
				ControladorChave.getInstance().devolverChave(ControladorChave.getInstance().pegaFuncionario(m), ControladorChave.getInstance().getChave(id));
			} catch (ArrayIndexOutOfBoundsException e2) {
				JOptionPane.showMessageDialog(null, Messages.getString(Messages.SELECIONE_CHAVE));
			}

		}

		if (e.getActionCommand().equals(Messages.getString(Messages.REMOVER))) {
			Integer m = Integer.parseInt(JOptionPane.showInputDialog(Messages.getString(Messages.JOPINPUT_MATRICULA)));
			Long id = (Long) this.tChaves.getValueAt(this.tChaves.getSelectedRow(), 0);

			ControladorChave.getInstance().deletarChave(id, m);
		}

		if (e.getActionCommand().equals(Messages.getString(Messages.VOLTAR))) {
			setVisible(false);
			ControladorChave.getInstance().voltarMenuPrincipal();
		}

		if (e.getActionCommand().equals(Messages.getString(Messages.SAIR))) {
			sair();
		}

		if (e.getActionCommand().equals(Messages.getString(Messages.VER))) {
			String mat =  JOptionPane.showInputDialog(Messages.getString(Messages.JOPINPUT_MATRICULA));

			Funcionario f =ControladorFuncionario.getInstance().getFuncionario(Integer.parseInt(mat));
			if(f == null){
				JOptionPane.showMessageDialog(null, Messages.getString(Messages.MATRICULA_INEXISTENTE));
			} else{
				this.atualizaLista(f);
			}
		}

	}
}
