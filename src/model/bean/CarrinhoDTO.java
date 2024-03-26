package model.bean;

public class CarrinhoDTO {
    private int  id_produto;
    private String nome;
    private int quantidade;
    private float preco_unitario;

    public CarrinhoDTO() {
    }

    public CarrinhoDTO(int id_produto, String nome, int quantidade, float preco_unitario) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco_unitario = preco_unitario;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
