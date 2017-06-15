package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import br.ufsc.ine5605.grupo3.controladores.ControladorPrincipal;
import br.ufsc.ine5605.grupo3.controladores.ControladorVeiculos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame implements Tela, ActionListener {
    private JLabel bemVindo;
    private JButton bFuncionarios;
    private JButton bVeiculos;
    private JButton bChaves;
    private JButton bRelatorios;
    private JButton bSair;

    public TelaPrincipal()  {
        super("Claviculario - Grupo03 - DSO - P. Jean");
        this.inic();
    }

    @Override
    public void inic() {
//        Configurando constraints e instanciando layout
        Container container = this.getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

//        Criando os botões e labels
        bemVindo = new JLabel();
        bFuncionarios = new JButton();
        bVeiculos = new JButton();
        bChaves = new JButton();
        bRelatorios = new JButton();
        bSair = new JButton();

//        Inserindo o texto neles
        bemVindo.setText("Bem Vindo ao Claviculário");
        bFuncionarios.setText("Ir para Funcionarios");
        bVeiculos.setText("Ir para Veículos");
        bChaves.setText("Ir para Chaves");
        bRelatorios.setText("Ir para Relatórios");
        bSair.setText("Sair");

//        Configurando botões
        bFuncionarios.setActionCommand("telaFuncionarios");
        bFuncionarios.addActionListener(this);

        bVeiculos.setActionCommand("telaVeiculos");
        bVeiculos.addActionListener(this);

        bChaves.setActionCommand("telaChaves");
        bChaves.addActionListener(this);

        bRelatorios.setActionCommand("telaRegistros");
        bRelatorios.addActionListener(this);

        bSair.setActionCommand("Sair");
        bSair.addActionListener(this);

//        Adicionando e instanciando na Tela os componentes
        constraints.gridy = 0;
        container.add(bemVindo, constraints);
        constraints.gridy = 1;
        container.add(bFuncionarios, constraints);
        constraints.gridy = 2;
        container.add(bVeiculos, constraints);
        constraints.gridy = 3;
        container.add(bChaves, constraints);
        constraints.gridy = 4;
        container.add(bRelatorios, constraints);
        constraints.gridy = 5;
        container.add(bSair, constraints);


//      Configurando Layout da tela
        setSize(800,600);
        setVisible(true);

//        Botão de fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void atualizaLista() {
//        Do nothing
    }

    @Override
    public void sair() {
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("telaFuncionarios")){
            ControladorPrincipal.getInstance().exibeTelaFuncionarios();
        }

        if (e.getActionCommand().equals("telaVeiculos")){
            ControladorPrincipal.getInstance().exibeTelaVeiculos();
        }

        if (e.getActionCommand().equals("telaChaves")){
            ControladorPrincipal.getInstance().exibeTelaChaves();
        }

        if (e.getActionCommand().equals("telaRegistros")){
            ControladorPrincipal.getInstance().exibeTelaRegistros();
        }

        if (e.getActionCommand().equals("Sair")){
            this.sair();
        }

    }
}
