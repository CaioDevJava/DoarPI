package br.com.conexao;

import java.sql.*;


/**
 * @author Breno Baudeson
 * @author Camila França
 * @author Caio Magno
 * @author Felipe Rodrigues
 * @author Waismann Alves
 *
 * @version Beta v0.01
 */

public class ModuloConexao {
    //Metodo responsavel por estabelecer conecao com o BD

         
    public static Connection conector() {
        Connection conexao = null;
        

        //A linha abaixo chama o driver
        final String driver = "com.mysql.cj.jdbc.Driver";
        // Armazenando informações referentes ao banco
        final String url = "jdbc:mysql://localhost:3306/DOARPI";
        String user = "root";
        String password = "Cm#210690";
        // Estabelecendo a Conexão com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
