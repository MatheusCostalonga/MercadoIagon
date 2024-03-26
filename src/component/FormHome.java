package component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import model.DAO.ProdutoDAO;
import model.bean.CarrinhoDTO;
import model.bean.CarrinhoSingleton;
import model.bean.ProdutoDTO;
import raven.glasspanepopup.GlassPanePopup;
import raven.toast.Notifications;

public class FormHome extends javax.swing.JPanel {

    List<CarrinhoDTO> carrinhoItens = new ArrayList<>();

    public FormHome() {
        initComponents();
        exibirProdutos();
    }

    public void exibirProdutos() {
        ProdutoDAO objProdutoDao = new ProdutoDAO();
        List<ProdutoDTO> produtos = objProdutoDao.leitura();

        for (ProdutoDTO produto : produtos) {
            JPanel newPanel = new JPanel();
            newPanel.setBackground(Color.white);
            newPanel.setPreferredSize(new Dimension(150, 400)); // Definindo o tamanho do novo painel
            newPanel.setBorder(BorderFactory.createLineBorder(Color.black));
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
            JLabel labelPreco = new JLabel("Preço: R$ " + produto.getValor());

            JButton btnAdicionarAoCarrinho = new JButton("Adicionar ao Carrinho");
//            btnAdicionarAoCarrinho.setEnabled(false);

            btnAdicionarAoCarrinho.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CarrinhoDTO carrinhoItem = new CarrinhoDTO();
                    int qtdProduto = (int) spinner.getValue();
                    carrinhoItem.setId_produto(produto.getIdProduto());
                    carrinhoItem.setNome(produto.getNome());
                    carrinhoItem.setPreco_unitario(produto.getValor());
                    carrinhoItem.setQuantidade(qtdProduto);
                    CarrinhoSingleton.getInstance().adicionarItem(carrinhoItem);
                    JOptionPane.showMessageDialog(null, "Produto adicionado ao carrinho!");
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

        ScrollPane = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        btnCarrinho = new raven.glasspanepopup.Button();

        setPreferredSize(new java.awt.Dimension(1889, 992));

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

        btnCarrinho.setBackground(new java.awt.Color(255, 255, 255));
        btnCarrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/carrinho.png"))); // NOI18N
        btnCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarrinhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(btnCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarrinhoActionPerformed
        GlassPanePopup.showPopup(new FormCarrinho());
    }//GEN-LAST:event_btnCarrinhoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane;
    private raven.glasspanepopup.Button btnCarrinho;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
