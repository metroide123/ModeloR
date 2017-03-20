package br.com.roleta.view;

import br.com.roleta.controlador.AlertaThead;
import br.com.roleta.controlador.CasinoControlador;
import br.com.roleta.controlador.DadosChamadaRoleta;
import br.com.roleta.controlador.ThreadLeituraTela;
import br.com.roleta.controlador.TransFrameCZero;
import br.com.roleta.controlador.TransparentFrame;
import br.com.roleta.modelo.Casino;
import br.com.roleta.modelo.Roleta;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class RoletaTela extends javax.swing.JFrame {

    TransparentFrame FrameTransparente;
    TransFrameCZero FrameZero;
    ThreadLeituraTela ThreadLeitura;
    AtualizaGrafico Atualizatela;
    Temporizador TimeSessao;
    AlertaThead Alerta = new AlertaThead();
    Home jpdHome;
    public Casino CasinoEsc = new Casino();
    public CasinoControlador cc = new CasinoControlador();

    int apMin;
    boolean controlethead = true, FrameZeroTeste = false, EntradaAp = false;

    public RoletaTela(DadosChamadaRoleta n, String tipo, String L, Home jp, Roleta r) {
        jpdHome = jp;
        FrameTransparente = new TransparentFrame(r.getFrameLargura(), r.getFrameAltura(), 1187, 401);
        FrameTransparente.setOpacity(0.55f);
        FrameTransparente.setVisible(true);

        CasinoEsc = cc.procurarCasinoId(r.getIdCassino());
        apMin = n.getApMin();

        ThreadLeitura = new ThreadLeituraTela();
        ThreadLeitura.windowRefence = FrameTransparente;

        ThreadLeitura.getEstra().ColunasMax = n.getCol();
        ThreadLeitura.getEstra().DuziaMax = n.getDuz();
        ThreadLeitura.getEstra().MaiorMenorMax = n.getMM();
        ThreadLeitura.getEstra().ParInparMax = n.getPI();
        ThreadLeitura.getEstra().PreVerMax = n.getVP();
        ThreadLeitura.Local = L;
        ThreadLeitura.nomeRoleta = tipo;

        Atualizatela = new AtualizaGrafico();
        TimeSessao = new Temporizador();

        AtThread();
        initComponents();
        PlayTrad.setText("PLAY");
        ApAtual.setText(Integer.toString(apMin));
        ApAtual.setEditable(false);
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
        jTextField5.setEditable(false);
        jTextField12.setEditable(false);
        jTextField7.setEditable(false);
        jTextField8.setEditable(false);
        jTextField9.setEditable(false);
        jTextArea1.setLineWrap(true);
        TimeSessao.start();

        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
    }

    public RoletaTela() {
        initComponents();
    }

    public void AtThread() {
        ThreadLeitura.start();
        ThreadLeitura.suspend();
        Atualizatela.start();
        Atualizatela.suspend();

    }

    public void Grafico() {
        // mexer depois pois da erro com a outra tread caso apague o codigo
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        ChartPanel panel;
        JFreeChart chart = null;
        String Titulo = "";

        String produto1 = "D12";

        String dia1 = "D32";
        String dia9 = "D12";
        String dia2 = "C32";
        String dia10 = "C12";
        String dia3 = "Imp";
        String dia4 = "Par";
        String dia5 = "Pre";
        String dia6 = "Ver";
        String dia7 = "M19";
        String dia8 = "M18";

        String R = ThreadLeitura.getEstra().Verificar();
        jTextArea1.setText(R);

    }

    public void VerificaGanhoPerda() {
        // Ver Quem é a Entrada, Fazer a Entrada, Ver o Resultado e Zerar ou Dograr Caso Ganhe ou Perca
        if (ThreadLeitura.getEstra().getRetonoAposta() == 1) {

        } else {
            JOptionPane.showMessageDialog(null, "Não Existe Entrada No Momento");
        }
    }

    public void MudaCorJtsfile(JTextField dt, int pri1) {
        if (pri1 == 1) {
            dt.setForeground(Color.blue);
            dt.setBackground(Color.red);
        } else if (pri1 == 2) {
            dt.setForeground(Color.WHITE);
            dt.setBackground(Color.GREEN);
        } else if (pri1 == 3) {
            dt.setForeground(Color.WHITE);
            dt.setBackground(Color.RED);
        } else {
            dt.setForeground(Color.WHITE);
            dt.setBackground(Color.BLACK);
        }
    }

    public int SetarCor(int n) {
        if (n == 99) {
            return 1;
        } else if (n == 0) {
            return 2;
        } else if (n == 1 || n == 3 || n == 5 || n == 7 || n == 9 || n == 12 || n == 14 || n == 16 || n == 18 || n == 19 || n == 21
                || n == 23 || n == 25 || n == 27 || n == 30 || n == 32 || n == 34 || n == 36) {
            return 3;
        } else {
            return 4;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        ApAtual = new javax.swing.JTextField();
        ZerarBotao = new javax.swing.JButton();
        InformarEntrada = new javax.swing.JButton();
        jTextField12 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        txfAdicionarNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Sair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        AddNum = new javax.swing.JButton();
        PlayTrad = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TempoSessao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("00,00");

        ApAtual.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        ZerarBotao.setText("Zerar/ Daeller");
        ZerarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZerarBotaoActionPerformed(evt);
            }
        });

        InformarEntrada.setText("Entrar");

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setText("0");

        jLabel10.setText("Valor Aposta Atual: ");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("0");

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("0");

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("0");

        jLabel2.setText("Add Número:");

        Sair.setText("SAIR");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("");
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setText("Saldo Casino:");

        AddNum.setText("ADD Num");
        AddNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNumActionPerformed(evt);
            }
        });

        PlayTrad.setText("PLAY");
        PlayTrad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayTradActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("0");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("0");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("0");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("0");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("0");

        jLabel5.setText("Tempo Restante Sessão:");

        TempoSessao.setBackground(new java.awt.Color(255, 255, 255));
        TempoSessao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TempoSessao.setText("20:00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TempoSessao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ZerarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(InformarEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ApAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txfAdicionarNumero))
                                    .addComponent(AddNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(PlayTrad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(TempoSessao)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txfAdicionarNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddNum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ApAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGap(12, 12, 12)
                .addComponent(PlayTrad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InformarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ZerarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ZerarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZerarBotaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ZerarBotaoActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed

        FrameTransparente.dispose();

        ThreadLeitura.stop();
        Atualizatela.stop();
        TimeSessao.stop();
        jpdHome.setI(jpdHome.getI() - 1);
        
        this.dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void AddNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNumActionPerformed

        int i;
        if (txfAdicionarNumero.getText() != "") {
            i = Integer.parseInt(txfAdicionarNumero.getText());

            if (i >= 0 && i <= 36) {
                ThreadLeitura.getEstra().ConverterInt(Integer.parseInt(txfAdicionarNumero.getText()));
            } else {

            }
        }
    }//GEN-LAST:event_AddNumActionPerformed

    private void PlayTradActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayTradActionPerformed

        if (controlethead) {
            ThreadLeitura.resume();
            PlayTrad.setText("PAUSE");
            controlethead = false;
            Atualizatela.resume();
        } else {

            ThreadLeitura.suspend();
            Atualizatela.suspend();

            PlayTrad.setText("PLAY");
            controlethead = true;
        }
    }//GEN-LAST:event_PlayTradActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RoletaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoletaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoletaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoletaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoletaTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNum;
    private javax.swing.JTextField ApAtual;
    private javax.swing.JButton InformarEntrada;
    private javax.swing.JButton PlayTrad;
    private javax.swing.JButton Sair;
    public javax.swing.JLabel TempoSessao;
    private javax.swing.JButton ZerarBotao;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField txfAdicionarNumero;
    // End of variables declaration//GEN-END:variables

    public class AtualizaGrafico extends Thread {

        int pri1 = 0;

        @Override
        public void run() {

            try {
                while (true) {
                    Grafico();
                    pri1 = SetarCor(ThreadLeitura.getEstra().ConvertInt);
                    jTextField1.setText(Integer.toString(ThreadLeitura.getEstra().ConvertInt));
                    MudaCorJtsfile(jTextField1, pri1);

                    pri1 = SetarCor(ThreadLeitura.getEstra().A1);
                    jTextField2.setText(Integer.toString(ThreadLeitura.getEstra().A1));
                    MudaCorJtsfile(jTextField2, pri1);

                    pri1 = SetarCor(ThreadLeitura.getEstra().A2);
                    jTextField3.setText(Integer.toString(ThreadLeitura.getEstra().A2));
                    MudaCorJtsfile(jTextField3, pri1);

                    pri1 = SetarCor(ThreadLeitura.getEstra().A3);
                    jTextField4.setText(Integer.toString(ThreadLeitura.getEstra().A3));
                    MudaCorJtsfile(jTextField4, pri1);

                    pri1 = SetarCor(ThreadLeitura.getEstra().A4);
                    jTextField5.setText(Integer.toString(ThreadLeitura.getEstra().A4));
                    MudaCorJtsfile(jTextField5, pri1);

                    pri1 = SetarCor(ThreadLeitura.getEstra().A5);
                    jTextField12.setText(Integer.toString(ThreadLeitura.getEstra().A5));
                    MudaCorJtsfile(jTextField12, pri1);

                    pri1 = SetarCor(ThreadLeitura.getEstra().A6);
                    jTextField7.setText(Integer.toString(ThreadLeitura.getEstra().A6));
                    MudaCorJtsfile(jTextField7, pri1);

                    pri1 = SetarCor(ThreadLeitura.getEstra().A7);
                    jTextField8.setText(Integer.toString(ThreadLeitura.getEstra().A7));
                    MudaCorJtsfile(jTextField8, pri1);

                    pri1 = SetarCor(ThreadLeitura.getEstra().A8);
                    jTextField9.setText(Integer.toString(ThreadLeitura.getEstra().A8));
                    MudaCorJtsfile(jTextField9, pri1);

                    AtualizaGrafico.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public class Temporizador extends Thread {

        int Minutos = CasinoEsc.getTempoSessao();
        int Segundos = 00;

        @Override
        public void run() {

            try {
                while (true) {

                    if (Segundos == 0) {
                        if (Minutos > 0) {
                            Segundos = 59;
                            Minutos--;
                        }
                    } else {
                        Segundos--;
                    }

                    TempoSessao.setText(Integer.toString(Minutos) + ":" + Integer.toString(Segundos));

                    if (Segundos == 00 && Minutos == 00) {
                        JOptionPane.showMessageDialog(null, "Tempo de Sessão Acabou");
                        TimeSessao.suspend();
                    }

                    this.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
