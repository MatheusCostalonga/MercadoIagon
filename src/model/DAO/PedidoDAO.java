package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.bean.CarrinhoDTO;
import model.bean.CarrinhoSingleton;
import model.bean.PedidoDTO;

public class PedidoDAO {

    public void inserePedido(PedidoDTO objPedido) {
        String sql = "INSERT INTO pedidos (usuario_id, endereco, metodo_pagamento, valor_total, data_hora) VALUES (?, ?, ?, ?, NOW())";
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, objPedido.getUsuarioId());
            stmt.setString(2, objPedido.getEndereco());
            stmt.setString(3, objPedido.getMetodoPagamento());
            stmt.setFloat(4, objPedido.getValorTotal());

            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            int idPedido = -1;
            if (generatedKeys.next()) {
                idPedido = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Falha ao recuperar o ID do pedido gerado automaticamente.");
            }

            inserirItensPedido(CarrinhoSingleton.getInstance().getCarrinhoItens(), idPedido);

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Insere Pedido: " + e);
        }
    }

    private void inserirItensPedido(List<CarrinhoDTO> carrinhoItens, int idPedido) {
        String sql = "INSERT INTO pedidos_produtos (pedido_id, produto_id, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            for (CarrinhoDTO item : carrinhoItens) {
                stmt.setInt(1, idPedido);
                stmt.setInt(2, item.getId_produto());
                stmt.setInt(3, item.getQuantidade());
                stmt.setFloat(4, item.getPreco_unitario());
                stmt.executeUpdate();
            }

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Inserir Itens do Pedido: " + e);
        }
    }

}
