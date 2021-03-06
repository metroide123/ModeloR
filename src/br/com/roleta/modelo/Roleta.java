/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.modelo;

/**
 *
 * @author Rodolfo Fonseca
 */
public class Roleta {

    private int idRoleta;
    private String nome;
    private int idCassino;
    private int valorMinino;
    private int frameAltura;
    private int frameLargura;
    private int frameZeroAltura;
    private int frameZeroLargura;
    private int frameZerofonte;

    public int getFrameZeroAltura() {
        return frameZeroAltura;
    }

    public void setFrameZeroAltura(int frameZeroAltura) {
        this.frameZeroAltura = frameZeroAltura;
    }

    public int getFrameZeroLargura() {
        return frameZeroLargura;
    }

    public void setFrameZeroLargura(int frameZeroLargura) {
        this.frameZeroLargura = frameZeroLargura;
    }

    public int getFrameZerofonte() {
        return frameZerofonte;
    }

    public void setFrameZerofonte(int frameZerofonte) {
        this.frameZerofonte = frameZerofonte;
    }

    public int getIdRoleta() {
        return idRoleta;
    }

    public void setIdRoleta(int idRoleta) {
        this.idRoleta = idRoleta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdCassino() {
        return idCassino;
    }

    public void setIdCassino(int idCassino) {
        this.idCassino = idCassino;
    }

    public int getValorMinino() {
        return valorMinino;
    }

    public void setValorMinino(int valorMinino) {
        this.valorMinino = valorMinino;
    }

    public int getFrameAltura() {
        return frameAltura;
    }

    public void setFrameAltura(int frameAltura) {
        this.frameAltura = frameAltura;
    }

    public int getFrameLargura() {
        return frameLargura;
    }

    public void setFrameLargura(int frameLargura) {
        this.frameLargura = frameLargura;
    }

}
