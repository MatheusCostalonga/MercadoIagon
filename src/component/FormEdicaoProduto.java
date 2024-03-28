package component;

import conexao.Conexao;
import java.awt.Image;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.DAO.CategoriaDAO;
import model.DAO.ProdutoDAO;
import model.bean.CategoriaDTO;
import model.bean.ProdutoDTO;
import raven.toast.Notifications;

public class FormEdicaoProduto extends javax.swing.JPanel {

    private FileInputStream fis;
    private int tamanho;
    int idProduto = 0;
    List<ProdutoDTO> produtos;

    public FormEdicaoProduto() {
        initComponents();
        readJtable();
        restaurarDadosComboboxCategoria();
        ProdutoDAO objProdutoDao = new ProdutoDAO();
        
        tblProduto.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                List<ProdutoDTO> produtos = objProdutoDao.leitura();  
                int setar = tblProduto.getSelectedRow();
                if (setar >= 0) {
                    idProduto = (int) tblProduto.getModel().getValueAt(setar, 0);
                    txtNome.setText((String) tblProduto.getModel().getValueAt(setar, 1));
                    cbxCategoria.setSelectedItem((String) tblProduto.getModel().getValueAt(setar, 2));
                    spinPreco.setValue((float) tblProduto.getModel().getValueAt(setar, 3));
                    for (ProdutoDTO objProduto : produtos) {
                        if (objProduto.getIdProduto() == idProduto) {
                            ImageIcon icon = new ImageIcon(objProduto.getImagem());
                            Image img = icon.getImage();
                            Image newImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Redimensiona a imagem para 300x300
                            icon = new ImageIcon(newImg);
                            lblImg.setIcon(icon);
                        }
                    }
                }
            }

        });
    }

    private void carregarFoto() {
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Selecionar arquivo");
        jfc.setFileFilter(new FileNameExtensionFilter("Arquivo de imagens (*.PNG,*.JPG,*.JPEG)", "png", "jpg", "jpeg"));
        int resultado = jfc.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(jfc.getSelectedFile());
                tamanho = (int) jfc.getSelectedFile().length();
                Image foto = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(lblImg.getWidth(),
                        lblImg.getHeight(), Image.SCALE_SMOOTH);
                lblImg.setIcon(new ImageIcon(foto));
                lblImg.updateUI();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void readJtable() {
        DefaultTableModel modelo = (DefaultTableModel) tblProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDAO objProdutoDao = new ProdutoDAO();
        CategoriaDAO objCategoriaDao = new CategoriaDAO();
        List<CategoriaDTO> categorias = objCategoriaDao.leitura();
        List<ProdutoDTO> produtos = objProdutoDao.leitura();
        for (ProdutoDTO p : produtos) {
            CategoriaDTO objCategoria = encontrarCategoria(categorias, p.getCategoriaId());
            modelo.addRow(new Object[]{
                p.getIdProduto(),
                p.getNome(),
                objCategoria.getNome(),
                p.getValor()
            });
        }
    }

    private CategoriaDTO encontrarCategoria(List<CategoriaDTO> categorias, int idCategoria) {
        for (CategoriaDTO objCategoria : categorias) {
            if (objCategoria.getIdCategoria() == idCategoria) {
                return objCategoria;
            }
        }
        return null;
    }
    Vector<Integer> id_categoria = new Vector<Integer>();

    private void restaurarDadosComboboxCategoria() {
        try {
            ProdutoDAO objProdutoDao = new ProdutoDAO();
            ResultSet rs = objProdutoDao.listarCategoria();
            while (rs.next()) {
                id_categoria.addElement(rs.getInt(1));
                cbxCategoria.addItem(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void limparCampos() {
        txtNome.setText("");
        spinPreco.setValue(0);
        cbxCategoria.setSelectedItem("Selecionar");
        lblImg.setIcon(new ImageIcon(FormCadastroProduto.class.getResource("/assets/carregar-imagem.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        reset = new javax.swing.JButton();
        buttonBuscar = new javax.swing.JButton();
        campoBusca = new javax.swing.JTextField();
        spinPreco = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblImg = new javax.swing.JLabel();
        btnImg = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("EDIÇÂO DE PRODUTOS");

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jPanel2.setBorder(dropShadowBorder1);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProduto.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome", "Categoria", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProduto);
        if (tblProduto.getColumnModel().getColumnCount() > 0) {
            tblProduto.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 470, 510));

        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel2.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 50, 30));

        buttonBuscar.setText("buscar");
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(buttonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, 30));

        campoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBuscaActionPerformed(evt);
            }
        });
        jPanel2.add(campoBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 300, 30));

        spinPreco.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        spinPreco.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 1.0f));
        jPanel2.add(spinPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 120, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel4.setText("PREÇO");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, -1, -1));

        cbxCategoria.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));
        jPanel2.add(cbxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 120, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setText("CATEGORIA");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, -1, -1));

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 230, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setText("NOME");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/carregar-imagem.png"))); // NOI18N
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        lblImg.setBorder(dropShadowBorder2);
        jPanel2.add(lblImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, -1, 280));

        btnImg.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnImg.setText("CARREGAR IMAGEM");
        btnImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgActionPerformed(evt);
            }
        });
        jPanel2.add(btnImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 420, -1, -1));

        btnAtualizar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnAtualizar.setText("ATUALIZAR");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 560, 140, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(429, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(585, 585, 585)))
                .addGap(279, 279, 279))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgActionPerformed
        carregarFoto();
    }//GEN-LAST:event_btnImgActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        readJtable();
    }//GEN-LAST:event_resetActionPerformed

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed

    }//GEN-LAST:event_buttonBuscarActionPerformed

    private void campoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscaActionPerformed

    }//GEN-LAST:event_campoBuscaActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if (txtNome.getText().trim().equals("") || (float) spinPreco.getValue() == 0) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "PREENCHA TODOS OS CAMPOS CORRETAMENTE!");
            return;
        } else if (cbxCategoria.getSelectedItem().equals("Selecionar")) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "SELECIONE UMA CATEGORIA!");
            return;
        } else if (tamanho == 0) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "SELECIONE UMA FOTO!");
            return;
        } else {
            String sql = "UPDATE produtos SET categoria_id = ?, nome = ?, imagem = ?, valor = ? WHERE id_produto = ?";
            try {
                Connection conexao = Conexao.conectar();
                PreparedStatement stmt = null;
                stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, id_categoria.get(cbxCategoria.getSelectedIndex() - 1));
                stmt.setString(2, txtNome.getText());
                stmt.setBlob(3, fis, tamanho);
                stmt.setFloat(4, (float) spinPreco.getValue());
                stmt.setInt(5, idProduto);

                stmt.executeUpdate();
                stmt.close();
                conexao.close();
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "PRODUTO ATUALIZADO COM SUCESSO!");
            } catch (SQLException e) {
                System.out.println("Erro update de produto: " + e);
            }
        }
        readJtable();
        limparCampos();
        idProduto = 0;
    }//GEN-LAST:event_btnAtualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnImg;
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JTextField campoBusca;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImg;
    private javax.swing.JButton reset;
    private javax.swing.JSpinner spinPreco;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
