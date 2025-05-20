
package Model;


public class ModelMusica {
    private String nome, artista, genero;
    private boolean curtida;

    public ModelMusica() {
    }

    public ModelMusica(String nome, String artista, String genero) {
        this.nome = nome;
        this.artista = artista;
        this.genero = genero;
        this.curtida = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
     public boolean isCurtida() {
        return curtida;
    }

    public void setCurtida(boolean curtida) {
        this.curtida = curtida;
    }
    
}

