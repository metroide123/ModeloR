package br.com.roleta.view;

import br.com.roleta.controlador.ThreadLeituraTela;
import br.com.roleta.controlador.TransFrameCZero;
import br.com.roleta.controlador.TransparentFrame;
import br.com.roleta.modelo.Roleta;

public class TesteFrame extends javax.swing.JInternalFrame {

    TransparentFrame FrameTransparente;
    TransFrameCZero FrameZero;
    ThreadLeituraTela ThreadLeitura;
    //AtualizaGrafico Atualizatela;
    boolean t = false;

    // PARADO NO MOMENTO ESTAVA TENDO CONFLITO NAS THREADS 
    
    public TesteFrame(Roleta n, boolean TFrameZero) {

        FrameTransparente = new TransparentFrame(n.getFrameLargura(), n.getFrameAltura(), 1187, 401);
        FrameTransparente.setOpacity(0.55f);
        FrameTransparente.setVisible(true);

        ThreadLeitura = new ThreadLeituraTela();
        ThreadLeitura.windowRefence = FrameTransparente;

        ThreadLeitura.Local = "Leitor1";
        ThreadLeitura.nomeRoleta = "Leitura Teste";
        ThreadLeitura.start();
       // Atualizatela = new AtualizaGrafico();

        StartTrade();

        initComponents();
    }

    void StartTrade() {
        
        //Atualizatela.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (t) {
            FrameZero.dispose();
        }
        FrameTransparente.dispose();
        ThreadLeitura.stop();
       // Atualizatela.stop();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

   /* public class AtualizaGrafico extends Thread {

        @Override
        public void run() {

            try {
                while (true) {
                    jTextField1.setText(Integer.toString(ThreadLeitura.);

                    AtualizaGrafico.sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    } */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
