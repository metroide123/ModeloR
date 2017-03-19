/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.LeituraImagem;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;

public class Pixel {

    BufferedImage image;
    int width;
    int height;

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
        int total = 0;
        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {

                Color c = new Color(image.getRGB(j, i));
                // total += c.getRed();
                //  System.out.print(c.getRed() + " ");
                //if(c.getRGB()  != 113 && c.getRed() != 49 && c.getRed() != 130)
                if (c.getRed() >= 200) {
                    total += c.getRed();
                }

            }

        }
        return numeroSorteado(total);
    }

    public int numeroSorteado(int valor) {
        if (valor == 454) {
            return 1;

        } else if (valor == 1060) {
            return 2;

        } else if (valor == 1273) {
            return 35;

        } else if (valor == 1276) {
            return 8;

        } else if (valor == 1499) {

            return 7;

        } else if (valor == 1561) {

            return 3;

        } else if (valor == 1570) {

            return 9;

        } else if (valor == 1693) {

            return 4;

        } else if (valor == 1737) {
            return 5;

        } else if (valor == 1783) {
            return 6;

        } else if (valor == 1995) {

            return 0;
        } else if (valor == 2336) {

            return 33;
        } else if (valor == 2598) {
            return 13;
        } else if (valor == 2610) {
            return 15;

        } else if (valor == 2663) {
            return 17;
        } else if (valor == 2740) {
            return 31;
        } else if (valor == 2767) {
            return 29;
        } else if (valor == 3000) {
            return 310;
        } else if (valor == 3002) {
            return 11;
        } else if (valor == 3034) {
            return 28;
        } else if (valor == 3190) {
            return 27;
        } else if (valor == 3195) {
            return 20;
        } else if (valor == 3322) {
            return 30;
        } else if (valor == 3458) {
            return 19;
        } else if (valor == 3625) {
            return 22;
        } else if (valor == 3625) {
            return 26;
        } else if (valor == 3728) {
            return 18;
        } else if (valor == 3739) {
            return 14;
        } else if (valor == 3756) {
            return 12;
        } else if (valor == 3775) {
            return 25;
        } else if (valor == 3784) {
            return 21;
        } else if (valor == 3789) {
            return 24;
        } else if (valor == 3964) {
            return 23;
        } else if (valor == 3967) {
            return 34;
        } else if (valor == 3984) {
            return 32;
        } else if (valor == 4167) {
            return 16;
        } else if (valor == 4395) {
            return 36;
        } else {
            return 99;
        }

    }

}
