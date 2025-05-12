
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Model.Usuario;


public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Usuario usuario) throws SQLException{
        String sql = "select * from usuario where usuario = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void inserir(Usuario usuario) throws SQLException{
        String sql = "insert into usuario (nome, usuario, senha) values ('"
                      + usuario.getNome()    + "', '"
                      + usuario.getUsuario() + "', '"
                      + usuario.getSenha()   + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
}