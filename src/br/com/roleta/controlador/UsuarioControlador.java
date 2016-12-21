
package br.com.roleta.controlador;

import br.com.roleta.dao.usuarioDao;
import br.com.roleta.modelo.usuario;
import java.util.List;


public class UsuarioControlador {
    
    private final usuarioDao usuarioDao = new usuarioDao();
    
    
    public void inseirUsuario(usuario c) {
        usuarioDao.inserirUsuario(c);
    }
    
    public List<usuario> listarUsuarios() {
        return usuarioDao.listar();
        
    }
    
    public void DeletarUsuario(String nome){
        usuarioDao.deletarUsuario(nome);
    }
      
}
