package model.DAO;

import conexao.Conexao;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.ProdutoDTO;

public class ProdutoDAO {

    public List<ProdutoDTO> leitura() {
        List<ProdutoDTO> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ProdutoDTO objProduto = new ProdutoDTO();
                objProduto.setIdProduto(rs.getInt("id_produto"));
                objProduto.setNome(rs.getString("nome"));
                objProduto.setValor(rs.getFloat("valor"));
                Blob blob = rs.getBlob("imagem");
                int blobLength = (int) blob.length();
                byte[] imagemBytes = blob.getBytes(1, blobLength);
                blob.free();
                objProduto.setImagem(imagemBytes);
                produtos.add(objProduto);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Leitura de produtos: " + e);
        }
        return produtos;
    }

    public ResultSet listarCategoria() {
        String sql = "SELECT * FROM categorias order by nome;";
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
