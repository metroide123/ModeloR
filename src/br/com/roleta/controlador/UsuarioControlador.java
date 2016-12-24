
package br.com.roleta.controlador;

import br.com.roleta.dao.usuarioDao;
import br.com.roleta.modelo.Usuario;
import java.util.List;


public class UsuarioControlador {
    
    private final usuarioDao usuarioDao = new usuarioDao();
    
    
    public void inseirUsuario(Usuario c) {
        usuarioDao.inserirUsuario(c);
    }
    
    public List<Usuario> listarUsuarios() {
        return usuarioDao.listar();
        
    }
    
    public Usuario autenticarUsuario(String usuario) {
        return usuarioDao.autenticar(usuario);
        
    }
    
    public void DeletarUsuario(String nome){
        usuarioDao.deletarUsuario(nome);
    }
      
}
