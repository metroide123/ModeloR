/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.view;

import br.com.roleta.controlador.casinoControlador;
import br.com.roleta.modelo.Casino;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodolfo Fonseca
 */
public class CadastroCassino extends javax.swing.JInternalFrame {
    
    private casinoControlador CasinoContro = new casinoControlador();
    private Casino Casino = new Casino();

    public CadastroCassino() {
        initComponents();
    }
    
    public void Cadastro(){
        if ("".equals(jTextNomeCasino.getText()) | "".equals(jTextTempoSessao.getText()) ){
            JOptionPane.showMessageDialog(null, "Nenhum Campo deve Ficar em Braco!");
        } else {
            Casino.setNome(jTextNomeCasino.getText());
            Casino.setTempoSessao(Integer.parseInt(jTextTempoSessao.getText()));
            Casino.setMoeda(jComboMoeda.getSelectedItem().toString());
            CasinoContro.inseirCasino(Casino);
            
            JOptionPane.showMessageDialog(null, "Casino Cadastrado Com Sucesso!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        CadastrarCasino = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextNomeCasino = new javax.swing.JTextField();
        jTextTempoSessao = new javax.swing.JTextField();
        jComboMoeda = new javax.swing.JComboBox();

        setClosable(true);

        jLabel4.setText("Tempo da Sessao (min):");

        CadastrarCasino.setText("Salvar");
        CadastrarCasino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarCasinoActionPerformed(evt);
            }
        });

        jLabel5.setText("Moeda:");

        jLabel2.setText("Nome do Casino:");

        jTextTempoSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTempoSessaoActionPerformed(evt);
            }
        });

        jComboMoeda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dolar", "Euro", "Reais" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboMoeda, 0, 134, Short.MAX_VALUE)
                                .addComponent(jTextTempoSessao)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                            .addComponent(jTextNomeCasino, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(CadastrarCasino, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextNomeCasino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextTempoSessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboMoeda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(CadastrarCasino, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextTempoSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTempoSessaoActionPerformed

    }//GEN-LAST:event_jTextTempoSessaoActionPerformed

    private void CadastrarCasinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarCasinoActionPerformed

    }//GEN-LAST:event_CadastrarCasinoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadastrarCasino;
    private javax.swing.JComboBox jComboMoeda;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextNomeCasino;
    private javax.swing.JTextField jTextTempoSessao;
    // End of variables declaration//GEN-END:variables
}
