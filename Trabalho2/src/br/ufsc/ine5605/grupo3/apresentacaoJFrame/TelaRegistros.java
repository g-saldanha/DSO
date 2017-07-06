package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ufsc.ine5605.grupo3.controladores.ControladorPrincipal;
import br.ufsc.ine5605.grupo3.controladores.ControladorRegistro;
import br.ufsc.ine5605.grupo3.entidades.Registro;
import br.ufsc.ine5605.grupo3.mensagens.Messages;

public class TelaRegistros extends JFrame implements Tela, ActionListener {
/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	//    Atributos
    private JLabel bemVindo;
    private JLabel lista;
    private JButton bSair;
    private JButton bVoltar;
    private JTable tRegistros;
    private JScrollPane scrollPane;
    private JButton bFiltroPorPlaca;
    private JButton bFiltroPorMotivo;
    private JButton bFiltroPorMatricula;
	private JComboBox<String> cPlaca;
	private JComboBox<String> cMotivo;
	private DefaultTableModel tModelo;
	private JComboBox<Integer> cMatricula;
	private JButton bVerTodos;
	private JButton bVerMensagem;

    public TelaRegistros() {
        inic();
    }

    @Override
    public void inic(){
//        Definir Container e Layout
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

//    Instanciando os componentes
        this.bemVindo = new JLabel();
        this.lista = new JLabel();
        this.bSair = new JButton();
        this.bVoltar = new JButton();
        this.tRegistros = new JTable();
        this.bFiltroPorPlaca = new JButton(Messages.REGISTROS_BT4);
        this.bFiltroPorMotivo = new JButton(Messages.REGISTROS_BT3;
        this.bFiltroPorMatricula = new JButton(Messages.REGISTROS_BT2);
        this.bVerTodos = new JButton(Messages.REGISTRO_BT1);
        this.bVerMensagem = new JButton(Messages.BT5);

//    Configurando texto
        this.bemVindo.setText(Messages.REGISTROS_LB2);
        this.lista.setText(Messages.REGISTROS_LB1);
        this.bSair.setText(Messages.SAIR);
        this.bVoltar.setText(Messages.VOLTAR);

//        Configurando ações dos botões
        this.bVerTodos.setActionCommand(Messages.REGISTROS_BT1);
        this.bVerTodos.addActionListener(this);

        this.bFiltroPorMatricula.setActionCommand(Messages.REGISTROS_BT2);
        this.bFiltroPorMatricula.addActionListener(this);

        this.bFiltroPorMotivo.setActionCommand(Messages.REGISTROS_BT3);
        this.bFiltroPorMotivo.addActionListener(this);

        this.bFiltroPorPlaca.setActionCommand(Messages.REGISTROS_BT4);
        this.bFiltroPorPlaca.addActionListener(this);

        this.bVoltar.setActionCommand(Messages.VOLTAR);
        this.bVoltar.addActionListener(this);

        this.bSair.setActionCommand(Messages.SAIR);
        this.bSair.addActionListener(this);

        this.bVerMensagem.setActionCommand(Messages.VER);
		this.bVerMensagem.addActionListener(this);

//        Setando Layout

//      Adicionando e instanciando na Tela os componentes
		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridx = 1;
		constraints.gridy = 0;
		container.add(this.bemVindo, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(this.bFiltroPorMatricula, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 2;
		container.add(this.bFiltroPorPlaca, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 3;
		container.add(this.bFiltroPorMotivo, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 2;
		constraints.gridy = 1;
		container.add(this.bSair, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 2;
		constraints.gridy = 2;
		container.add(this.bVoltar, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 4;
		container.add(this.bVerTodos, constraints);
		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridx = 1;
		constraints.gridy = 4;
		container.add(this.lista, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 2;
		constraints.gridy = 4;
		container.add(this.bVerMensagem, constraints);
//      tabela
		this.tRegistros.setFillsViewportHeight(true);
		this.tRegistros.setPreferredScrollableViewportSize(new Dimension(400, 70));
		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 6;
		constraints.gridheight = 3;
		this.scrollPane = new JScrollPane(this.tRegistros);
		container.add(this.scrollPane, constraints);
//      Fim tabela


//	   Configurar tamanho da tela
	   this.setSize(800,600);

//	   Configurando fechar tela
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void tModelo(){
    	this.tModelo = new DefaultTableModel();
    	this.tModelo.addColumn(Messages.REGISTROS_COL1);
    	this.tModelo.addColumn(Messages.REGISTROS_COL2);
    	this.tModelo.addColumn(Messages.REGISTROS_COL3);
    	this.tModelo.addColumn(Messages.REGISTROS_COL4);
    	this.tModelo.addColumn(Messages.REGISTROS_COL5);
    	this.tModelo.addColumn(Messages.REGISTROS_COL6);
    	this.tModelo.addColumn(Messages.REGISTROS_COL7);
    }

    @Override
    public void atualizaLista() {
    	tModelo();
    	for (Registro r : ControladorRegistro.getInstance().getTodosRegistros()) {
			this.tModelo.addRow(new Object[]{r.getId(),r.getData()+"/"+r.getMesDoAno(),r.getHora(),r.getFuncionario().getNome(),r.getVeiculo().getPlaca(),r.getKmAndados(),r.getTipoMotivo(),});
		}

    	this.tRegistros.setModel(this.tModelo);
    	this.repaint();

    }

    public void atualizaLista(String placa){
    	tModelo();
    	for (Registro r : ControladorRegistro.getInstance().getTodosRegistros()) {
    		if(r.getVeiculo().getPlaca().equals(placa)){
    			this.tModelo.addRow(new Object[]{r.getId(),r.getData()+"/"+r.getMesDoAno(),r.getHora(),r.getFuncionario().getNome(),r.getVeiculo().getPlaca(),r.getKmAndados(),r.getTipoMotivo(),});
    		}
		}
    	this.tRegistros.setModel(this.tModelo);
    	this.repaint();
    }

    public void atualizaLista(boolean motivo){
    	tModelo();
    	for (Registro r : ControladorRegistro.getInstance().getTodosRegistros()) {
    		if(r.getMotivo() == motivo){
    			this.tModelo.addRow(new Object[]{r.getId(),r.getData()+"/"+r.getMesDoAno(),r.getHora(),r.getFuncionario().getNome(),r.getVeiculo().getPlaca(),r.getKmAndados(),r.getTipoMotivo(),});
    		}
		}
    	this.tRegistros.setModel(this.tModelo);
    	this.repaint();
    }

    public void atualizaLista(Integer matricula){
    	tModelo();
    	for (Registro r : ControladorRegistro.getInstance().getTodosRegistros()) {
    		if(r.getFuncionario().getNumeroMatricula().equals(matricula)){
    			this.tModelo.addRow(new Object[]{r.getId(),r.getData()+"/"+r.getMesDoAno(),r.getHora(),r.getFuncionario().getNome(),r.getVeiculo().getPlaca(),r.getKmAndados(),r.getTipoMotivo(),});
    		}
		}
    	this.tRegistros.setModel(this.tModelo);
    	this.repaint();
    }

    @Override
    public void sair() {
        dispose();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(Messages.REGISTROS_BT4)) {
			this.cPlaca = new JComboBox<String>();
			try {
				this.cPlaca.setModel(new DefaultComboBoxModel<String>(new Vector<>(ControladorRegistro.getInstance().getPlacas())));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog( null, this.cPlaca, Messages.REGISTROS_MSG1, JOptionPane.QUESTION_MESSAGE);
			this.atualizaLista((String) this.cPlaca.getSelectedItem());
		}
		if (e.getActionCommand().equals(Messages.REGISTROS_BT3)) {
			String[] motivos = new String[]{Messages.PERMISSAO, Messages.NEGACAO};
			this.cMotivo = new JComboBox<String>(motivos);
			JOptionPane.showMessageDialog( null, this.cMotivo, Messages.REGISTROS_MSG2, JOptionPane.QUESTION_MESSAGE);
			boolean motivo = false;
			if(this.cMotivo.getSelectedItem().equals(Messages.PERMISSAO)){
				motivo = true;
			}
			this.atualizaLista(motivo);
		}
		if (e.getActionCommand().equals(Messages.REGISTROS_BT2)) {
			this.cMatricula = new JComboBox<Integer>();
			try {
				this.cMatricula.setModel(new DefaultComboBoxModel<Integer>(new Vector<>(ControladorRegistro.getInstance().getMatriculas())));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog( null, this.cPlaca, Messages.JOPDIALOG_MATRICULA, JOptionPane.QUESTION_MESSAGE);
			this.atualizaLista((Integer) this.cMatricula.getSelectedItem());
		}

		if(e.getActionCommand().equals(Messages.REGISTROS_BT1)){
			this.atualizaLista();
		}
		if (e.getActionCommand().equals(Messages.VOLTAR)) {
			setVisible(false);
			try {
				ControladorPrincipal.getInstance().voltarMenuPrincipal();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getActionCommand().equals(Messages.SAIR)){
			sair();
		}

		if (e.getActionCommand().equals(Messages.VER)) {
			try {
				Registro r = ControladorRegistro.getInstance().getRegistro((Long) this.tRegistros.getValueAt(this.tRegistros.getSelectedRow(), 0));
				JOptionPane.showMessageDialog(null, r.getMensagem());
			} catch (ArrayIndexOutOfBoundsException e2) {
				JOptionPane.showMessageDialog(null, Messages.JOPDIALOG_REGISTRO);
			}
		}

	}
}
