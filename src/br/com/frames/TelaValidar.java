
package br.com.frames;

import br.com.Beans.Instituicao;
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
public class TelaValidar extends javax.swing.JFrame {

    public TelaValidar() {
        initComponents();
        popularTb();
    }
    
    
    // Método Responsável por popular tabela das instituicões não Validadas
    public void popularTb(){
        DefaultTableModel modelo = (DefaultTableModel) this.tbInstVali.getModel();
        modelo.setNumRows(0);
        
        InstituicaoDAO ins = new InstituicaoDAO();
        
        for(Instituicao i : ins.populaValida()){
            modelo.addRow(new Object[]{
                i.getNome(),
                i.getEmail(),
                i.getDdd(),
                i.getContato(),
                i.getResp(),
                i.getStatus()
            });
        }
    }
    
    
    // Método Responsável por pegar um campo da Tabela selecionado pelo usuário
    // e retorna o ID da Instituicao
    private int settar_campos() {
        int setar = this.tbInstVali.getSelectedRow();
        InstituicaoDAO ins = new InstituicaoDAO();

        String email = tbInstVali.getModel().getValueAt(setar, 1).toString();
        int id = ins.recIdInst(email);
        
        return id;
    }
    
    // Método responsável por validar uma instituicão indicada por um usuário
    // Esse método esta disponivel apenas para usuários Administradores os Usuários comuns não tem
    // acesso a ele
    public void validar(){
       
        Instituicao in = new Instituicao();
        InstituicaoDAO ins = new InstituicaoDAO();
        int i = 0;
        in.setCod(settar_campos());
        ins.validar(in.getCod());
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbInstVali = new javax.swing.JTable();
        btValidar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Savoye LET", 1, 36)); // NOI18N
        jLabel1.setText("Validação de Instituição");

        jLabel2.setText("Doar PI");

        tbInstVali.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Instituição", "Email", "DDD", "Contato", "Responsável", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbInstVali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbInstValiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbInstVali);
        if (tbInstVali.getColumnModel().getColumnCount() > 0) {
            tbInstVali.getColumnModel().getColumn(2).setMinWidth(5);
            tbInstVali.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        btValidar.setText("Validar");
        btValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValidarActionPerformed(evt);
            }
        });

        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btValidar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFechar)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btValidar)
                    .addComponent(btFechar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        // Evento do Botao fechar da tela de validacão da Instituição
        this.dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void tbInstValiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInstValiMouseClicked
        // Evento que chama o metodo de setar um item da tabela para retornar o ID da instituição
        // esse ID é passado para o método validar()
       settar_campos();
    }//GEN-LAST:event_tbInstValiMouseClicked

    private void btValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValidarActionPerformed
        // Evento do botão de Validar uma instituicão chamando o método validar()
        validar();
        
        // Usa o método popularTb() para atualizar a tabela de Instituicões a serem validadas
        // Então é listada somente as Instituições não validadas
        popularTb();
    }//GEN-LAST:event_btValidarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaValidar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaValidar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaValidar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaValidar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaValidar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btValidar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbInstVali;
    // End of variables declaration//GEN-END:variables
}
