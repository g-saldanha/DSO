package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.ufsc.ine5605.grupo3.controladores.ControladorFuncionario;
import br.ufsc.ine5605.grupo3.entidades.Cargo;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.mensagens.Messages;

/**
 * Created by gabriel on 16/06/17.
 */
public class TelaCadastroFuncionarios extends JFrame implements Tela, ActionListener {
	private JLabel bemVindo;
	private JLabel lbCadastro;
	private JLabel lbMatricula;
	private JLabel lbNome;
	private JLabel lbCargo;
	private JLabel lbDataNascimento;
	private JLabel lbTelefone;
	private JButton btCadastro;
	private JButton btCancelar;
	private JButton btSair;
	private JTextField tfNome;
	private JTextField tfMatricula;
	private JTextField tfTelefone;
	private JTextField tfDataNascimento;
	private JComboBox<Cargo> bjCargos;
	private Funcionario f;

	public TelaCadastroFuncionarios() {
		inic();
	}

	public TelaCadastroFuncionarios(Funcionario funcionario){
		this.f = funcionario;
		inic();
		edita();
	}

	@Override
	public void inic() {
//		Criando Container e Layout
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

//		Instanciando Botões, Labels e afins e botando o texto
		if (this.f == null) {
			this.bemVindo = new JLabel(Messages.FUNCIONARIOS_LB7_1);
		} else {
			this.bemVindo = new JLabel(Messages.FUNCIONARIOS_LB7_2);
		}
		this.lbMatricula = new JLabel(Messages.FUNCIONARIOS_LB8);
		this.tfMatricula = new JTextField();
		this.lbNome = new JLabel(Messages.FUNCIONARIOS_LB9);
		this.tfNome = new JTextField();
		this.lbTelefone = new JLabel(Messages.FUNCIONARIOS_LB10);
		this.tfTelefone = new JTextField();
		this.lbDataNascimento = new JLabel(Messages.FUNCIONARIOS_LB11);
		this.tfDataNascimento = new JTextField();
		this.lbCargo = new JLabel(Messages.FUNCIONARIOS_LB12);
		this.bjCargos = new JComboBox<>(Cargo.values());
		if (this.f == null) {
			this.btCadastro = new JButton(Messages.CADASTRAR);
			this.btCadastro.setActionCommand(Messages.CADASTRAR);
			this.btCadastro.addActionListener(this);
		} else {
			this.btCadastro = new JButton(Messages.EDITAR);
			this.btCadastro.setActionCommand(Messages.EDITAR);
			this.btCadastro.addActionListener(this);
		}
		this.btCancelar = new JButton(Messages.CANCELAR);
		this.btSair = new JButton(Messages.SAIR);

//		Configurando ações nos botões
		this.btCancelar.setActionCommand(Messages.CANCELAR);
		this.btCancelar.addActionListener(this);

		this.btSair.setActionCommand(Messages.SAIR);
		this.btSair.addActionListener(this);

//		Criando componentes na tela
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridy = 0;
		container.add(this.bemVindo, constraints);
		if (this.f == null) {
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.gridx = 0;
			constraints.gridy = 1;
			container.add(this.lbMatricula, constraints);
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.gridx = 1;
			constraints.gridy = 1;
			container.add(this.tfMatricula, constraints);
		}
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 2;
		container.add(this.lbNome, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 2;
		container.add(this.tfNome, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 3;
		container.add(this.lbTelefone, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 3;
		container.add(this.tfTelefone, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 4;
		container.add(this.lbDataNascimento, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 4;
		container.add(this.tfDataNascimento, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 5;
		container.add(this.lbCargo, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 5;
		container.add(this.bjCargos, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 6;
		container.add(this.btCadastro, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 7;
		container.add(this.btSair, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 7;
		container.add(this.btCancelar, constraints);


//		configurando o layout
		this.setSize(800,600);

//		Fechar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void limpa(){
		this.tfDataNascimento.setText(null);
		this.tfMatricula.setText(null);
		this.tfNome.setText(null);
		this.tfTelefone.setText(null);
	}

	public void edita(){
		this.tfDataNascimento.setText(""+this.f.getDataNascimento());
		this.bjCargos.setSelectedItem(this.f.getCargo());
		this.tfMatricula.setText(this.f.getNumeroMatricula()+"");
		this.tfNome.setText(this.f.getNome());
		this.tfTelefone.setText(this.f.getTelefone()+"");
	}
	@Override
	public void atualizaLista() {
	}

	@Override
	public void sair() {
		dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(Messages.CADASTRAR)) {
			if(this.bjCargos.getSelectedItem().equals(Cargo.COMUM)){
				setVisible(false);
				ControladorFuncionario.getInstance().exibeTelaPermissões(Integer.parseInt(this.tfMatricula.getText()), this.tfNome.getText(), Integer.parseInt(this.tfDataNascimento.getText()), Integer.parseInt(this.tfTelefone.getText()), (Cargo) this.bjCargos.getSelectedItem());
			} else {
				String msg = ControladorFuncionario.getInstance().cadastraFuncionario(Integer.parseInt(this.tfMatricula.getText()), this.tfNome.getText(), Integer.parseInt(this.tfDataNascimento.getText()), Integer.parseInt(this.tfTelefone.getText()), (Cargo) this.bjCargos.getSelectedItem());
				limpa();
				JOptionPane.showMessageDialog(null, msg);
			}
			setVisible(false);

			ControladorFuncionario.getInstance().exibeTelaFuncionario();
		}
		if (e.getActionCommand().equals(Messages.EDITAR)) {
			String msg = ControladorFuncionario.getInstance().alteraFuncionario(Integer.parseInt(this.tfMatricula.getText()), this.tfNome.getText(), Integer.parseInt(this.tfDataNascimento.getText()), Integer.parseInt(this.tfTelefone.getText()), (Cargo) this.bjCargos.getSelectedItem());
			JOptionPane.showMessageDialog(null, msg);
			limpa();
			setVisible(false);
			ControladorFuncionario.getInstance().exibeTelaFuncionario();
		}
		if(e.getActionCommand().equals(Messages.CANCELAR)){
			setVisible(false);
			ControladorFuncionario.getInstance().exibeTelaFuncionario();
		}
		if (e.getActionCommand().equals(Messages.SAIR)) {
			sair();
		}
	}
}
