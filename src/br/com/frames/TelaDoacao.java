package br.com.frames;

import br.com.Beans.Instituicao;
import br.com.Beans.UsuarioCad;
import br.com.classesDAO.DoacaoDAO;
import br.com.classesDAO.InstituicaoDAO;
import javax.swing.table.DefaultTableModel;


/**
 * @author Breno Baudeson
 * @author Camila França
 * @author Caio Magno
 * @author Felipe Rodrigues
 * @author Waismann Alves
 *
 * @version Beta v0.01
 */
public class TelaDoacao extends javax.swing.JFrame {

   
    public TelaDoacao() {
        initComponents();
        btDoar.setEnabled(false);
        populaTabela();
        
    }
    
    //Metodo Construtor que pega os valores de IDs para inserir na tabela Doação
    public TelaDoacao(int idU, int item){
        initComponents();
        populaTabela();
        this.idUser = idU;
        this.idItem = item;
        btDoar.setEnabled(true);
    }
    
    // Metodo Construtor que pega apenas o ID do usuário
    public TelaDoacao(int idU){
        initComponents();
        this.idUser = idU;
        btDoar.setEnabled(false);
        populaTabela();
    }
    
    // Variáveis e Objetos usados nesta classe
    UsuarioCad u = new UsuarioCad();
    InstituicaoDAO i = new InstituicaoDAO();
    DoacaoDAO d = new DoacaoDAO();
    int idUser;
    int idItem;
    
    

    //Metodo Responsavel por popular a JTable
    public void populaTabela(){
        
        DefaultTableModel modelo = (DefaultTableModel) this.tbInstituicao.getModel();
        modelo.setNumRows(0);
        InstituicaoDAO i = new InstituicaoDAO();
        
        
        for(Instituicao ins : i.listarInsDoa()){
            modelo.addRow(new Object [] {
                ins.getNome(),
                ins.getEmail()
            });
        }
    }
    
    
    // Metodo responsavel por pesquisar por uma instituicão na JTable
    public void pesquisaTb() {
        InstituicaoDAO i = new InstituicaoDAO();
        DefaultTableModel modelo = (DefaultTableModel) this.tbInstituicao.getModel();
        modelo.setNumRows(0);

        for (Instituicao in : i.pesquisa(txtInst.getText())) {
            modelo.addRow(new Object[]{
                in.getNome(),
                in.getEmail()
            });
        }
    }
    
    //Pegar email da tabela por ser único em cada instituição
    public String settar(){
       InstituicaoDAO i = new InstituicaoDAO();
        
     int set = tbInstituicao.getSelectedRow();
     String emailIns =  tbInstituicao.getModel().getValueAt(set, 0).toString();
     u.setEmail(tbInstituicao.getModel().getValueAt(set, 1).toString());
        
        return emailIns;
    }
    
    // Insere uma Doacão na Base de Dados
    public void insertDoa(){
        
        // Recuperando o ID da Instituicao
        int idI = i.recIdInst(u.getEmail());
        int idIt = d.recuperaIdI();
        d.fazerDoação(idIt, idUser, idI);
        System.out.println(idI + " instituicao " + idUser+ " user" + idIt+ " item");
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtInst = new javax.swing.JTextField();
        btDoar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbInstituicao = new javax.swing.JTable();
        btSelect = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Doação");

        jLabel6.setFont(new java.awt.Font("Savoye LET", 1, 36)); // NOI18N
        jLabel6.setText("Doação");

        jLabel1.setText("Instituição:");

        txtInst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInstActionPerformed(evt);
            }
        });
        txtInst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtInstKeyReleased(evt);
            }
        });

        btDoar.setText("Doar");
        btDoar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.setToolTipText("Cancelar Doação");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/doacao-de-sangue.png"))); // NOI18N

        tbInstituicao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbInstituicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbInstituicaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbInstituicao);

        btSelect.setText("Selecionar");
        btSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelectActionPerformed(evt);
            }
        });

        jLabel4.setText("Selecione os Itens para Doação:");

        jLabel5.setText("Doar PI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btDoar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 119, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btSelect)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtInst, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addContainerGap())))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtInst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSelect)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDoar)
                    .addComponent(btCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInstActionPerformed
    }//GEN-LAST:event_txtInstActionPerformed

    private void btSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelectActionPerformed
        // Chama a Tela de Selecão de Itens para Doar
        
        TelaDeSelecaoItens tela = new TelaDeSelecaoItens(idUser);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btSelectActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // Desiste da Doação
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void txtInstKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInstKeyReleased
        // // Evento do JTextField para buscar Instituição
        pesquisaTb();
    }//GEN-LAST:event_txtInstKeyReleased

    private void tbInstituicaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInstituicaoMouseClicked
        // Recupera o email da tabela Instituição ao clicar em um item dela
        settar();
        
    }//GEN-LAST:event_tbInstituicaoMouseClicked

    private void btDoarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoarActionPerformed
        // insere uma nova Doação no Banco de Dados chamando o método responsável
        insertDoa();
        
        // Chama a tela de todas as Doacões feitas para o usuário ver sua doção listada
        // dentre as doacões feitas
        TdsDoacoes tela = new TdsDoacoes(idUser);
        tela.setVisible(true);
        
        // Fecha a tela de Doação
        this.dispose();
    }//GEN-LAST:event_btDoarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDoacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDoacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDoacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDoacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDoacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btDoar;
    private javax.swing.JButton btSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbInstituicao;
    private javax.swing.JTextField txtInst;
    // End of variables declaration//GEN-END:variables
}
