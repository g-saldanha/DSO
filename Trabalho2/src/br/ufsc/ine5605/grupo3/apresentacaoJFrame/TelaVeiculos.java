package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import br.ufsc.ine5605.grupo3.controladores.ControladorVeiculos;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVeiculos extends JFrame implements Tela, ActionListener{

    //    Atributos
    private ControladorVeiculos ctrl;
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
        bemVindo = new JLabel();
        lista = new JLabel();
        tVeiculos = new JTable();
        adicionar = new JButton();
        editar = new JButton();
        remover = new JButton();
        voltar = new JButton();
        sair = new JButton();


//        Inserindo o texto nos componentes
        bemVindo.setText("Bem Vindo a Tela de Veículos");
        lista.setText("Lista de Veículos");
        adicionar.setText("Adicionar Veículos");
        editar.setText("Editar Veículos");
        remover.setText("Remover Veículos");
        voltar.setText("Voltar");
        sair.setText("Sair");

//        Configurando eventos dos botões
        adicionar.setActionCommand("Adicionar");
        adicionar.addActionListener(this);

        editar.setActionCommand("Editar");
        editar.addActionListener(this);

        remover.setActionCommand("Remover");
        remover.addActionListener(this);

        voltar.setActionCommand("Voltar");
        voltar.addActionListener(this);

        sair.setActionCommand("Sair");
        sair.addActionListener(this);

//        Adicionando e instanciando na Tela os componentes
        constraints.gridx = 1;
        constraints.gridy = 0;
        container.add(bemVindo, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        container.add(adicionar, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        container.add(editar, constraints);
        constraints.gridx = 2;
        constraints.gridy = 1;
        container.add(remover, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        container.add(sair, constraints);
        constraints.gridx = 2;
        constraints.gridy = 4;
        container.add(voltar, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        container.add(lista, constraints);
//        tabela
        tVeiculos.setFillsViewportHeight(true);
        constraints.fill = GridBagConstraints.CENTER;
        constraints.gridy = 3;
        constraints.gridheight = 6;
        constraints.gridheight = 5;
        scrollPane = new JScrollPane(tVeiculos);
        container.add(scrollPane, constraints);
//        Fim tabela


        //      Configurando Layout da tela
        setSize(800, 600);
        setVisible(true);


        //        Botão de fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        for (Veiculo v : ctrl.getVeiculos()) {
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

        }

        if (e.getActionCommand().equals("Editar")){

        }
        if (e.getActionCommand().equals("Remover")){
            String v = (String) tVeiculos.getValueAt(tVeiculos.getSelectedRow(), 0);
            ControladorVeiculos.getInstance().removeVeiculo(v);
        }
        if (e.getActionCommand().equals("Voltar")){
            this.setVisible(false);
            this.ctrl.voltarMenuPrincipal();

        }
        if (e.getActionCommand().equals("Sair")){
            this.sair();
        }

    }
}
