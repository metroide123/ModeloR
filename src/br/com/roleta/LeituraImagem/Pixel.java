/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.LeituraImagem;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Pixel {

    BufferedImage image;
    int width;
    int height;
    final int padraoPreto = 35;
    final int padraoVermelho = 88;
    final int padraoVerde = 111;
    ArrayList<Integer> total = new ArrayList<>();

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
        //System.out.println("");
        System.out.println(totalPixel);
        return numeroSorteado(totalPixel);
    }


    public int numeroSorteado(int valor) {

        if (valor == 4251) {//NOVO 0
            return 0;
        } else if (valor == 2099) {//NOVO 1
            return 1;

        } else if (valor == 1384) {//NOVO 2
            return 2;

        } else if (valor == 2234) {//NOVO 3
            return 3;

        } else if (valor == 2640) {//NOVO 4
            return 4;

        } else if (valor == 2259) {//NOVO 5
            return 5;

        } else if (valor == 2075) {//NOVO 6
            return 6;

        } else if (valor == 1777) {//NOVO 7
            return 7;

        } else if (valor == 2462) {//NOVO 8
            return 8;

        } else if (valor == 2286) {//NOVO 9
            return 9;

        } else if (valor == 3056) {//NOVO 10
            return 10;
            
        } else if (valor == 724) {//NOVO 11
            return 11;
            
        } else if (valor == 4247) {//NOVO 12
            return 12;
            
        } else if (valor == 2281) {//NOVO 13
            return 13;
            
        } else if (valor == 5071) {//NOVO 14
            return 14;
            
        } else if (valor == 1212) {//NOVO 15
            return 15;

        } else if (valor == 4916) {//NOVO 16
            return 16;
            
        } else if (valor == 1611) {//NOVO 17
            return 17;
            
        } else if (valor == 5384) {//NOVO 18
            return 18;
            
        } else if (valor == 4505) {//NOVO 19
            return 19;
            
        } else if (valor == 3519) {//NOVO 20
            return 20;
            
        } else if (valor == 2476) {//NOVO 21
            return 21;
            
        } else if (valor == 2753) {//NOVO 22
            return 22;
            
        } else if (valor == 4313) {//NOVO 23
            return 23;
            
        } else if (valor == 2510) {//NOVO 24
            return 24;
            
        } else if (valor == 3818) {//NOVO 25
            return 25;
            
        } else if (valor == 2983) {//NOVO OK
            return 26;
            
        } else if (valor == 3606) {//NOVO 27
            return 27;
            
        } else if (valor == 3246) {//NOVO 28
            return 28;
            
        } else if (valor == 3014) {//NOVO 29
            return 29;
            
        } else if (valor == 5979) {//NOVO 30
            return 30;
            
        } else if (valor == 2063) {//NOVO 31
            return 31;
            
        } else if (valor == 4796) {//NOVO 32
            return 32;
            
        } else if (valor == 3620) {//NOVO 33
            return 33;
            
        } else if (valor == 5620) {//NOVO 34
            return 34;
            
        } else if (valor == 2551) {//NOVO 35
            return 35;

        } else if (valor == 5465) {//NOVO 36
            return 36;
            
        } else {
            return 99;
        }

    }

}
