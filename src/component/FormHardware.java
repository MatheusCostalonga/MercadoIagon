package component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.CompoundBorder;
import model.DAO.ProdutoDAO;
import model.bean.CarrinhoDTO;
import model.bean.CarrinhoSingleton;
import model.bean.ProdutoDTO;
import model.bean.UsuarioDTO;
import org.jdesktop.swingx.border.DropShadowBorder;
import raven.glasspanepopup.GlassPanePopup;
import raven.toast.Notifications;
import telas.TelaPrincipal;

public class FormHardware extends javax.swing.JPanel {

    private boolean adm = UsuarioDTO.isAdmin();
    List<CarrinhoDTO> carrinhoItens = new ArrayList<>();
    private TelaPrincipal telaPrincipal;

    public FormHardware(TelaPrincipal telaPrincipal) {
        initComponents();
        exibirProdutos();
        this.telaPrincipal = telaPrincipal;
        if (adm) {
            btnCarrinho3.setEnabled(false);
        } else {
            btnCarrinho3.setEnabled(true);
        }
    }

    public void exibirProdutos() {
        ProdutoDAO objProdutoDao = new ProdutoDAO();
        List<ProdutoDTO> produtos = objProdutoDao.leituraHardware();

        for (ProdutoDTO produto : produtos) {
            JPanel newPanel = new JPanel();
            newPanel.setBackground(Color.white);
            newPanel.setPreferredSize(new Dimension(150, 500)); // Definindo o tamanho do novo painel
            DropShadowBorder shadowBorder = new DropShadowBorder();
            CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(
                    shadowBorder,
                    BorderFactory.createEmptyBorder(5, 5, 5, 5) // Adiciona um espaço interno para evitar que a sombra seja cortada
            );
            newPanel.setBorder(compoundBorder);
            newPanel.setLayout(new BorderLayout());

            // Adicionando a imagem
            ImageIcon icon = new ImageIcon(produto.getImagem());
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Redimensiona a imagem para 300x300
            icon = new ImageIcon(newImg);
            JLabel labelImagem = new JLabel(icon);

            JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1)); // Valores mínimos, máximos e iniciais
            spinner.setMaximumSize(new Dimension(10, 30)); // Definir a largura máxima desejada

            JLabel labelNome = new JLabel(produto.getNome());
            labelNome.setFont(new Font("Segoe UI", Font.BOLD, 16));
            JLabel labelPreco = new JLabel("Preço: R$ " + produto.getValor());
            labelPreco.setFont(new Font("Segoe UI", Font.PLAIN, 15));

            JButton btnAdicionarAoCarrinho = new JButton("Adicionar ao Carrinho");
            btnAdicionarAoCarrinho.setFont(new Font("Segoe UI", Font.BOLD, 16));
            if (adm) {
                btnAdicionarAoCarrinho.setEnabled(false);
            } else {
                btnAdicionarAoCarrinho.setEnabled(true);
            }
            btnAdicionarAoCarrinho.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CarrinhoDTO carrinhoItem = new CarrinhoDTO();
                    int qtdProduto = (int) spinner.getValue();
                    carrinhoItem.setId_produto(produto.getIdProduto());
                    carrinhoItem.setNome(produto.getNome());
                    carrinhoItem.setPreco_unitario(produto.getValor());
                    carrinhoItem.setQuantidade(qtdProduto);
                    CarrinhoSingleton.getInstance().adicionarItem(carrinhoItem);
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "PRODUTO ADICIONADO AO CARRINHO!");
                    spinner.setValue(1);
                }
            });

            // Criando um painel para a imagem e o nome
            JPanel imageAndNamePanel = new JPanel(new BorderLayout());
            imageAndNamePanel.add(labelImagem, BorderLayout.CENTER);
            imageAndNamePanel.add(labelNome, BorderLayout.SOUTH);

            // Criando um painel para o preço e o controle giratório
            JPanel priceAndSpinnerPanel = new JPanel(new BorderLayout());
            priceAndSpinnerPanel.add(labelPreco, BorderLayout.CENTER);
            priceAndSpinnerPanel.add(spinner, BorderLayout.SOUTH);

            // Criando um painel para o botão "Adicionar ao Carrinho"
            JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            btnPanel.add(btnAdicionarAoCarrinho);

            // Usando um painel principal para organizar os painéis acima verticalmente
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.add(imageAndNamePanel);
            mainPanel.add(priceAndSpinnerPanel);
            mainPanel.add(btnPanel);
            newPanel.add(mainPanel);

            // Obtendo o JPanel contido no JScrollPane
            JPanel panelInScrollPane = (JPanel) ScrollPane.getViewport().getView();
            GridLayout gridLayout = new GridLayout(0, 5);// Configurando o layout como GridLayout com 0 linhas e 3 colunas e espaçamento entre os componentes
            gridLayout.setHgap(20); // Define o espaçamento horizontal entre os componentes como 10 pixels
            gridLayout.setVgap(20); // Define o espaçamento vertical entre os componentes como 10 pixels
            panelInScrollPane.setLayout(gridLayout);
            panelInScrollPane.add(newPanel); // Adicionando o novo painel ao JPanel no JScrollPane
            ScrollPane.setViewportView(panelInScrollPane); // Definindo o JPanel como o componente exibido pelo JScrollPane
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCarrinho3 = new raven.glasspanepopup.Button();
        jLabel1 = new javax.swing.JLabel();
        ScrollPane = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        btnCarrinho3.setBackground(new java.awt.Color(233, 233, 233));
        btnCarrinho3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/carrinho.png"))); // NOI18N
        btnCarrinho3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarrinho3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("HARDWARE");

        ScrollPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1885, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 988, Short.MAX_VALUE)
        );

        ScrollPane.setViewportView(jPanel3);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/cpu (1).png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCarrinho3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addComponent(ScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCarrinho3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarrinho3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarrinho3ActionPerformed
        GlassPanePopup.showPopup(new FormCarrinho(telaPrincipal));
    }//GEN-LAST:event_btnCarrinho3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane;
    private raven.glasspanepopup.Button btnCarrinho3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
