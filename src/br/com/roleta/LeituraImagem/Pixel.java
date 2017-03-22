/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.LeituraImagem;

import br.com.roleta.dao.MapeamentoNumero;
import br.com.roleta.view.ChamadaRoleta;
import br.com.roleta.view.Home;
import br.com.roleta.view.MapearNumero;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Pixel {

    BufferedImage image;
    public int NunTotal;
    int width;
    int height;
    final int padraoPreto = 35;
    final int padraoVermelho = 88;
    final int padraoVerde = 111;
    ArrayList<Integer> total = new ArrayList<>();
    MapeamentoNumero mn = new MapeamentoNumero();

    public Pixel(String file) {
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

    public int numeroSorteado2(int valor) {
        return mn.encontrarNumero(valor, ChamadaRoleta.CasinoEscolha.getIdCasino(), Home.usuario.getIdUsuario());
    }

    public int numeroSorteado(int valor) {

        if (valor == 2772) {//NOVO 0
            return 0;
        } else if (valor == 454) {//NOVO 1
            return 1;

        } else if (valor == 2122) {//NOVO 2
            return 2;

        } else if (valor == 1579) {//NOVO 3
            return 3;

        } else if (valor == 2148) {//NOVO 4
            return 4;

        } else if (valor == 2615) {//NOVO 5
            return 5;

        } else if (valor == 1809) {//NOVO 6
            return 6;

        } else if (valor == 1943) {//NOVO 7
            return 7;

        } else if (valor == 1972) {//NOVO 8
            return 8;

        } else if (valor == 2433) {//NOVO 9
            return 9;

        } else if (valor == 3653) {//NOVO 10
            return 10;
            
        } else if (valor == 1854) {//NOVO 11
            return 11;
            
        } else if (valor == 3985) {//NOVO 12
            return 12;
            
        } else if (valor == 2728) {//NOVO 13
            return 13;
            
        } else if (valor == 3801) {//NOVO 14
            return 14;
            
        } else if (valor == 3295) {//NOVO 15
            return 15;

        } else if (valor == 3621) {//NOVO 16
            return 16;
            
        } else if (valor == 2866) {//NOVO 17
            return 17;
            
        } else if (valor == 4831) {//NOVO 18
            return 18;
            
        } else if (valor == 3968) {//NOVO 19
            return 19;
            
        } else if (valor == 4414) {//NOVO 20
            return 20;
            
        } else if (valor == 3550) {//NOVO 21
            return 21;
            
        } else if (valor == 4309) {//NOVO 22
            return 22;
            
        } else if (valor == 4675) {//NOVO 23
            return 23;
            
        } else if (valor == 4335) {//NOVO 24
            return 24;
            
        } else if (valor == 5711) {//NOVO 25
            return 25;
            
        } else if (valor == 3996) {//NOVO OK
            return 26;
            
        } else if (valor == 5039) {//NOVO 27
            return 27;
            
        } else if (valor == 4159) {//NOVO 28
            return 28;
            
        } else if (valor == 3918) {//NOVO 29
            return 29;
            
        } else if (valor == 4952) {//NOVO 30
            return 30;
            
        } else if (valor == 1783) {//NOVO 31
            return 31;
            
        } else if (valor == 4672) {//NOVO 32
            return 32;
            
        } else if (valor == 2657) {//NOVO 33
            return 33;
            
        } else if (valor == 4488) {//NOVO 34
            return 34;
            
        } else if (valor == 3224) {//NOVO 35
            return 35;

        } else if (valor == 4308) {//NOVO 36
            return 36;
            
        } else {
            return 99;
        }

    }

}
