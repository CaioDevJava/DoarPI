package br.com.frames;

import java.sql.*;
import br.com.conexao.ModuloConexao;
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
public class TelaLogin extends javax.swing.JFrame {

    // Objetos e Variáveis usados nesta Classe
    Connection con = null;
    PreparedStatement pst;
    ResultSet rs;
    int idP;
    String user, perfil;

    
    
    public TelaLogin() {
        initComponents();

        // Objeto que conecta a Base de dados
        con = ModuloConexao.conector();

        // Verificando a conexão com o Servidor de Banco de Dados
        // Caso esteja conectado aparecerá a imagem referente a conexao caso não exibira outra mensagem
        if (con != null) {
            lbStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/dbok.png")));
        } else {
            lbStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/error.png")));
        }
    }

    
    // Metodo Responsavel por logar no app ele confere se usuário e senha são iguais aos da base de dados
    public void login() {
        String sql = "SELECT p.idPessoas, p.nome, pr.user, pr.password, pr.tipo FROM pessoas AS p INNER JOIN profile as pr ON(idprofile = profile) WHERE pr.user = ? and pr.password = ?";
        int id = 0;

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, txtUser.getText());

            //Captura de Senha de forma mais segura
            String pass = new String(txtPass.getPassword());

            //Passando a Senha capturada acima para consulta
            pst.setString(2, pass);

            rs = pst.executeQuery();

            //Obtém o perfil correspondente ao usuario logado
            // Passando como parametro a colula que se encontra a informação do perfil
            if (rs.next()) {
                perfil = rs.getString(5);
                id = rs.getInt(1);
                user = rs.getString(2);

                System.out.println(perfil);
                if (perfil.equals("ADMIN")) {
                    JOptionPane.showMessageDialog(null, "Seja Bem-Vindo!");
                    
                    TelaPrincipal tela = new TelaPrincipal(id);
                    tela.setVisible(true);
                    TelaPrincipal.lblUser.setText(user + "!");
                   
                } else {
                    JOptionPane.showMessageDialog(null, "Seja Bem-Vindo!");
                    TelaPrincipal tela = new TelaPrincipal(id, user);
                    tela.setVisible(true);
                }

                //Fecha a tela de login
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    
    //Consulta no banco o nome do usuário e passa para o objeto Label
    public String usuario() {

        String sql = "SELECT p.nome, pr.user, pr.password, pr.tipo FROM pessoas AS p INNER JOIN profile as pr ON(idprofile = profile) WHERE pr.user = ? and pr.password = ?";
        String u = new String(txtPass.getPassword());

        con = ModuloConexao.conector();

        try {

            pst = con.prepareStatement(sql);
            pst.setString(1, txtUser.getText());
            pst.setString(2, u);
            rs = pst.executeQuery();

            u = rs.getString(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro em setLabel: " + e);
        }
        return u;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btAcessar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        btCad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/imagem_tela_login.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Savoye LET", 1, 36)); // NOI18N
        jLabel2.setText("Login");

        jLabel3.setText("Usuário:");

        jLabel4.setText("Senha:");

        btAcessar.setText("Acessar");
        btAcessar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAcessarMouseClicked(evt);
            }
        });
        btAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAcessarActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        jLabel5.setText("Status do Servidor:");

        btCad.setText("Cadastrar");
        btCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPass, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtUser)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btAcessar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btSair)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btCad, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(65, 65, 65)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAcessar)
                    .addComponent(btSair))
                .addGap(18, 18, 18)
                .addComponent(btCad)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAcessarActionPerformed
        // Evento do Botão Acessar que chama o método login para conferir se usuário e senha estão corretos
        login();
    }//GEN-LAST:event_btAcessarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // Sair da Aplicacão
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btAcessarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAcessarMouseClicked
        
    }//GEN-LAST:event_btAcessarMouseClicked

    private void btCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadActionPerformed
        // Evento que chama a tela de Cadastro de novo Usuário
        CadastroUser tela = new CadastroUser();
        tela.setVisible(true);

    }//GEN-LAST:event_btCadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAcessar;
    private javax.swing.JButton btCad;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
