/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.grupo3.controladores;

import java.io.IOException;
import java.util.ArrayList;

import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaChaves;
import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaPrincipal;
import br.ufsc.ine5605.grupo3.apresentacaoJFrame.TelaVeiculos;
import br.ufsc.ine5605.grupo3.entidades.Carro;
import br.ufsc.ine5605.grupo3.entidades.Funcionario;
import br.ufsc.ine5605.grupo3.entidades.Funcionario.Cargo;
import br.ufsc.ine5605.grupo3.entidades.Moto;
import br.ufsc.ine5605.grupo3.entidades.Veiculo;

/**
 *
 * @author Caio & Gabriel
 */
public class Claviculario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Moto m = new Moto("DSO123", "Biz", "Honda", 2011, 10);
        Carro c = new Carro("DSO1234", "Escalade", "Cadillac", 2016, 9);

        ArrayList<Veiculo> a1 = new ArrayList<>();
        a1.add(m);
        a1.add(c);

        ControladorChave.getInstance().adicionarChave("DSO123");
        ControladorChave.getInstance().adicionarChave("DSO1234");

        ControladorVeiculos.getInstance().cadastrarVeiculo(m);
        ControladorVeiculos.getInstance().cadastrarVeiculo(c);

        Funcionario f1 = new Funcionario(123, "Jotao", 11042011, 88888888, Cargo.COMUM, a1);
        Funcionario f2 = new Funcionario(1234, "Jotinha", 11042012, 999999999, Cargo.DIRETORIA, null);

        ControladorFuncionario.getInstance().cadastraFuncionario(f1);
        ControladorFuncionario.getInstance().cadastraFuncionario(f2);


//        TelaVeiculos telaVeiculos = new TelaVeiculos(ControladorVeiculos.getInstance());
//        telaVeiculos.atualizaLista();

//        telaPrincipal.setVisible(true);
//        telaVeiculos.setVisible(true);
        TelaChaves telaChaves = new TelaChaves(ControladorChave.getInstance());
        telaChaves.atualizaLista();

        telaChaves.setVisible(true);
    }

}
