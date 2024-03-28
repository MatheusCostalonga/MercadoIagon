package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.CategoriaDTO;

public class CategoriaDAO {

    public List<CategoriaDTO> leitura() {
        List<CategoriaDTO> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categorias";
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                CategoriaDTO objCategoria = new CategoriaDTO();
                objCategoria.setIdCategoria(rs.getInt("id_categoria"));
                objCategoria.setNome(rs.getString("nome"));
                categorias.add(objCategoria);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Leitura de categorias: " + e);
        }
        return categorias;
    }
}
