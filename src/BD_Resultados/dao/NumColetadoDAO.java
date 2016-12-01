/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD_Resultados.dao;

import BD_Resultados.bean.NumColetado;
import BD_ResultadosDados.connection.ConnectionFactory;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodolfo Fonseca
 */
public class NumColetadoDAO {

    public void create(NumColetado n) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO numcoletado (numColeta,tipoRoleta,dataColeta,horaColeta) VALUES(?,?,?,?)");
            stmt.setInt(1, n.getNumcoletado());
            stmt.setString(2, n.getTipoRoleta());
            stmt.setString(3, n.getDataColeta());
            stmt.setString(4, n.getHoraColeta());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Coletar Num" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<NumColetado> Lertura() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<NumColetado> Coletados = new ArrayList<>();

        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM numcoletado");
            rs = stmt.executeQuery();

            while (rs.next()) {

                NumColetado n = new NumColetado();

                n.setId(rs.getInt("id"));
                n.setNumcoletado(rs.getInt("numColeta"));
                n.setTipoRoleta(rs.getString("tipoRoleta"));
                n.setDataColeta(rs.getString("dataColeta"));
                n.setHoraColeta(rs.getString("horacoleta"));

                Coletados.add(n);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Coletar Num" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Coletados;

    }

    public void Delete() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM numcoletado");
            rs = stmt.executeQuery();

            while (rs.next()) {

                NumColetado n = new NumColetado();

                n.setId(rs.getInt("id"));

                stmt = (PreparedStatement) con.prepareStatement("DELETE FROM numcoletado WHERE id = ?");
                stmt.setInt(1, n.getId());
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Coletar Num" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }

    public void Delete(int i) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM numcoletado WHERE id = ?");
            stmt.setInt(1, i);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Coletar Num" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
