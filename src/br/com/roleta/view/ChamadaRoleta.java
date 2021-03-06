/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roleta.view;

import br.com.roleta.controlador.CasinoControlador;
import br.com.roleta.controlador.DadosChamadaRoleta;
import br.com.roleta.controlador.RoletaControlador;
import br.com.roleta.modelo.Casino;
import br.com.roleta.modelo.Roleta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodolfo Fonseca
 */
public class ChamadaRoleta extends javax.swing.JInternalFrame {

    RoletaControlador RoletaControl = new RoletaControlador();
    CasinoControlador CasinoControl = new CasinoControlador();
    DadosChamadaRoleta ChamadoRoleta = new DadosChamadaRoleta();
    public static Casino CasinoEscolha;
    Roleta RoletaEscolha;

    JDesktopPane jpdHome;
    public int I;
    Home home;

    public ChamadaRoleta(JDesktopPane jp, int i, Home h) {
        jpdHome = jp;
        home = h;
        I = i;
        initComponents();
        popularCasinos();
    }

    private void popularCasinos() {
        CasinoControlador cc = new CasinoControlador();
        List<String> listarCasinos = new ArrayList<>();
        listarCasinos.add("<Selecione Casino>");
        for (Casino listarCasino : cc.listarCasinos()) {
            listarCasinos.add(listarCasino.getNome());
        }
        bxCasino.setModel(new DefaultComboBoxModel(listarCasinos.toArray()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        bxDuz = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bxCol = new javax.swing.JComboBox();
        bxVP = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        bxMM = new javax.swing.JComboBox();
        bxCasino = new javax.swing.JComboBox();
        bxPI = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        bxRoleta = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        bxColunaUni = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        bxDuziaUnica = new javax.swing.JComboBox();
        bxAlternaDuzia = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        bxAlternaColuna = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        bxAlterVerPre = new javax.swing.JComboBox<String>();

        jLabel9.setText("Casino: ");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Spotingbet 01", "Spotingbet 02", "Bet365", "888 Cassino" }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setClosable(true);
        setTitle("Configurações da Sequência");
        setMinimumSize(new java.awt.Dimension(150, 150));
        setPreferredSize(new java.awt.Dimension(450, 530));

        bxDuz.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "11", "12", "13" }));

        jLabel2.setText("Verm/Preto:");

        jLabel3.setText("Maior/Menor:");

        jLabel4.setText("Par/Ímp:");

        jLabel5.setText("Duzia:");

        jLabel6.setText("Coluna:");

