

package br.com.roleta.dao;

import br.com.roleta.conexao.ConnectionFactory;
import br.com.roleta.modelo.usuario;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class usuarioDao {
    
    private final Connection con = ConnectionFactory.getConnection();

    public void inserirUsuario(usuario c) {
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO usuario (nome) VALUES(?)");
            stmt.setString(1, c.getNome());
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar novo usuario" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public List<usuario> listar() {

        PreparedStatement stmt = null;
        
        List<usuario> lista = new ArrayList<>();

        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT idUsuario, nome FROM usuario");

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                lista.add(mapear(resultSet));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuarios" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return lista;
    }

    public void deletarUsuario(String nome) {
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM usuario WHERE nome = ?");
            stmt.setString(1, nome);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar noco Usuario" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    private usuario mapear(ResultSet resultSet) throws SQLException {
        usuario usuario = new usuario();
        usuario.setIdUsuario(resultSet.getInt("idUsuario"));
        usuario.setNome(resultSet.getString("nome"));

        return usuario;
    }
    
}
