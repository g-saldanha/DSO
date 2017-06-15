package br.ufsc.ine5605.grupo3.apresentacaoJFrame;

import br.ufsc.ine5605.grupo3.controladores.ControladorVeiculos;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAddEditVeiculo extends JFrame implements Tela, ActionListener {

    private ControladorVeiculos ctrl;

    public TelaAddEditVeiculo() {
        this.ctrl = ControladorVeiculos.getInstance();
        this.inic();;
    }

    @Override
    public void inic() {

    }


    public void edit(Veiculo veiculo){

    }

    @Override
    public void atualizaLista() {

    }

    @Override
    public void sair() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
