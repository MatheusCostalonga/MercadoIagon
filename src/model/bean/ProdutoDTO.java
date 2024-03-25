package model.bean;

import java.sql.Blob;

public class ProdutoDTO {
    private int idProduto;
    private String nome;
    private byte[] imagem;
    private Blob imgBlob;
    private float valor;

    public ProdutoDTO() {
    }

    public ProdutoDTO(int idProduto, String nome, byte[] imagem, Blob imgBlob, float valor) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.imagem = imagem;
        this.imgBlob = imgBlob;
        this.valor = valor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Blob getImgBlob() {
        return imgBlob;
    }

    public void setImgBlob(Blob imgBlob) {
        this.imgBlob = imgBlob;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
}
