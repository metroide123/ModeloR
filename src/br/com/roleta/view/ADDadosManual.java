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

    RoletaControlador RoletaControl = new RoletaControlador();
    CasinoControlador CasinoControl = new CasinoControlador();
    NumeroControlador ControleNumero = new NumeroControlador();
    Casino CasinoEscolha ;
    Roleta RoletaEscolha ;

    Date date = new Date();
    DateFormat formato = new SimpleDateFormat("dd/MM/yyyy - hh:mm");
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

        String a = jTextArea1.getText();
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
        jTextArea1 = new javax.swing.JTextArea();
        Limpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        GerarNumeros = new javax.swing.JButton();
        bxCasino = new javax.swing.JComboBox();
        bxRoletas = new javax.swing.JComboBox();

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
                                .addComponent(Limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                                .addComponent(GerarNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(Limpar, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(GerarNumeros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        setBounds(150, 30, 499, 359);
    }// </editor-fold>//GEN-END:initComponents

    private void LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparActionPerformed
        jTextArea1.setText("");
    }//GEN-LAST:event_LimparActionPerformed

    private void GerarNumerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerarNumerosActionPerformed
        if (!"".equals(jTextArea1.getText())) {
            if (!"<Selecione Casino>".equals(bxCasino.getSelectedItem().toString()) && !"<Selecione Roleta>".equals(bxRoletas.getSelectedItem().toString())) {
                GerarLista(CasinoEscolha.getIdCasino(), RoletaEscolha.getIdRoleta());
                JtabelaNumColetados1 novo = new JtabelaNumColetados1(ListadeNumeros);
                jpdHome.add(novo);
                novo.setVisible(true);
                //this.dispose(); 
            } else {
                JOptionPane.showMessageDialog(null, "Casino ou Roleta não Selecionados");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Digite Numeros Separados por Vírgula para Add ao Banco");
        }
    }//GEN-LAST:event_GerarNumerosActionPerformed

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
            bxRoletas.setModel(new DefaultComboBoxModel(lisR.toArray()));
        }
    }//GEN-LAST:event_bxCasinoItemStateChanged

    private void bxRoletasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bxRoletasItemStateChanged
        if (!"<Selecione Roleta>".equals(bxRoletas.getSelectedItem().toString())) {
            RoletaEscolha = RoletaControl.procurarCasino(bxRoletas.getSelectedItem().toString());
        }
    }//GEN-LAST:event_bxRoletasItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GerarNumeros;
    private javax.swing.JButton Limpar;
    private javax.swing.JComboBox bxCasino;
    private javax.swing.JComboBox bxRoletas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
