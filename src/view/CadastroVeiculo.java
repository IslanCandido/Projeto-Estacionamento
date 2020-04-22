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
    
    Vector<Plano> vetorPrecos;
    Vector<Proprietario> vetorProprietarios;

    public CadastroVeiculo() {        
        initComponents();

        //Instancias de Objetos
        veiculo = new Veiculo();
        Proprietario objProprietario = new Proprietario();
        Plano objPreco = new Plano();
        veiculoBll = new VeiculoBLL();

        //Preencher comboBox de proprietario e planos
        vetorPrecos = veiculoBll.listarPlanos();
        vetorProprietarios = veiculoBll.listarProprietarios();

        //metodos
        criarTabela();
        verificarPlanos();
        verificarProprietarios();
        consultar();
        
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
        txtCor.setText("");
        cbxIdPlano.setSelectedIndex(0);
        cbxIdProprietario.setSelectedIndex(0);
        btnSalvar.setEnabled(true);
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
        if (vetorPrecos == null) {
            Vector msg = new Vector();
            msg.add("Nenhum plano cadastrado");
            cbxIdPlano.setModel(new DefaultComboBoxModel(msg));
        } else {
            cbxIdPlano.setModel(new DefaultComboBoxModel(vetorPrecos));
        }
    }

    private void verificarProprietarios() {
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
        txtCor.setText(veiculo.getCor());
        cbxIdPlano.setSelectedItem(veiculo.getIdPreco().getPlano());
        cbxIdProprietario.setSelectedItem(veiculo.getIdPropietario().getNome());
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVeiculos = new javax.swing.JTable();
        cbxIdProprietario = new javax.swing.JComboBox<>();
        cbxIdPlano = new javax.swing.JComboBox<>();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jLabelTelaFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de veículos");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Placa");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 10, 30, 30);

        try {
            txtPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("???-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtPlaca);
        txtPlaca.setBounds(70, 10, 70, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Modelo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 10, 50, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cor");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(400, 10, 19, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Proprietário");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 50, 68, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Plano");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(350, 50, 40, 30);
        getContentPane().add(txtModelo);
        txtModelo.setBounds(230, 10, 140, 28);
        getContentPane().add(txtCor);
        txtCor.setBounds(430, 10, 150, 28);

        tblVeiculos.setModel(modelo);
        tblVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVeiculosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblVeiculos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 90, 580, 210);

        getContentPane().add(cbxIdProprietario);
        cbxIdProprietario.setBounds(110, 50, 200, 28);

        getContentPane().add(cbxIdPlano);
        cbxIdPlano.setBounds(400, 50, 180, 28);

        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(500, 310, 71, 28);

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(230, 310, 69, 28);

        btnDeletar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletar);
        btnDeletar.setBounds(320, 310, 75, 28);

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(410, 310, 73, 28);

        jLabelTelaFundo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelaFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Fundo Cadastro.jpg"))); // NOI18N
        getContentPane().add(jLabelTelaFundo);
        jLabelTelaFundo.setBounds(0, -10, 610, 390);

        setSize(new java.awt.Dimension(610, 377));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVeiculosMouseClicked
        int linha = tblVeiculos.getSelectedRow();
        Integer codigo = (Integer) tblVeiculos.getValueAt(linha, 0);
        preencheCampos((int) codigo);
        btnSalvar.setEnabled(false);
    }//GEN-LAST:event_tblVeiculosMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            veiculo.setPlaca(txtPlaca.getText());
            veiculo.setModelo(txtModelo.getText());
            veiculo.setCor(txtCor.getText());
            veiculo.setIdPropietario(vetorProprietarios.get(cbxIdProprietario.getSelectedIndex()));
            veiculo.setIdPreco(vetorPrecos.get(cbxIdPlano.getSelectedIndex()));

            if (txtPlaca.getText().isEmpty() || txtModelo.getText().isEmpty() || txtCor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
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
            veiculo.setPlaca(txtPlaca.getText());
            veiculo.setModelo(txtModelo.getText());
            veiculo.setCor(txtCor.getText());
            veiculo.setIdPropietario(vetorProprietarios.get(cbxIdProprietario.getSelectedIndex()));
            veiculo.setIdPreco(vetorPrecos.get(cbxIdPlano.getSelectedIndex()));

            if (txtPlaca.getText().isEmpty() || txtModelo.getText().isEmpty() || txtCor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
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
            if (txtPlaca.getText().isEmpty() || txtModelo.getText().isEmpty() || txtCor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            }
            //veiculoBll.remover(veiculoBll.getConsultaPorId(veiculo.getCodigo()));
            veiculoBll.remover(veiculo);
        } catch (Exception ex) {
            Logger.getLogger(CadastroProprietario.class.getName()).log(Level.SEVERE, null, ex);
        }
        consultar();
        limparCampos();
    
    }//GEN-LAST:event_btnDeletarActionPerformed

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
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Vector> cbxIdPlano;
    private javax.swing.JComboBox<Vector> cbxIdProprietario;
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
