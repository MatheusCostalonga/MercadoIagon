package component;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.CarrinhoDTO;
import model.bean.CarrinhoSingleton;
import model.bean.UsuarioDTO;
import raven.glasspanepopup.GlassPanePopup;
import telas.TelaPrincipal;

public class FormCarrinho extends javax.swing.JPanel {

    private DefaultTableModel model;
    private TelaPrincipal telaPrincipal;
    private boolean logged = UsuarioDTO.isLogged();

    public FormCarrinho(TelaPrincipal telaPrincipal) {
        initComponents();
        carregarItensCarrinho();
        this.telaPrincipal = telaPrincipal;
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

        tblCarrinho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        btnContinuar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnContinuar.setText("CONTINUAR COMPRA");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setText("CARRINHO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(btnContinuar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(173, 173, 173))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnContinuar)
                .addContainerGap())
        );

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
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
    private javax.swing.JTable tblCarrinho;
    // End of variables declaration//GEN-END:variables
}
