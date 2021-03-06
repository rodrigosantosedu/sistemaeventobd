package controle;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConectaBanco {

    public Statement stm;//public para acessar em outras classes
    public ResultSet rs;//public para acessar em outras classes
    private final String driver = "oracle.jdbc.driver.OracleDriver";
    private final String caminho = "jdbc:oracle:thin:@grad.icmc.usp.br:15215:orcl";
    private final String usuario = "R10262461";
    private final String senha = "R10262461";
    public Connection conn;//public para acessar em outras classes
    public String error ="ok";
    public void conexao() { // metodo responsavel por realizar a conexao com o banco oracle
        try {
            System.setProperty("jdbc.Drivers", driver);// seta a propriedade do driver de conexao
            conn = DriverManager.getConnection(caminho, usuario, senha);// realiza conexao
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro de conexão com o banco de dados!\nTente Novamente! ");
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void executaSQL(String sql) {// esse método serve para executar strings sql 
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            if(e.getErrorCode()==2292){
                JOptionPane.showMessageDialog(null, "Esse linha é referenciada por outros cadastros e não pode ser apagado!");
                error = "error";
            }
        }

    }

    public void desconecta() {// esse metodo serve para desconectar o banco
        try {
            conn.close();
        } catch (SQLException ex) {
        }
    }

}
