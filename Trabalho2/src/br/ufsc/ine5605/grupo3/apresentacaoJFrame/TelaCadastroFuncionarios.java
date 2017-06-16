package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import br.ufsc.ine5605.grupo3.controladores.ControladorFuncionario;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gabriel on 16/06/17.
 */
public class TelaCadastroFuncionarios extends JFrame {

	private JLabel lbCadastro;
	private JLabel lbMatricula;
	private JLabel lbNome;
	private JLabel lbCargo;
	private JLabel lbDataNascimento;
	private JLabel lbTelefone;
	private JButton btCadastro;
	private JButton btCancel;
	private JTextField tfNome;
	private JTextField tfMatricula;
	private JTextField tfTelefone;
	private JTextField tfDataNascimento;
	private JComboBox<Funcionario.Cargo> bjCargos;
	private JTextField tfNumeroCargo;

	private GerenciadorDeBotoes gerenciadorBotoes;
	private Container container;

	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	public TelaCadastroFuncionarios() {
		super("Cadastro Funcionarios");
		container = getContentPane();
		container.setLayout(new GridBagLayout());

		this.iniciaComponentes();

		btCadastro.addActionListener(gerenciadorBotoes);
		btCancel.addActionListener(gerenciadorBotoes);
		bjCargos.addActionListener(gerenciadorBotoes);

		setSize(350, 150);
		setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //talvez seja bom mudar, @author: Gabriel -> mudei para fechar

	}

	private void iniciaComponentes() {
		GridBagConstraints constraints = new GridBagConstraints();
		gerenciadorBotoes = new GerenciadorDeBotoes();

		lbCadastro = new JLabel();
		lbCadastro.setText("Cadastro de Funcionario");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 0;
		container.add(lbCadastro, constraints);

		lbMatricula = new JLabel();
		lbMatricula.setText("Matricula");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(lbMatricula, constraints);

		tfMatricula = new JTextField();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 1;
		tfMatricula.setSize(100, 20);
		tfMatricula.setPreferredSize(new Dimension(100,20));
		container.add(tfMatricula, constraints);

		lbNome = new JLabel();
		lbNome.setText("Nome");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 2;
		lbNome.setSize(100, 20);
		lbNome.setPreferredSize(new Dimension(100,20));
		container.add(lbNome, constraints);

		tfNome = new JTextField();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 2;
		container.add(tfNome, constraints);

		lbCargo = new JLabel();
		lbCargo.setText("Cargo");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 3;
		lbCargo.setSize(100, 20);
		lbCargo.setPreferredSize(new Dimension(100,20));
		container.add(lbCargo, constraints);

		bjCargos = new JComboBox<Funcionario.Cargo>(Funcionario.Cargo.values());
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 3;
		container.add(bjCargos, constraints);

		//faltou data de nascimento e telefone. adicionar depois

		btCadastro = new JButton();
		btCadastro.setText("Cadastrar");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 4;
		btCadastro.setActionCommand(OpcoesCadastroFuncionario.CADASTRAR.name());
		container.add(btCadastro, constraints);

		btCancel = new JButton();
		btCancel.setText("Voltar");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 4;
		btCancel.setActionCommand(OpcoesCadastroFuncionario.CANCELAR.name());
		container.add(btCancel, constraints);


	}



	private  class GerenciadorDeBotoes implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getActionCommand().equals(OpcoesCadastroFuncionario.CADASTRAR.name())) {
				Integer matriculaFuncionario = -1;

				try{
					matriculaFuncionario = Integer.valueOf(tfMatricula.getText());
					ControladorFuncionario.getInstance().cadastraFuncionario(matriculaFuncionario, tfNome.getText(), Integer.parseInt(tfDataNascimento.getText()) ,Integer.parseInt(tfTelefone.getText()) ,(Funcionario.Cargo) bjCargos.getSelectedItem());
					JOptionPane.showMessageDialog(null,"novo funcionario cadastrado:\n"
							+ "\nNome: " + tfNome.getText()
							+ "\nPartido: " + bjCargos.getSelectedItem().toString()
							+ "\nCodigo: " + tfMatricula.getText() );
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Funcionario com matricula inválida!");
				}

				tfMatricula.setText(null);
				tfNome.setText(null);
			}
			else if(e.getActionCommand().equals(OpcoesCadastroFuncionario.CANCELAR.name())){
				setVisible(false);
				ControladorFuncionario.getInstance().exibeTelaFuncionario();
			}
		}
	}

}
