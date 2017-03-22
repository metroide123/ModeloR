package br.com.roleta.dao;

import br.com.roleta.conexao.ConnectionFactory;
import br.com.roleta.modelo.Usuario;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDao {

    private final Connection con = ConnectionFactory.getConnection();

    public void inserirUsuario(Usuario c) {
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO Usuario (nome) VALUES(?)");
            stmt.setString(1, c.getNome());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar novo usuario\n" + ex);
        }

    }
    
      public Usuario encontrarUsuario(String nome) {

        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM Usuario WHERE nome = ?");
            stmt.setString(1, nome);

            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return mapear(resultSet);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Procurar usuario" + ex);
        } 
        
        return null;
    }

    public List<Usuario> listar() {

        PreparedStatement stmt = null;

        List<Usuario> lista = new ArrayList<>();

        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT idUsuario, nome FROM Usuario");

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                lista.add(mapear(resultSet));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuarios\n" + ex);
        }
        return lista;
    }

    public void deletarUsuario(String nome) {
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM Usuario WHERE nome = ?");
            stmt.setString(1, nome);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar novo Usuario\n" + ex);
        } 
    }

    private Usuario mapear(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(resultSet.getInt("idUsuario"));
        usuario.setNome(resultSet.getString("nome"));

        return usuario;
    }

    public Usuario autenticar(String nome) {
        PreparedStatement stmt = null;
        ResultSet resultSet = null; 
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM Usuario WHERE nome = ?");
            stmt.setString(1, nome);
            //JOptionPane.showMessageDialog(null, "Encontrado!");
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return (mapear(resultSet));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuario\n" + ex);
        } 
        return null;
    }

}
