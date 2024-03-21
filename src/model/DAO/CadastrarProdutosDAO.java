/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.CadastrarProdutos;
/**
 *
 * @author Senai
 */
public class CadastrarProdutosDAO {
 public List<CadastrarProdutos>read() {
        List<CadastrarProdutos> produtos = new ArrayList();
        
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement("SELECT * FROM produtos");
            rs = stmt.executeQuery();
            while(rs.next()){
                CadastrarProdutos produto = new CadastrarProdutos();
                produto.setId_produto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria_id(rs.getInt("categoria"));
                produto.setDesconto(rs.getInt("desconto"));
                produto.setValor(rs.getFloat("valor"));
            }
            rs.close();
            stmt.close();
            conexao.close();
        }
        catch(SQLException e){
    e.printStackTrace();
        return produtos;
     }
        return produtos;
}
    //---------------------------------------------------------------------
    public void create(CadastrarProdutos produtos){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("INSERT INTO produtos(categoria_id, nome, valor, desconto) VALUES (?,?,?)");
            stmt.setInt(1, produtos.getCategoria_id());
            stmt.setString(2, produtos.getNome());
            stmt.setFloat(3, produtos.getValor());
            stmt.setInt(4, produtos.getDesconto());            
            
            stmt.executeUpdate();
            
            
            stmt.close();
            conexao.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    //------------------------------------------------------------------
    public void delete(CadastrarProdutos produtos){
        try{
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        
        stmt = conexao.prepareStatement("DELETE FROM produtos WHERE id_produto = ?");
        stmt.setInt(1, produtos.getId_produto());
        
        stmt.executeUpdate();
        
        
        stmt.close();
        conexao.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void atualiza(CadastrarProdutos produtos){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("UPDATE produtos SET valor = ? WHERE id_produtos_pedido = ?");
            stmt.setFloat(1, produtos.getValor());
            stmt.setInt(2, produtos.getId_produto());   
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Estoque Atualizado");
            
            stmt.close();
            conexao.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
