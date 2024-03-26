package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            System.out.println("Insere Pedido: "+ e);
        }
    }
}
