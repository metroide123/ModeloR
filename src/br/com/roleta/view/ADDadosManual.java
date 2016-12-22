/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.view;

import br.com.roleta.controlador.CasinoControlador;
import br.com.roleta.modelo.NumColetado;
import br.com.roleta.dao.NumColetadoDAO;
import br.com.roleta.controlador.Estrategias;
import br.com.roleta.controlador.NumeroControlador;
import br.com.roleta.modelo.Casino;
import br.com.roleta.modelo.numerosorteado;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;

/**
 *
 * @author Rodolfo Fonseca
 */
public class ADDadosManual extends javax.swing.JInternalFrame {

    NumeroControlador ControleNumero = new NumeroControlador();

    NumColetado NovoNum = new NumColetado();
    NumColetadoDAO NovoNumDAO = new NumColetadoDAO();
    Date date = new Date();
    DateFormat formato = new SimpleDateFormat("dd/MM/yyyy - hh:mm");

    String nomeRoleta;

    Estrategias e = new Estrategias();

    JDesktopPane jpdHome;
    ArrayList<numerosorteado> ListadeNumeros = new ArrayList<>();

    public ADDadosManual(JDesktopPane jp) {
        jpdHome = jp;
        initComponents();
        jTextArea1.setLineWrap(true);
        popularCasinos();
    }

    private void popularCasinos() {
        CasinoControlador cc = new CasinoControlador();
        List<String> listarCasinos = new ArrayList<>();
        for (Casino listarCasino : cc.listarCasinos()) {
            listarCasinos.add(listarCasino.getNome());
        }
        jComboBox1.setModel(new DefaultComboBoxModel(listarCasinos.toArray()));
    }

    public void GerarLista() {

        int IdUsuario = 0;
        int IdCasino = 0; // Criar No banco
        int IdRoleta = 0;

        String a = jTextArea1.getText();
        String[] parts = a.split(",");

        for (String i : parts) {
            int n;
            n = Integer.parseInt(i);

            if (n != 99) {
                if (n >= 0 && n <= 36) {
                    numerosorteado NovoNumero = new numerosorteado();
                    NovoNumero.setNumero(i);
                    e.AnalisandoDadosBDVP(n);
                    String formattedDate = formato.format(date);
                    NovoNumero.setDataHora(formattedDate);
                    NovoNumero.setIdRoleta(IdRoleta);
                    NovoNumero.setIdUsuario(IdCasino);
                    ListadeNumeros.add(NovoNumero);

                }

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Limpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        GerarNumeros = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        Limpar.setText("Limpar");
        Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Digite os Numeros abaixo separados por virgula.");

        GerarNumeros.setText("Gerar Numeros");
        GerarNumeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerarNumerosActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Casino:");

        jLabel3.setText("Roleta: ");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GerarNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Limpar, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(GerarNumeros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        setBounds(150, 30, 504, 359);
    }// </editor-fold>//GEN-END:initComponents

    private void LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparActionPerformed
        jTextArea1.setText("");
    }//GEN-LAST:event_LimparActionPerformed

    private void GerarNumerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerarNumerosActionPerformed
        if (!"".equals(jTextArea1.getText())) {
            GerarLista();
            JtabelaNumColetados1 novo = new JtabelaNumColetados1(ListadeNumeros);
            jpdHome.add(novo);
            novo.setVisible(true);
            //this.dispose(); 
        }
    }//GEN-LAST:event_GerarNumerosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GerarNumeros;
    private javax.swing.JButton Limpar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
