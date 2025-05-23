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
        String sql = "SELECT nome, artista, genero, curtida FROM musica WHERE " +
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
                musica.setCurtida(rs.getBoolean("curtida"));
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
}public List<ModelMusica> buscarCurtidas() {
    List<ModelMusica> curtidas = new ArrayList<>();
    String sql = "SELECT nome, artista, genero, curtida FROM musica WHERE curtida = TRUE";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ModelMusica musica = new ModelMusica(
                rs.getString("nome"),
                rs.getString("artista"),
                rs.getString("genero")
            );
            musica.setCurtida(rs.getBoolean("curtida"));
            curtidas.add(musica);
        }
    } catch (SQLException e) {
        System.out.println("Erro ao buscar músicas curtidas: " + e.getMessage());
    }

    return curtidas;
}

    public void inserirHistoricoBusca(ModelMusica musica) {
    String sql = "INSERT INTO historico_busca (nome, artista, genero, curtida) VALUES (?, ?, ?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, musica.getNome());
        stmt.setString(2, musica.getArtista());
        stmt.setString(3, musica.getGenero());
        stmt.setBoolean(4, musica.isCurtida());
        stmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Erro ao inserir histórico: " + e.getMessage());
    }
}
    
public List<ModelMusica> buscarHistorico() {
    List<ModelMusica> resultados = new ArrayList<>();
    String sql = "SELECT nome, artista, genero, curtida FROM historico ORDER BY data_busca DESC LIMIT 10";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ModelMusica musica = new ModelMusica(
                rs.getString("nome"),
                rs.getString("artista"),
                rs.getString("genero"),
                rs.getBoolean("curtida")
            );
            resultados.add(musica);
        }
    } catch (SQLException e) {
        System.out.println("Erro ao buscar histórico: " + e.getMessage());
    }

    return resultados;
}




public void salvarHistorico(ModelMusica musica) {
    String sql = "INSERT INTO historico (nome, artista, genero, curtida) VALUES (?, ?, ?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, musica.getNome());
        stmt.setString(2, musica.getArtista());
        stmt.setString(3, musica.getGenero());
        stmt.setBoolean(4, musica.isCurtida());
        stmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Erro ao salvar histórico: " + e.getMessage());
    }
}

public List<ModelMusica> buscarDescurtidas() {
    List<ModelMusica> lista = new ArrayList<>();
    String sql = "SELECT nome, artista, genero, curtida FROM musica WHERE curtida = false";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ModelMusica musica = new ModelMusica(
                rs.getString("nome"),
                rs.getString("artista"),
                rs.getString("genero")
            );
            musica.setCurtida(false);
            lista.add(musica);
        }
    } catch (SQLException e) {
        System.out.println("Erro ao buscar músicas descurtidas: " + e.getMessage());
    }
    return lista;
}

}
