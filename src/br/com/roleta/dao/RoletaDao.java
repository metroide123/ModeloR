/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.dao;

import br.com.roleta.conexao.ConnectionFactory;
import br.com.roleta.modelo.Roleta;
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
public class RoletaDao {

    private final Connection con = ConnectionFactory.getConnection();

    public void inserir(Roleta c) {
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO Roleta (nome, valorMinimo, frameAltura, frameLargura, idCasino) VALUES(?,?,?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setInt(2, c.getValorMinino());
            stmt.setInt(3, c.getFrameAltura());
            stmt.setInt(4, c.getFrameLargura());
            stmt.setInt(5, c.getIdCassino());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar novo Roleta\n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Roleta> listar() {

        PreparedStatement stmt = null;

        List<Roleta> lista = new ArrayList<>();

        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT idRoleta, nome, valorMinimo, frameLargura, frameAltura, idCasino FROM Roleta");

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                lista.add(mapear(resultSet));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Roletas\n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return lista;
    }

    public void deletar(String nome) {
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM Roleta WHERE nome = ?");
            stmt.setString(1, nome);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar novo Roleta\n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    private Roleta mapear(ResultSet resultSet) throws SQLException {
        Roleta Roleta = new Roleta();
        Roleta.setIdRoleta(resultSet.getInt("idRoleta"));
        Roleta.setNome(resultSet.getString("nome"));
        Roleta.setValorMinino(resultSet.getInt("valorMinimo"));
        Roleta.setIdCassino(resultSet.getInt("idCasino"));
        Roleta.setFrameAltura(resultSet.getInt("frameAltura"));
        Roleta.setFrameLargura(resultSet.getInt("frameLargura"));

        return Roleta;
    }

        public List<Roleta> encontrarRoletaPorCasino(int idCasino) {

        PreparedStatement stmt = null;
        List<Roleta> lista = new ArrayList<>();
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM Roleta WHERE idCasino = ?");
            stmt.setInt(1, idCasino);

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                lista.add(mapear(resultSet));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na listar de Roletas\n" + ex);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt);
        }
        return lista;
    }
        
    public Roleta encontrarRoleta(String nome) {

        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM Roleta WHERE nome = ?");
            stmt.setString(1, nome);

            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return mapear(resultSet);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Roleta\n" + ex);
        } 
        ConnectionFactory.closeConnection(con, stmt, resultSet);
        return null;
    }
    
    
}
