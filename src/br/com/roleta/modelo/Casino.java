/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.modelo;

/**
 *
 * @author andreqbs
 */
public class Casino {
    
    private int idCasino;
    private String nome;
    private String moeda;

    public Casino() {
    }
    
    public Casino(int idCasino, String nome, String moeda) {
        this.idCasino = idCasino;
        this.nome = nome;
        this.moeda = moeda;
    }

    public int getIdCasino() {
        return idCasino;
    }

    public void setIdCasino(int idCasino) {
        this.idCasino = idCasino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }
    
    
    
    
    
    
    
}
