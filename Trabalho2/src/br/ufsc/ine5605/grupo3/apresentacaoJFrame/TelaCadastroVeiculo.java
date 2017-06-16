package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import br.ufsc.ine5605.grupo3.controladores.ControladorVeiculos;
import br.ufsc.ine5605.grupo3.entidades.Tipo;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroVeiculo extends JFrame implements Tela, ActionListener {
    private JLabel lPlaca;
    private JLabel lModelo;
    private JLabel lMarca;
    private JLabel lAno;
    private JLabel lKm;
    private JLabel lTipo;
    private JTextField tPlaca;
    private JTextField tModelo;
    private JTextField tMarca;
    private JTextField tAno;
    private JTextField tKm;
    private JComboBox<Tipo> cTipo;
    private JButton bVoltar;
    private JButton bSair;
    private JButton bCadastrar;


    public TelaCadastroVeiculo() {
        super("Cadastro/Edição de Veículos");
        this.inic();
    }

    @Override
    public void inic() {
//        Configurando, instanciando o Layout e constraints
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

//        Criando os botões, labels e combos
        lPlaca = new JLabel();
        lModelo = new JLabel();
        lMarca = new JLabel();
        lAno = new JLabel();
        lKm = new JLabel();
        lTipo = new JLabel();
        tPlaca = new JTextField();
        tModelo = new JTextField();
        tMarca = new JTextField();
        tAno = new JTextField();
        tKm = new JTextField();
        cTipo = new JComboBox<Tipo>(Tipo.values());
        bCadastrar = new JButton();
        bSair = new JButton();
        bCadastrar = new JButton();
        bVoltar = new JButton();

//        Colocando os textos nas labels e botões
        lPlaca.setText("Digite a Placa: ");
        lModelo.setText("Digite o Modelo:");
        lMarca.setText("Digite a Marca:");
        lAno.setText("Digite o Ano:");
        lKm.setText("Digite o Km:");
        lTipo.setText("Digite o Tipo de Veículo:");
        bCadastrar.setText("Cadastrar Veículo");
        bVoltar.setText("Voltar");
        bSair.setText("Sair");
        
//          Configurando os Eventos dos botões
	    bCadastrar.setActionCommand("Cadastrar");
	    bCadastrar.addActionListener(this);
	    
	    bVoltar.setActionCommand("Voltar");
	    bVoltar.addActionListener(this);
	    
	    bSair.setActionCommand("Sair");
	    bSair.addActionListener(this);
	    
//	    Configurando o tamaho dos Campos de texto
	    tKm.setPreferredSize(textFieldLayout());
	    tAno.setPreferredSize(textFieldLayout());
	    tModelo.setPreferredSize(textFieldLayout());
	    tPlaca.setPreferredSize(textFieldLayout());
	    
//	    Colocando os componentes na tela

//	    Placa
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 0;
	    constraints.gridy = 1;
	    container.add(lPlaca, constraints);
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 1;
	    constraints.gridy = 1;
	    container.add(tPlaca, constraints);
	    
//	    Modelo
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 0;
	    constraints.gridy = 2;
	    container.add(lModelo, constraints);
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 1;
	    constraints.gridy = 2;
	    container.add(tModelo, constraints);
	    
//	    Marca
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 0;
	    constraints.gridy = 3;
	    container.add(lMarca, constraints);
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 1;
	    constraints.gridy = 3;
	    container.add(tMarca, constraints);
	    
//      Ano
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 0;
	    constraints.gridy = 4;
		container.add(lAno, constraints);
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 1;
	    constraints.gridy = 4;
	    container.add(tAno, constraints);
	    
//	    KM
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 0;
	    constraints.gridy = 5;
		container.add(lKm, constraints);
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 1;
	    constraints.gridy = 5;
	    container.add(tKm, constraints);
	    
//	    Tipo
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 0;
	    constraints.gridy = 6;
		container.add(lTipo, constraints);
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 1;
	    constraints.gridy = 6;
	    container.add(cTipo, constraints);
	    
//	    Botões
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 1;
	    constraints.gridy = 7;
	    container.add(bCadastrar, constraints);
	    
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 0;
	    constraints.gridy = 9;
	    container.add(bSair, constraints);
	    
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 2;
	    constraints.gridy = 9;
	    container.add(bVoltar, constraints);
	    
	    
//	    Tamanho da Tela
	    setSize(800,600);
	    
//	    fechar
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    

    }
	
	
	@Override
    public void atualizaLista() {
//Do nothing
    }

    @Override
    public void sair() {
		this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getActionCommand().equals("Cadastrar")){
    		Integer ano = Integer.parseInt(tAno.getText());
    		Integer km = Integer.parseInt(tKm.getText());
    		
    		ControladorVeiculos.getInstance().cadastraVeiculo(tPlaca.getText(), tModelo.getText(), tMarca.getText(), ano, km, (Tipo) cTipo.getSelectedItem());
    	    JOptionPane.showMessageDialog(null, "Veículo Placa " + tPlaca.getText() + "Cadastrado com sucesso!");
    	    
    	    setVisible(false);
    	    ControladorVeiculos.getInstance().exibeTelaVeiculos();
    	    
	    }
	    
	    if (e.getActionCommand().equals("Voltar")){
    	    setVisible(false);
		    ControladorVeiculos.getInstance().exibeTelaVeiculos();
	    }
	    
	    if (e.getActionCommand().equals("Sair")){
	    	sair();
	    }
	    
	
    }
    
    public Dimension textFieldLayout(){
        return new Dimension(100,20);
    }
}
