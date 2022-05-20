package br.com.classesDAO;

import br.com.Beans.Endereco;
import java.sql.*;
import br.com.conexao.ModuloConexao;
import java.util.ArrayList;
import br.com.Beans.UsuarioCad;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Breno Baudeson
 * @author Camila França
 * @author Caio Magno
 * @author Felipe Rodrigues
 * @author Waismann Alves
 *
 * @version Beta v0.01
 */
public class UserCadDAO {

    
    // Objetos usados nesta Classe
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    ArrayList<UsuarioCad> user = new ArrayList<>();

    /*----------------------------------------------------------------------------------------
    //Metodo Responsável por Validar o Login
    // As Strings dos parâmetros são o que o usuário digitou para fazer o Login
    ----------------------------------------------------------------------------------------*/
    public ArrayList<UsuarioCad> login(String us, String ps) {

        String sql = "SELECT user, password FROM profile WHERE user = ? AND password = ?";
        UsuarioCad u = new UsuarioCad();

        // Objeto conexão obtendo conexão com a Base de Dados
        conexao = ModuloConexao.conector();

        //Tratamento de Excessão
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            //Obtendo o Login e a Senha do Banco de Dados
            while (rs.next()) {
                u.setLogin(rs.getString(1));
                u.setSenha(rs.getString(2));
                user.add(u);
            }

            //Verificacão se o usuário e a senha estao corretos
            if (us.equals(u.getLogin()) && ps.equals(u.getSenha())) {
                JOptionPane.showMessageDialog(null, "Acesso Concedido!");
            } else {
                JOptionPane.showMessageDialog(null, "Acesso Negado!\nUsuário ou Senha incorretos");
            }
            
            conexao.close();
            pst.close();

            //Pegando uma Excessão e exibindo qual erro caso ocorra
        } catch (SQLException ex) {
            Logger.getLogger(UserCadDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }

        // Retornando para fora do método os dados coletados no Banco de Dados
        return user;
    }

    /*----------------------------------------------------------------------------------------
    // Metodo para pegar o ID da tabela Estado
    ----------------------------------------------------------------------------------------*/
    public int idEstado(String est) {
        //Pega o ID do estado que esta sendo inserido para atribuir ao usuário cadastrado
        String sql = "SELECT idEstado, estado FROM estado where estado = ? ORDER BY estado";
        int end = 0;

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, est);

            rs = pst.executeQuery();
            while (rs.next()) {
                Endereco e = new Endereco();
                e.setId(rs.getInt(1));
                end = e.getId();

            }

