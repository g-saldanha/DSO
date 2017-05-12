/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1;

import java.io.IOException;

import br.ine5605.ufsc.controladores.ControladorPrincipal;

/**
 *
 * @author Caio
 */
public class Claviculario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        
        ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstance();        
        controladorPrincipal.inicia();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        
    }
    
}
