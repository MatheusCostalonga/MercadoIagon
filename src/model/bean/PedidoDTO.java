package model.bean;

public class PedidoDTO {

    private int idPedido;
    private int usuarioId;
    private String status;
    private String endereco;
    private String metodoPagamento;
    private float valorTotal;

    public PedidoDTO() {
    }

    public PedidoDTO(int idPedido, int usuarioId, String status, String endereco, String metodoPagamento, float valorTotal) {
        this.idPedido = idPedido;
        this.usuarioId = usuarioId;
        this.status = status;
        this.endereco = endereco;
        this.metodoPagamento = metodoPagamento;
        this.valorTotal = valorTotal;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

}
