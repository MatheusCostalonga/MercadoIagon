package component;

import model.DAO.UsuarioDAO;
import model.bean.UsuarioDTO;
import raven.toast.Notifications;
import com.raven.datechooser.DateChooser;
import java.text.SimpleDateFormat;
import telas.TelaPrincipal;

public class FormCadastroUser extends javax.swing.JPanel {
    private final DateChooser objDateNascimento = new DateChooser();
    private TelaPrincipal telaPrincipal;
    /**
     * Creates new form FormCadastroUser
     */
    public FormCadastroUser(TelaPrincipal telaPrincipal) {
        initComponents();
        objDateNascimento.setDateFormat(new SimpleDateFormat ("yyyy-MM-dd"));
        objDateNascimento.setTextField(txtNascimento);
        objDateNascimento.setDateSelectionMode(DateChooser.DateSelectionMode.SINGLE_DATE_SELECTED);
        this.telaPrincipal = telaPrincipal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        txtCriar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), " Conta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria Math", 1, 30))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setText("Usuário");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setText("Senha");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel4.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, 50));

        txtSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel4.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 220, 50));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Informações Pessoais", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria Math", 1, 30), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Nome");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel5.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 250, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setText("Nascimento");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        txtNascimento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNascimento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(txtNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 250, 50));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel10.setText("Telefone");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, -1));

        txtTelefone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel5.add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 250, 50));

        txtEndereco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel5.add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 250, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setText("Endereço");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("Email");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel5.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 250, 50));

        txtCpf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel5.add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 250, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setText("Cpf");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setText("Cep");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, -1));

        txtCep.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel5.add(txtCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 250, 50));

        txtCriar.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        txtCriar.setText("Criar");
        txtCriar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriarActionPerformed(evt);
            }
        });
        jPanel5.add(txtCriar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 580, 310, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Já Tem Uma Conta?");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 640, -1, -1));

        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarMouseClicked(evt);
            }
        });
        jPanel5.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 640, -1, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 80, -1, -1));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 296, -1, 448));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/undraw_fill_forms_yltj-768x483.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel13.setText("Faça Cadastro");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel14.setText("E Entre Para Nosso Time!");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 2108, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseClicked
        telaPrincipal.showForm(new FormEntrar(telaPrincipal));
    }//GEN-LAST:event_btnEntrarMouseClicked

    private void txtCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriarActionPerformed
        if (txtUser.getText().isEmpty() || txtSenha.getText().isEmpty() || txtNome.getText().isEmpty()
            || txtNascimento.getText().isEmpty() || txtCpf.getText().isEmpty() || txtCep.getText().isEmpty()
            || txtEmail.getText().isEmpty() || txtTelefone.getText().isEmpty() || txtEndereco.getText().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Preencha Todos os Campos!");
        }
        try {
            String usuario = txtUser.getText();
            String senha = txtSenha.getText();
            String nome = txtNome.getText();
            String data_nascimento = txtNascimento.getText();
            String cpf = txtCpf.getText();
            String cep = txtCep.getText();
            String email = txtEmail.getText();
            String telefone = txtTelefone.getText();
            String endereco = txtEndereco.getText();
            UsuarioDTO objusuario = new UsuarioDTO();
            objusuario.setUsuario(usuario);
            objusuario.setSenha(senha);
            objusuario.setNome(nome);
            objusuario.setData_nascimento(data_nascimento);
            objusuario.setCpf(cpf);
            objusuario.setCep(cep);
            objusuario.setEmail(email);
            objusuario.setTelefone(telefone);
            objusuario.setEndereco(endereco);
            UsuarioDAO objusuarioDAO = new UsuarioDAO();
            objusuarioDAO.inserir(objusuario);
            telaPrincipal.showForm(new FormEntrar(telaPrincipal));
        } catch (NumberFormatException erro) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Erro ao realizar cadastro!");
        }
        
    }//GEN-LAST:event_txtCriarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JButton txtCriar;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
