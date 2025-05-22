package Controller;

import DAO.MusicaDAO;
import Model.ModelMusica;
import java.util.List;

public class ControllerMusica {

    private final MusicaDAO musicaDAO;

    public ControllerMusica() {
        musicaDAO = new MusicaDAO();
    }

    public List<ModelMusica> buscarMusicas(String termo) {
        return musicaDAO.buscarPorTermo(termo);
    }
    
    // dentro do seu ControllerMusica


public void atualizarCurtida(String nomeMusica, boolean curtida) {
    musicaDAO.atualizarCurtida(nomeMusica, curtida);  // chama pelo objeto
}

}
