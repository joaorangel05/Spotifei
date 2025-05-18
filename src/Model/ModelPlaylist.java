package Model;

import java.util.ArrayList;
import java.util.List;

public class ModelPlaylist {
    private String nome;
    private List<ModelMusica> musicas;

    public ModelPlaylist(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<ModelMusica> getMusicas() { return musicas; }

    public void adicionarMusica(ModelMusica musica) {
        musicas.add(musica);
    }

    public void removerMusica(ModelMusica musica) {
        musicas.remove(musica);
    }

    @Override
    public String toString() {
        return nome;
    }
}
