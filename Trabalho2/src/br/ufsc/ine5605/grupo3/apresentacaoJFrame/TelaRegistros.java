package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import java.awt.Container;
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

//    Configurando texto
        this.bemVindo.setText("Bem vindo a Tela de registros");
        this.lista.setText("Lista de Registros");
        this.bSair.setText("Sair");
        this.bVoltar.setText("voltar");

//        Configurando ações dos botões
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
		constraints.gridx = 1;
		constraints.gridy = 1;
		container.add(this.bFiltroPorPlaca, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 2;
		constraints.gridy = 1;
		container.add(this.bFiltroPorMotivo, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 4;
		container.add(this.bSair, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 2;
		constraints.gridy = 4;
		container.add(this.bVoltar, constraints);
		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridx = 1;
		constraints.gridy = 2;
		container.add(this.lista, constraints);
//      tabela
		this.tRegistros.setFillsViewportHeight(true);
		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridy = 3;
		constraints.gridheight = 6;
		constraints.gridheight = 5;
		this.scrollPane = new JScrollPane(this.tRegistros);
		container.add(this.scrollPane, constraints);
//      Fim tabela


//	   Configurar tamanho da tela
	   this.setSize(800,600);

//	   Configurando fechar tela
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    @Override
    public void atualizaLista() {
    	DefaultTableModel tModelo = new DefaultTableModel();
    	tModelo.addColumn("Data");
    	tModelo.addColumn("Hora");
    	tModelo.addColumn("Funcionario");
    	tModelo.addColumn("Veículo");
    	tModelo.addColumn("Km Andados");
    	tModelo.addColumn("Motivo");
    	tModelo.addColumn("Mensagem");

    	for (Registro r : ControladorRegistro.getInstance().getTodosRegistros()) {
    		JButton bVerMensagem = new JButton("Ver");
    		bVerMensagem.setActionCommand("Ver");
    		bVerMensagem.addActionListener(this);
			tModelo.addRow(new Object[]{r.getData()+"/"+r.getMesDoAno(),r.getHora(),r.getFuncionario(),r.getVeiculo(),r.getKmAndados(),r.getTipoMotivo(), bVerMensagem});
		}

    	this.tRegistros.setModel(tModelo);
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
			ControladorRegistro.getInstance().exibTelaRegistrosPorFiltro((String) this.cPlaca.getSelectedItem());
		}


	}
}
