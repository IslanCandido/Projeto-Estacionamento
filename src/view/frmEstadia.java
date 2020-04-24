package view;

import bll.EstadiaBLL;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Estadia;
import model.Funcionario;
import model.Veiculo;

public class frmEstadia extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    EstadiaBLL estadiaBll = new EstadiaBLL();
    Estadia estadia = new Estadia();

    Vector<Veiculo> vetorVeiculos;
    Vector<Funcionario> vetorFuncionarios;

    public frmEstadia() {
        initComponents();

        //Preencher comboBox de proprietario e plano
        vetorVeiculos = estadiaBll.listarVeiculos();
        vetorFuncionarios = estadiaBll.listarFuncionarios();

        criarTabela();
        verificarVeiculos();
        verificarFuncionarios();
        consultar();
    }

    private void criarTabela() {
        tblEstadias = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Data");
        modelo.addColumn("Horário de Entrada");
        modelo.addColumn("Horário de Saída");
        modelo.addColumn("Desconto");
        modelo.addColumn("Veículo");
        modelo.addColumn("Funcionário");
        modelo.addColumn("Valor");
        modelo.addColumn("Situação");

        tblEstadias.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblEstadias.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblEstadias.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblEstadias.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblEstadias.getColumnModel().getColumn(4).setPreferredWidth(30);
        tblEstadias.getColumnModel().getColumn(5).setPreferredWidth(30);
        tblEstadias.getColumnModel().getColumn(6).setPreferredWidth(30);
        tblEstadias.getColumnModel().getColumn(7).setPreferredWidth(30);
        tblEstadias.getColumnModel().getColumn(8).setPreferredWidth(30);
    }

    private static Date criarData(String data) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String ConverterDateParaString(Date dtConsulta) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
            return formatter.format(dtConsulta);
        } catch (Exception e) {
            return null;
        }
    }

    private void limparCampos() {
        estadia = new Estadia();
        
        txtCodigo.setText("");
        txtData.setText("");
        cbxDesconto.setSelectedIndex(0);
        cbxIdVeiculo.setSelectedIndex(0);
        cbxIdFuncionario.setSelectedIndex(0);
        txtPreco.setText("");
        buttonGroup1.clearSelection();
        btnSalvar.setEnabled(true);
    }

    private void consultar() {
        modelo.setNumRows(0);
        List<Estadia> lista = new ArrayList<Estadia>();

        lista = estadiaBll.getConsulta();

        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[]{
                    lista.get(i).getCodigo(),
                    lista.get(i).getData(),
                    lista.get(i).getHoraEntrada(),
                    lista.get(i).getHoraSaida(),
                    lista.get(i).getDesconto(),
                    lista.get(i).getIdVeiculo().getModelo(),
                    lista.get(i).getIdFuncionario().getNome(),
                    lista.get(i).getValor(),
                    lista.get(i).getSituacaoPagamento()
                });
            }
        } else {
            modelo.setNumRows(0);
        }
    }

    private void verificarVeiculos() {
        if (vetorVeiculos == null) {
            Vector msg = new Vector();
            msg.add("Nenhum veículo cadastrado");
            cbxIdVeiculo.setModel(new DefaultComboBoxModel(msg));
        } else {
            cbxIdVeiculo.setModel(new DefaultComboBoxModel(vetorVeiculos));
        }
    }

    private void verificarFuncionarios() {
        if (vetorFuncionarios == null) {
            Vector msg = new Vector();
            msg.add("Nenhum funcionário cadastrado");
            cbxIdFuncionario.setModel(new DefaultComboBoxModel(msg));
        } else {
            cbxIdFuncionario.setModel(new DefaultComboBoxModel(vetorFuncionarios));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTimeHoraEntrada = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel3 = new javax.swing.JLabel();
        jTimeHoraSaida = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel4 = new javax.swing.JLabel();
        cbxIdFuncionario = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbxIdVeiculo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbxDesconto = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rbDevendo = new javax.swing.JRadioButton();
        rbPago = new javax.swing.JRadioButton();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnFinalizarEstadia = new javax.swing.JButton();
        btnEmitirCupom = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstadias = new javax.swing.JTable();
        txtData = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabelTelaDeFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar estadia");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 10, 40, 14);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Horário de Entrada");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(220, 10, 106, 14);
        getContentPane().add(jTimeHoraEntrada);
        jTimeHoraEntrada.setBounds(220, 30, 106, 28);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Horário de Saída");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(360, 10, 93, 14);
        getContentPane().add(jTimeHoraSaida);
        jTimeHoraSaida.setBounds(360, 30, 106, 28);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Funcionário");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 70, 65, 14);

        cbxIdFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbxIdFuncionario);
        cbxIdFuncionario.setBounds(10, 90, 190, 28);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Veículo");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(230, 70, 40, 14);

        cbxIdVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxIdVeiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxIdVeiculoItemStateChanged(evt);
            }
        });
        getContentPane().add(cbxIdVeiculo);
        cbxIdVeiculo.setBounds(230, 90, 140, 28);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Desconto");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(500, 10, 53, 14);

        cbxDesconto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Nenhum", "10%", "20%", "30%" }));
        cbxDesconto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxDescontoItemStateChanged(evt);
            }
        });
        getContentPane().add(cbxDesconto);
        cbxDesconto.setBounds(500, 30, 100, 28);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Preço");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(400, 70, 32, 14);
        getContentPane().add(txtPreco);
        txtPreco.setBounds(400, 90, 60, 28);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(" R$");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(460, 90, 20, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Situação pagamento");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(500, 70, 140, 14);

        buttonGroup1.add(rbDevendo);
        rbDevendo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbDevendo.setForeground(new java.awt.Color(255, 255, 255));
        rbDevendo.setText("DEVENDO");
        rbDevendo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(rbDevendo);
        rbDevendo.setBounds(500, 110, 110, 20);

        buttonGroup1.add(rbPago);
        rbPago.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbPago.setForeground(new java.awt.Color(255, 255, 255));
        rbPago.setText("PAGO");
        rbPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(rbPago);
        rbPago.setBounds(500, 90, 110, 20);

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(440, 410, 80, 28);

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(650, 410, 90, 28);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(540, 410, 90, 28);

        btnFinalizarEstadia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnFinalizarEstadia.setText("Finalizar Estadia");
        btnFinalizarEstadia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnFinalizarEstadia);
        btnFinalizarEstadia.setBounds(140, 410, 130, 28);

        btnEmitirCupom.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEmitirCupom.setText("Emitir Cupom");
        getContentPane().add(btnEmitirCupom);
        btnEmitirCupom.setBounds(10, 410, 110, 28);

        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(660, 90, 71, 28);

        tblEstadias.setModel(modelo);
        jScrollPane1.setViewportView(tblEstadias);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 140, 740, 260);

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });
        getContentPane().add(txtData);
        txtData.setBounds(100, 30, 90, 28);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ID");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 10, 20, 14);
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(10, 30, 60, 28);

        jLabelTelaDeFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Fundo Cadastro 02.jpg"))); // NOI18N
        getContentPane().add(jLabelTelaDeFundo);
        jLabelTelaDeFundo.setBounds(0, -10, 790, 470);

        setSize(new java.awt.Dimension(771, 479));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            estadia.setData(criarData(txtData.getText()));
            estadia.setHoraEntrada(Time.valueOf(jTimeHoraEntrada.getFormatedDate()));
            estadia.setHoraSaida(Time.valueOf(jTimeHoraSaida.getFormatedDate()));
            estadia.setDesconto(cbxDesconto.getSelectedItem().toString());
            estadia.setIdVeiculo(vetorVeiculos.get(cbxIdVeiculo.getSelectedIndex()));
            estadia.setIdFuncionario(vetorFuncionarios.get(cbxIdFuncionario.getSelectedIndex()));
            estadia.setValor(Double.parseDouble(txtPreco.getText()));
            estadia.setSituacaoPagamento(buttonGroup1.getSelection().toString());

            if (txtData.getText().equals("") || jTimeHoraEntrada.getTimeField().equals("")
                    || jTimeHoraSaida.getTimeField().equals("") || cbxDesconto.getSelectedItem().equals("Selecione")
                    || txtPreco.getText().equals("") || buttonGroup1.getSelection().equals(false)) {
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            }
            else if(!txtCodigo.getText().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "ID GERADO AUTOMATICAMENTE!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            }
            else {
                estadiaBll.adicionar(estadia);
                limparCampos();
                consultar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        
    }//GEN-LAST:event_txtDataActionPerformed

    private void cbxDescontoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxDescontoItemStateChanged
        if (txtPreco.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "NENHUM VALOR PARA DESCONTO", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        } else {
            DecimalFormat df = new DecimalFormat("####");
            double preco = Double.parseDouble(txtPreco.getText());

            if (cbxDesconto.getSelectedItem().equals("10%")) {
                txtPreco.setText(String.valueOf(df.format(preco - (preco * 0.1))));
            } else if (cbxDesconto.getSelectedItem().equals("20%")) {
                txtPreco.setText(String.valueOf(df.format(preco - (preco * 0.2))));
            } else if (cbxDesconto.getSelectedItem().equals("30%")) {
                txtPreco.setText(String.valueOf(df.format(preco - (preco * 0.3))));
            }
        }

    }//GEN-LAST:event_cbxDescontoItemStateChanged

    private void cbxIdVeiculoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxIdVeiculoItemStateChanged

    }//GEN-LAST:event_cbxIdVeiculoItemStateChanged

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            estadia.setCodigo(Integer.parseInt(txtCodigo.getText()));
            estadia.setData(criarData(txtData.getText()));
            estadia.setHoraEntrada(Time.valueOf(jTimeHoraEntrada.getFormatedDate()));
            estadia.setHoraSaida(Time.valueOf(jTimeHoraSaida.getFormatedDate()));
            estadia.setDesconto(cbxDesconto.getSelectedItem().toString());
            estadia.setIdVeiculo(vetorVeiculos.get(cbxIdVeiculo.getSelectedIndex()));
            estadia.setIdFuncionario(vetorFuncionarios.get(cbxIdFuncionario.getSelectedIndex()));
            estadia.setValor(Double.parseDouble(txtPreco.getText()));
            estadia.setSituacaoPagamento(buttonGroup1.getSelection().toString());

            if (txtData.getText().equals("") || jTimeHoraEntrada.getTimeField().equals("")
                    || jTimeHoraSaida.getTimeField().equals("") || cbxDesconto.getSelectedItem().equals("Selecione")
                    || txtPreco.getText().equals("") || buttonGroup1.getSelection().equals(false)) {
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                estadiaBll.alterar(estadia);
                limparCampos();
                consultar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            if(txtCodigo.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "CAMPO ID É OBRIGATORIO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else{
                estadia.setCodigo(Integer.parseInt(txtCodigo.getText()));
                estadiaBll.remover(estadia.getCodigo());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(CadastroProprietario.class.getName()).log(Level.SEVERE, null, ex);
        }
        consultar();
        limparCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(frmEstadia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEstadia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEstadia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEstadia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEstadia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEmitirCupom;
    private javax.swing.JButton btnFinalizarEstadia;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxDesconto;
    private javax.swing.JComboBox<String> cbxIdFuncionario;
    private javax.swing.JComboBox<String> cbxIdVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTelaDeFundo;
    private javax.swing.JScrollPane jScrollPane1;
    private lu.tudor.santec.jtimechooser.JTimeChooser jTimeHoraEntrada;
    private lu.tudor.santec.jtimechooser.JTimeChooser jTimeHoraSaida;
    private javax.swing.JRadioButton rbDevendo;
    private javax.swing.JRadioButton rbPago;
    private javax.swing.JTable tblEstadias;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
