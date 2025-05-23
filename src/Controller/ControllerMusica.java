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
    
    


public void atualizarCurtida(String nomeMusica, boolean curtida) {
    musicaDAO.atualizarCurtida(nomeMusica, curtida);  
}

public List<ModelMusica> buscarCurtidas() {
    return musicaDAO.buscarCurtidas();
}
public List<ModelMusica> buscarHistorico() {
    MusicaDAO dao = new MusicaDAO();
    return dao.buscarHistorico();
}


public void salvarHistorico(ModelMusica musica) {
    MusicaDAO dao = new MusicaDAO();
    dao.salvarHistorico(musica);
}

public List<ModelMusica> buscarDescurtidas() {
    MusicaDAO dao = new MusicaDAO();
    return dao.buscarDescurtidas();
}

}
