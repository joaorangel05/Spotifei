package DAO;

import Model.ModelMusica;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicaDAO {

    private Connection conn;

    public MusicaDAO() {
        try {
            conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/rangel",
                "postgres", "machado2614");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }

    public List<ModelMusica> buscarPorTermo(String termo) {
        List<ModelMusica> resultados = new ArrayList<>();
        String sql = "SELECT nome, artista, genero FROM musica WHERE " +
                     "LOWER(nome) LIKE ? OR LOWER(artista) LIKE ? OR LOWER(genero) LIKE ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            String busca = "%" + termo.toLowerCase() + "%";
            stmt.setString(1, busca);
            stmt.setString(2, busca);
            stmt.setString(3, busca);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ModelMusica musica = new ModelMusica(
                    rs.getString("nome"),
                    rs.getString("artista"),
                    rs.getString("genero")
                );
                resultados.add(musica);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar músicas: " + e.getMessage());
        }

        return resultados;
    }
    
    public void atualizarCurtida(String nomeMusica, boolean curtida) {
        String sql = "UPDATE musica SET curtida = ? WHERE nome = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setBoolean(1, curtida);
        stmt.setString(2, nomeMusica);
        stmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar curtida: " + e.getMessage());
    }
}
}
