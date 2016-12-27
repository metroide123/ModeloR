package br.com.roleta.view;

import br.com.roleta.modelo.Usuario;
import java.awt.Dimension;

public class Home extends javax.swing.JFrame {

    int I = 0;
    Usuario usuario;

    public int getI() {
        return I;
    }

    public void setI(int I) {
        this.I = I;
    }

    public Home() {
        initComponents();
       
        //usuario = login.getUsuario();
        adjustInternalFrameLocation();
    }

    private void adjustInternalFrameLocation() {
        UsuarioDados usuarioDados = new UsuarioDados();
        jdpHome.add(usuarioDados);
    //    usuarioDados.setNome(usuario.getNome());
        
        Dimension desktopDim = this.getSize();

        int x = (desktopDim.width - 20 - usuarioDados.getWidth());
     //   int y = (desktopDim.height - usuarioDados.getHeight());

        usuarioDados.setLocation(x, 5);
        usuarioDados.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpHome = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        NovoCassino = new javax.swing.JMenuItem();
        DeletarCassino = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        NovaRoleta = new javax.swing.JMenuItem();
        DeletarRoleta = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        NovoUsuario = new javax.swing.JMenuItem();
        DeletarUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jdpHomeLayout = new javax.swing.GroupLayout(jdpHome);
        jdpHome.setLayout(jdpHomeLayout);
        jdpHomeLayout.setHorizontalGroup(
            jdpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        jdpHomeLayout.setVerticalGroup(
            jdpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        getContentPane().add(jdpHome, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Analise");

        jMenuItem2.setText("Adcionar Dados Manual");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Exibir Grafico de Dados");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Jogo Roleta");

        jMenuItem1.setText("Nova Roleta");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Configurações");

        jMenu4.setText("Banco de Dados");
        jMenu5.add(jMenu4);

        jMenuItem5.setText("Editar dados Usuario");
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        jMenu9.setText("Cadastro");

        jMenu7.setText("Casino");

        NovoCassino.setText("Novo");
        NovoCassino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoCassinoActionPerformed(evt);
            }
        });
        jMenu7.add(NovoCassino);

        DeletarCassino.setText("Deletar");
        DeletarCassino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarCassinoActionPerformed(evt);
            }
        });
        jMenu7.add(DeletarCassino);

        jMenu9.add(jMenu7);

        jMenu6.setText("Roleta");

        NovaRoleta.setText("Novo");
        NovaRoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovaRoletaActionPerformed(evt);
            }
        });
        jMenu6.add(NovaRoleta);

        DeletarRoleta.setText("Deletar");
        DeletarRoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarRoletaActionPerformed(evt);
            }
        });
        jMenu6.add(DeletarRoleta);

        jMenu9.add(jMenu6);

        jMenu8.setText("Usuário");

        NovoUsuario.setText("Novo");
        NovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoUsuarioActionPerformed(evt);
            }
        });
        jMenu8.add(NovoUsuario);

        DeletarUsuario.setText("Deletar");
        DeletarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarUsuarioActionPerformed(evt);
            }
        });
        jMenu8.add(DeletarUsuario);

        jMenu9.add(jMenu8);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 804, 562);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        I++;
        ChamadaRoleta r1 = new ChamadaRoleta(jdpHome, I, this);
        jdpHome.add(r1);
        r1.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ADDadosManual r1 = new ADDadosManual(jdpHome);
        r1.setTitle("Adição de Numeros Manual");
        jdpHome.add(r1);
        r1.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        GraficoAnalise r1 = new GraficoAnalise();
        r1.setTitle("Grafico Analise");
        jdpHome.add(r1);
        r1.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void DeletarCassinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarCassinoActionPerformed
        DeletarCassino Cassino = new DeletarCassino();
        jdpHome.add(Cassino);
        Cassino.setVisible(true);
    }//GEN-LAST:event_DeletarCassinoActionPerformed

    private void NovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoUsuarioActionPerformed
        CadastroUsuario Usuario = new CadastroUsuario();
        jdpHome.add(Usuario);
        Usuario.setVisible(true);
    }//GEN-LAST:event_NovoUsuarioActionPerformed

    private void NovoCassinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoCassinoActionPerformed
        CadastroCassino Cassino = new CadastroCassino();
        jdpHome.add(Cassino);
        Cassino.setVisible(true);

    }//GEN-LAST:event_NovoCassinoActionPerformed

    private void NovaRoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovaRoletaActionPerformed
        CadastroRoleta Roleta = new CadastroRoleta(jdpHome);
        jdpHome.add(Roleta);
        Roleta.setVisible(true);
    }//GEN-LAST:event_NovaRoletaActionPerformed

    private void DeletarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarUsuarioActionPerformed
        DeletarUsuario Usuario = new DeletarUsuario();
        jdpHome.add(Usuario);
        Usuario.setVisible(true);
    }//GEN-LAST:event_DeletarUsuarioActionPerformed

    private void DeletarRoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarRoletaActionPerformed
        DeletarRoleta Roleta = new DeletarRoleta();
        jdpHome.add(Roleta);
        Roleta.setVisible(true);
    }//GEN-LAST:event_DeletarRoletaActionPerformed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_formPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem DeletarCassino;
    private javax.swing.JMenuItem DeletarRoleta;
    private javax.swing.JMenuItem DeletarUsuario;
    private javax.swing.JMenuItem NovaRoleta;
    private javax.swing.JMenuItem NovoCassino;
    private javax.swing.JMenuItem NovoUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JDesktopPane jdpHome;
    // End of variables declaration//GEN-END:variables

    void setUsuario(Usuario usuario) {
       this.usuario = usuario;
    }
}
