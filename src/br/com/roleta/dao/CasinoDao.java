/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.dao;

import br.com.roleta.conexao.ConnectionFactory;
import br.com.roleta.modelo.Casino;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CasinoDao {

    private final Connection con = ConnectionFactory.getConnection();

    public void inserir(Casino c) {
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO Casino (nome, tempoSessao, moeda) VALUES(?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setInt(2, c.getTempoSessao());
            stmt.setString(3, c.getMoeda());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar novo casino" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Casino> listar() {

        PreparedStatement stmt = null;

        List<Casino> lista = new ArrayList<>();

        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT idCasino, nome, tempoSessao, moeda FROM Casino");

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                lista.add(mapear(resultSet));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar casinos" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return lista;
    }

    public void deletarCasino(int idCasino) {
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM Casino WHERE idCasino = ?");
            stmt.setInt(1, idCasino);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar novo casino" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void deletarCasinoNome(String NomeCasino) {
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM Casino WHERE nome = ?");
            stmt.setString(1, NomeCasino);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar novo casino" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    private Casino mapear(ResultSet resultSet) throws SQLException {
        Casino casino = new Casino();
        casino.setIdCasino(resultSet.getInt("idCasino"));
        casino.setNome(resultSet.getString("nome"));
        casino.setMoeda(resultSet.getString("moeda"));
        casino.setTempoSessao(resultSet.getInt("tempoSessao"));

        return casino;
    }

    public Casino encontrarCasino(String nome) {

        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM Casino WHERE nome = ?");
            stmt.setString(1, nome);

            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return mapear(resultSet);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar casinos" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return null;

    }

}
