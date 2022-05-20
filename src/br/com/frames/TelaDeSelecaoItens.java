
package br.com.frames;

import br.com.Beans.ItensDoacao;
import br.com.classesDAO.DoacaoDAO;

/**
 * @author Breno Baudeson
 * @author Camila França
 * @author Caio Magno
 * @author Felipe Rodrigues
 * @author Waismann Alves
 *
 * @version Beta v0.01
 */
public class TelaDeSelecaoItens extends javax.swing.JFrame {

    // Declaração de Variáveis e Objetos usados nesta classe
     DoacaoDAO doa = new DoacaoDAO();
     ItensDoacao it = new ItensDoacao();
     int idU, idI;
     
     // Construtor Default
    public TelaDeSelecaoItens() {
        initComponents();
        cbTipoRoupa.setEnabled(false);
        txtDinheiro.setEnabled(false);
        cbTipoAlimento.setEnabled(false);
        cbTipoVoluntario.setEnabled(false);
        
    }
    
    // Construtor que passa o ID do Usuário que será usado para identificar
    //  o usuário que esta fazendo a doacão
    public TelaDeSelecaoItens(int idU) {
        initComponents();
        cbTipoRoupa.setEnabled(false);
        txtDinheiro.setEnabled(false);
        cbTipoAlimento.setEnabled(false);
        cbTipoVoluntario.setEnabled(false);
        this.idU = idU;
        
    }
    
    
    //  Método Responsável por inserir na Tabela de itens quais são os Itens
    // que estão sendo doados
    public void selecionaItens(){
        
        //Verificação se o item
        if(cbxRoupas.isSelected()){
            
            it.setRoupa(cbTipoRoupa.getSelectedItem().toString());
        }else{
            it.setRoupa(null);
        }
        
        //Verifica se tiver marcado a Caixa de Seleção
        //Se tiver Atribui o valor ao Objeto item
        if(cbxDinheiro.isSelected()){
            
            it.setDinheiro(Double.parseDouble(txtDinheiro.getText()));
        }else{
            it.setDinheiro(0.0f);
        }
        
        if(cbxAlimento.isSelected()){
            
            it.setAlimentacao(cbTipoAlimento.getSelectedItem().toString());
        }else{
            it.setAlimentacao(null);
        }
        
        if(cbxVoluntario.isSelected()){
            
            it.setServico(cbTipoVoluntario.getSelectedItem().toString());
        }else{
            it.setServico(null);
        }
        
        // Passa o Objeto com os Valores Obtidos para o metodo que insere no
        // banco de dados.
        
        doa.selecionaItem(it);
        idI = doa.recuperaIdI();
        
        // Instancia a tela de Doação
        TelaDoacao tela = new TelaDoacao(idU, idI);
        
        // Torna visível a tela de Doação
        tela.setVisible(true);
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxRoupas = new javax.swing.JCheckBox();
        cbxDinheiro = new javax.swing.JCheckBox();
        cbxAlimento = new javax.swing.JCheckBox();
        cbxVoluntario = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbTipoRoupa = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtDinheiro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbTipoAlimento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbTipoVoluntario = new javax.swing.JComboBox<>();
        btAddItem = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Itens");

        cbxRoupas.setText("Roupas");
        cbxRoupas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRoupasActionPerformed(evt);
            }
        });

        cbxDinheiro.setText("Dinheiro");
        cbxDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDinheiroActionPerformed(evt);
            }
        });

        cbxAlimento.setText("Alimentação");
        cbxAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAlimentoActionPerformed(evt);
            }
        });

        cbxVoluntario.setText("Serviço Voluntário");
        cbxVoluntario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxVoluntarioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Savoye LET", 0, 36)); // NOI18N
        jLabel1.setText("Selecione os Itens para Doação:");

        jLabel2.setText("Tipo:");

        cbTipoRoupa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blusa", "Agasalho", "Calça", "Bermuda" }));

        jLabel3.setText("Valor:");

        jLabel4.setText("Tipo:");

        cbTipoAlimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feijão", "Arroz", "Frutas", "Legumes" }));

        jLabel5.setText("Tipo:");

        cbTipoVoluntario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Limpeza", "Transporte", "Outro(s)" }));
        cbTipoVoluntario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoVoluntarioActionPerformed(evt);
            }
        });

        btAddItem.setText("Adicionar Itens");
        btAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddItemActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");

        jLabel6.setText("Doar PI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxAlimento)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btAddItem)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btCancelar))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbTipoRoupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(132, 132, 132))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(134, 134, 134)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbxDinheiro)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(5, 5, 5)
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cbTipoVoluntario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(cbxVoluntario))
                                    .addGap(22, 22, 22)))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbxRoupas))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cbxRoupas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbTipoRoupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cbxDinheiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxAlimento)
                    .addComponent(cbxVoluntario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cbTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbTipoVoluntario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAddItem)
                    .addComponent(btCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbTipoVoluntarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoVoluntarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoVoluntarioActionPerformed

    private void cbxRoupasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRoupasActionPerformed
        //Verificação se o item foi selecionado
        
        if(cbxRoupas.isSelected()){
            cbTipoRoupa.setEnabled(true);
        }else{
            cbTipoRoupa.setEnabled(false);
        }
    }//GEN-LAST:event_cbxRoupasActionPerformed

    private void cbxDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDinheiroActionPerformed
        //Verificação se o item foi selecionado
        
        if(cbxDinheiro.isSelected()){
            txtDinheiro.setEnabled(true);
        }else{
            txtDinheiro.setEnabled(false);
        }
    }//GEN-LAST:event_cbxDinheiroActionPerformed

    private void cbxAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAlimentoActionPerformed
        //Verificação se o item foi selecionado
      
        if(cbxAlimento.isSelected()){
            cbTipoAlimento.setEnabled(true);
        }else{
            cbTipoAlimento.setEnabled(false);
        }
    }//GEN-LAST:event_cbxAlimentoActionPerformed

    private void cbxVoluntarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxVoluntarioActionPerformed
        //Verificação se o item foi selecionado
            
        if(cbxVoluntario.isSelected()){
            cbTipoVoluntario.setEnabled(true);
        }else{
            cbTipoVoluntario.setEnabled(false);
        }
    }//GEN-LAST:event_cbxVoluntarioActionPerformed

    private void btAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddItemActionPerformed
        // Adiciona os itens na tabela itens chamando o método responsável por esta ação
        selecionaItens();
        this.dispose();
        
    }//GEN-LAST:event_btAddItemActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDeSelecaoItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeSelecaoItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeSelecaoItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeSelecaoItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeSelecaoItens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddItem;
    private javax.swing.JButton btCancelar;
    private javax.swing.JComboBox<String> cbTipoAlimento;
    private javax.swing.JComboBox<String> cbTipoRoupa;
    private javax.swing.JComboBox<String> cbTipoVoluntario;
    private javax.swing.JCheckBox cbxAlimento;
    private javax.swing.JCheckBox cbxDinheiro;
    private javax.swing.JCheckBox cbxRoupas;
    private javax.swing.JCheckBox cbxVoluntario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtDinheiro;
    // End of variables declaration//GEN-END:variables
}