            conexao.close();
            pst.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar estado no banco " + ex);
            
        }

        return end;
    }

    /*----------------------------------------------------------------------------------------
    //Pega o ID do endereço que esta sendo inserido para atribuir ao usuário
    ----------------------------------------------------------------------------------------*/
    public int idEndereco() {

        String sql = "SELECT MAX(idEndereco) FROM endereco";
        int id = 0;

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {
                UsuarioCad u = new UsuarioCad();
                u.setCod(rs.getInt("MAX(idEndereco)"));
                id = rs.getInt("MAX(idEndereco)");
            }

            conexao.close();
            pst.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Recuperar IDEndereco " + ex);
        }
        return id;
    }

    /*----------------------------------------------------------------------------------------
    //Recuperar o ID do telefone inserido
    ----------------------------------------------------------------------------------------*/
    public int idTelefone() {

        String sqlTelC = "SELECT MAX(idTelefone) FROM telefone";
        int id = 0;

        try {

            //Pega o ID do telefone indicado pelo Usuário
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sqlTelC);

            rs = pst.executeQuery();

            while (rs.next()) {
                id = rs.getInt("MAX(idTelefone)");
            }

            conexao.close();
            pst.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar idTelefone " + ex);
        }
        return id;
    }

    /*----------------------------------------------------------------------------------------
    //Metodo para retornar a PK do Profile
    ----------------------------------------------------------------------------------------*/
    public int idProfile(String us) {
        String sqlProfC = "SELECT idProfile FROM profile where user = ?";
        int id = 0;

        try {
            conexao = ModuloConexao.conector();

            pst = conexao.prepareStatement(sqlProfC);
            pst.setString(1, us);
            rs = pst.executeQuery();

            while (rs.next()) {
                id = rs.getInt("idProfile");
            }

            conexao.close();
            pst.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o perfil do usuário ao banco " + ex);
        }
        return id;
    }

    /*----------------------------------------------------------------------------------------
    // Metodo para Cadastrar novo Telefone
    ----------------------------------------------------------------------------------------*/
    public void insertTel(String cod, String ddd, String num) {
        //Inserir telefone do usuário ao banco
        String sqlTel = "INSERT INTO TELEFONE ( cod_pais, ddd, numero) VALUES ( ?, ?, ?)";
        conexao = ModuloConexao.conector();

        try {
            pst = conexao.prepareStatement(sqlTel);
            pst.setString(1, cod);
            pst.setString(2, ddd);
            pst.setString(3, num);

            int info = pst.executeUpdate();

            if (info > 0) {
                JOptionPane.showMessageDialog(null, "Telefone inserido");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi Possivel adicionar o Telefone!");
            }

            conexao.close();
            pst.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir telefone no banco " + ex);
        }
    }

    /*----------------------------------------------------------------------------------------
    //Metodo para Cadastrar novo Usuário e Senha
    ----------------------------------------------------------------------------------------*/
    public void insertProf(String l, String s) {
        //Inserir o profile do usuário ao banco
        String sqlProf = "INSERT INTO profile ( user, password) VALUES ( ?, ?)";

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sqlProf);
            pst.setString(1, l);
            pst.setString(2, s);

            pst.executeUpdate();

            conexao.close();
            pst.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o perfil do usuário ao banco " + ex);
        }
    }

    /*----------------------------------------------------------------------------------------
    //Metodo para cadastrar novo endereço
    ----------------------------------------------------------------------------------------*/
    public void insertEnd(String r, int n, String b, String c, int e) {
        // Inserir Endereco do usuário ao banco
        String sqlEnd = "INSERT INTO endereco (idEndereco, rua, numero, bairro, cidade, estado) VALUES (default, ?, ?, ?, ?, ?)";
        int id = 0;
        
        conexao = ModuloConexao.conector();
        try {
            pst = conexao.prepareStatement(sqlEnd);
            pst.setString(1, r);
            pst.setInt(2, n);
            pst.setString(3, b);
            pst.setString(4, c);
            pst.setInt(5, e);

            int info = pst.executeUpdate();

            conexao.close();
            pst.close();

            if (info > 0) {
                JOptionPane.showMessageDialog(null, "Endereço inserido");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi Possivel adicionar o Endereço!");
            }
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir endereço no banco " + ex);
        }
       
    }

    /*----------------------------------------------------------------------------------------*/
    //Metodo para cadastrar novo usuário completo com usuário e senha
    public void cadastrarUser(Endereco e, UsuarioCad u, int idEnd, int idP, int idT) {

        //Inserir os dados pessoais do Usuário ao Banco
        String sqlUser = "INSERT INTO PESSOAS (idpessoas, nome, pendereco, ptelefone, profile, email, nascimento, doacao) VALUES (default, ?,?,?,?,?,?,?)";

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sqlUser);

            pst.setString(1, u.getNome());
            pst.setInt(2, idEnd);
            pst.setInt(3, idT);
            pst.setInt(4, idP);
            pst.setString(5, u.getEmail());
            pst.setString(6, u.getData());
            pst.setInt(7, 0);

            //Se o usuário for cadastrado com sucesso
            //Exibira uma caixa de mensagem informando
            int info = pst.executeUpdate();
            if (info > 0) {
                JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não pode ser cadastrado!");
            }

            // Fechando conexão com o Banco de Dados
            conexao.close();
            pst.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir usuário ao banco " + ex);
        }

    }

    //Metodo para cadastrar novo usuário quando não tem usuário e senha
    // usado para indicar o responsável de uma instituição
    public int cadastrarUser(Endereco e, UsuarioCad u, int idEnd, int idT) {

        //Inserir os dados pessoais do Usuário ao Banco
        String sqlUser = "INSERT INTO PESSOAS (nome, pendereco, ptelefone, email, nascimento, doacao) VALUES (?,?,?,?,?,?)";
        int id = 0;
        
        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sqlUser);

            pst.setString(1, u.getNome());
            pst.setInt(2, idEnd);
            pst.setInt(3, idT);
            pst.setString(4, u.getEmail());
            pst.setString(5, u.getData());
            pst.setInt(6, 0);
            
            

            //Se o usuário for cadastrado com sucesso
            //Exibira uma caixa de mensagem informando
            int info = pst.executeUpdate();
            if (info > 0) {
                JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não pode ser cadastrado!");
            }
            
            String sql_ = "SELECT MAX(idPessoas) from Pessoas";
            
            pst = conexao.prepareStatement(sql_);
            rs = pst.executeQuery();
            
            while(rs.next()){
                id = rs.getInt("MAX(idPessoas)");
            }

            // Fechando conexão com o Banco de Dados
            conexao.close();
            pst.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir usuário ao banco " + ex);
        }
        return id;
    }
    
    

    /*----------------------------------------------------------------------------------------
    // Carrega todos os estados do Banco de Dados para popular o ComboBox referente a Estado
    ----------------------------------------------------------------------------------------*/
    public ArrayList<String> estado() {

        String sql = "SELECT estado FROM estado ORDER BY estado";
        ArrayList<String> estado = new ArrayList<>();

        conexao = ModuloConexao.conector();
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String e = rs.getString("estado");
                estado.add(e);
            }

            conexao.close();
            pst.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar Estados: " + e);
        }

        return estado;
    }
    
    
    // Método usado para recuperar o ID do usuário
    public int recuperaIdU(String email) {
        String sql = "SELECT idPessoas FROM pessoas WHERE email = ?";
        int id = 0;

        conexao = ModuloConexao.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();

            while (rs.next()) {

                id = rs.getInt("idPessoas");
            }

            conexao.close();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("pesquisa usuario" + ex);
        }

        return id;
    }

}
