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
public class CadastrarProdutos {
    private int id_produto;
    private int categoria_id;
    private String nome;
    private float valor;
    private int desconto;

    public CadastrarProdutos() {
    }

    public CadastrarProdutos(int id_produto, int categoria_id, String nome, int desconto, float valor) {
        this.id_produto = id_produto;
        this.categoria_id = categoria_id;
        this.nome = nome;
        this.valor = valor;
        this.desconto = desconto;

    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDesconto() {
        return desconto;
    }

        public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }


    
    
}