        bxCol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "11", "12", "13" }));

        bxVP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "11", "12", "13" }));
        bxVP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bxVPActionPerformed(evt);
            }
        });

        jLabel8.setText("Casino: ");

        bxMM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08", "09", "10", "11", "12", "13" }));
        bxMM.setSelectedIndex(2);

        bxCasino.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bxCasinoItemStateChanged(evt);
            }
        });

        bxPI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09", "10", "11", "12", "13" }));
        bxPI.setSelectedIndex(1);

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Roleta:");

        bxRoleta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bxRoletaItemStateChanged(evt);
            }
        });

        jLabel14.setText("Coluna Única:");

        bxColunaUni.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "04", "05", "06", "07" }));
        bxColunaUni.setSelectedIndex(2);

        jLabel15.setText("Duzia Unica:");

        bxDuziaUnica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "04", "05", "06", "07" }));
        bxDuziaUnica.setSelectedIndex(2);

        bxAlternaDuzia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "05", "06", "07", "08" }));
        bxAlternaDuzia.setSelectedIndex(1);

        jLabel16.setText("AlterDuzia:");

        bxAlternaColuna.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "05", "06", "07", "08" }));
        bxAlternaColuna.setSelectedIndex(1);

        jLabel17.setText("AlterColuna:");

        jLabel11.setText("AlterVerPre:");

        bxAlterVerPre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07", "08", "09", "10" }));
        bxAlterVerPre.setSelectedIndex(3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(bxVP, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bxMM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bxCol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bxPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jLabel5))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel11)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(bxAlterVerPre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(bxDuz, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(bxColunaUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bxDuziaUnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(24, 24, 24)
                                .addComponent(bxAlternaColuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bxAlternaDuzia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bxCasino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bxRoleta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bxVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(bxMM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(bxAlterVerPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bxPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bxCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(bxDuz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bxColunaUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(bxDuziaUnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bxAlternaColuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bxAlternaDuzia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(bxCasino, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(bxRoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(250, 5, 394, 399);
    }// </editor-fold>//GEN-END:initComponents

    private void bxVPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bxVPActionPerformed

    }//GEN-LAST:event_bxVPActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!"<Selecione Casino>".equals(bxCasino.getSelectedItem().toString()) && !"<Selecione Roleta>".equals(bxRoleta.getSelectedItem().toString())) {
            ChamadoRoleta.setVP(Integer.parseInt(bxVP.getSelectedItem().toString()));
            ChamadoRoleta.setMM(Integer.parseInt(bxMM.getSelectedItem().toString()));
            ChamadoRoleta.setPI(Integer.parseInt(bxPI.getSelectedItem().toString()));
            ChamadoRoleta.setDuz(Integer.parseInt(bxDuz.getSelectedItem().toString()));
            ChamadoRoleta.setCol(Integer.parseInt(bxCol.getSelectedItem().toString()));
            ChamadoRoleta.setColunaUnicaMax(Integer.parseInt(bxColunaUni.getSelectedItem().toString()));
            ChamadoRoleta.setDuziaUnicaMax(Integer.parseInt(bxDuziaUnica.getSelectedItem().toString()));
            ChamadoRoleta.setAlternaColunaMax(Integer.parseInt(bxAlternaColuna.getSelectedItem().toString()));
            ChamadoRoleta.setAlternaDuziaMax(Integer.parseInt(bxAlternaDuzia.getSelectedItem().toString()));
            ChamadoRoleta.setAlternaVPMax(Integer.parseInt(bxAlterVerPre.getSelectedItem().toString()));

            String Local;
            Roleta NRoleta = RoletaEscolha;

            if (I == 1) {
                Local = "Leitor1";
                RoletaTela novo = new RoletaTela(ChamadoRoleta, "ROLETA " + Integer.toString(I), Local, home, NRoleta);
                novo.setTitle(NRoleta.getNome());
                novo.setVisible(true);
                this.dispose();
            }
            if (I == 2) {
                Local = "Leitor2";
                RoletaTela novo = new RoletaTela(ChamadoRoleta, "ROLETA " + Integer.toString(I), Local, home, NRoleta);
                novo.setTitle(NRoleta.getNome());
                novo.setVisible(true);
                this.dispose();
            }
            if (I == 3) {
                Local = "Leitor3";
                RoletaTela novo = new RoletaTela(ChamadoRoleta, "ROLETA " + Integer.toString(I), Local, home, NRoleta);
                novo.setTitle(NRoleta.getNome());
                novo.setVisible(true);
                this.dispose();
            }

            if (I == 4) {
                Local = "Leitor4";
                RoletaTela novo = new RoletaTela(ChamadoRoleta, "ROLETA " + Integer.toString(I), Local, home, NRoleta);
                novo.setTitle(NRoleta.getNome());
                novo.setVisible(true);
                this.dispose();
            }

            if (I == 5) {
                Local = "Leitor5";
                RoletaTela novo = new RoletaTela(ChamadoRoleta, "ROLETA " + Integer.toString(I), Local, home, NRoleta);
                novo.setTitle(NRoleta.getNome());
                novo.setVisible(true);
                this.dispose();
            }
            if (I > 5) {
                JOptionPane.showMessageDialog(null, "Maximo De Roletas Abertas");
                this.dispose();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Cassino ou Roleta Não Selecionados!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bxCasinoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bxCasinoItemStateChanged
        if (!"<Selecione Casino>".equals(bxCasino.getSelectedItem().toString())) {
            CasinoEscolha = CasinoControl.procurarCasino(bxCasino.getSelectedItem().toString());
            List<Roleta> lista;
            List<String> lisR = new ArrayList<>();
            lisR.add("<Selecione Roleta>");
            lista = RoletaControl.ProcurarRoletasIdCasino(CasinoEscolha.getIdCasino());
            for (Roleta listarroleta : lista) {
                lisR.add(listarroleta.getNome());
            }
            bxRoleta.setModel(new DefaultComboBoxModel(lisR.toArray()));
        }
    }//GEN-LAST:event_bxCasinoItemStateChanged

    private void bxRoletaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bxRoletaItemStateChanged
        if (!"<Selecione Roleta>".equals(bxRoleta.getSelectedItem().toString())) {
            RoletaEscolha = RoletaControl.procurarCasino(bxRoleta.getSelectedItem().toString());
        }
    }//GEN-LAST:event_bxRoletaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bxAlterVerPre;
    private javax.swing.JComboBox bxAlternaColuna;
    private javax.swing.JComboBox bxAlternaDuzia;
    private javax.swing.JComboBox bxCasino;
    private javax.swing.JComboBox bxCol;
    private javax.swing.JComboBox bxColunaUni;
    private javax.swing.JComboBox bxDuz;
    private javax.swing.JComboBox bxDuziaUnica;
    private javax.swing.JComboBox bxMM;
    private javax.swing.JComboBox bxPI;
    private javax.swing.JComboBox bxRoleta;
    private javax.swing.JComboBox bxVP;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
