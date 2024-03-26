package component;

import java.util.List;
import javaswingdev.GradientDropdownMenu;
import model.DAO.UsuarioDAO;
import model.bean.UsuarioDTO;
import raven.toast.Notifications;
import telas.TelaPrincipal;

public class FormEntrar extends javax.swing.JPanel {

    private TelaPrincipal telaPrincipal;

    public FormEntrar(TelaPrincipal telaPrincipal) {
        initComponents();
        this.telaPrincipal = telaPrincipal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnInscrever = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        fechado = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        aberto = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jPanel3.setBorder(dropShadowBorder1);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInscrever.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnInscrever.setText("Inscrever-se");
        btnInscrever.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInscrever.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInscreverMouseClicked(evt);
            }
        });
        jPanel3.add(btnInscrever, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 570, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel6.setText("Não tem uma conta?");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, -1, -1));

        btnEntrar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnEntrar.setText("ENTRAR");
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, -1, -1));

        txtSenha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel3.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 260, -1));

        fechado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_invisible_25px_1.png"))); // NOI18N
        fechado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fechado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechadoMouseClicked(evt);
            }
        });
        jPanel3.add(fechado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, -1, -1));

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel3.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 260, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_user_25px.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/IAGON-Photoroom.png-Photoroom.png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel2.setText("Senha");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel1.setText("Usuário");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        aberto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_eye_25px_3.png"))); // NOI18N
        aberto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aberto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abertoMouseClicked(evt);
            }
        });
        jPanel3.add(aberto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(423, 423, 423)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(619, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 69, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInscreverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInscreverMouseClicked
        if (telaPrincipal != null) {
            telaPrincipal.showForm(new FormCadastroUser());
        }
    }//GEN-LAST:event_btnInscreverMouseClicked

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        String usuario = txtUser.getText();
        String senha = txtSenha.getText();
        if (txtUser.getText().trim().equals("") || txtSenha.getText().trim().equals("")) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Preencha Usúario e Senha!");
            return;
        }
        UsuarioDAO objUsuarioDao = new UsuarioDAO();
        List<UsuarioDTO> usuarios = objUsuarioDao.ler();
        boolean encontrado = false;
        for (UsuarioDTO objUsuario : usuarios) {
            if (objUsuario.getUsuario().equals(usuario) && objUsuario.getSenha().equals(senha)) {
                encontrado = true;
                UsuarioDTO.setLogged(true);
                System.out.println();
                if (objUsuario.isAdm()) {
                    UsuarioDTO.setAdmin(true);
                } else {
                    UsuarioDTO.setAdmin(false);
                    UsuarioDTO.setIdUsuario(objUsuario.getId_usuario());
                }
                if (telaPrincipal != null) {
                    GradientDropdownMenu menu = new GradientDropdownMenu();
                    telaPrincipal.atualizarVariaveis();
                    telaPrincipal.showForm(new FormHome(telaPrincipal));
                    telaPrincipal.atualizaMenu();
                }
            }
        }
        if (!encontrado) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Login ou Senha Incorretos!");
            txtUser.setText("");
            txtSenha.setText("");
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void fechadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechadoMouseClicked
        txtSenha.setEchoChar((char) 0);
        fechado.setEnabled(false);
        fechado.setVisible(false);
        aberto.setEnabled(true);
        aberto.setVisible(true);
    }//GEN-LAST:event_fechadoMouseClicked

    private void abertoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abertoMouseClicked
        txtSenha.setEchoChar((char) 8226);
        fechado.setEnabled(true);
        fechado.setVisible(true);
        aberto.setEnabled(false);
        aberto.setVisible(false);
    }//GEN-LAST:event_abertoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aberto;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel btnInscrever;
    private javax.swing.JLabel fechado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
