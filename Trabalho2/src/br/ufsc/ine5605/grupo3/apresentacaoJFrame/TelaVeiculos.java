package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import java.awt.Container;
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

import br.ufsc.ine5605.grupo3.controladores.ControladorVeiculos;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

public class TelaVeiculos extends JFrame implements Tela, ActionListener{

    //    Atributos
    private JLabel bemVindo;
    private JLabel lista;
    private JTable tVeiculos;
    private JScrollPane scrollPane;
    private JButton adicionar;
    private JButton editar;
    private JButton remover;
    private JButton voltar;
    private JButton sair;

    public TelaVeiculos(){
        this.inic();
    }

    @Override
    public void inic() {
//      Configurando constraints e instanciando layout
        Container container = this.getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

//        Criando os botões e labels
        this.bemVindo = new JLabel();
        this.lista = new JLabel();
        this.tVeiculos = new JTable();
        this.adicionar = new JButton();
        this.editar = new JButton();
        this.remover = new JButton();
        this.voltar = new JButton();
        this.sair = new JButton();


//        Inserindo o texto nos componentes
        this.bemVindo.setText("Bem Vindo a Tela de Veículos");
        this.lista.setText("Lista de Veículos");
        this.adicionar.setText("Adicionar Veículos");
        this.editar.setText("Editar Veículos");
        this.remover.setText("Remover Veículos");
        this.voltar.setText("Voltar");
        this.sair.setText("Sair");

//        Configurando eventos dos botões
        this.adicionar.setActionCommand("Adicionar");
        this.adicionar.addActionListener(this);

        this.editar.setActionCommand("Editar");
        this.editar.addActionListener(this);

        this.remover.setActionCommand("Remover");
        this.remover.addActionListener(this);

        this.voltar.setActionCommand("Voltar");
        this.voltar.addActionListener(this);

        this.sair.setActionCommand("Sair");
        this.sair.addActionListener(this);

//        Adicionando e instanciando na Tela os componentes
        constraints.gridx = 1;
        constraints.gridy = 0;
        container.add(this.bemVindo, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        container.add(this.adicionar, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        container.add(this.editar, constraints);
        constraints.gridx = 2;
        constraints.gridy = 1;
        container.add(this.remover, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        container.add(this.sair, constraints);
        constraints.gridx = 2;
        constraints.gridy = 4;
        container.add(this.voltar, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        container.add(this.lista, constraints);
//        tabela
        this.tVeiculos.setFillsViewportHeight(true);
        constraints.fill = GridBagConstraints.CENTER;
        constraints.gridy = 3;
        constraints.gridheight = 6;
        constraints.gridheight = 5;
        this.scrollPane = new JScrollPane(this.tVeiculos);
        container.add(this.scrollPane, constraints);
//        Fim tabela


        //      Configurando Layout da tela
        this.setSize(800, 600);


        //        Botão de fechar
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void atualizaLista(){
        DefaultTableModel tbModelo = new DefaultTableModel();
        tbModelo.addColumn("Placa");
        tbModelo.addColumn("Modelo");
        tbModelo.addColumn("Marca");
        tbModelo.addColumn("Ano");
        tbModelo.addColumn("Km");
        tbModelo.addColumn("Tipo");

        for (Veiculo v : ControladorVeiculos.getInstance().getVeiculos()) {
            tbModelo.addRow(new Object[]{v.getPlaca(),v.getModelo(),v.getMarca(),
            v.getAno(), v.getKm(),v.getTipo()});
        }

        this.tVeiculos.setModel(tbModelo);
        this.repaint();
    }

    @Override
    public void sair() {
        this.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Adicionar")) {
            this.setVisible(false);
            ControladorVeiculos.getInstance().exibeTelaCadastroVeiculo();
        }

        if (e.getActionCommand().equals("Editar")){
        	String placa = (String) this.tVeiculos.getValueAt(this.tVeiculos.getSelectedRow(), 0);
        	if(placa != null){
        		ControladorVeiculos.getInstance().exibeTelaEditaVeiculo(placa);
        	}

        }
        if (e.getActionCommand().equals("Remover")){
            String v = (String) this.tVeiculos.getValueAt(this.tVeiculos.getSelectedRow(), 0);
            ControladorVeiculos.getInstance().removeVeiculo(v);
            if (ControladorVeiculos.getInstance().getVeiculos().contains(ControladorVeiculos.getInstance().pegaVeiculo(v))){
            	JOptionPane.showMessageDialog(null, "Não deletou");
            } else {
            	JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
            }
            this.atualizaLista();
        }
        if (e.getActionCommand().equals("Voltar")){
            this.setVisible(false);
            ControladorVeiculos.getInstance().voltarMenuPrincipal();

        }
        if (e.getActionCommand().equals("Sair")){
            this.sair();
        }

    }
}
