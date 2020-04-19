/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bll.VeiculoBLL;
import dal.PrecoDAL;
import dal.ProprietarioDAL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Preco;
import model.Proprietario;
import model.Veiculo;


public class CadastroVeiculo extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    VeiculoBLL veiculoBll = new VeiculoBLL();
    Veiculo veiculo = new Veiculo();

    /**
     * Creates new form CadastroVeiculo
     */
    public CadastroVeiculo() {
        Criartabela();
        Consultar();
        initComponents(); 
        preencherCbx();
    }
    
    private void Criartabela() {
        tblVeiculos = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Placa");
        modelo.addColumn("Modelo");
        modelo.addColumn("Cor");
        modelo.addColumn("Proprietário");
        modelo.addColumn("Plano");

        tblVeiculos.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblVeiculos.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblVeiculos.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblVeiculos.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblVeiculos.getColumnModel().getColumn(4).setPreferredWidth(30);
        tblVeiculos.getColumnModel().getColumn(5).setPreferredWidth(30);
    }

    private void Consultar() {

        modelo.setNumRows(0);
        List<Veiculo> lista = new ArrayList<Veiculo>();

        lista = veiculoBll.getConsulta();

        if (lista.size() > 0) {

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[]{lista.get(i).getCodigo(),
                    lista.get(i).getPlaca(),
                    lista.get(i).getModelo(),
                    lista.get(i).getCor(),
                    lista.get(i).getIdPropietario(),
                    lista.get(i).getIdPreco()});
            }
        } else {
            modelo.setNumRows(0);
        }

    }
    
    private void LimparCampos() {
        veiculo = new Veiculo();
        
        txtPlaca.setValue("");
        txtModelo.setText("");
        txtCor.setText("");
        cbxIdPlano.setSelectedIndex(0);
        cbxIdProprietario.setSelectedIndex(0);
    }

    private void PreencheCampos(int id) {
        veiculo = veiculoBll.getConsultaPorId(id);
        txtPlaca.setText(veiculo.getPlaca());
        txtModelo.setText(veiculo.getModelo());
        txtCor.setText(veiculo.getCor());
        cbxIdProprietario.setSelectedItem(veiculo.getIdPropietario());
        cbxIdPlano.setSelectedItem(veiculo.getIdPreco());
    }
    
    
    public void preencherCbx() {
        /*DefaultComboBoxModel defaultComboBoxPlano = new DefaultComboBoxModel(veiculoBll.PreencherCbxPlanos().toArray());
        cbxIdPlano.setModel(defaultComboBoxPlano);
        
        DefaultComboBoxModel defaultComboBoxProp = new DefaultComboBoxModel(veiculoBll.PreencherCbxProprietario().toArray());
        cbxIdProprietario.setModel(defaultComboBoxProp);*/
        
        PrecoDAL precoDal = new PrecoDAL();
        
        for(Preco preco : precoDal.mostrarTodos()){
            cbxIdPlano.addItem(preco);
        }
        
        ProprietarioDAL propDal = new ProprietarioDAL();
        for(Proprietario prop : propDal.mostrarTodos()){
            cbxIdProprietario.addItem(prop);
        }
    }    

    public int pegarIdPreco(){
        Preco preco = (Preco) cbxIdPlano.getSelectedItem();
        return preco.getCodigo();
    }
    
    public int pegarIdProprietario(){
        Proprietario prop = (Proprietario) cbxIdProprietario.getSelectedItem();
        
        return prop.getCodigo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtCor = new javax.swing.JTextField();
        cbxIdProprietario = new javax.swing.JComboBox<>();
        cbxIdPlano = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVeiculos = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jLabelTelaFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de veículos");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Placa");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 14, 30, 20);

        try {
            txtPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("???-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtPlaca);
        txtPlaca.setBounds(50, 11, 81, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Modelo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 14, 41, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cor");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(422, 14, 19, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Proprietário");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 50, 68, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Plano");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(290, 50, 31, 30);
        getContentPane().add(txtModelo);
        txtModelo.setBounds(211, 11, 185, 28);
        getContentPane().add(txtCor);
        txtCor.setBounds(451, 11, 160, 28);

        getContentPane().add(cbxIdProprietario);
        cbxIdProprietario.setBounds(88, 49, 180, 28);

        getContentPane().add(cbxIdPlano);
        cbxIdPlano.setBounds(330, 50, 170, 28);

        tblVeiculos.setModel(modelo);
        tblVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVeiculosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblVeiculos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 87, 600, 218);

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(198, 316, 80, 30);

        btnExcluir.setBackground(new java.awt.Color(255, 255, 255));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExcluir.setText("Deletar");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(296, 316, 80, 30);

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(394, 316, 80, 30);

        btnLimpar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(492, 316, 80, 30);

        btnAtualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar);
        btnAtualizar.setBounds(520, 50, 90, 30);

        jLabelTelaFundo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelaFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Fundo Cadastro.jpg"))); // NOI18N
        getContentPane().add(jLabelTelaFundo);
        jLabelTelaFundo.setBounds(0, 0, 640, 360);

        setSize(new java.awt.Dimension(635, 383));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVeiculosMouseClicked
        int linha = tblVeiculos.getSelectedRow();
        Integer codigo = (Integer) tblVeiculos.getValueAt(linha, 0);
        PreencheCampos((int) codigo);
    }//GEN-LAST:event_tblVeiculosMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {   
            veiculo.setPlaca(txtPlaca.getText());
            veiculo.setModelo(txtModelo.getText());
            veiculo.setCor(txtCor.getText());
            veiculo.setIdPropietario(Integer.parseInt(cbxIdProprietario.getSelectedItem().toString().split(" - ")[0]));
            veiculo.setIdPreco(Integer.parseInt(cbxIdPlano.getSelectedItem().toString().split(" - ")[0]));
            //veiculo.setIdPreco(pegarIdPreco());
            //veiculo.setIdPropietario(pegarIdProprietario());
            
            if (txtPlaca.getText().isEmpty() || txtModelo.getText().isEmpty() || txtCor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                veiculoBll.Adicionar(veiculo);
                Consultar();
                LimparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            if (txtPlaca.getText().isEmpty() || txtModelo.getText().isEmpty() || txtCor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            }
            veiculoBll.Remover(veiculoBll.getConsultaPorId(veiculo.getCodigo()));
        } catch (Exception ex) {
            Logger.getLogger(CadastroProprietario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Consultar();
        LimparCampos();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            veiculo.setPlaca(txtPlaca.getText());
            veiculo.setModelo(txtModelo.getText());
            veiculo.setCor(txtCor.getText());
            veiculo.setIdPropietario(Integer.parseInt(cbxIdProprietario.getSelectedItem().toString().split(" - ")[0]));
            veiculo.setIdPreco(Integer.parseInt(cbxIdPlano.getSelectedItem().toString().split(" - ")[0]));
            
            if (txtPlaca.getText().isEmpty() || txtModelo.getText().isEmpty() || txtCor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                veiculoBll.Alterar(veiculo);
                Consultar();
                LimparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        LimparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        cbxIdPlano.removeAllItems();
        cbxIdProprietario.removeAllItems();
        preencherCbx();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    
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
            java.util.logging.Logger.getLogger(CadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Object> cbxIdPlano;
    private javax.swing.JComboBox<Object> cbxIdProprietario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelTelaFundo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblVeiculos;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JFormattedTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
