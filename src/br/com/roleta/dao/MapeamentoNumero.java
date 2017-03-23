/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.dao;

import br.com.roleta.conexao.ConnectionFactory;
import br.com.roleta.modelo.NumeroMapeado;
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
public class MapeamentoNumero {

    private final Connection con = ConnectionFactory.getConnection();

    public void inserir(int pixel, int numero, int idCassino, int idUsuario) {
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO MapeamentoNumero (numero, pixelNumero, idCasino, idUsuario) VALUES(?,?,?,?)");
            stmt.setInt(1, numero);
            stmt.setInt(2, pixel);
            stmt.setInt(3, idCassino);
            stmt.setInt(4, idUsuario);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar novo mapeamento" + ex);
        }

    }

    public int encontrarNumer(int pixel, int idCasino, int idUsuario) {

        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM MapeamentoNumero WHERE idCasino = ? AND idUsuario = ? AND pixelNumero = ?");
            stmt.setInt(1, idCasino);
            stmt.setInt(2, idUsuario);
            stmt.setInt(3, pixel);

            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("numero");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Procurar casinos" + ex);
        }

        return 99;
    }

    public List<NumeroMapeado> listar(int idCasino, int idUsuario) {

        PreparedStatement stmt;

        List<NumeroMapeado> lista = new ArrayList<>();

        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM MapeamentoNumero WHERE idCasino = ? AND idUsuario = ?");
            stmt.setInt(1, idCasino);
            stmt.setInt(2, idUsuario);
            
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                lista.add(mapear(resultSet));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar casinos" + ex);
        }
        return lista;
    }

    private NumeroMapeado mapear(ResultSet resultSet) throws SQLException {
        NumeroMapeado num = new NumeroMapeado();
        num.setNumeroPixel(resultSet.getInt("pixelNumero"));
        num.setNumero(resultSet.getInt("numero"));

        return num;
    }

}
