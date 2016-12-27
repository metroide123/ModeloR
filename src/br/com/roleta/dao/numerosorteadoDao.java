

package br.com.roleta.dao;

import br.com.roleta.conexao.ConnectionFactory;
import br.com.roleta.modelo.numerosorteado;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class numerosorteadoDao {
    
    private final Connection con = ConnectionFactory.getConnection();

    public void inserir(numerosorteado c) {
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO NumeroSorteado (numero, dataHora, idUsuario, idRoleta) VALUES(?,?,?,?)");
            stmt.setInt(1, c.getIdNumeros());
            stmt.setString(2, c.getDataHora());
            stmt.setInt(3, c.getIdUsuario());
            stmt.setInt(4, c.getIdRoleta());
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adcinoar Número\n" + ex);
        } 

    }
    
    
    public List<numerosorteado> listar() {

        PreparedStatement stmt = null;
        
        List<numerosorteado> lista = new ArrayList<>();

        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT idNumeros, numero, dataHora, idUsuario, idRoleta FROM NumeroSorteado");

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                lista.add(mapear(resultSet));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar casinos" + ex);
        } 
        return lista;
    }
    
     private numerosorteado mapear(ResultSet resultSet) throws SQLException {
        numerosorteado Numero = new numerosorteado();
        Numero.setIdNumeros(resultSet.getInt("idNumero"));
        Numero.setNumero(resultSet.getString("numero"));
        Numero.setDataHora(resultSet.getString("dataHora"));
        Numero.setIdUsuario(resultSet.getInt("idUsuario"));
        Numero.setIdRoleta(resultSet.getInt("idRoleta"));

        return Numero;
    }
    
    
    
    
}
