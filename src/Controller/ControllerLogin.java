
package Controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.Login;


public class ControllerLogin {
    private Login view;

    public ControllerLogin(Login view) {
        this.view = view;
    }
    
    public void loginUsuario(){
        Usuario usuario = new Usuario(null, 
                                view.getTxt_usuario_login().getText(),
                                view.getTxt_senha_login().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(usuario);
            if(res.next()){
                JOptionPane.showMessageDialog(view, 
                                              "Login efetuado!", 
                                              "Aviso",
                                              JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(view, 
                                              "Login NÃO efetuado!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
            }
        } catch(SQLException e){    
            JOptionPane.showMessageDialog(view, 
                                              "Erro de conexão!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
        }
    }
}
