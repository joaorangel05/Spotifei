
package Controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.Cadastro;

public class ControllerCadastro {
    private Cadastro view;
    
    public ControllerCadastro(Cadastro view){
        this.view = view;
    }
    
    public void salvarUsuario(){
        String nome = view.getTxt_nome_cadastro().getText();
        String usuario = view.getTxt_usuario_cadastro().getText();
        String senha = view.getTxt_senha_cadastro().getText();
        Usuario usu = new Usuario(nome, usuario,senha);
        
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.inserir(usu);
            JOptionPane.showMessageDialog(view, "Usuario Cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Usuário não cadastrado!","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
