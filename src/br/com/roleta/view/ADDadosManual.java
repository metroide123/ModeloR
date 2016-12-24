package br.com.roleta.view;

import br.com.roleta.controlador.CasinoControlador;
import br.com.roleta.controlador.NumeroControlador;
import br.com.roleta.controlador.RoletaControlador;
import br.com.roleta.modelo.Casino;
import br.com.roleta.modelo.Roleta;
import br.com.roleta.modelo.numerosorteado;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodolfo Fonseca
 */
public class ADDadosManual extends javax.swing.JInternalFrame {

    private final RoletaControlador RoletaControl = new RoletaControlador();
    private final CasinoControlador CasinoControl = new CasinoControlador();
    private Casino CasinoEscolha;
    private Roleta RoletaEscolha;

    JDesktopPane jpdHome;
    ArrayList<numerosorteado> ListadeNumeros = new ArrayList<>();

    public ADDadosManual(JDesktopPane jp) {
        jpdHome = jp;
        initComponents();
        txaNumeros.setLineWrap(true);
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

    public void GerarLista(int IdC, int IdR) {

        int IdUsuario = IdC;
        int IdCasino = 0; // Criar no Banco
        int IdRoleta = IdR;
        Date date = new Date();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy - hh:mm");
        String a = txaNumeros.getText();
        String[] parts = a.split(",");

        for (String i : parts) {
            int n;
            n = Integer.parseInt(i);

            if (n != 99) {
                if (n >= 0 && n <= 36) {
                    numerosorteado NovoNumero = new numerosorteado();
                    NovoNumero.setNumero(i);
                    String formattedDate = formato.format(date);
                    NovoNumero.setDataHora(formattedDate);
                    NovoNumero.setIdRoleta(IdRoleta);
                    NovoNumero.setIdUsuario(IdUsuario);
                    ListadeNumeros.add(NovoNumero);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txaNumeros = new javax.swing.JTextArea();
        btnLimpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnGerarNumeros = new javax.swing.JButton();
        bxCasino = new javax.swing.JComboBox();
        bxRoletas = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);

        txaNumeros.setColumns(20);
        txaNumeros.setRows(5);
        jScrollPane1.setViewportView(txaNumeros);

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Digite os Numeros abaixo separados por virgula.");

        btnGerarNumeros.setText("Gerar Numeros");
        btnGerarNumeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarNumerosActionPerformed(evt);
            }
        });

        bxCasino.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bxCasinoItemStateChanged(evt);
            }
        });

        bxRoletas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bxRoletasItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bxCasino, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bxRoletas, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                                .addComponent(btnGerarNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(21, 21, 21))
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
                    .addComponent(bxCasino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bxRoletas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnGerarNumeros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(150, 30, 499, 359);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txaNumeros.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnGerarNumerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarNumerosActionPerformed
        if (!"".equals(txaNumeros.getText())) {
            if (!"<Selecione Casino>".equals(bxCasino.getSelectedItem().toString()) && !"<Selecione Roleta>".equals(bxRoletas.getSelectedItem().toString())) {
                GerarLista(CasinoEscolha.getIdCasino(), RoletaEscolha.getIdRoleta());
                NumerosColetados novo = new NumerosColetados(ListadeNumeros);
                jpdHome.add(novo);
                novo.setVisible(true);
                //this.dispose(); 
            } else {
                JOptionPane.showMessageDialog(null, "Casino ou Roleta não Selecionados");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Digite Numeros Separados por Vírgula para Add ao Banco");
        }
    }//GEN-LAST:event_btnGerarNumerosActionPerformed

    private void bxCasinoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bxCasinoItemStateChanged
        if (!"<Selecione Casino>".equals(bxCasino.getSelectedItem().toString())) {
            CasinoEscolha = CasinoControl.procurarCasino(bxCasino.getSelectedItem().toString());
            List<Roleta> lista;
            List<String> lisR = new ArrayList<>();
            lisR.add("<Selecione Roleta>");
            lista = RoletaControl.procurarRoletas(CasinoEscolha.getIdCasino());
            for (Roleta listarroleta : lista) {
                lisR.add(listarroleta.getNome());
            }
            bxRoletas.setModel(new DefaultComboBoxModel(lisR.toArray()));
        }
    }//GEN-LAST:event_bxCasinoItemStateChanged

    private void bxRoletasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bxRoletasItemStateChanged
        if (!"<Selecione Roleta>".equals(bxRoletas.getSelectedItem().toString())) {
            RoletaEscolha = RoletaControl.procurarCasino(bxRoletas.getSelectedItem().toString());
        }
    }//GEN-LAST:event_bxRoletasItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarNumeros;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox bxCasino;
    private javax.swing.JComboBox bxRoletas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaNumeros;
    // End of variables declaration//GEN-END:variables
}
