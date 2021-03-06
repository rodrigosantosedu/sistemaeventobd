/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import modelo.ModeloContrato;
import modelo.ModeloEvento;
import modelo.ModeloTabela;
import controle.ConectaBanco;
import controle.ControleContrato;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author rodrigo
 */
public class FrmContrato extends javax.swing.JFrame {

    ConectaBanco conectaContrato = new ConectaBanco();
    String combinadata;

    public FrmContrato() {
        initComponents();
        conectaContrato.conexao();
        PreencherTabela("select *from contrato join atracao on atracao = cnpj order by eventodata desc");
        conectaContrato.executaSQL("select nome,data from evento");
        jComboBoxAtracao.removeAllItems();
        try {
            conectaContrato.rs.first();
            do {
                combinadata = "" + conectaContrato.rs.getString("nome") + "-" + conectaContrato.rs.getString("data") + "";
                jComboBoxEvento.addItem(combinadata);
            } while (conectaContrato.rs.next());
        } catch (SQLException ex) {
        }

        conectaContrato.executaSQL("select *from atracao");
        jComboBoxAtracao.removeAllItems();
        try {
            conectaContrato.rs.first();
            do {
                jComboBoxAtracao.addItem(conectaContrato.rs.getString("nome"));
            } while (conectaContrato.rs.next());
        } catch (SQLException ex) {
        }

    }

    public void PreencherTabela(String SQL) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Nome", "EventoNome", "EventoData", "ValorCache"}; // aqui são os nomes que irão aparecer nas colunas da tabela
        try {
            conectaContrato.executaSQL(SQL);
            conectaContrato.rs.first();
            do {
                dados.add(new Object[]{conectaContrato.rs.getString("NOME"), conectaContrato.rs.getString("EVENTONOME"), conectaContrato.rs.getString("EVENTODATA"), conectaContrato.rs.getString("VALORCACHE")});
            } while (conectaContrato.rs.next());
        } catch (SQLException ex) {
        }
        try {
            conectaContrato.executaSQL("select count(*) from contrato");
            conectaContrato.rs.first();
            jLabelNumContratos.setText("O número de contratos é: " + conectaContrato.rs.getNString(1));
            //JOptionPane.showMessageDialog(rootPane, conecta.rs.getNString(1));
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableContrato.setModel(modelo);
        jTableContrato.getColumnModel().getColumn(0).setPreferredWidth(125);
        jTableContrato.getColumnModel().getColumn(1).setPreferredWidth(125);
        jTableContrato.getColumnModel().getColumn(2).setPreferredWidth(125);
        jTableContrato.getColumnModel().getColumn(3).setPreferredWidth(125);
        jTableContrato.getTableHeader().setReorderingAllowed(false);
        jTableContrato.setAutoResizeMode(jTableContrato.AUTO_RESIZE_OFF);
        jTableContrato.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTableContrato = new javax.swing.JTable();
        jComboBoxAtracao = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxEvento = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCache = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonRefreshEvento = new javax.swing.JButton();
        jButtonAddEvento = new javax.swing.JButton();
        jLabelNumContratos = new javax.swing.JLabel();
        jButtonContratoSalvar = new javax.swing.JButton();
        jButtonAddAtracao = new javax.swing.JButton();
        jButtonRefreshAtracao = new javax.swing.JButton();
        jButtonContratoDelete = new javax.swing.JButton();
        jButtonContratoSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableContrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableContrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContratoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableContrato);

        jLabel5.setText("Atração");

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel1.setText("Formulário de Contrato");

        jLabel6.setText("Evento");

