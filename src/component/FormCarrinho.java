package component;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.CarrinhoDTO;
import model.bean.CarrinhoSingleton;
import model.bean.UsuarioDTO;
import raven.glasspanepopup.GlassPanePopup;
import raven.toast.Notifications;
import telas.TelaPrincipal;

public class FormCarrinho extends javax.swing.JPanel {

    private DefaultTableModel model;
    private TelaPrincipal telaPrincipal;
    private boolean logged = UsuarioDTO.isLogged();

    public FormCarrinho(TelaPrincipal telaPrincipal) {
        initComponents();
        carregarItensCarrinho();
        this.telaPrincipal = telaPrincipal;
        lblDeleta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeletaMouseClicked(evt);
            }
        });
    }

    private void lblDeletaMouseClicked(java.awt.event.MouseEvent evt) {
        int rowIndex = tblCarrinho.getSelectedRow();
        if (rowIndex != -1) {
            removerItemCarrinho(rowIndex);
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "SELECIONE UM ITEM!");
        }
    }

    public void removerItemCarrinho(int rowIndex) {
        List<CarrinhoDTO> carrinhoItens = CarrinhoSingleton.getInstance().getCarrinhoItens();
        if (rowIndex >= 0 && rowIndex < carrinhoItens.size()) {
            carrinhoItens.remove(rowIndex);
            carregarItensCarrinho();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "ITEM REMOVIDO!");
        } else {
            System.out.println("Índice da linha selecionada fora dos limites da lista de carrinho.");
        }
    }

    public void carregarItensCarrinho() {
        List<CarrinhoDTO> carrinhoItens = CarrinhoSingleton.getInstance().getCarrinhoItens();
        DefaultTableModel model = (DefaultTableModel) tblCarrinho.getModel();
        model.setRowCount(0);
        double total = 0.0;
        for (CarrinhoDTO item : carrinhoItens) {
            Object[] rowData = {item.getId_produto(), item.getNome(), item.getPreco_unitario(), item.getQuantidade()};
            model.addRow(rowData);
            double subtotal = item.getPreco_unitario() * item.getQuantidade();
            total += subtotal;
        }
        String totalFormatado = String.format("%.2f", total);
        Object[] totalRow = {"Total", "", "", totalFormatado};
        model.addRow(totalRow);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarrinho = new javax.swing.JTable();
        btnContinuar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblDeleta = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCarrinho.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tblCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUTO", "VALOR", "QUANTIDADE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCarrinho);
        if (tblCarrinho.getColumnModel().getColumnCount() > 0) {
            tblCarrinho.getColumnModel().getColumn(0).setMaxWidth(45);
            tblCarrinho.getColumnModel().getColumn(2).setMaxWidth(100);
            tblCarrinho.getColumnModel().getColumn(3).setMinWidth(90);
            tblCarrinho.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 440, 486));

        btnContinuar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnContinuar.setText("CONTINUAR COMPRA");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 570, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setText("CARRINHO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 13, -1, -1));

        lblDeleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/excluir.png"))); // NOI18N
        lblDeleta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(lblDeleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        if (CarrinhoSingleton.getInstance().getCarrinhoItens().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "CARRINHO FAZIO!");
            return;
        }
        if (logged) {
            GlassPanePopup.closePopupAll();
            telaPrincipal.showForm(new FormFinalizar(telaPrincipal));
        } else {
            JOptionPane.showMessageDialog(null, "Você não está logado em uma conta. Por favor, faça login.", "Aviso de Login", JOptionPane.WARNING_MESSAGE);
            GlassPanePopup.closePopupAll();
            telaPrincipal.showForm(new FormEntrar(telaPrincipal));
        }

    }//GEN-LAST:event_btnContinuarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDeleta;
    private javax.swing.JTable tblCarrinho;
    // End of variables declaration//GEN-END:variables
}
