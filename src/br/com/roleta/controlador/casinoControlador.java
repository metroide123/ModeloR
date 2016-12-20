/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.controlador;

import br.com.roleta.dao.casinoDao;
import br.com.roleta.modelo.Casino;
import java.util.List;

/**
 *
 * @author andreqbs
 */
public class casinoControlador {
    
    private final casinoDao casinoDao = new casinoDao();
    
    
    public void inseirCasino(Casino c) {
        casinoDao.inserir(c);
    }
    
    public List<Casino> listarCasinos() {
        
        return casinoDao.listar();
    }
    
}
