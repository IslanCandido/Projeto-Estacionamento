package view;

import bll.PrecoBLL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Preco;

public class CadastroPreco extends javax.swing.JFrame {
    
    DefaultTableModel modelo = new DefaultTableModel();
    PrecoBLL precoBll = new PrecoBLL();
    Preco preco = new Preco();

    public CadastroPreco() {
        criarTabela();
        consultar();
        initComponents();
    }
    
    private void criarTabela() {
        tblPrecos = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Plano");
        modelo.addColumn("Tipo Veículo");
        modelo.addColumn("Preço");

        tblPrecos.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblPrecos.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblPrecos.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblPrecos.getColumnModel().getColumn(3).setPreferredWidth(30);

    }

    private void consultar() {

        modelo.setNumRows(0);
        List<Preco> lista = new ArrayList<Preco>();

        lista = precoBll.getConsulta();

        if (lista.size() > 0) {

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[]{lista.get(i).getCodigo(),
                    lista.get(i).getPlano(),
                    lista.get(i).getTipoVeiculo(),
                    lista.get(i).getPreco()});
            }
        } else {
            modelo.setNumRows(0);
        }

    }

    private void limparCampos() {
        preco = new Preco();
        txtPreco.setText("");
        cbxPlano.setSelectedIndex(0);
        cbxTipoVeiculo.setSelectedIndex(0);
        btnSalvar.setEnabled(true);
    }

    private void preencheCampos(int id) {
        preco = precoBll.getConsultaPorId(id);
        cbxPlano.setSelectedItem(preco.getPlano());
        cbxTipoVeiculo.setSelectedItem(preco.getTipoVeiculo());
        txtPreco.setText(String.valueOf(preco.getPreco()));        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxPlano = new javax.swing.JComboBox<>();
        cbxTipoVeiculo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTable1 = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPrecos = new javax.swing.JTable();
        txtPreco = new javax.swing.JTextField();
        jLabelTelaFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de preços");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Plano");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 32, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 50, 32, 28);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Preço");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 90, 40, 28);

        cbxPlano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Livre", "Diário", "Mensal", "Anual" }));
        getContentPane().add(cbxPlano);
        cbxPlano.setBounds(50, 10, 110, 30);

        cbxTipoVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Carro", "Moto" }));
        getContentPane().add(cbxTipoVeiculo);
        cbxTipoVeiculo.setBounds(50, 50, 110, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("R$");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 90, 15, 30);

        jTable1.setModel(modelo);
        getContentPane().add(jTable1);
        jTable1.setBounds(0, 0, 0, 0);

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(10, 140, 80, 30);

        btnExcluir.setBackground(new java.awt.Color(255, 255, 255));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExcluir.setText("Deletar");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(100, 140, 80, 30);

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(10, 180, 80, 30);

        btnLimpar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(100, 180, 80, 30);

        tblPrecos.setModel(modelo);
        tblPrecos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPrecosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPrecos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(190, 10, 310, 200);

        txtPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecoKeyTyped(evt);
            }
        });
        getContentPane().add(txtPreco);
        txtPreco.setBounds(50, 90, 90, 28);

        jLabelTelaFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Fundo Cadastro.jpg"))); // NOI18N
        getContentPane().add(jLabelTelaFundo);
        jLabelTelaFundo.setBounds(0, -10, 530, 440);

        setSize(new java.awt.Dimension(519, 250));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            preco.setPlano(cbxPlano.getSelectedItem().toString());
            preco.setTipoVeiculo(cbxTipoVeiculo.getSelectedItem().toString());
            preco.setPreco(Double.parseDouble(txtPreco.getText()));

            if (txtPreco.getText().isEmpty() || cbxPlano.getSelectedItem().equals("Selecione") || cbxTipoVeiculo.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            }
            else if(preco.getPreco() <= 0 || preco.getPreco()>5000){
                JOptionPane.showMessageDialog(rootPane, "PREÇO INVALIDO!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
            }
            else {
                    precoBll.adicionar(preco);
                    consultar();
                    limparCampos();
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            if (txtPreco.getText().isEmpty() || cbxPlano.getSelectedItem().equals("Selecione") || cbxTipoVeiculo.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            }
            precoBll.remover(precoBll.getConsultaPorId(preco.getCodigo()));
        } catch (Exception ex) {
            Logger.getLogger(CadastroProprietario.class.getName()).log(Level.SEVERE, null, ex);
        }
        consultar();
        limparCampos();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            preco.setPlano(cbxPlano.getSelectedItem().toString());
            preco.setTipoVeiculo(cbxTipoVeiculo.getSelectedItem().toString());
            preco.setPreco(Double.parseDouble(txtPreco.getText()));

            if (txtPreco.getText().isEmpty() || cbxPlano.getSelectedItem().equals("Selecione") || cbxTipoVeiculo.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                    precoBll.alterar(preco);
                    consultar();
                    limparCampos();
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void tblPrecosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrecosMouseClicked
        btnSalvar.setEnabled(false);
        int linha = tblPrecos.getSelectedRow();
        Integer codigo = (Integer) tblPrecos.getValueAt(linha, 0);
        preencheCampos((int) codigo);
    }//GEN-LAST:event_tblPrecosMouseClicked

    private void txtPrecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoKeyTyped
        Character ch = evt.getKeyChar();
        int comprimentoDeCampo = txtPreco.getText().length();
        if (comprimentoDeCampo >= 4) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "LIMITE DE 4 DIGITOS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }  
    }//GEN-LAST:event_txtPrecoKeyTyped

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
            java.util.logging.Logger.getLogger(CadastroPreco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPreco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPreco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPreco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPreco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxPlano;
    private javax.swing.JComboBox<String> cbxTipoVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelTelaFundo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblPrecos;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
