
package br.com.classesDAO;

import br.com.Beans.Endereco;
import br.com.Beans.Instituicao;
import br.com.Beans.UsuarioCad;
import java.util.ArrayList;
import br.com.conexao.ModuloConexao;
import java.sql.*;
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
public class InstituicaoDAO {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public ArrayList<Instituicao> listar() {
        
        ArrayList<Instituicao> i = new ArrayList<>();
        
        String sql = "select i.nome, p.nome from instituicao AS i INNER JOIN pessoas AS p ON (i.Iresponsavel = p.idPessoas) ";
        
        // Inicia a conexao
        con = ModuloConexao.conector();
        
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                
                Instituicao ins = new Instituicao();
                ins.setNome(rs.getString("i.nome"));
                ins.setResp(rs.getString("p.nome"));
                i.add(ins);
            }
            
            //Encerra conexao para liberar Recursos
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Carregar Tabela Instituicões " + e);
        }
        
        return i;
    }
    
        // Metodo Responsável por Listar as Instituicões Validas para o usuário fazer a Doacão
        public ArrayList<Instituicao> listarInsDoa() {
        
        ArrayList<Instituicao> i = new ArrayList<>();
        
        String sql = "SELECT nome, email FROM instituicao WHERE status = 'VALIDADO'";
        
        // Inicia a conexao
        con = ModuloConexao.conector();
        
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                
                Instituicao ins = new Instituicao();
                ins.setNome(rs.getString("nome"));
                ins.setEmail(rs.getString("email"));
                
                i.add(ins);
            }
            
            //Encerra conexao para liberar Recursos
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Carregar Tabela Instituicões " + e);
        }
        
        
        return i;
    }
    
        /*
            Metodo usado para o recuperar a descricão da Instituicao
        */
   public String descricao(int i){
        
        String sql = "SELECT descricao FROM instituicao WHERE idInstituicao = ?";
        String desc = new String();
        ArrayList<String> ins = new ArrayList<>();
        
        con = ModuloConexao.conector();
        
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, i);
            rs = pst.executeQuery();
            
            while(rs.next()){
                Instituicao in = new Instituicao();
                in.setNome(rs.getString("descricao"));
                desc = in.getNome();
                ins.add(desc);
            }
            
            con.close();
            pst.close();
            
        }catch(SQLException ex){
            
        }
        return desc;
    }
    
    // Pesquisa por uma instituicao pelo nome
    //Metodo usado na JTextField da Tela de Doações
    public ArrayList<Instituicao> pesquisa(String p){
        ArrayList<Instituicao> ins = new ArrayList<>();
        
        String sql = "SELECT nome, email FROM instituicao where nome like ?";
        
        con = ModuloConexao.conector();
        
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, "%" + p + "%");
            rs = pst.executeQuery();
            
            while(rs.next()){
                
                Instituicao i = new Instituicao();
                
                i.setNome(rs.getString("nome"));
                i.setEmail(rs.getString("email"));
                ins.add(i);
            }
            
            con.close();
            pst.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Pesquisar instituição" + ex);
        }
        
        
        return ins;
    }
    
    // Recupera o ID da instituicao selecionada pelo usuário para efetuar a doação
    
    /* Metodo usado para a tela de doação para inserir na tabela de doação qual instituição
    * o usuário escolheu
    */
    public int recIdInst(String email){
        String sql = "SELECT idInstituicao FROM instituicao WHERE email = ?";
        int id = 0;
        
        con = ModuloConexao.conector();
        
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();
            
            while(rs.next()){

                Instituicao i = new Instituicao();
                id = rs.getInt("idInstituicao");
                
            }
            
            con.close();
            pst.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ID instituição" + ex);
        }
        
        
        return id;
    }
    
    
    // Método usado quando tem o id do usuário
    public void IndicaInst(Instituicao i, int idE, int idT, int idU){
                //Inserir telefone do usuário ao banco
        String sqlTel = "INSERT INTO instituicao (nome, Iendereco, Iresponsavel,Itelefone, email, status ) values (? , ?, ?, ?, ?, ?)";
        con = ModuloConexao.conector();
        String status = "NÃO VALIDADO";
        
        
        
        try{
            pst = con.prepareStatement(sqlTel);
            pst.setString(1, i.getNome());
            pst.setInt(2, idE);
            pst.setInt(3, idU);
            pst.setInt(4, idT);
            pst.setString(5, i.getEmail());
            pst.setString(6, status);
            
            
            int info = pst.executeUpdate();
            
            if(info>0){
                JOptionPane.showMessageDialog(null, "Indicação feita com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi Possivel adicionar sua Indicação!");
            }
            
            con.close();
            pst.close();
             
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir Instituicao1 no banco " + ex);
            
        }
    }
    
    
    // Método usado quando não tem ID do usuário
     public void IndicaInst(Instituicao i, int idE, int idT){
                //Inserir telefone do usuário ao banco
        String sqlTel = "INSERT INTO instituicao (nome, Iendereco, Iresponsavel,Itelefone, email, status ) values (? , ?, ?, ?, ?, ?)";
        con = ModuloConexao.conector();
        String status = "NÃO VALIDADO";
        
        
        try{
            pst = con.prepareStatement(sqlTel);
            
            pst.setString(1, i.getNome());
            pst.setInt(2, idE);
            pst.setInt(3, 29);
            pst.setInt(4, idT);
            pst.setString(5, i.getEmail());
            pst.setString(6, status);
            
            
            int info = pst.executeUpdate();
            
            if(info>0){
                JOptionPane.showMessageDialog(null, "Indicação feita com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi Possivel adicionar sua Indicação!");
            }
            
            con.close();
            pst.close();
             
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir Instituicao no banco " + ex);
            
        }
    }
    
       //Metodo para cadastrar novo usuário
    public void cadastrarUser(Endereco e, UsuarioCad u, int idEnd, int idT){
        
        //Inserir os dados pessoais do Usuário ao Banco
        String sqlUser = "INSERT INTO PESSOAS ( nome, pendereco, ptelefone,  email, nascimento, doacao) VALUES ( ?,?,?,?,?,?)";
        
        try{
            con = ModuloConexao.conector();
            pst = con.prepareStatement(sqlUser);
            
            pst.setString(1, u.getNome());
            pst.setInt(2, idEnd);
            pst.setInt(3, idT);
            
            pst.setString(5, u.getEmail());
            pst.setString(6, u.getData());
            pst.setInt(7, 0);
            
            //Se o usuário for cadastrado com sucesso
            //Exibira uma caixa de mensagem informando
            int info = pst.executeUpdate();
            if(info>0){
                JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Usuário não pode ser cadastrado!");
            }

            // Fechando conexão com o Banco de Dados
            con.close();
            pst.close();
            
            
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro ao inserir usuário ao banco " + ex); 
        }
        
    }
    
    
    //Popula a JTable da tela de validação da Instituição
    
    public ArrayList<Instituicao> populaValida(){
        
        String sql = "SELECT i.nome, i.email, t.ddd, t.numero, p.nome, i.status FROM instituicao AS i INNER JOIN telefone AS t ON(Itelefone = idTelefone) INNER JOIN pessoas AS p ON(idPessoas = Iresponsavel) WHERE status = 'NÃO VALIDADO'";
       
        ArrayList<Instituicao> ins = new ArrayList<>();

        con = ModuloConexao.conector();
        
        try{
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                
                Instituicao i = new Instituicao();
                
                i.setNome(rs.getString("i.nome"));
                i.setDdd(rs.getString("t.ddd"));
                i.setContato(rs.getString("t.numero"));
                i.setEmail(rs.getString("i.email"));
                i.setResp(rs.getString("p.nome"));
                i.setStatus(rs.getString("i.status"));
                ins.add(i);
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Popular Tabela " + ex);
        }
        
        
        return ins;
    }
    
    
        //Validar uma Instituição
        public ArrayList<Instituicao> validar(int id){
        
        String sql = "UPDATE instituicao SET status = 'VALIDADO' WHERE idInstituicao = ?";
       
        ArrayList<Instituicao> ins = new ArrayList<>();

        con = ModuloConexao.conector();
        
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            int info = pst.executeUpdate();
            
            // Caso de Sucesso ou de Erro
            if(info>0){
                JOptionPane.showMessageDialog(null, "Instituição Validada com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível validar a Instituição!");
            }
        }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, "Validar instituição" + ex);   
        }
        
        
        return ins;
    }
    
}
