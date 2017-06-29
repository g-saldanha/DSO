package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.ufsc.ine5605.grupo3.controladores.ControladorPrincipal;
import br.ufsc.ine5605.grupo3.mensagens.Messages;

public class TelaPrincipal extends JFrame implements Tela, ActionListener {
    private JLabel bemVindo;
    private JButton bFuncionarios;
    private JButton bVeiculos;
    private JButton bChaves;
    private JButton bRelatorios;
    private JButton bSair;
   	String telaFuncionarios = "telaFuncionarios";
	String telaVeiculos = "telaVeiculos";
	String telaChaves = "telaChaves";
	String telaRegistros = "telaRegistros";

    public TelaPrincipal()  {
        super(Messages.TITULO_INICIO);
        inic();
    }

    @Override
    public void inic() {



//        Configurando constraints e instanciando layout
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

//        Criando os botões e labels
        this.bemVindo = new JLabel();
        this.bFuncionarios = new JButton();
        this.bVeiculos = new JButton();
        this.bChaves = new JButton();
        this.bRelatorios = new JButton();
        this.bSair = new JButton();

//        Inserindo o texto neles
        this.bemVindo.setText(Messages.CHAVES_LB1);
        this.bFuncionarios.setText(Messages.PRINCIPAL_BT1);
        this.bVeiculos.setText(Messages.PRINCIPAL_BT2);
        this.bChaves.setText(Messages.PRINCIPAL_BT3);
        this.bRelatorios.setText(Messages.PRINCIPAL_BT4);
        this.bSair.setText(Messages.SAIR);

//        Configurando botões
        this.bFuncionarios.setActionCommand(this.telaFuncionarios);
        this.bFuncionarios.addActionListener(this);

        this.bVeiculos.setActionCommand(this.telaVeiculos);
        this.bVeiculos.addActionListener(this);

        this.bChaves.setActionCommand(this.telaChaves);
        this.bChaves.addActionListener(this);

        this.bRelatorios.setActionCommand(this.telaRegistros);
        this.bRelatorios.addActionListener(this);

        this.bSair.setActionCommand(Messages.SAIR);
        this.bSair.addActionListener(this);

//        Adicionando e instanciando na Tela os componentes
        constraints.gridy = 0;
        container.add(this.bemVindo, constraints);
        constraints.gridy = 1;
        container.add(this.bFuncionarios, constraints);
        constraints.gridy = 2;
        container.add(this.bVeiculos, constraints);
        constraints.gridy = 3;
        container.add(this.bChaves, constraints);
        constraints.gridy = 4;
        container.add(this.bRelatorios, constraints);
        constraints.gridy = 5;
        container.add(this.bSair, constraints);


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
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(this.telaFuncionarios)){
            ControladorPrincipal.getInstance().exibeTelaFuncionarios();
        }

        if (e.getActionCommand().equals(this.telaVeiculos)){
            ControladorPrincipal.getInstance().exibeTelaVeiculos();
        }

        if (e.getActionCommand().equals(this.telaChaves)){
            ControladorPrincipal.getInstance().exibeTelaChaves();
        }

        if (e.getActionCommand().equals(this.telaRegistros)){
            ControladorPrincipal.getInstance().exibeTelaRegistros();
        }

        if (e.getActionCommand().equals(Messages.SAIR)){
            sair();
        }

    }
}
