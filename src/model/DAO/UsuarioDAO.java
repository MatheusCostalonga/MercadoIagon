/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.UsuarioDTO;
import raven.toast.Notifications;

/**
 *
 * @author carlo
 */
public class UsuarioDAO {

    public List<UsuarioDTO> ler() {
        List<UsuarioDTO> usuarios = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement("SELECT * FROM usuarios");
            rs = stmt.executeQuery();
            while (rs.next()) {
                UsuarioDTO objUsuario = new UsuarioDTO();
                objUsuario.setId_usuario(rs.getInt("id_usuario"));
                objUsuario.setNome(rs.getString("nome"));
                objUsuario.setEmail(rs.getString("email"));
                objUsuario.setSenha(rs.getString("senha"));
                objUsuario.setUsuario(rs.getString("usuario"));
                objUsuario.setTelefone(rs.getString("telefone"));
                objUsuario.setEndereco(rs.getString("endereco"));
                objUsuario.setData_nascimento(rs.getString("data_nascimento"));
                objUsuario.setCep(rs.getString("cep"));
                objUsuario.setCpf(rs.getString("cpf"));
                objUsuario.setAdm(rs.getBoolean("adm"));
                usuarios.add(objUsuario);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return usuarios;
    }

    public void inserir(UsuarioDTO objUsuario) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("INSERT INTO usuarios (nome, email, senha, usuario, telefone, endereco, data_nascimento, cpf, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, objUsuario.getNome());
            stmt.setString(2, objUsuario.getEmail());
            stmt.setString(3, objUsuario.getSenha());
            stmt.setString(4, objUsuario.getUsuario());
            stmt.setString(5, objUsuario.getTelefone());
            stmt.setString(6, objUsuario.getEndereco());
            stmt.setString(7, objUsuario.getData_nascimento());
            stmt.setString(8, objUsuario.getCpf());
            stmt.setString(9, objUsuario.getCep());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "USUARIO CADASTRADO COM SUCESSO!");
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
}
