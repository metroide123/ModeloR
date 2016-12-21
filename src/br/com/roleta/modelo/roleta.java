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
public class roleta {
    
    private int idRoleta;
    private String nome;
    private int idCassino;
    private int valorMinino;
    private int tamanhoFrame;

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

    public int getTamanhoFrame() {
        return tamanhoFrame;
    }

    public void setTamanhoFrame(int tamanhoFrame) {
        this.tamanhoFrame = tamanhoFrame;
    }
    
    
    
}
