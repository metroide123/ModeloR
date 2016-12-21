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
public class Apostas {
    
    private int idAposta;
    private float valorAposta;
    private int status;
    private int idTipodaAposta;
    private int idUsuario;
    private float retorno;

    public int getId() {
        return idAposta;
    }

    public void setId(int id) {
        this.idAposta = id;
    }

    public float getValorAposta() {
        return valorAposta;
    }

    public void setValorAposta(float valorAposta) {
        this.valorAposta = valorAposta;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdTipodaAposta() {
        return idTipodaAposta;
    }

    public void setIdTipodaAposta(int idTipodaAposta) {
        this.idTipodaAposta = idTipodaAposta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public float getRetorno() {
        return retorno;
    }

    public void setRetorno(float retorno) {
        this.retorno = retorno;
    }
    
    
    
    
}
