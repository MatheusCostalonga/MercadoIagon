package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.bean.CarrinhoDTO;
import model.bean.CarrinhoSingleton;
import model.bean.PedidoDTO;

public class PedidoDAO {

    public List<PedidoDTO> leitura() {
        List<PedidoDTO> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedidos";
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                PedidoDTO objPedido = new PedidoDTO();
                objPedido.setIdPedido(rs.getInt("id_pedido"));
                objPedido.setUsuarioId(rs.getInt("usuario_id"));
                objPedido.setStatus(rs.getString("status_pagamento"));
                objPedido.setEndereco(rs.getString("endereco"));
                objPedido.setMetodoPagamento(rs.getString("metodo_pagamento"));
                objPedido.setValorTotal(rs.getFloat("valor_total"));
                objPedido.setData(rs.getString("data_hora"));
                pedidos.add(objPedido);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro leirura de pedidos: " + e);
        }
        return pedidos;
    }

    public void deletaPedido(PedidoDTO objpedido) {
        String sql = "DELETE FROM pedidos WHERE id_pedido = ?";
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, objpedido.getIdPedido());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            System.out.println("Erro delete pedido: " + e);
        }
    }

    public void deletaPedidoProduto(PedidoDTO objpedido) {
        String sql = "DELETE FROM pedidos_produtos WHERE pedido_id = ?";
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, objpedido.getIdPedido());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            System.out.println("Erro delete pedido´produto: " + e);
        }
    }

    public void updatePedido(PedidoDTO objPedido) {
        String sql = "UPDATE pedidos SET status_pagamento = ? WHERE id_pedido = ?";
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, objPedido.getStatus());
            stmt.setInt(2, objPedido.getIdPedido());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro em atulizar pedidos: " + e);
        }
    }

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