        jTextFieldCache.setBackground(new java.awt.Color(254, 254, 254));
        jTextFieldCache.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCacheActionPerformed(evt);
            }
        });

        jLabel4.setText("Cache");

        jButtonRefreshEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/refresh.png"))); // NOI18N
        jButtonRefreshEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshEventoActionPerformed(evt);
            }
        });

        jButtonAddEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jButtonAddEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddEventoActionPerformed(evt);
            }
        });

        jButtonContratoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save.png"))); // NOI18N
        jButtonContratoSalvar.setToolTipText("Salvar");
        jButtonContratoSalvar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jButtonContratoSalvarComponentMoved(evt);
            }
        });
        jButtonContratoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContratoSalvarActionPerformed(evt);
            }
        });

        jButtonAddAtracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jButtonAddAtracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAtracaoActionPerformed(evt);
            }
        });

        jButtonRefreshAtracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/refresh.png"))); // NOI18N
        jButtonRefreshAtracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshAtracaoActionPerformed(evt);
            }
        });

        jButtonContratoDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/garbage.png"))); // NOI18N
        jButtonContratoDelete.setToolTipText("Apagar");
        jButtonContratoDelete.setEnabled(false);
        jButtonContratoDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonContratoDeleteMouseClicked(evt);
            }
        });
        jButtonContratoDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContratoDeleteActionPerformed(evt);
            }
        });

        jButtonContratoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sign-out.png"))); // NOI18N
        jButtonContratoSair.setToolTipText("Apagar");
        jButtonContratoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContratoSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonRefreshEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonRefreshAtracao, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCache, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBoxEvento, 0, 327, Short.MAX_VALUE)
                                            .addComponent(jComboBoxAtracao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonAddEvento)
                                            .addComponent(jButtonAddAtracao)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(jLabel1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonContratoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonContratoDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonContratoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(317, 317, 317)
                                .addComponent(jLabelNumContratos, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 26, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxAtracao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAddAtracao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAddEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCache, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRefreshAtracao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRefreshEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonContratoDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(jButtonContratoSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonContratoSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabelNumContratos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCacheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCacheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCacheActionPerformed

    private void jButtonAddEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddEventoActionPerformed
        FrmEvento frm = new FrmEvento();
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddEventoActionPerformed

    private void jButtonRefreshEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshEventoActionPerformed
        conectaContrato.executaSQL("select nome,data from evento");
        jComboBoxEvento.removeAllItems();
        try {
            conectaContrato.rs.first();
            do {
                combinadata = "" + conectaContrato.rs.getString("nome") + "-" + conectaContrato.rs.getString("data") + "";
                jComboBoxEvento.addItem(combinadata);
            } while (conectaContrato.rs.next());
        } catch (SQLException ex) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRefreshEventoActionPerformed

    private void jButtonContratoSalvarComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jButtonContratoSalvarComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonContratoSalvarComponentMoved

    private void jButtonContratoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContratoSalvarActionPerformed
        String concatenada;
        String array[] = new String[2];
        ///try {
        ModeloContrato contrato = new ModeloContrato();
        conectaContrato.executaSQL("select cnpj from atracao where nome='" + jComboBoxAtracao.getSelectedItem() + "'");

        try {
            conectaContrato.rs.first();
            contrato.setAtracao(conectaContrato.rs.getNString("cnpj"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getErrorCode());
        }

        concatenada = (String) jComboBoxEvento.getSelectedItem();
        array = concatenada.split("-");
        contrato.setEventonome(array[0]);
        contrato.setEventodata(array[1]);
        contrato.setValorcache(jTextFieldCache.getText());
        ControleContrato control_contrato = new ControleContrato();
        control_contrato.InserirContrato(contrato);
        PreencherTabela("select *from contrato join atracao on atracao = cnpj order by eventodata desc");
    }//GEN-LAST:event_jButtonContratoSalvarActionPerformed

    private void jButtonAddAtracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAtracaoActionPerformed
        FrmAtracao frm = new FrmAtracao();
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddAtracaoActionPerformed

    private void jButtonRefreshAtracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshAtracaoActionPerformed
        conectaContrato.executaSQL("select *from atracao");
        jComboBoxAtracao.removeAllItems();
        try {
            conectaContrato.rs.first();
            do {
                jComboBoxAtracao.addItem(conectaContrato.rs.getString("nome"));
            } while (conectaContrato.rs.next());
        } catch (SQLException ex) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRefreshAtracaoActionPerformed

    private void jButtonContratoDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContratoDeleteActionPerformed
        String cnpj;
        try {
            conectaContrato.executaSQL("select *from atracao where nome='"+jTableContrato.getValueAt(jTableContrato.getSelectedRow(),0)+"'");
            conectaContrato.rs.first();
            cnpj =conectaContrato.rs.getNString("cnpj");
            conectaContrato.executaSQL("delete from contrato where atracao='"+cnpj+"'"
            + " and eventonome='"+jTableContrato.getValueAt(jTableContrato.getSelectedRow(),1)+"'"
            + " and eventodata='"+jTableContrato.getValueAt(jTableContrato.getSelectedRow(),2)+"'");
        } catch (SQLException ex2) {
            Logger.getLogger(FrmContrato.class.getName()).log(Level.SEVERE, null, ex2);
        }
        PreencherTabela("select *from contrato join atracao on atracao = cnpj order by eventodata desc");//atualiza tabela após mudança

    }//GEN-LAST:event_jButtonContratoDeleteActionPerformed

    private void jButtonContratoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContratoSairActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonContratoSairActionPerformed

    private void jButtonContratoDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonContratoDeleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonContratoDeleteMouseClicked

    private void jTableContratoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContratoMouseClicked
       jButtonContratoDelete.setEnabled(true);
    }//GEN-LAST:event_jTableContratoMouseClicked

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
            java.util.logging.Logger.getLogger(FrmContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmContrato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddAtracao;
    private javax.swing.JButton jButtonAddEvento;
    private javax.swing.JButton jButtonContratoDelete;
    private javax.swing.JButton jButtonContratoSair;
    private javax.swing.JButton jButtonContratoSalvar;
    private javax.swing.JButton jButtonRefreshAtracao;
    private javax.swing.JButton jButtonRefreshEvento;
    private javax.swing.JComboBox jComboBoxAtracao;
    private javax.swing.JComboBox jComboBoxEvento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelNumContratos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContrato;
    private javax.swing.JTextField jTextFieldCache;
    // End of variables declaration//GEN-END:variables
}
