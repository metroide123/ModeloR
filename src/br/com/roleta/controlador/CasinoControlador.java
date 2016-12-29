/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.controlador;

import br.com.roleta.dao.CasinoDao;
import br.com.roleta.modelo.Casino;
import java.util.List;

/**
 *
 * @author andreqbs
 */
public class CasinoControlador {
    
    private final CasinoDao casinoDao = new CasinoDao();
    
    
    public void inseirCasino(Casino c) {
        casinoDao.inserir(c);
    }
    
    public List<Casino> listarCasinos() {
        return casinoDao.listar();
    }
    
    public void DeletarCasinoNome(String c) {
        casinoDao.deletarCasinoNome(c);
    }
    
    public Casino procurarCasino(String nome) {
        return casinoDao.encontrarCasino(nome);
    }
    
    public Casino procurarCasinoId(int id) {
        return casinoDao.encontrarCasinoId(id);
    }
}

