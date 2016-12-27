package br.com.roleta.view;

import br.com.roleta.controlador.UsuarioControlador;
import br.com.roleta.modelo.Usuario;
import javax.swing.JOptionPane;


public class CadastroUsuario extends javax.swing.JInternalFrame {

    private Usuario NUsuario = new Usuario();
    private UsuarioControlador NUsuarioDao = new UsuarioControlador();

    public CadastroUsuario() {
        initComponents();
    }

    public void CadastroUsuario() {
        if (!"".equals(jTextNomeUsuario.getText())) {
            NUsuario.setNome(jTextNomeUsuario.getText());
            NUsuarioDao.inseirUsuario(NUsuario);
            JOptionPane.showMessageDialog(null, "Cadastrado Com Sucesso");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Caixa de Cadastro não pode Ser vaziu");
        }
        jTextNomeUsuario.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextNomeUsuario = new javax.swing.JTextField();
        SalvarUsuario = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Cadastro de Usuario");

        jLabel2.setText("Digite o nome do Usuario:");

        SalvarUsuario.setText("Salvar");
        SalvarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(jTextNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(SalvarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(SalvarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalvarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarUsuarioActionPerformed
        CadastroUsuario();
    }//GEN-LAST:event_SalvarUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SalvarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextNomeUsuario;
    // End of variables declaration//GEN-END:variables
}
