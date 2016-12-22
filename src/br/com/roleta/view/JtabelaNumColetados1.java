/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.roleta.view;

import br.com.roleta.controlador.NumeroControlador;
import br.com.roleta.modelo.numerosorteado;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Rodolfo Fonseca
 */
public class JtabelaNumColetados1 extends javax.swing.JInternalFrame {

    ArrayList<numerosorteado> ListadeNumeros = new ArrayList<>();
    NumeroControlador ControleNumero = new NumeroControlador();
    
    public JtabelaNumColetados1(ArrayList<numerosorteado> n) {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(modelo));
        ListadeNumeros = n;
        LerDados();
        Tnum.setText(Integer.toString(i));
    }
    int i = 0;

    
    private void LerDados(){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0); 
        
        for(numerosorteado n: ListadeNumeros){
            i++;
            modelo.addRow(new Object[]{
                n.getNumero(),
                n.getDataHora(),
                n.getIdRoleta(),
                n.getIdUsuario()
                    
            });
            
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Tnum = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SalvarBanco = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NumColetado", "Data", "IdRoleta", "IdUsuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Tnum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tnum.setText("0");

        jLabel2.setText("Total de num coletados:");

        SalvarBanco.setText("Salvar no Banco");
        SalvarBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarBancoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tnum, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SalvarBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tnum)
                    .addComponent(jLabel2)
                    .addComponent(SalvarBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(65, 25, 649, 334);
    }// </editor-fold>//GEN-END:initComponents

    private void SalvarBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarBancoActionPerformed

            ListadeNumeros.stream().forEach((n) -> {
                ControleNumero.inseirNumero(n);
            });
            JOptionPane.showMessageDialog(null, "Dados Salvos no Banco Com Sucesso!");
        
    }//GEN-LAST:event_SalvarBancoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SalvarBanco;
    private javax.swing.JLabel Tnum;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
