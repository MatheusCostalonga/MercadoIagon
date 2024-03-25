/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Senai
 */
public class CarrinhoDTO {
    private int  id_produtos_pedido;
    private int quantidade;
    private float preco_unitario;

    public CarrinhoDTO() {
    }

    public CarrinhoDTO(int id_produtos_pedido, int quantidade, float preco_unitario) {
        this.id_produtos_pedido = id_produtos_pedido;
        this.quantidade = quantidade;
        this.preco_unitario = preco_unitario;
    }

    public int getId_produtos_pedido() {
        return id_produtos_pedido;
    }

    public void setId_produtos_pedido(int id_produtos_pedido) {
        this.id_produtos_pedido = id_produtos_pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(float preco_unitario) {
        this.preco_unitario = preco_unitario;
    }
    
    
}
