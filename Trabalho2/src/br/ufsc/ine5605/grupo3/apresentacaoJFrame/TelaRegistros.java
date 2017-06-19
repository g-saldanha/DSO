package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        this.inic();
    }

    @Override
    public void inic(){
//        Definir Container e Layout
        Container container = this.getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

//    Instanciando os componentes
        this.bemVindo = new JLabel();
        this.lista = new JLabel();
        this.bSair = new JButton();
        this.bVoltar = new JButton();
        this.tRegistros = new JTable();
        this.bFiltroPorPlaca = new JButton("Fitro por Placa");
        this.bFiltroPorMotivo = new JButton("Filtro por Motivo");
        this.bFiltroPorMatricula = new JButton("Filtro por Matricula");
        this.bVerTodos = new JButton("Ver Todos");
        this.bVerMensagem = new JButton("Ver Mensagem");

//    Configurando texto
        this.bemVindo.setText("Bem vindo a Tela de registros");
        this.lista.setText("Lista de Registros");
        this.bSair.setText("Sair");
        this.bVoltar.setText("Voltar");

//        Configurando ações dos botões
        this.bVerTodos.setActionCommand("Todos");
        this.bVerTodos.addActionListener(this);

        this.bFiltroPorMatricula.setActionCommand("Matricula");
        this.bFiltroPorMatricula.addActionListener(this);

        this.bFiltroPorMotivo.setActionCommand("Motivo");
        this.bFiltroPorMotivo.addActionListener(this);

        this.bFiltroPorPlaca.setActionCommand("Placa");
        this.bFiltroPorPlaca.addActionListener(this);

        this.bVoltar.setActionCommand("Voltar");
        this.bVoltar.addActionListener(this);

        this.bSair.setActionCommand("Sair");
        this.bSair.addActionListener(this);

        this.bVerMensagem.setActionCommand("Ver");
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
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void tModelo(){
    	this.tModelo = new DefaultTableModel();
    	this.tModelo.addColumn("Registro");
    	this.tModelo.addColumn("Data");
    	this.tModelo.addColumn("Hora");
    	this.tModelo.addColumn("Funcionario");
    	this.tModelo.addColumn("Veículo");
    	this.tModelo.addColumn("Km Andados");
    	this.tModelo.addColumn("Motivo");
    }

    @Override
    public void atualizaLista() {
    	this.tModelo();
    	for (Registro r : ControladorRegistro.getInstance().getTodosRegistros()) {
			this.tModelo.addRow(new Object[]{r.getId(),r.getData()+"/"+r.getMesDoAno(),r.getHora(),r.getFuncionario().getNome(),r.getVeiculo().getPlaca(),r.getKmAndados(),r.getTipoMotivo(),});
		}

    	this.tRegistros.setModel(this.tModelo);
    	this.repaint();

    }

    public void atualizaLista(String placa){
    	this.tModelo();
    	for (Registro r : ControladorRegistro.getInstance().getTodosRegistros()) {
    		if(r.getVeiculo().getPlaca().equals(placa)){
    			this.tModelo.addRow(new Object[]{r.getId(),r.getData()+"/"+r.getMesDoAno(),r.getHora(),r.getFuncionario().getNome(),r.getVeiculo().getPlaca(),r.getKmAndados(),r.getTipoMotivo(),});
    		}
		}
    	this.tRegistros.setModel(this.tModelo);
    	this.repaint();
    }

    public void atualizaLista(boolean motivo){
    	this.tModelo();
    	for (Registro r : ControladorRegistro.getInstance().getTodosRegistros()) {
    		if(r.getMotivo() == motivo){
    			this.tModelo.addRow(new Object[]{r.getId(),r.getData()+"/"+r.getMesDoAno(),r.getHora(),r.getFuncionario().getNome(),r.getVeiculo().getPlaca(),r.getKmAndados(),r.getTipoMotivo(),});
    		}
		}
    	this.tRegistros.setModel(this.tModelo);
    	this.repaint();
    }

    public void atualizaLista(Integer matricula){
    	this.tModelo();
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
        this.dispose();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Placa")) {
			this.cPlaca = new JComboBox<String>();
			this.cPlaca.setModel(new DefaultComboBoxModel<String>(new Vector<>(ControladorRegistro.getInstance().getPlacas())));
			JOptionPane.showMessageDialog( null, this.cPlaca, "Selecione uma Placa", JOptionPane.QUESTION_MESSAGE);
			this.atualizaLista((String) this.cPlaca.getSelectedItem());
		}
		if (e.getActionCommand().equals("Motivo")) {
			String[] motivos = new String[]{"Permissão", "Negação"};
			this.cMotivo = new JComboBox<String>(motivos);
			JOptionPane.showMessageDialog( null, this.cMotivo, "Selecione um Motivo", JOptionPane.QUESTION_MESSAGE);
			boolean motivo = false;
			if(this.cMotivo.getSelectedItem().equals("Permissão")){
				motivo = true;
			}
			this.atualizaLista(motivo);
		}
		if (e.getActionCommand().equals("Matricula")) {
			this.cMatricula = new JComboBox<Integer>();
			this.cMatricula.setModel(new DefaultComboBoxModel<Integer>(new Vector<>(ControladorRegistro.getInstance().getMatriculas())));
			JOptionPane.showMessageDialog( null, this.cPlaca, "Selecione uma Matricula", JOptionPane.QUESTION_MESSAGE);
			this.atualizaLista((Integer) this.cMatricula.getSelectedItem());
		}

		if(e.getActionCommand().equals("Todos")){
			this.atualizaLista();
		}
		if (e.getActionCommand().equals("Voltar")) {
			this.setVisible(false);
			ControladorPrincipal.getInstance().voltarMenuPrincipal();
		}
		if(e.getActionCommand().equals("Sair")){
			this.sair();
		}

		if (e.getActionCommand().equals("Ver")) {
			try {
				Registro r = ControladorRegistro.getInstance().getRegistro((Long) this.tRegistros.getValueAt(this.tRegistros.getSelectedRow(), 0));
				JOptionPane.showMessageDialog(null, r.getMensagem());
			} catch (ArrayIndexOutOfBoundsException e2) {
				JOptionPane.showMessageDialog(null, "Selecione um Registro");
			}
		}

	}
}
