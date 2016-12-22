
package br.com.roleta.view;

import br.com.roleta.controlador.UsuarioControlador;
import br.com.roleta.modelo.usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class DeletarUsuario extends javax.swing.JInternalFrame {

    public DeletarUsuario() {
        initComponents();
        popularListas();
    }

    private void popularListas() {
        UsuarioControlador cc = new UsuarioControlador();
        List<String> listarUsuarios = new ArrayList<>();
        for (usuario listarUsuario : cc.listarUsuarios()){
            listarUsuarios.add(listarUsuario.getNome());
        }
        jComboBox1.setModel(new DefaultComboBoxModel(listarUsuarios.toArray()));
    }
    
    private void DeletarUsuario() {
        UsuarioControlador cc = new UsuarioControlador();
        String Usuario = jComboBox1.getSelectedItem().toString();
        if (!"".equals(Usuario)) {
        cc.DeletarUsuario(jComboBox1.getName());
        JOptionPane.showMessageDialog(null, "Deletado Com Sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na seleção do Usuario");
        }
        this.dispose();
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DeletarUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        setClosable(true);

        DeletarUsuario.setText("Deletar");
        DeletarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Deletar  Usuario");

        jLabel2.setText("Selecione o  Usuario:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(DeletarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(DeletarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeletarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarUsuarioActionPerformed
       DeletarUsuario();
    }//GEN-LAST:event_DeletarUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeletarUsuario;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
