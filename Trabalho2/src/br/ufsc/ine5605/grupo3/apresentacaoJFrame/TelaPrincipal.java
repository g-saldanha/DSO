package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {
    private JLabel bemVindo;
    private JButton bFuncionarios;
    private JButton bVeiculos;
    private JButton bChaves;
    private JButton bRelatorios;

    public TelaPrincipal(){
        super("Claviculario - Grupo03 - DSO - P. Jean");

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

//        Inserindo o texto neles
        bemVindo.setText("Bem Vindo ao Claviculário");
        bFuncionarios.setText("Ir para Funcionarios");
        bVeiculos.setText("Ir para Veículos");
        bChaves.setText("Ir para Chaves");
        bRelatorios.setText("Ir para Relatórios");

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


//      Configurando Layout da tela
        setSize(800,600);

//        Botão de fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
