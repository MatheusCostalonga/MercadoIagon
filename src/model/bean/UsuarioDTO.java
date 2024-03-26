package model.bean;

public class UsuarioDTO {

    private int id_usuario;
    private String usuario;
    private String senha;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String data_nascimento;
    private String cep;
    private String cpf;
    private static boolean admin;
    private boolean adm;
    private static boolean logged;
    private static int idUsuario;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id_usuario, String usuario, String senha, String nome, String email, String telefone, String endereco, String data_nascimento, String cep, String cpf, boolean adm) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.data_nascimento = data_nascimento;
        this.cep = cep;
        this.cpf = cpf;
        this.adm = adm;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static boolean isAdmin() {
        return admin;
    }

    public static void setAdmin(boolean admin) {
        UsuarioDTO.admin = admin;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

    public static boolean isLogged() {
        return logged;
    }

    public static void setLogged(boolean logged) {
        UsuarioDTO.logged = logged;
    }

    public static int getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(int idUsuario) {
        UsuarioDTO.idUsuario = idUsuario;
    }

}
