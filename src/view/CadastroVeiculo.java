package view;

import bll.VeiculoBLL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Plano;
import model.Proprietario;
import model.Veiculo;

public class CadastroVeiculo extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();
    VeiculoBLL veiculoBll = new VeiculoBLL();
    Veiculo veiculo = new Veiculo();
    String cor;
    
    Vector<Plano> vetorPrecos;
    Vector<Proprietario> vetorProprietarios;
    
    public CadastroVeiculo() {        
        criarTabela();
        consultar();
        initComponents();
        verificarPlanos();
        verificarProprietarios();
    }
    
    private void criarTabela(){
        tblVeiculos = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Placa");
        modelo.addColumn("Modelo");
        modelo.addColumn("Cor");
        modelo.addColumn("Plano");
        modelo.addColumn("Proprietário");
        
        tblVeiculos.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblVeiculos.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblVeiculos.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblVeiculos.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblVeiculos.getColumnModel().getColumn(4).setPreferredWidth(30);
        tblVeiculos.getColumnModel().getColumn(5).setPreferredWidth(30);
    }

    private void limparCampos() {
        veiculo = new Veiculo();
        txtPlaca.setValue("");
        txtModelo.setText("");
        cbxCor.setSelectedIndex(0);
        cbxIdPlano.setSelectedIndex(0);
        cbxIdProprietario.setSelectedIndex(0);
        
        btnSalvar.setEnabled(true);
        verificarPlanos();
        verificarProprietarios();
    }
    
    private void consultar(){
        modelo.setNumRows(0);
        List<Veiculo> lista = new ArrayList<Veiculo>();
        
        lista = veiculoBll.getConsulta();
        
        if (lista.size() > 0){
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[]{
                    lista.get(i).getCodigo(),
                    lista.get(i).getPlaca(),
                    lista.get(i).getModelo(),
                    lista.get(i).getCor(),
                    lista.get(i).getIdPreco().getPlano(),
                    lista.get(i).getIdPropietario().getNome()
                });
            }
        } else{
            modelo.setNumRows(0);
        }
    }

    private void verificarPlanos() {
        vetorPrecos = veiculoBll.listarPlanos();     
        if (vetorPrecos == null) {
            Vector msg = new Vector();
            msg.add("Nenhum plano cadastrado");
            cbxIdPlano.setModel(new DefaultComboBoxModel(msg));
        } else {
            cbxIdPlano.setModel(new DefaultComboBoxModel(vetorPrecos));
        }
    }

    private void verificarProprietarios() {
        vetorProprietarios = veiculoBll.listarProprietarios();
        if (vetorProprietarios == null) {
            Vector msg = new Vector();
            msg.add("Nenhum proprietario cadastrado");
            cbxIdProprietario.setModel(new DefaultComboBoxModel(msg));
        } else {
            cbxIdProprietario.setModel(new DefaultComboBoxModel(vetorProprietarios));
        }
    }
    
    private void preencheCampos(int id) {
        veiculo = veiculoBll.getConsultaPorId(id);
        txtPlaca.setText(veiculo.getPlaca());
        txtModelo.setText(veiculo.getModelo());
        cbxCor.setSelectedItem(veiculo.getCor());
        cbxIdPlano.setSelectedItem(veiculo.getIdPreco().toString());
        cbxIdProprietario.setSelectedItem(veiculo.getIdPropietario().toString());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        cbxIdProprietario = new javax.swing.JComboBox<>();
        cbxIdPlano = new javax.swing.JComboBox<>();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVeiculos = new javax.swing.JTable();
        cbxCor = new javax.swing.JComboBox<>();
        btnProprietario = new javax.swing.JButton();
        btnPlano = new javax.swing.JButton();
        jLabelTelaFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de veículos");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Placa");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 30, 30);

        try {
            txtPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("???-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtPlaca);
        txtPlaca.setBounds(20, 40, 80, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Modelo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 50, 50, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cor");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 10, 20, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Proprietário");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(330, 10, 68, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Plano");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(350, 50, 40, 30);

        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModeloKeyTyped(evt);
            }
        });
        getContentPane().add(txtModelo);
        txtModelo.setBounds(180, 50, 120, 28);

        getContentPane().add(cbxIdProprietario);
        cbxIdProprietario.setBounds(410, 10, 200, 28);

        getContentPane().add(cbxIdPlano);
        cbxIdPlano.setBounds(410, 50, 200, 28);

        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Limpar.png"))); // NOI18N
        btnLimpar.setToolTipText("Limpar campos");
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(560, 300, 52, 38);

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Salver.png"))); // NOI18N
        btnSalvar.setToolTipText("Salvar veículo");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(350, 300, 52, 38);

        btnDeletar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Excluir.png"))); // NOI18N
        btnDeletar.setToolTipText("Excluir veículo");
        btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletar);
        btnDeletar.setBounds(420, 300, 52, 38);

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Editar.png"))); // NOI18N
        btnAlterar.setToolTipText("Editar veículo");
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(490, 300, 52, 38);

        tblVeiculos.setModel(modelo);
        tblVeiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVeiculosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblVeiculos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 90, 650, 200);

        cbxCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Branco", "Prata", "Preto", "Vermelho", "Outro" }));
        cbxCor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCorItemStateChanged(evt);
            }
        });
        getContentPane().add(cbxCor);
        cbxCor.setBounds(180, 10, 120, 28);

        btnProprietario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnProprietario.setText("+");
        btnProprietario.setToolTipText("Adicionar proprietário");
        btnProprietario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProprietarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnProprietario);
        btnProprietario.setBounds(610, 10, 40, 28);

        btnPlano.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPlano.setText("+");
        btnPlano.setToolTipText("Adicionar plano");
        btnPlano.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlanoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlano);
        btnPlano.setBounds(610, 50, 40, 28);

        jLabelTelaFundo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelaFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Tela.jpg"))); // NOI18N
        getContentPane().add(jLabelTelaFundo);
        jLabelTelaFundo.setBounds(0, -10, 690, 370);

        setSize(new java.awt.Dimension(679, 378));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            veiculo.setPlaca(txtPlaca.getText().toUpperCase());
            veiculo.setModelo(txtModelo.getText());
            veiculo.setIdPropietario(vetorProprietarios.get(cbxIdProprietario.getSelectedIndex()));
            veiculo.setIdPreco(vetorPrecos.get(cbxIdPlano.getSelectedIndex()));
            if(cbxCor.getSelectedItem().equals("Outro")){
                cor = JOptionPane.showInputDialog(rootPane, "Cor: ");
                veiculo.setCor(cor);
            } else{
                veiculo.setCor(cbxCor.getSelectedItem().toString());
            }
            
            if (txtPlaca.getText().isEmpty() || txtModelo.getText().isEmpty() || cbxCor.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            }
            else {
                veiculoBll.adicionar(veiculo);
                consultar();
                limparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            veiculo.setPlaca(txtPlaca.getText().toUpperCase());
            veiculo.setModelo(txtModelo.getText());
            veiculo.setIdPropietario(vetorProprietarios.get(cbxIdProprietario.getSelectedIndex()));
            veiculo.setIdPreco(vetorPrecos.get(cbxIdPlano.getSelectedIndex()));
            
            if(cbxCor.getSelectedItem().equals("Outro")){
                cor = JOptionPane.showInputDialog(rootPane, "Cor: ");
                veiculo.setCor(cor);
            } else{
                veiculo.setCor(cbxCor.getSelectedItem().toString());
            }

            if (txtPlaca.getText().isEmpty() || txtModelo.getText().isEmpty() || cbxCor.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            }
            else {
                veiculoBll.alterar(veiculo);
                consultar();
                limparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        try {
            
            if(txtPlaca.getText().isEmpty() || txtModelo.getText().isEmpty() || cbxCor.getSelectedItem().equals("Selecione")){
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            }else{
                veiculoBll.remover(veiculoBll.getConsultaPorId(veiculo.getCodigo()));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(CadastroProprietario.class.getName()).log(Level.SEVERE, null, ex);
        }
        consultar();
        limparCampos();
    
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void tblVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVeiculosMouseClicked
        btnSalvar.setEnabled(false);
        int linha = tblVeiculos.getSelectedRow();
        Integer codigo = (Integer) tblVeiculos.getValueAt(linha, 0);
        preencheCampos((int) codigo);
    }//GEN-LAST:event_tblVeiculosMouseClicked

    private void cbxCorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCorItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCorItemStateChanged

    CadastroProprietario telaProprietario;
    CadastroPlano telaPlano;
    
    private void btnProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProprietarioActionPerformed
        if(telaProprietario == null){
            telaProprietario = new CadastroProprietario();
            telaProprietario.setVisible(true);
        } else{
            telaProprietario.setVisible(true);
            telaProprietario.setResizable(false);
        }
        
    }//GEN-LAST:event_btnProprietarioActionPerformed

    private void btnPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlanoActionPerformed
        if(telaPlano == null){
            telaPlano = new CadastroPlano();
            telaPlano.setVisible(true);
        } else{
            telaPlano.setVisible(true);
            telaPlano.setResizable(false);
        }
    }//GEN-LAST:event_btnPlanoActionPerformed

    private void txtModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyTyped
        Character ch = evt.getKeyChar();
        int comprimentoDeCampo = txtModelo.getText().length();
        if (comprimentoDeCampo >= 30) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "EXCEDEU O LIMITE DE CARACTERES!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtModeloKeyTyped

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
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPlano;
    private javax.swing.JButton btnProprietario;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCor;
    private javax.swing.JComboBox<Vector> cbxIdPlano;
    private javax.swing.JComboBox<Vector> cbxIdProprietario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelTelaFundo;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblVeiculos;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JFormattedTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
