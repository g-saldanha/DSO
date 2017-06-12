package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import br.ufsc.ine5605.grupo3.controladores.ControladorRegistro;

import javax.swing.*;
import java.awt.*;

public class TelaRegistros extends JFrame implements Tela {
//    Atributos
    private ControladorRegistro ctrl;
    private JLabel bemVindo;
    private JLabel lista;
    private JButton ver;
    private JButton sair;
    private JButton voltar;
    private JTable tRegistros;
    private JScrollPane scrollPane;

    public TelaRegistros(ControladorRegistro ctrl) {
        this.ctrl = ctrl;
        this.inic();
    }

    //    private int data;
//    private int mes;
//    private int hora;
//    private Funcionario funcionario;
//    private Veiculo veiculo;
//    private boolean motivo;
//    private int kmAndados;
//    private String mensagem;
    @Override
    public void inic(){
//        Definir Container e Layout
    Container container = this.getContentPane();
    container.setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();

//    Instanciando os componentes
    bemVindo = new JLabel();
    lista = new JLabel();
    ver = new JButton();
    sair = new JButton();
    voltar = new JButton();
    tRegistros = new JTable();

//
    }



    @Override
    public void atualizaLista() {

    }

    @Override
    public void sair() {

    }
}
