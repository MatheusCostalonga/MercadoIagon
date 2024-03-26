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
import model.bean.CarrinhoDTO;

/**
 *
 * @author Senai
 */
public class CarrinhoDAO {
         public List<CarrinhoDTO>read() {
        List<CarrinhoDTO> carrinhos = new ArrayList();
        
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement("SELECT * FROM produtos_pedidos");
            rs = stmt.executeQuery();
            while(rs.next()){
                CarrinhoDTO carrinho = new CarrinhoDTO();
                carrinho.setQuantidade(rs.getInt("id_produtos_pedido"));
                carrinho.setPreco_unitario(rs.getInt("quantidade"));
                carrinhos.add(carrinho);
            }
            rs.close();
            stmt.close();
            conexao.close();
        }
        catch(SQLException e){
    e.printStackTrace();
        return carrinhos;
     }
        return carrinhos;
}
       public void addProdutoAoCarrinho(CarrinhoDTO carrinhos){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("INSERT INTO produtos_pedidos (quantidade, preco_unitario) VALUES(?,?)");
            stmt.setInt(1, carrinhos.getQuantidade());
            stmt.setFloat(2, carrinhos.getPreco_unitario());
             
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Item foi inserido no carrinho com sucesso.");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
       //resetar o carrinho
       public void resetar (CarrinhoDTO carrinhos){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("DELETE FROM produtos_pedidos");

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    } 
    public void ExcluirItemDoCarrinho (CarrinhoDTO carrinhos){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("DELETE FROM produtos_pedidos WHERE id_produtos_pedido = ?");
            stmt.setString(1, Integer.toString(carrinhos.getId_produto()));
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Item do carrinho foi excluido com sucesso!!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    } 
}
