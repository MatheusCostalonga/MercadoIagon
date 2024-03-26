package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.bean.CarrinhoDTO;
import model.bean.PedidoDTO;

public class PedidoDAO {

    public void inserePedido(PedidoDTO objPedido) {
        String sql = "INSERT INTO pedidos (usuario_id,endereco,metodo_pagamento,valor_total,data_hora)values(?,?,?,?,NOW())";
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, objPedido.getUsuarioId());
            stmt.setString(2, objPedido.getEndereco());
            stmt.setString(3, objPedido.getMetodoPagamento());
            stmt.setFloat(4, objPedido.getValorTotal());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Insere Pedido: " + e);
        }
    }

    public void inserePedidoProduto(List<CarrinhoDTO> carrinhoItens, int pedidoId) {
        String sql = "INSERT INTO pedidos_produtos (pedido_id,produto_id,quantidade,preco_unitario)values(?,?,?,?)";
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement(sql);
            for (CarrinhoDTO item : carrinhoItens) {
                stmt.setInt(1, pedidoId);
                stmt.setInt(2, item.getId_produto());
                stmt.setInt(3, item.getQuantidade());
                stmt.setFloat(4, item.getPreco_unitario());
                stmt.executeUpdate();
            }
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Insere pedidos_produtos: " + e);
        }
    }
}
