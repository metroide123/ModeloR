/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.controlador;

import br.com.roleta.dao.RoletaDao;
import br.com.roleta.modelo.Roleta;
import java.util.List;

/**
 *
 * @author andreqbs
 */
public class RoletaControlador {
    
    private final RoletaDao RoletaDao = new RoletaDao();
    
    
    public void inseirRoleta(Roleta c) {
        RoletaDao.inserir(c);
    }
    
    public List<Roleta> listarRoletass() {
        return RoletaDao.listar();
    }
    
    public void deletarCasinoNome(String c) {
        RoletaDao.deletar(c);
    }
    
}
