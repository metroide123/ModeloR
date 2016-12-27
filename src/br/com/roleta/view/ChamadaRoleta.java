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
    Casino CasinoEscolha;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bxVP = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        bxMM = new javax.swing.JComboBox();
        bxCasino = new javax.swing.JComboBox();
        bxPI = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        bxRoleta = new javax.swing.JComboBox();
        bxVitoriaCaixa = new javax.swing.JComboBox();
        bxDerrotaCaixa = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        ApMinima = new javax.swing.JTextField();
        SFrameZero = new javax.swing.JCheckBox();

        jLabel9.setText("Casino: ");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Spotingbet 01", "Spotingbet 02", "Bet365", "888 Cassino" }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setClosable(true);

        bxDuz.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "11", "12", "13" }));

        jLabel2.setText("Verm/Preto:");

        jLabel3.setText("Maior/Menor:");

        jLabel4.setText("Par/Ímp:");

        jLabel5.setText("Duzia:");

        jLabel6.setText("Coluna:");

        bxCol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "11", "12", "13" }));

        jLabel1.setFont(new java.awt.Font("Urdu Typesetting", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Configurações Iniciais");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Configurações da Sequência:");

        bxVP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "11", "12", "13" }));
        bxVP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bxVPActionPerformed(evt);
            }
        });

        jLabel8.setText("Casino: ");

        bxMM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08", "09", "10", "11", "12", "13" }));

        bxCasino.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bxCasinoItemStateChanged(evt);
            }
        });

        bxPI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09", "10", "11", "12", "13" }));

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

        bxVitoriaCaixa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "4", "5", "6", "7", "8", "9", "10" }));

        bxDerrotaCaixa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "4", "5", "6", "7" }));

        jLabel11.setText("Limite Vitoria:");

        jLabel12.setText("Limite Derrota:");

        jLabel13.setText("Aposta Minima:");

        SFrameZero.setText("Ativar Frame com Zero Interno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel2))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(bxVP, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(bxMM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(bxCol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(2, 2, 2))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel5))))
                                    .addGap(21, 21, 21)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(bxPI, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bxDuz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bxVitoriaCaixa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bxDerrotaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bxCasino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bxRoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ApMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SFrameZero)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bxVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(bxMM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bxPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(bxDuz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(bxCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bxVitoriaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bxDerrotaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(ApMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(bxCasino, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(bxRoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SFrameZero)
                .addGap(12, 12, 12)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        setBounds(250, 5, 294, 494);
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
            
            if(SFrameZero.isSelected()){
                ChamadoRoleta.setFrameZeroAt(true);
            }
            ChamadoRoleta.setMaxPerda(Integer.parseInt(bxDerrotaCaixa.getSelectedItem().toString()));
            ChamadoRoleta.setMaxGanho(Integer.parseInt(bxVitoriaCaixa.getSelectedItem().toString()));
            
            String Local;
            Roleta NRoleta = RoletaEscolha;
            if(!"".equals(ApMinima.getText()) ){
            ChamadoRoleta.setApMin(Integer.parseInt(ApMinima.getText()));
            if (ChamadoRoleta.getApMin() >= NRoleta.getValorMinino()){
            if (I == 1) {
                Local = "Leitor1";
                TelaRoleta novo = new TelaRoleta(ChamadoRoleta, "ROLETA " + Integer.toString(I), Local, home, NRoleta);
                novo.setTitle(NRoleta.getNome());
                jpdHome.add(novo);
                novo.setVisible(true);
                this.dispose();
            }
            if (I == 2) {
                Local = "Leitor2";
                TelaRoleta novo = new TelaRoleta(ChamadoRoleta, "ROLETA " + Integer.toString(I), Local, home, NRoleta);
                novo.setTitle(NRoleta.getNome());
                jpdHome.add(novo);
                novo.setVisible(true);
                this.dispose();
            }
            if (I == 3) {
                Local = "Leitor3";
                TelaRoleta novo = new TelaRoleta(ChamadoRoleta, "ROLETA " + Integer.toString(I), Local, home, NRoleta);
                novo.setTitle(NRoleta.getNome());
                jpdHome.add(novo);
                novo.setVisible(true);
                this.dispose();
            }

            if (I == 4) {
                Local = "Leitor4";
                TelaRoleta novo = new TelaRoleta(ChamadoRoleta, "ROLETA " + Integer.toString(I), Local, home, NRoleta);
                novo.setTitle(NRoleta.getNome());
                jpdHome.add(novo);
                novo.setVisible(true);
                this.dispose();
            }

            if (I == 5) {
                Local = "Leitor5";
                TelaRoleta novo = new TelaRoleta(ChamadoRoleta, "ROLETA " + Integer.toString(I), Local, home, NRoleta);
                novo.setTitle(NRoleta.getNome());
                jpdHome.add(novo);
                novo.setVisible(true);
                this.dispose();
            }
            if (I > 5) {
                JOptionPane.showMessageDialog(null, "Maximo De Roletas Abertas");
                this.dispose();
            }
            } else {
                JOptionPane.showMessageDialog(null, "Valor Aposta Minima que o Minimo da Roleta");
            }
            } else {
                 JOptionPane.showMessageDialog(null, "Valor Base Vazio");
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
    private javax.swing.JTextField ApMinima;
    private javax.swing.JCheckBox SFrameZero;
    private javax.swing.JComboBox bxCasino;
    private javax.swing.JComboBox bxCol;
    private javax.swing.JComboBox bxDerrotaCaixa;
    private javax.swing.JComboBox bxDuz;
    private javax.swing.JComboBox bxMM;
    private javax.swing.JComboBox bxPI;
    private javax.swing.JComboBox bxRoleta;
    private javax.swing.JComboBox bxVP;
    private javax.swing.JComboBox bxVitoriaCaixa;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
