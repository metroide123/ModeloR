package Menu.Jogo;

import Inicio.Home;
import ThreadsMetodos.AlertaThead;
import ThreadsMetodos.ThreadLeituraTela;
import ThreadsMetodos.TransFrameCZero;
import ThreadsMetodos.TransparentFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Roleta extends javax.swing.JInternalFrame {

    TransparentFrame FrameTransparente;
    TransFrameCZero FrameZero;
    ThreadLeituraTela ThreadLeitura;
    AtualizaGrafico Atualizatela;
    AlertaThead Alerta = new AlertaThead();
    Home jpdHome;
    
    int larFrameZero = 0, AltFrameZero = 0, locFraZero1 = 0, locFraZero2 = 0,
            LarFrameTrans = 0, AltFrameTrans = 0, locFranTrans1 = 0, locFranTrans2 = 0, TamFont = 0;
    int cont = 0;
    float opFrameZero, opFrameTrans;
  
    boolean controlethead = true;

    public Roleta(int vp, int mm, int pp, int duz, int col, int escolha, String tipo, String L,Home jp) {
        escolha(escolha);
        jpdHome = jp;
        FrameTransparente = new TransparentFrame(LarFrameTrans, AltFrameTrans, locFranTrans1, locFranTrans2);
        FrameTransparente.setOpacity(opFrameTrans);
        FrameTransparente.setVisible(true);

        FrameZero = new TransFrameCZero(larFrameZero, AltFrameZero, locFraZero1, locFraZero2, TamFont);
        FrameZero.setOpacity(opFrameZero);
        FrameZero.setVisible(true);

        ThreadLeitura = new ThreadLeituraTela();
        ThreadLeitura.windowRefence = FrameTransparente;

        ThreadLeitura.getEstra().ColunasMax = col;
        ThreadLeitura.getEstra().DuziaMax = duz;
        ThreadLeitura.getEstra().MaiorMenorMax = mm;
        ThreadLeitura.getEstra().ParInparMax = pp;
        ThreadLeitura.getEstra().PreVerMax = vp;
        ThreadLeitura.Local = L;
        ThreadLeitura.nomeRoleta = tipo;
        ThreadLeitura.start();
        ThreadLeitura.suspend();
        Atualizatela = new AtualizaGrafico();
        Atualizatela.start();
        

        initComponents();
        PlayTrad.setText("PLAY");

        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
        jTextField5.setEditable(false);

    }

    public Roleta() {
        initComponents();
    }

    public void escolha(int i) {
        switch (i) {
            case 1: { //spotingbet tamanho 1
                // Frame com o Zero
                larFrameZero = 10;
                AltFrameZero = 30;
                locFraZero1 = 1193;
                locFraZero2 = 401;
                opFrameZero = 0.6f;
                TamFont = 18;
                // Frame da Captura
                LarFrameTrans = 45;
                AltFrameTrans = 30;
                locFranTrans1 = 1187;
                locFranTrans2 = 401;
                opFrameTrans = 0.55f;
                break;
            }
        }
    }

    public void Grafico() {

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

        data.addValue(ThreadLeitura.getEstra().D32, produto1, dia9);
        data.addValue(ThreadLeitura.getEstra().D12, produto1, dia1);
        data.addValue(ThreadLeitura.getEstra().C23, produto1, dia10);
        data.addValue(ThreadLeitura.getEstra().C12, produto1, dia2);
        data.addValue(ThreadLeitura.getEstra().P, produto1, dia6);
        data.addValue(ThreadLeitura.getEstra().V, produto1, dia5);
        data.addValue(ThreadLeitura.getEstra().Inpar, produto1, dia4);
        data.addValue(ThreadLeitura.getEstra().Par, produto1, dia3);
        data.addValue(ThreadLeitura.getEstra().Maior, produto1, dia8);
        data.addValue(ThreadLeitura.getEstra().Menor, produto1, dia7);

        data.addValue(10, "", dia1);

        if (ThreadLeitura.getEstra().MaiorCont9()) {
            Titulo = "ATENÇÃO";
        }
        if (ThreadLeitura.getEstra().Maax()) {
            Titulo = "APOSTE";
        } else {
            Titulo = "";
        }

        chart = ChartFactory.createBarChart(Titulo,
                "",
                "",
                data,
                PlotOrientation.VERTICAL,
                false,
                true,
                false);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        // Cor das Barras
        chart.getCategoryPlot().getRenderer(0).setSeriesPaint(0, Color.BLUE);

        if (ThreadLeitura.getEstra().MaiorCont9()) {
            chart.getCategoryPlot().getRenderer(0).setSeriesPaint(0, Color.ORANGE);
            chart.getTitle().setPaint(Color.ORANGE);
        }

        if (ThreadLeitura.getEstra().Maax()) {

            chart.getCategoryPlot().getRenderer(0).setSeriesPaint(0, Color.RED);
            chart.getTitle().setPaint(Color.RED);
            cont++;

        } else {
            cont = 0;

        }

        chart.getCategoryPlot().getRenderer(0).setSeriesPaint(1, Color.WHITE);
        plot.setDomainGridlinesVisible(true);
        plot.setBackgroundPaint(Color.WHITE);
        panel = new ChartPanel(chart);

        panel.setBounds(1, 20, 490, 335);

        Barras.removeAll();
        Barras.add(panel, BorderLayout.CENTER);
        Barras.setBackground(Color.WHITE);
        Barras.repaint();

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

        jTextField10 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        Barras = new javax.swing.JPanel();
        AddNum = new javax.swing.JButton();
        PlayTrad = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Sair = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        PlayTrad1 = new javax.swing.JButton();

        jLabel1.setText("Add Número:");

        setBackground(new java.awt.Color(255, 255, 255));
        setIconifiable(true);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout BarrasLayout = new javax.swing.GroupLayout(Barras);
        Barras.setLayout(BarrasLayout);
        BarrasLayout.setHorizontalGroup(
            BarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );
        BarrasLayout.setVerticalGroup(
            BarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Barras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Barras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPane1.setLayer(Barras, javax.swing.JLayeredPane.DEFAULT_LAYER);

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

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("10");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("10");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("10");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("10");

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setText("10");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("10");

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("10");

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("10");

        jLabel2.setText("Add Número:");

        Sair.setText("SAIR");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("36");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        PlayTrad1.setText("Salvar Dados BD");
        PlayTrad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayTrad1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Sair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField6))
                            .addComponent(AddNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PlayTrad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PlayTrad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
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
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddNum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlayTrad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PlayTrad1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlayTradActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayTradActionPerformed

        if (controlethead) {
            ThreadLeitura.resume();
            PlayTrad.setText("PAUSE");
            controlethead = false;
        } else {
            ThreadLeitura.suspend();
            PlayTrad.setText("PLAY");
            controlethead = true;
        }
    }//GEN-LAST:event_PlayTradActionPerformed

    private void AddNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNumActionPerformed

        int i;
        i = Integer.parseInt(jTextField6.getText());
        if (i >= 0 && i <= 36) {
            ThreadLeitura.getEstra().ConverterInt(jTextField6.getText());
        } else {

        }
    }//GEN-LAST:event_AddNumActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed

        FrameZero.dispose();
        FrameTransparente.dispose();
        ThreadLeitura.stop();
        Atualizatela.stop();
        jpdHome.setI(jpdHome.getI()-1);
        this.dispose();

    }//GEN-LAST:event_SairActionPerformed

    private void PlayTrad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayTrad1ActionPerformed

    }//GEN-LAST:event_PlayTrad1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNum;
    private javax.swing.JPanel Barras;
    private javax.swing.JButton PlayTrad;
    private javax.swing.JButton PlayTrad1;
    private javax.swing.JButton Sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
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

}