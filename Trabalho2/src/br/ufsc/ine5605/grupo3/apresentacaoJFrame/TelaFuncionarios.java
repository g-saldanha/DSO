package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import br.ufsc.ine5605.grupo3.controladores.ControladorFuncionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaFuncionarios extends JFrame implements Tela, ActionListener{
//      Atributos
    private ControladorFuncionario ctrl;
    private JLabel bemVindo;
    private JLabel lista;
    private JTable tFuncionarios;
    private JButton bAdicionar;
    private JButton bEditar;
    private JButton bRemover;
    private JButton voltar;
    private JButton sair;

    public TelaFuncionarios() throws HeadlessException {
        this.inic();
    }

    @Override
    public void inic() {
//        Configurando Layout
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

//        Instanciando componentes
        bemVindo = new JLabel();
        lista = new JLabel();
        tFuncionarios = new JTable();
        bAdicionar = new JButton();
        bEditar = new JButton();
        bRemover = new JButton();
        voltar = new JButton();
        sair = new JButton();

//        Configurando textos dos componentes
        bemVindo.setText("Bem vindo a Tela de Funcionários");
        lista.setText("Lista de Funcionarios");
        bAdicionar.setText("Adicionar");
        bEditar.setText("Editar");
        bRemover.setText("Remover");
        voltar.setText("Voltar");
        sair.setText("Sair");

//        Connfigurando Eventos dos botões
        bAdicionar.setActionCommand("Adicionar");
        bAdicionar.addActionListener(this);

        bEditar.setActionCommand("Editar");
        bEditar.addActionListener(this);

        bRemover.setActionCommand("Remover");
        bRemover.addActionListener(this);

        voltar.setActionCommand("Voltar");
        voltar.addActionListener(this);

        sair.setActionCommand("Sair");
        sair.addActionListener(this);


    }

    @Override
    public void atualizaLista() {
        DefaultTableModel tModelo = new DefaultTableModel();

    }

    @Override
    public void sair() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Adicionar")){
            TelaAddEditFuncionario.inic();
        }

        if(e.getActionCommand().equals("Editar")){
            Integer numeroMatriculaFuncionario = (Integer) tFuncionarios.getValueAt(tFuncionarios.getSelectedRow(), 0 );
            TelaAddEditFuncionario.inic(ctrl.getFuncionario(numeroMatriculaFuncionario));
        }

        if(e.getActionCommand().equals("Remover")){
            Integer f = (Integer) tFuncionarios.getValueAt(tFuncionarios.getSelectedRow(), 0 );
            ControladorFuncionario.getInstance().excluiFuncionario(ControladorFuncionario.getInstance().getFuncionario(f));
        }

        if (e.getActionCommand().equals("Voltar")){
            this.setVisible(false);
            this.ctrl.voltarMenuPrincipal();
        }

        if (e.getActionCommand().equals("Sair")){
            this.setVisible(false);
        }

    }
}
