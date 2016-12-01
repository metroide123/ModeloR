/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD_Resultados.dao;

import BD_Resultados.bean.ResultaDados;
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
public class ResultadosTotalDAO {

    public void create(ResultaDados r) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO coletatotaldadosresultados (Entrada,Resultado,P1,P2,P3,TamanhoEspera) VALUES(?,?,?,?,?,?)");
            stmt.setString(1, r.getEntrada());
            stmt.setString(2, r.getResultado());
            stmt.setString(3, r.getP1());
            stmt.setString(4, r.getP2());
            stmt.setString(5, r.getP3());
            stmt.setInt(6, r.getTamanhoespera());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<ResultaDados> Lertura() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<ResultaDados> ColetadosResultados = new ArrayList<>();

        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM coletatotaldadosresultados");
            rs = stmt.executeQuery();

            while (rs.next()) {

                ResultaDados n = new ResultaDados();

                n.setId(rs.getInt("id"));

                n.setEntrada(rs.getString("Entrada"));
                n.setResultado(rs.getString("Resultado"));
                n.setP1(rs.getString("P1"));
                n.setP2(rs.getString("P2"));
                n.setP3(rs.getString("P3"));
                n.setTamanhoespera(rs.getInt("TamanhoEspera"));

                ColetadosResultados.add(n);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Coletar Num" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return ColetadosResultados;

    }

    public void Delete() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM coletatotaldadosresultados");
            rs = stmt.executeQuery();

            while (rs.next()) {

                ResultaDados n = new ResultaDados();

                n.setId(rs.getInt("id"));

                stmt = (PreparedStatement) con.prepareStatement("DELETE FROM coletatotaldadosresultados WHERE id = ?");
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

            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM coletatotaldadosresultados WHERE id = ?");
            stmt.setInt(1, i);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Coletar Num" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
