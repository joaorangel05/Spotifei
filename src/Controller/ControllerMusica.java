package Controller;

import Model.ModelMusica;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerMusica {
    private List<ModelMusica> musicas;

    public ControllerMusica() {
        musicas = new ArrayList<>();
        adicionarMusicas();
    }

    private void adicionarMusicas() {
        musicas.add(new ModelMusica("musica 1", "artista 1", "genero 1"));
        musicas.add(new ModelMusica("musica 2", "artista 2", "genero 2"));
        musicas.add(new ModelMusica("musica 3", "artista 3", "genero 1"));
        musicas.add(new ModelMusica("musica 4", "artista 4", "genero 2"));
        musicas.add(new ModelMusica("musica 5", "artista 5", "genero 3"));
        musicas.add(new ModelMusica("musica 6", "artista 1", "genero 1"));
        musicas.add(new ModelMusica("musica 7", "artista 2", "genero 3"));
        musicas.add(new ModelMusica("musica 8", "artista 3", "genero 2"));
        musicas.add(new ModelMusica("musica 9", "artista 4", "genero 1"));
        musicas.add(new ModelMusica("musica 10", "artista 5", "genero 2"));
    }

    public List<ModelMusica> buscarPorNome(String nome) {
        return musicas.stream()
                .filter(m -> m.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<ModelMusica> buscarPorArtista(String artista) {
        return musicas.stream()
                .filter(m -> m.getArtista().toLowerCase().contains(artista.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<ModelMusica> buscarPorGenero(String genero) {
        return musicas.stream()
                .filter(m -> m.getGenero().toLowerCase().contains(genero.toLowerCase()))
                .collect(Collectors.toList());
    }
}
