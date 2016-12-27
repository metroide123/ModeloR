/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.dao;

import br.com.roleta.conexao.ConnectionFactory;
import br.com.roleta.modelo.Fundos;
import br.com.roleta.modelo.Usuario;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author andreqbs
 */
public class FundosDao {

    private final Connection con = ConnectionFactory.getConnection();

    public void inserirFundos(Fundos c) {
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO Usuario (nome) VALUES(?)");
          //  stmt.setString(1, c.getNome());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar novo usuario\n" + ex);
        }

    }

    public List<Fundos> listarPorId(Usuario u) {

        PreparedStatement stmt = null;

        List<Fundos> lista = new ArrayList<>();

        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM Fundos WHERE idUsuario = ?");
            stmt.setInt(1, u.getIdUsuario());
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                lista.add(mapear(resultSet));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuarios\n" + ex);
        }
        return lista;
    }

    public void deletarFundo(String nome) {
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM Fundos WHERE nome = ?");
            stmt.setString(1, nome);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar novo Usuario\n" + ex);
        }
    }

    private Fundos mapear(ResultSet resultSet) throws SQLException {
        Fundos fundos = new Fundos();
        fundos.setIdUsuario(resultSet.getInt("idUsuario"));
        fundos.setIdCassino(resultSet.getInt("idCassino"));
        fundos.setSaldo(resultSet.getInt("saldo"));

        return fundos;
    }

    public Fundos autenticar(String nome) {
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
