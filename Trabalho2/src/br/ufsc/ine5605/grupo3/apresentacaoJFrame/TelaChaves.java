package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import br.ufsc.ine5605.grupo3.controladores.ControladorChave;
import br.ufsc.ine5605.grupo3.entidades.Chave;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaChaves extends JFrame implements Tela, ActionListener{
//    Atributos
    private ControladorChave ctrl;
    private JLabel bemVindo;
    private JLabel lista;
    private JTable tChaves;
    private JScrollPane scrollPane;
    private JButton pegar;
    private JButton devolver;
    private JButton remover;
    private JButton voltar;
    private JButton sair;

    public TelaChaves() {
        this.inic();
    }

    @Override
    public void inic() {
//        Instanciar Container e Layout
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

//        Instanciando os componentes
        bemVindo = new JLabel();
        lista = new JLabel();
        tChaves = new JTable();
        pegar = new JButton();
        pegar.setActionCommand("Pegar");
        pegar.addActionListener(this);
        devolver = new JButton();
        remover = new JButton();
        voltar = new JButton();
        sair = new JButton();

//        Colocando os textos nos componentes
        bemVindo.setText("Bem vindo ao Claviculário");
        lista.setText("Lista de Chaves");
        pegar.setText("Pegar Chave");
        devolver.setText("Devolver Chave");
        remover.setText("Remover Chave");
        voltar.setText("Voltar");
        sair.setText("Sair");

//        Adicionando e instanciando na Tela os componentes
        constraints.gridx = 1;
        constraints.gridy = 0;
        container.add(bemVindo, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        container.add(pegar, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        container.add(devolver, constraints);
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
        tChaves.setFillsViewportHeight(true);
        constraints.fill = GridBagConstraints.CENTER;
        constraints.gridy = 3;
        constraints.gridheight = 5;
        constraints.gridheight = 5;
        scrollPane = new JScrollPane(tChaves);
        container.add(scrollPane, constraints);
//        Fim tabela




//        Configurando o Layout
        setSize(800, 600);
        setVisible(true);

//        Botão de fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void atualizaLista() {
        DefaultTableModel tModelo = new DefaultTableModel();
        tModelo.addColumn("Chave");
        tModelo.addColumn("Placa");
        tModelo.addColumn("Veiculo");
        tModelo.addColumn("Alugada");
        tModelo.addColumn("Quem Alugou");

        for (Chave c :
             ctrl.getChaves()) {
            tModelo.addRow(new Object[]{ctrl.checkExists(c.getPlaca()), c.getPlaca(), c.getModelo(), c.getEstado() });
        }

        tChaves.setModel(tModelo);
        repaint();


    }

    @Override
    public void sair() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Pegar")){
            int j =  Integer.parseInt(JOptionPane.showInputDialog("Insira Sua Matrícula"));
            String placa = (String) tChaves.getValueAt(tChaves.getSelectedRow(),1);
            ctrl.cederChave(ctrl.pegaFuncionario(j), ctrl.getChave(placa));
            


        }
    }
}
