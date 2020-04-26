package view;

import bll.ProprietarioBLL;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Proprietario;

public class CadastroProprietario extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private ProprietarioBLL proprietarioBll = new ProprietarioBLL();
    Proprietario proprietario = new Proprietario();

    public CadastroProprietario() {
        criarTabela();
        consultar();
        initComponents();
    }

    private void criarTabela() {
        tblProprietarios = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        modelo.addColumn("Telefone");
        modelo.addColumn("CNH");

        tblProprietarios.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblProprietarios.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblProprietarios.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblProprietarios.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblProprietarios.getColumnModel().getColumn(4).setPreferredWidth(50);

    }

    private void consultar() {

        modelo.setNumRows(0);
        List<Proprietario> lista = new ArrayList<Proprietario>();

        lista = proprietarioBll.getConsulta();

        if (lista.size() > 0) {

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[]{lista.get(i).getCodigo(),
                    lista.get(i).getNome(),
                    lista.get(i).getCpf(),
                    lista.get(i).getTelefone(),
                    lista.get(i).getCnh()});
            }

        } else {
            modelo.setNumRows(0);
        }

    }

    private void limparCampos() {
        proprietario = new Proprietario();

        txtNome.setText("");
        txtCpf.setValue("");
        txtTelefone.setValue("");
        txtCnh.setValue("");
        btnSalvar.setEnabled(true);
    }

    private void preencheCampos(int id) {

        proprietario = proprietarioBll.getConsultaPorId(id);
        txtNome.setText(proprietario.getNome());
        txtCpf.setText(proprietario.getCpf());
        txtTelefone.setText(proprietario.getTelefone());
        txtCnh.setText(proprietario.getCnh());

    }

    private boolean isCPF(String CPF) {
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public boolean isCNH(String cnh) {
        char char1 = cnh.charAt(0);

        if (cnh.replaceAll("\\D+", "").length() != 11
                || String.format("%0" + 11 + "d", 0).replace('0', char1).equals(cnh)) {
            return false;
        }

        long v = 0, j = 9;

        for (int i = 0; i < 9; ++i, --j) {
            v += ((cnh.charAt(i) - 48) * j);
        }

        long dsc = 0, vl1 = v % 11;

        if (vl1 >= 10) {
            vl1 = 0;
            dsc = 2;
        }

        v = 0;
        j = 1;

        for (int i = 0; i < 9; ++i, ++j) {
            v += ((cnh.charAt(i) - 48) * j);
        }

        long x = v % 11;
        long vl2 = (x >= 10) ? 0 : x - dsc;

        return (String.valueOf(vl1) + String.valueOf(vl2)).equals(cnh.substring(cnh.length() - 2));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProprietarios = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        txtCnh = new javax.swing.JFormattedTextField();
        btnAlterar = new javax.swing.JButton();
        jLabelImagemdeFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de proprietários");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(null);

        btnLimpar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(400, 260, 71, 30);

        btnExcluir.setBackground(new java.awt.Color(255, 255, 255));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExcluir.setText("Deletar");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(220, 260, 75, 30);

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(140, 260, 69, 30);

        tblProprietarios.setModel(modelo);
        tblProprietarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblProprietarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProprietariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProprietarios);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 90, 470, 160);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CNH");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(270, 50, 40, 30);

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefoneKeyTyped(evt);
            }
        });
        getContentPane().add(txtTelefone);
        txtTelefone.setBounds(320, 10, 150, 28);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefone");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(260, 10, 50, 30);

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });
        getContentPane().add(txtNome);
        txtNome.setBounds(60, 10, 169, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 10, 40, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" CPF");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 50, 30, 30);

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCpfKeyTyped(evt);
            }
        });
        getContentPane().add(txtCpf);
        txtCpf.setBounds(60, 50, 170, 25);

        try {
            txtCnh.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCnh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCnhKeyTyped(evt);
            }
        });
        getContentPane().add(txtCnh);
        txtCnh.setBounds(320, 50, 150, 25);

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(310, 260, 80, 30);

        jLabelImagemdeFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Tela de Fundo Cadastros.jpg"))); // NOI18N
        getContentPane().add(jLabelImagemdeFundo);
        jLabelImagemdeFundo.setBounds(0, -10, 510, 330);

        setSize(new java.awt.Dimension(496, 328));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            if (txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() || txtTelefone.getText().isEmpty() || txtCnh.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "NENHUM PROPRIETÁRIO FOI SELECIONADO!", "Erro!", JOptionPane.ERROR_MESSAGE);
            } else{
                proprietarioBll.remover(proprietarioBll.getConsultaPorId(proprietario.getCodigo()));
            }
        } catch (Exception ex) {
            Logger.getLogger(CadastroProprietario.class.getName()).log(Level.SEVERE, null, ex);
        }
        consultar();
        limparCampos();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            proprietario.setNome(txtNome.getText());
            proprietario.setCpf(txtCpf.getText());
            proprietario.setTelefone(txtTelefone.getText());
            proprietario.setCnh(txtCnh.getText());

            if (txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() || txtTelefone.getText().isEmpty() || txtCnh.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                if (isCPF(txtCpf.getText()) && isCNH(txtCnh.getText()) && 
                proprietarioBll.verificarCpfsIguais(txtCpf.getText()) == false &&
                proprietarioBll.verificarCnhsIguais(txtCnh.getText()) == false) {
                    
                    proprietarioBll.adicionar(proprietario);

                    consultar();
                    limparCampos();
                } else {
                    if (isCPF(txtCpf.getText()) == false) {
                        JOptionPane.showMessageDialog(rootPane, "CPF Invalido!", "Cuidado!", JOptionPane.WARNING_MESSAGE);
                    }
                    if (isCNH(txtCnh.getText()) == false) {
                        JOptionPane.showMessageDialog(rootPane, "CNH Invalido!", "Cuidado!", JOptionPane.WARNING_MESSAGE);
                    }
                    if(proprietarioBll.verificarCpfsIguais(txtCpf.getText())){
                        JOptionPane.showMessageDialog(rootPane, "CPF JÁ CADASTRADO!", "Cuidado!", JOptionPane.ERROR_MESSAGE);
                    }
                    if(proprietarioBll.verificarCnhsIguais(txtCnh.getText())){
                        JOptionPane.showMessageDialog(rootPane, "CNH JÁ CADASTRADO!", "Cuidado!", JOptionPane.ERROR_MESSAGE);                        
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tblProprietariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProprietariosMouseClicked
        int linha = tblProprietarios.getSelectedRow();
        Integer codigo = (Integer) tblProprietarios.getValueAt(linha, 0);
        preencheCampos((int) codigo);
        btnSalvar.setEnabled(false);
    }//GEN-LAST:event_tblProprietariosMouseClicked

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE LETRAS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtNomeKeyTyped

    private void txtTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtTelefoneKeyTyped

    private void txtCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtCpfKeyTyped

    private void txtCnhKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCnhKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtCnhKeyTyped

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            proprietario.setNome(txtNome.getText());
            proprietario.setCpf(txtCpf.getText());
            proprietario.setTelefone(txtTelefone.getText());
            proprietario.setCnh(txtCnh.getText());

            if (txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() || txtTelefone.getText().isEmpty() || txtCnh.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                if (isCPF(txtCpf.getText()) && isCNH(txtCnh.getText())) {
                    
                    proprietarioBll.alterar(proprietario);
                    consultar();
                    limparCampos();
                } else {
                    if (isCPF(txtCpf.getText()) == false) {
                        JOptionPane.showMessageDialog(rootPane, "CPF Invalido!", "Cuidado!", JOptionPane.WARNING_MESSAGE);
                    }
                    if (isCNH(txtCnh.getText()) == false) {
                        JOptionPane.showMessageDialog(rootPane, "CNH Invalido!", "Cuidado!", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroProprietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProprietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProprietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProprietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProprietario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelImagemdeFundo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProprietarios;
    private javax.swing.JFormattedTextField txtCnh;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
