package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import br.ufsc.ine5605.grupo3.controladores.ControladorChave;
import br.ufsc.ine5605.grupo3.controladores.ControladorPrincipal;
import br.ufsc.ine5605.grupo3.entidades.Chave;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaChaves extends JFrame implements Tela, ActionListener{
//    Atributos
    private JLabel bemVindo;
    private JLabel lista;
    private JTable tChaves;
    private JScrollPane scrollPane;
    private JButton pegar;
    private JButton bDevolver;
    private JButton bRemover;
    private JButton bVoltar;
    private JButton bSair;

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
        bDevolver = new JButton();
        bRemover = new JButton();
        bVoltar = new JButton();
        bSair = new JButton();

//        Colocando os textos nos componentes
        bemVindo.setText("Bem vindo ao Claviculário");
        lista.setText("Lista de Chaves");
        pegar.setText("Pegar Chave");
        bDevolver.setText("Devolver Chave");
        bRemover.setText("Remover Chave");
        bVoltar.setText("Voltar");
        bSair.setText("Sair");

//        Configurando ações dos botões
        pegar.setActionCommand("Pegar");
        pegar.addActionListener(this);

        bDevolver.setActionCommand("Devolver");
        bDevolver.addActionListener(this);

        bRemover.setActionCommand("Remover");
        bRemover.addActionListener(this);

        bSair.setActionCommand("Sair");
        bSair.addActionListener(this);

        bVoltar.setActionCommand("Voltar");
        bVoltar.addActionListener(this);

//        Adicionando e instanciando na Tela os componentes
        constraints.gridx = 1;
        constraints.gridy = 0;
        container.add(bemVindo, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        container.add(pegar, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        container.add(bDevolver, constraints);
        constraints.gridx = 2;
        constraints.gridy = 1;
        container.add(bRemover, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        container.add(bSair, constraints);
        constraints.gridx = 2;
        constraints.gridy = 4;
        container.add(bVoltar, constraints);
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
             ControladorChave.getInstance().getChaves()) {
            tModelo.addRow(new Object[]{ControladorChave.getInstance().checkExists(c.getPlaca()), c.getPlaca(), c.getModelo(), c.getEstado() });
        }

        tChaves.setModel(tModelo);
        repaint();


    }

    @Override
    public void sair() {
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Pegar")){
            int j =  Integer.parseInt(JOptionPane.showInputDialog("Insira Sua Matrícula"));
            String placa = (String) tChaves.getValueAt(tChaves.getSelectedRow(),1);
            if(ControladorPrincipal.getInstance().pegaFuncionario(j) != null) {
                ControladorChave.getInstance().cederChave(ControladorChave.getInstance().pegaFuncionario(j), ControladorChave.getInstance().getChave(placa));
            } else {
                JOptionPane.showMessageDialog(null, "Matricula Inexistente, favor digite uma matrícula correta");
            }
        }

        if (e.getActionCommand().equals("Devolver")){
            int m = Integer.parseInt(JOptionPane.showInputDialog("Insira Sua Matrícula"));
            String placa = (String) tChaves.getValueAt(tChaves.getSelectedRow(), 1);
            ControladorChave.getInstance().devolverChave(ControladorChave.getInstance().pegaFuncionario(m), ControladorChave.getInstance().getChave(placa));
        }

        if (e.getActionCommand().equals("Remover")){
            int m = Integer.parseInt(JOptionPane.showInputDialog("Insira Sua Matrícula"));
            String placa = (String) tChaves.getValueAt(tChaves.getSelectedRow(), 1);
            ControladorChave.getInstance().deletarChave(placa);
        }

        if (e.getActionCommand().equals("Voltar")){
            this.setVisible(false);
            ControladorChave.getInstance().voltarMenuPrincipal();
        }

        if (e.getActionCommand().equals("Sair")){
            this.sair();
        }

    }
}
