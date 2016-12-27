/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.controlador;

import br.com.roleta.dao.FundosDao;
import br.com.roleta.modelo.Fundos;
import br.com.roleta.modelo.Usuario;
import java.util.List;

/**
 *
 * @author andreqbs
 */
public class FundosControlador {
    
     private final FundosDao fundosDao = new FundosDao();
    
    
    public void inseirUsuario(Fundos c) {
       // fundosDao.inserirUsuario(c);
    }
    
    public List<Fundos> listar(Usuario u) {
        return fundosDao.listarPorId(u);
        
    }
    
    public Fundos autenticarUsuario(String usuario) {
        return fundosDao.autenticar(usuario);
        
    }
    
    public void DeletarUsuario(String nome){
      //  fundosDao.deletarUsuario(nome);
    }
    
    
}
