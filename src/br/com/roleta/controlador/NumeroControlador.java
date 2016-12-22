

package br.com.roleta.controlador;

import br.com.roleta.dao.numerosorteadoDao;
import br.com.roleta.modelo.numerosorteado;
import java.util.List;


public class NumeroControlador {
    
    private final numerosorteadoDao Numero = new numerosorteadoDao();
    
    
    public void inseirNumero(numerosorteado c) {
        Numero.inserir(c);
    }
    
    public List<numerosorteado> listarNumeros() {
        return Numero.listar();
    }
    
}
