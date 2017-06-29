package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.ufsc.ine5605.grupo3.controladores.ControladorVeiculos;
import br.ufsc.ine5605.grupo3.entidades.Tipo;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

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
    private Veiculo vEditar;


    public TelaCadastroVeiculo() {
        super("Cadastro de Veículos");
        inic();
    }

    public TelaCadastroVeiculo(String v){
    	super("Edição de Veículos");
    	inic();
    	this.vEditar = ControladorVeiculos.getInstance().pegaVeiculo(v);
    	edit();
    }

    @Override
    public void inic() {
//        Configurando, instanciando o Layout e constraints
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

//        Criando os botões, labels e combos
        this.lPlaca = new JLabel();
        this.lModelo = new JLabel();
        this.lMarca = new JLabel();
        this.lAno = new JLabel();
        this.lKm = new JLabel();
        this.lTipo = new JLabel();
        this.tPlaca = new JTextField();
        this.tModelo = new JTextField();
        this.tMarca = new JTextField();
        this.tAno = new JTextField();
        this.tKm = new JTextField();
        this.cTipo = new JComboBox<Tipo>(Tipo.values());
        this.bCadastrar = new JButton();
        this.bSair = new JButton();
        this.bCadastrar = new JButton();
        this.bVoltar = new JButton();

//        Colocando os textos nas labels e botões
        this.lPlaca.setText("Digite a Placa: ");
        this.lModelo.setText("Digite o Modelo:");
        this.lMarca.setText("Digite a Marca:");
        this.lAno.setText("Digite o Ano:");
        this.lKm.setText("Digite o Km:");
        this.lTipo.setText("Digite o Tipo de Veículo:");
        this.bCadastrar.setText("Cadastrar Veículo");
        this.bVoltar.setText("Voltar");
        this.bSair.setText("Sair");

//          Configurando os Eventos dos botões
	    this.bCadastrar.setActionCommand("Cadastrar");
	    this.bCadastrar.addActionListener(this);

	    this.bVoltar.setActionCommand("Voltar");
	    this.bVoltar.addActionListener(this);

	    this.bSair.setActionCommand("Sair");
	    this.bSair.addActionListener(this);

//	    Configurando o tamaho dos Campos de texto
	    this.tKm.setPreferredSize(textFieldLayout());
	    this.tAno.setPreferredSize(textFieldLayout());
	    this.tModelo.setPreferredSize(textFieldLayout());
	    this.tPlaca.setPreferredSize(textFieldLayout());

//	    Colocando os componentes na tela

//	    Placa
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 0;
	    constraints.gridy = 1;
	    container.add(this.lPlaca, constraints);
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 1;
	    constraints.gridy = 1;
	    container.add(this.tPlaca, constraints);

//	    Modelo
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 0;
	    constraints.gridy = 2;
	    container.add(this.lModelo, constraints);
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 1;
	    constraints.gridy = 2;
	    container.add(this.tModelo, constraints);

//	    Marca
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 0;
	    constraints.gridy = 3;
	    container.add(this.lMarca, constraints);
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 1;
	    constraints.gridy = 3;
	    container.add(this.tMarca, constraints);

//      Ano
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 0;
	    constraints.gridy = 4;
		container.add(this.lAno, constraints);
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 1;
	    constraints.gridy = 4;
	    container.add(this.tAno, constraints);

//	    KM
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 0;
	    constraints.gridy = 5;
		container.add(this.lKm, constraints);
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 1;
	    constraints.gridy = 5;
	    container.add(this.tKm, constraints);

//	    Tipo
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 0;
	    constraints.gridy = 6;
		container.add(this.lTipo, constraints);
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 1;
	    constraints.gridy = 6;
	    container.add(this.cTipo, constraints);

//	    Botões
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 1;
	    constraints.gridy = 7;
	    container.add(this.bCadastrar, constraints);

	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 0;
	    constraints.gridy = 9;
	    container.add(this.bSair, constraints);

	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.gridx = 2;
	    constraints.gridy = 9;
	    container.add(this.bVoltar, constraints);


//	    Tamanho da Tela
	    this.setSize(800,600);

//	    fechar
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


	@Override
    public void atualizaLista() {
//Do nothing
    }

    @Override
    public void sair() {
		dispose();
    }

    public void edit(){
    	this.tPlaca.setText(this.vEditar.getPlaca());
    	this.tModelo.setText(this.vEditar.getModelo());
    	this.tMarca.setText(this.vEditar.getMarca());
    	this.tAno.setText("" + this.vEditar.getAno());
    	this.tKm.setText("" + this.vEditar.getKm());
    }

    public void limpa(){
    	this.tPlaca.setText(null);
    	this.tModelo.setText(null);
    	this.tMarca.setText(null);
    	this.tAno.setText(null);
    	this.tKm.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getActionCommand().equals("Cadastrar")){
    		Integer ano = Integer.parseInt(this.tAno.getText());
    		Integer km = Integer.parseInt(this.tKm.getText());

    		String m = null;
			try {
				m = ControladorVeiculos.getInstance().cadastraVeiculo(this.tPlaca.getText(), this.tModelo.getText(), this.tMarca.getText(), ano, km, (Tipo) this.cTipo.getSelectedItem());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	    JOptionPane.showMessageDialog(null, m);
    	    limpa();
    	    setVisible(false);
    	    ControladorVeiculos.getInstance().exibeTelaVeiculos();

	    }

	    if (e.getActionCommand().equals("Voltar")){
	    	limpa();
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
