/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DebitController;
import dao.DBException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.DebitsView;
import javax.swing.table.DefaultTableModel;
import model.Debits;
import model.Utils;

/**
 *
 * @author jairo
 */
public class DebitsView extends javax.swing.JFrame {

    /**
     * Creates new form ProviderView
     */
    private DebitController controlador;
    
    public DebitsView() throws DBException {
        initComponents();
        
        this.setLocationRelativeTo(null);

        this.controlador = new DebitController();

        preencheTabela();
    }
    
    
    public void preencheTabela() {

        for (int i = 0; i < this.controlador.getDebitList().size(); i++) {

            ((DefaultTableModel) this.DebitTable.getModel()).addRow(
                    new Object[]{
                        this.controlador.getDebitList().get(i).getDescription(),
                        Utils.formatarData(this.controlador.getDebitList().get(i).getBuy_date()),
                        Utils.formatarData(this.controlador.getDebitList().get(i).getBuy_date()),
                        this.controlador.getDebitList().get(i).getValue(),
                        this.controlador.getDebitList().get(i).getValue_paid(),
                        this.controlador.getDebitList().get(i).isPaid_out(),
                        this.controlador.getDebitList().get(i).getNote(),
                        this.controlador.getDebitList().get(i).getFornecedores_id(),
                  }
            );
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DebitTable = new javax.swing.JTable();
        ButtonDelete = new javax.swing.JToggleButton();
        ButtonBack = new javax.swing.JToggleButton();
        ButtonEdit = new javax.swing.JToggleButton();
        Title = new javax.swing.JLabel();
        ButtonNew = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        DebitTable.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        DebitTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descrição", "Data de Compra", "Data de Vencimento", "Valor", "Valor Pago", "Pago", "Observação", "Fornecedores"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DebitTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(DebitTable);

        ButtonDelete.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        ButtonDelete.setText("Excluir");
        ButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteActionPerformed(evt);
            }
        });

        ButtonBack.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        ButtonBack.setText("Voltar");
        ButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackActionPerformed(evt);
            }
        });

        ButtonEdit.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        ButtonEdit.setText("Editar");
        ButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditActionPerformed(evt);
            }
        });

        Title.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        Title.setText("Debitos:");

        ButtonNew.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        ButtonNew.setText("Novo");
        ButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(ButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonNew, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(Title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(Title)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonDelete)
                    .addComponent(ButtonEdit)
                    .addComponent(ButtonBack)
                    .addComponent(ButtonNew))
                .addGap(19, 19, 19))
        );

        setSize(new java.awt.Dimension(972, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  
    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonDeleteActionPerformed

    private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
        FMenu menuScreen  = new FMenu();
        
        menuScreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_ButtonBackActionPerformed

    private void ButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditActionPerformed
     
        EditDebitsView editScreen = null;
        
        try {
            editScreen = new EditDebitsView();
        } catch (DBException ex) {
            Logger.getLogger(DebitsView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        editScreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_ButtonEditActionPerformed

    private void ButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNewActionPerformed
        RegisterDebitsView registerScreen = null;
        try {
            registerScreen = new RegisterDebitsView();
        } catch (DBException ex) {
            Logger.getLogger(DebitsView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        registerScreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_ButtonNewActionPerformed

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
            java.util.logging.Logger.getLogger(DebitsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DebitsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DebitsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DebitsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DebitsView().setVisible(true);
                } catch (DBException ex) {
                    Logger.getLogger(DebitsView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ButtonBack;
    private javax.swing.JToggleButton ButtonDelete;
    private javax.swing.JToggleButton ButtonEdit;
    private javax.swing.JToggleButton ButtonNew;
    private javax.swing.JTable DebitTable;
    private javax.swing.JLabel Title;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
