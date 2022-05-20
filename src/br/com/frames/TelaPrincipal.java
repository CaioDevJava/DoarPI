package br.com.frames;

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
public class TelaPrincipal extends javax.swing.JFrame {

    
    
    public TelaPrincipal() {
        initComponents();

    }
    //  Caso o usuário seja um Administrador chama esse metódo
    public TelaPrincipal(int id) {
        initComponents();
        this.id = id;
        btValidar.setVisible(true);
        lbValidar.setVisible(true);
    }

    //Caso o usuário seja um usuário comum chama esse metodo
    public TelaPrincipal(int id, String nome) {
        initComponents();
        btValidar.setVisible(false);
        lbValidar.setVisible(false);
        lblUser.setText(nome);
        this.id = id;
        this.nome = nome;

    }
    
    // Variáveis que pegam o ID e o nome do usuário para passar pro JLabel da Tela Principal qual usuário está Logado
    int id = 0;
    String nome;

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btVDoacao = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btIndica = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btFazDoa = new javax.swing.JButton();
        btInsti = new javax.swing.JButton();
        btValidar = new javax.swing.JButton();
        lbValidar = new javax.swing.JLabel();
        btSobre = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        btSair = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Savoye LET", 1, 36)); // NOI18N
        jLabel3.setText("Tela Principal");

        jLabel4.setText("Seja bem vindo, ");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btVDoacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/doacao.png"))); // NOI18N
        btVDoacao.setToolTipText("Ver Doações feitas pelo App");
        btVDoacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btVDoacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVDoacaoActionPerformed(evt);
            }
        });

        jLabel5.setText("Ver Doações");

        btIndica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/Indicar.png"))); // NOI18N
        btIndica.setToolTipText("Indicar uma Instituição");
        btIndica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btIndica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIndicaActionPerformed(evt);
            }
        });

        jLabel6.setText("Indicar Instituição");

        jLabel1.setText("Instituições");

        jLabel2.setText("Fazer Doação");

        btFazDoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/doacao-de-sangue.png"))); // NOI18N
        btFazDoa.setToolTipText("Fazer uma doação para uma Instituição");
        btFazDoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btFazDoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFazDoaActionPerformed(evt);
            }
        });

        btInsti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/associacao-2.png"))); // NOI18N
        btInsti.setToolTipText("Ver Instituições Cadastradas");
        btInsti.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btInsti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInstiActionPerformed(evt);
            }
        });

        btValidar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/validando-tiquete.png"))); // NOI18N
        btValidar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValidarActionPerformed(evt);
            }
        });

        lbValidar.setText("Validar Instituição");

        btSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/about.png"))); // NOI18N
        btSobre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSobreActionPerformed(evt);
            }
        });

        jLabel7.setText("Sobre Nós");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel1)
                        .addGap(127, 127, 127)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btInsti, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel7)))
                                .addGap(84, 84, 84)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btFazDoa, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(89, 89, 89)
                                        .addComponent(btVDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbValidar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(67, 67, 67)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btIndica, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6)))
                .addGap(125, 125, 125))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btFazDoa, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(btIndica, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btVDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btInsti, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbValidar)
                    .addComponent(jLabel7))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        lblUser.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N

        btSair.setText("Sair");
        btSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(748, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btInstiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInstiActionPerformed
        // Chama a tela que lista todas as instituições cadastradas na base de dados
        TelaInstituicoes tela = new TelaInstituicoes(id);
        tela.setVisible(true);

    }//GEN-LAST:event_btInstiActionPerformed

    private void btFazDoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFazDoaActionPerformed
        // Chama a Tela para o Usuário fazer sua Doação
        TelaDoacao tela = new TelaDoacao(id);
        String u = lblUser.getText();
        tela.setVisible(true);


    }//GEN-LAST:event_btFazDoaActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // Ação do Botão Sair que faz o Usuário faz um Logoff
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Obrigado por usar o Doar PI!\nVolte sempre!");
            this.dispose();
            TelaLogin tela = new TelaLogin();
            tela.setVisible(true);
        }

    }//GEN-LAST:event_btSairActionPerformed

    private void btVDoacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVDoacaoActionPerformed
        // Ver Doações feitas na plataforma
        TdsDoacoes tela = new TdsDoacoes(id);
        tela.setVisible(true);
    }//GEN-LAST:event_btVDoacaoActionPerformed

    private void btIndicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIndicaActionPerformed
        //Chama uma tela onde o usuário preenche os dados da Instituição que ele deseja indicar
        TelaIndicInst tela = new TelaIndicInst();
        tela.setVisible(true);
    }//GEN-LAST:event_btIndicaActionPerformed

    private void btValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValidarActionPerformed
        // Chama a tela para um administrador validar uma instituição indicada pelo usuário
        TelaValidar tela = new TelaValidar();
        tela.setVisible(true);
    }//GEN-LAST:event_btValidarActionPerformed

    private void btSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSobreActionPerformed
        // Chama a tela Sobre que exibirá informações do App e dos desenvolvedores dele
        Sobre tela = new Sobre();
        tela.setVisible(true);
    }//GEN-LAST:event_btSobreActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFazDoa;
    private javax.swing.JButton btIndica;
    private javax.swing.JButton btInsti;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSobre;
    private javax.swing.JButton btVDoacao;
    private javax.swing.JButton btValidar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbValidar;
    public static javax.swing.JLabel lblUser;
    // End of variables declaration//GEN-END:variables
}
