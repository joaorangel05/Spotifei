package Model;

import java.util.ArrayList;
import java.util.List;

public class ModelPlaylist {
    private int id;
    private String nome;
    private List<ModelMusica> musicas;

    public ModelPlaylist() {
        musicas = new ArrayList<>();
    }

    public ModelPlaylist(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<ModelMusica> getMusicas() { return musicas; }
    public void setMusicas(List<ModelMusica> musicas) { this.musicas = musicas; }
}
