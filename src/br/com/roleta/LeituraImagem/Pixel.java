/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.LeituraImagem;

import br.com.roleta.dao.MapeamentoNumero;
import br.com.roleta.modelo.NumeroMapeado;
import br.com.roleta.view.ChamadaRoleta;
import br.com.roleta.view.Home;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Pixel {

    BufferedImage image;
    public int NunTotal;
    int width;
    int height;
    final int padraoPreto = 35;
    final int padraoVermelho = 88;
    final int padraoVerde = 111;
    HashMap<Integer, Integer> numeros = new HashMap<>();
    MapeamentoNumero mn = new MapeamentoNumero();

    public void lerImagem(String file) {
        try {
            File input = new File(file);
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

        } catch (Exception e) {
            System.out.println("Erro na leitura do pixels");
        }
    }

    public int contarPixels() {
        int totalPixel = 0;
        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {

                Color c = new Color(image.getRGB(j, i));
                // total += c.getRed();
                //System.out.print(c.getRed() + " ");
                //if(c.getRGB()  != 113 && c.getRed() != 49 && c.getRed() != 130)
                if (c.getRed() >= 200) {
                    totalPixel += c.getRed();
                }

            }

        }

        System.out.println(totalPixel);
        return numeroSorteado2(totalPixel);
    }

    public void importarNumeros() {
        java.util.List<NumeroMapeado> listar = mn.listar(ChamadaRoleta.CasinoEscolha.getIdCasino(), Home.usuario.getIdUsuario());
        for (NumeroMapeado n : listar) {
            numeros.put(n.getNumeroPixel(), n.getNumero());
        }
    }

    public int numeroSorteado2(int valor) {
        //return mn.encontrarNumero(valor, ChamadaRoleta.CasinoEscolha.getIdCasino(), Home.usuario.getIdUsuario());
        if (numeros.containsKey(valor)) {
            return numeros.get(valor);
        } else {
            return 99;
        }
    }

}
