
package br.com.roleta.view;

import br.com.roleta.controlador.CasinoControlador;
import br.com.roleta.controlador.RoletaControlador;
import br.com.roleta.modelo.Casino;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import br.com.roleta.modelo.Roleta;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodolfo Fonseca
 */
public class CadastroRoleta extends javax.swing.JInternalFrame {

    JDesktopPane jpdHome;

    
    public CadastroRoleta(JDesktopPane jp) {
        jpdHome = jp;
        initComponents();
        popularCasinos();
    }
    
    private void popularCasinos() {
        CasinoControlador cc = new CasinoControlador();
        List<String> listarCasinos =  new ArrayList<>();
        for (Casino listarCasino : cc.listarCasinos()) {
            listarCasinos.add(listarCasino.getNome());
        }
        cbxCasino.setModel(new DefaultComboBoxModel(listarCasinos.toArray()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txfNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txfValor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxCasino = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txfLargura = new javax.swing.JTextField();
        txfAltura = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txfLarguraZero = new javax.swing.JTextField();
        txfAlturaZero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txfontZero = new javax.swing.JTextField();
        TesteCaptura = new javax.swing.JButton();
        TexteZero = new javax.swing.JCheckBox();

        setClosable(true);

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Cadastrar Roleta");

        jLabel2.setText("Nome da roleta:");

        jLabel3.setText("Casino:");

        txfValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfValorActionPerformed(evt);
            }
        });

        jLabel4.setText("Valor Minimo:");

        cbxCasino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Tamanho do Frame: ");

        jLabel6.setText("H");

        jLabel7.setText("V");

        jLabel8.setText("Tam. FrameZero: ");

        jLabel9.setText("H");

        jLabel10.setText("V");

        jLabel11.setText("Font:");

        TesteCaptura.setText("Teste Captura");
        TesteCaptura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TesteCapturaActionPerformed(evt);
            }
        });

        TexteZero.setText("Teste Com FrameZero");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfLarguraZero, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfAlturaZero, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TexteZero)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txfontZero, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))
                            .addComponent(TesteCaptura, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfValor)
                            .addComponent(txfNome)
                            .addComponent(cbxCasino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfLargura, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxCasino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txfLargura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txfLarguraZero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfAlturaZero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txfontZero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TexteZero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TesteCaptura, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfValorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if(!"".equals(txfNome.getText()) && !"".equals(txfValor.getText()) && !"".equals(txfAltura.getText()) && !"".equals(txfAlturaZero.getText()) && !"".equals(txfNome.getText()) && !"".equals(txfLarguraZero.getText()) && !"".equals(txfontZero.getText())) {
       CasinoControlador cc = new CasinoControlador();
        RoletaControlador rc = new RoletaControlador();
        Roleta r = new Roleta();
        r.setNome(txfNome.getText());
        r.setValorMinino(Integer.valueOf(txfValor.getText()));
        r.setFrameAltura(Integer.valueOf(txfAltura.getText()));
        r.setFrameLargura(Integer.valueOf(txfLargura.getText()));
        r.setIdCassino(cc.procurarCasino(cbxCasino.getSelectedItem().toString()).getIdCasino());
        r.setFrameZeroAltura(Integer.valueOf(txfAlturaZero.getText()));
        r.setFrameZeroLargura(Integer.valueOf(txfLarguraZero.getText()));
        r.setFrameZerofonte(Integer.parseInt(txfontZero.getText()));
        rc.inseirRoleta(r);
        JOptionPane.showMessageDialog(null, "Cadastrado Roleta Com Sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Todos os Campos devem Estar Preenchidos Coretamente!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TesteCapturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TesteCapturaActionPerformed
        if(!"".equals(txfNome.getText()) && !"".equals(txfValor.getText()) && !"".equals(txfAltura.getText()) && !"".equals(txfAlturaZero.getText()) && !"".equals(txfNome.getText()) && !"".equals(txfLarguraZero.getText()) && !"".equals(txfontZero.getText())) {
        boolean framezero = false;
        Roleta r = new Roleta();
        r.setFrameAltura(Integer.valueOf(txfAltura.getText()));
        r.setFrameLargura(Integer.valueOf(txfLargura.getText()));
        r.setFrameZeroAltura(Integer.valueOf(txfAlturaZero.getText()));
        r.setFrameZeroLargura(Integer.valueOf(txfLarguraZero.getText()));
        r.setFrameZerofonte(Integer.parseInt(txfontZero.getText()));
        if(TexteZero.isSelected()){
            framezero = true;
        }
        
        TesteFrame novo = new TesteFrame(r, framezero);
        jpdHome.add(novo);
        novo.setVisible(true);
        
        } else {
            JOptionPane.showMessageDialog(null, "Campo Vazio, Todos os campos devem estar preenchidos para o teste");
        }
        
    }//GEN-LAST:event_TesteCapturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TesteCaptura;
    private javax.swing.JCheckBox TexteZero;
    private javax.swing.JComboBox cbxCasino;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txfAltura;
    private javax.swing.JTextField txfAlturaZero;
    private javax.swing.JTextField txfLargura;
    private javax.swing.JTextField txfLarguraZero;
    private javax.swing.JTextField txfNome;
    private javax.swing.JTextField txfValor;
    private javax.swing.JTextField txfontZero;
    // End of variables declaration//GEN-END:variables
}
