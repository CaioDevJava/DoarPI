package br.com.classesDAO;

import br.com.Beans.Doacao;
import br.com.Beans.Instituicao;
import br.com.Beans.ItensDoacao;
import br.com.conexao.ModuloConexao;
import java.sql.*;
import java.util.ArrayList;
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
public class DoacaoDAO {

    // Objetos para Manipular a Base de Dados
    ResultSet rs;
    Connection con;
    PreparedStatement pst;

    
    
    //Metodo responsavel por cadastrar uma doação
    public void fazerDoação(int itens, int usuario, int instituicao) {
        String sql = "INSERT INTO doacao (itens, doador, instituicao) VALUES (?, ?, ?)";

        //Objeto para conectar ao Banco de Dados
        con = br.com.conexao.ModuloConexao.conector();
        try {

            //Objeto que pega a string com o camando SQL e executa a inserção no Banco de Dados
            pst = con.prepareStatement(sql);

            //Cada objeto desse pega o valor que contem em cada variavel e insere no banco suas informações
            pst.setInt(1, itens);
            pst.setInt(2, usuario);
            pst.setInt(3, instituicao);

            int info = pst.executeUpdate();

            if (info > 0) {
                JOptionPane.showMessageDialog(null, "Doação Feita com Sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao fazer doação!");
            }

            con.close();
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na classe DOACAO: " + e);
        }

    }

    
    
    //Metodo para Cancelar a Doação
    public void cancelarDoacao(Doacao doacao, Instituicao instituicao) {

        // Variavel capta a escolha do usuário
        int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir essa doação?", "Atenção!", JOptionPane.YES_NO_OPTION);

        // Se o valor recebido pela variavel for igual a "zero", ou seja, o usuario escolheu a opção sim
        // Entra no "IF"
        if (opcao == JOptionPane.YES_OPTION) {

            //Comando SQL para deleter uma doação
            String sql = "DELETE FROM DOACAO WHERE idDOCAO = ?";

            //Objeto responsavel pela conexão com a Base de Dados
            con = br.com.conexao.ModuloConexao.conector();
            try {

                //Objeto responsavel por executar a sentença SQL
                pst = con.prepareStatement(sql);

                // Comando que substitui a Interrogação pelo valor da Variável
                pst.setInt(1, doacao.getId());

                // A variavel info pega o valor retornado pelo objeto "PST" responsável por executa a sentença SQL
                // Sendo que se for maior que 0 a sentença foi executada com sucesso caso contrario deu erro!
                int info = pst.executeUpdate();

                if (info > 0) {
                    JOptionPane.showMessageDialog(null, "Doação Cancelada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cancelar doação!");
                }

                con.close();
                pst.close();
                // Pega a excessão e retorna o motivo do erro
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao cancelar Doacão: " + e);
            }
        }

    }

    
    
    // Metodo para Inserir os itens da doação
    public void selecionaItem(ItensDoacao it) {
        String sql = "INSERT INTO ITENS ( roupa, alimentos, dinheiro, servico ) VALUES (?,?,?,?)";
        int cod = 0;

        try {
            con = br.com.conexao.ModuloConexao.conector();
            pst = con.prepareStatement(sql);

            pst.setString(1, it.getRoupa());
            pst.setString(2, it.getAlimentacao());
            pst.setDouble(3, it.getDinheiro());
            pst.setString(4, it.getServico());

            int info = pst.executeUpdate();

            if (info > 0) {
                JOptionPane.showMessageDialog(null, "Item(s) adicionado(s) com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao adicionar Item(s)");
            }
            
            con.close();
            pst.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir itens: " + e);
        } finally {

        }
    }

    
    //RECUPERA O ID DOS ITENS INSERIOS
    public int recuperaIdI() {
        // Recuperar ID dos Itens
        String sql = "select MAX(idItens) from itens;";
        int cod = 0;

        con = ModuloConexao.conector();

        try {
            pst = con.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {

                cod = rs.getInt("MAX(idItens)");
            }
            System.out.println(cod);

            con.close();
            pst.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir itens: " + e);
        } finally {

        }

        // retorna o ID da Doação
        return cod;
    }

    
    //Metodo para listar as Doações feitas na plataforma buscando da Base de Dados e populando a JTable 
    //da tela de TdsDoacoes
    public ArrayList<Doacao> listarDoacao() {
        
        String sql = "SELECT i.nome AS Instituição, p.nome AS Doador, it.roupa AS Roupas, it.alimentos AS Alimento, it.dinheiro AS Dinheiro, it.servico AS Serviço, d.data AS Data FROM doacao AS d JOIN instituicao AS i ON(d.instituicao = i.idInstituicao) INNER JOIN pessoas AS p ON(d.doador = p.idPessoas) INNER JOIN itens AS it ON(d.itens = it.idItens) ORDER BY D.DATA DESC";
        ArrayList<Doacao> d = new ArrayList<>();

        con = ModuloConexao.conector();

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Doacao doa = new Doacao();
                doa.setInsti(rs.getString("Instituição"));
                doa.setUs(rs.getString("Doador"));
                doa.setRoupa(rs.getString("Roupas"));
                doa.setAlimento(rs.getString("Alimento"));
                doa.setDinheiro(rs.getDouble("Dinheiro"));
                doa.setServivo(rs.getString("Serviço"));
                doa.setData(rs.getString("Data"));
                d.add(doa);
            }

            con.close();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {

        }
        return d;
    }
}
