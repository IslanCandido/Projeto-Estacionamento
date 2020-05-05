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

    public static Time CriarNovaTime(String hora){
        if(hora == null){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        java.sql.Time a = null;
        try {
            a = new java.sql.Time(format.parse(hora).getTime());
        } catch (ParseException e) {
        }
        return a;
    }
    
    public static String convertTime(Time timeConsult) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            return formatter.format(timeConsult);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Date CriarNovaData(String data){
        if(data == null){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        java.sql.Date a = null;
        try {
            a = new java.sql.Date(format.parse(data).getTime());
        } catch (ParseException e) {
        }
        return a;
    }

    public static String convertDate(Date dtConsulta) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
            return formatter.format(dtConsulta);
        } catch (Exception e) {
            return null;
        }
    }

    public frmEstadia() {
        initComponents();
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

    private void limparCampos() {
        estadia = new Estadia();

        txtCodigo.setText("");
        txtData.setValue("");
        txtHoraEntrada.setValue("");
        txtHoraSaida.setValue("");
        cbxDesconto.setSelectedIndex(0);
        cbxIdVeiculo.setSelectedIndex(0);
        cbxIdFuncionario.setSelectedIndex(0);
        txtValor.setText("");
        buttonGroup1.clearSelection();
        btnSalvar.setEnabled(true);
    }

    private void consultar() {
        modelo.setNumRows(0);
        List<Estadia> lista = new ArrayList<Estadia>();

        lista = estadiaBll.getEstadiasDevendo();

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
        vetorVeiculos = estadiaBll.listarVeiculos();
        
        if (vetorVeiculos == null) {
            Vector msg = new Vector();
            msg.add("Nenhum veículo cadastrado");
            cbxIdVeiculo.setModel(new DefaultComboBoxModel(msg));
        } else {
            cbxIdVeiculo.setModel(new DefaultComboBoxModel(vetorVeiculos));
        }
    }

    private void verificarFuncionarios() {
        vetorFuncionarios = estadiaBll.listarFuncionarios();
        if (vetorFuncionarios == null) {
            Vector msg = new Vector();
            msg.add("Nenhum funcionário cadastrado");
            cbxIdFuncionario.setModel(new DefaultComboBoxModel(msg));
        } else {
            cbxIdFuncionario.setModel(new DefaultComboBoxModel(vetorFuncionarios));
        }
    }
    
    private boolean isData(String data) {
        String[] dataparticionada = data.split("/");
        int dia = Integer.parseInt(dataparticionada[0]);
        int mes = Integer.parseInt(dataparticionada[1]);
        int ano = Integer.parseInt(dataparticionada[2]);
        boolean anoBissexto = ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;

        if (((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && (dia >= 1 && dia <= 31))
        || ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia >= 1 && dia <= 30))
        || ((mes == 2) && (anoBissexto) && (dia >= 1 && dia <= 29) && (ano >=2020 && ano <=2021))
        || ((mes == 2) && !(anoBissexto) && (dia >= 1 && dia <= 28)  && (ano >=2020 && ano <=2021))) {
            
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isHorario(String horario){
        String[] horaparticionada = horario.split(":");
        int hora = Integer.parseInt(horaparticionada[0]);
        int minutos = Integer.parseInt(horaparticionada[1]);
        int segundos = Integer.parseInt(horaparticionada[2]);
        
        if((hora >= 0 && hora <= 23) || (minutos >= 0 || minutos <=59) || (segundos >=0 && segundos <=99)){
            return true;
        } else{
            return false;
        }
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxIdFuncionario = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbxIdVeiculo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbxDesconto = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rbDevendo = new javax.swing.JRadioButton();
        rbPago = new javax.swing.JRadioButton();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstadias = new javax.swing.JTable();
        txtData = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtHoraEntrada = new javax.swing.JFormattedTextField();
        txtHoraSaida = new javax.swing.JFormattedTextField();
        btnAddFuncionario = new javax.swing.JButton();
        btnAddVeiculo = new javax.swing.JButton();
        btnTelaHistorico = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar estadia");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 10, 40, 10);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Horário de Entrada");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(210, 10, 106, 14);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Horário de Saída");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(210, 70, 93, 14);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Funcionário");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(340, 10, 65, 14);

        cbxIdFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbxIdFuncionario);
        cbxIdFuncionario.setBounds(340, 30, 200, 28);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Veículo");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(340, 70, 40, 14);

        cbxIdVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxIdVeiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxIdVeiculoItemStateChanged(evt);
            }
        });
        getContentPane().add(cbxIdVeiculo);
        cbxIdVeiculo.setBounds(340, 90, 200, 28);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Desconto");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(80, 70, 53, 10);

        cbxDesconto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Nenhum", "10%", "15%", "20%" }));
        cbxDesconto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxDescontoItemStateChanged(evt);
            }
        });
        getContentPane().add(cbxDesconto);
        cbxDesconto.setBounds(80, 90, 110, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Valor");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(600, 10, 29, 14);

        txtValor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtValor.setEnabled(false);
        getContentPane().add(txtValor);
        txtValor.setBounds(600, 30, 60, 28);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(" R$");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(660, 30, 20, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Situação");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(600, 70, 60, 14);

        buttonGroup1.add(rbDevendo);
        rbDevendo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbDevendo.setForeground(new java.awt.Color(255, 255, 255));
        rbDevendo.setText("DEVENDO");
        rbDevendo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(rbDevendo);
        rbDevendo.setBounds(600, 110, 90, 20);

        buttonGroup1.add(rbPago);
        rbPago.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbPago.setForeground(new java.awt.Color(255, 255, 255));
        rbPago.setText("PAGO");
        rbPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(rbPago);
        rbPago.setBounds(600, 90, 90, 20);

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Salver.png"))); // NOI18N
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(400, 370, 52, 38);

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Editar.png"))); // NOI18N
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(540, 370, 52, 38);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Excluir.png"))); // NOI18N
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(470, 370, 52, 38);

        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Limpar.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(610, 370, 52, 38);

        tblEstadias.setModel(modelo);
        jScrollPane1.setViewportView(tblEstadias);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 140, 690, 220);

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
        txtData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDataKeyTyped(evt);
            }
        });
        getContentPane().add(txtData);
        txtData.setBounds(80, 30, 110, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ID");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 10, 20, 14);

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(20, 30, 40, 28);

        try {
            txtHoraEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtHoraEntrada);
        txtHoraEntrada.setBounds(210, 30, 110, 28);

        try {
            txtHoraSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtHoraSaida);
        txtHoraSaida.setBounds(210, 90, 110, 28);

        btnAddFuncionario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAddFuncionario.setText("+");
        btnAddFuncionario.setToolTipText("Adicionar funcionário");
        btnAddFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddFuncionario);
        btnAddFuncionario.setBounds(540, 30, 40, 28);

        btnAddVeiculo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAddVeiculo.setText("+");
        btnAddVeiculo.setToolTipText("Adicionar veículo");
        btnAddVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVeiculoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddVeiculo);
        btnAddVeiculo.setBounds(540, 90, 40, 28);

        btnTelaHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Historico teste.png"))); // NOI18N
        btnTelaHistorico.setToolTipText("Atalho para o histórico");
        btnTelaHistorico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTelaHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaHistoricoActionPerformed(evt);
            }
        });
        getContentPane().add(btnTelaHistorico);
        btnTelaHistorico.setBounds(30, 370, 52, 38);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Tela teste.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 0, 740, 510);

        setSize(new java.awt.Dimension(716, 446));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            estadia.setData(CriarNovaData(txtData.getText()));
            estadia.setHoraEntrada(CriarNovaTime(txtHoraEntrada.getText()));
            estadia.setHoraSaida(CriarNovaTime(txtHoraSaida.getText()));
            estadia.setDesconto(cbxDesconto.getSelectedItem().toString());
            estadia.setIdVeiculo(vetorVeiculos.get(cbxIdVeiculo.getSelectedIndex()));
            estadia.setIdFuncionario(vetorFuncionarios.get(cbxIdFuncionario.getSelectedIndex()));
            estadia.setValor(Double.parseDouble(txtValor.getText()));
            if(rbPago.isSelected()){
                estadia.setSituacaoPagamento("PAGO");
            } 
            if(rbDevendo.isSelected()){
                estadia.setSituacaoPagamento("DEVENDO");
            }
            
            if (txtData.getText().equals("") || txtHoraEntrada.getText().equals("")
                    || txtHoraSaida.getText().equals("") || cbxDesconto.getSelectedItem().equals("Selecione")
                    || txtValor.getText().equals("") || buttonGroup1.getSelection().equals(false)) {
                JOptionPane.showMessageDialog(rootPane, "TODOS OS CAMPOS SÃO OBRIGATORIOS!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else if (!txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "ID GERADO AUTOMATICAMENTE!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                if(isData(txtData.getText()) && isHorario(txtHoraEntrada.getText()) && isHorario(txtHoraSaida.getText())){
                    estadiaBll.adicionar(estadia);
                    limparCampos();
                    consultar();
                } else{
                    if(!isData(txtData.getText())){
                        JOptionPane.showMessageDialog(rootPane, "DATA INVALIDA!", "Cuidado!", JOptionPane.WARNING_MESSAGE);
                    }
                    if(!isHorario(txtHoraEntrada.getText())){
                        JOptionPane.showMessageDialog(rootPane, "HORÁRIO DE ENTRADA INVALIDA!", "Cuidado!", JOptionPane.WARNING_MESSAGE);
                    } 
                    if(isHorario(txtHoraSaida.getText())){
                        JOptionPane.showMessageDialog(rootPane, "HORÁRIO DE SAÍDA INVALIDA!", "Cuidado!", JOptionPane.WARNING_MESSAGE);
                    }
                }
                
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cbxDescontoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxDescontoItemStateChanged
        if (txtValor.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "NENHUM VALOR PARA DESCONTO", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        } else {
            DecimalFormat df = new DecimalFormat("####");
            double preco = Double.parseDouble(txtValor.getText());
            
            if(cbxDesconto.getSelectedItem().equals("Nenhum")){
                txtValor.setText(String.valueOf(df.format(preco)));
            }
            if (cbxDesconto.getSelectedItem().equals("10%")) {
                txtValor.setText(String.valueOf(df.format(preco - (preco * 0.1))));
            } else if (cbxDesconto.getSelectedItem().equals("15%")) {
                txtValor.setText(String.valueOf(df.format(preco - (preco * 0.15))));
            } else if (cbxDesconto.getSelectedItem().equals("30%")) {
                txtValor.setText(String.valueOf(df.format(preco - (preco * 0.20))));
            }
        }

    }//GEN-LAST:event_cbxDescontoItemStateChanged

    private void cbxIdVeiculoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxIdVeiculoItemStateChanged
        estadia.setIdVeiculo(vetorVeiculos.get(cbxIdVeiculo.getSelectedIndex()));
        int id = estadia.getIdVeiculo().getCodigo();
        double preco = estadiaBll.mostrarValor(id);
        DecimalFormat df = new DecimalFormat("####");
        
        txtValor.setText(String.valueOf(preco));
        if(txtHoraEntrada.getText().equals("")){
            
        }
        if(preco >= 100){
            rbPago.setSelected(true);
            JOptionPane.showMessageDialog(rootPane, "PLANO INCLUIDO!");
        } else{
            buttonGroup1.clearSelection();
        }
        
        if(preco <= 15){
            if(txtHoraEntrada.getValue().equals("") || txtHoraSaida.getValue().equals("")){
                JOptionPane.showMessageDialog(rootPane, "HORÁRIOS EM BRANCO!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
            }
            String horarioEntrada = txtHoraEntrada.getText();
            String horarioSaida = txtHoraSaida.getText();
            
            String[] entradaParticionada = horarioEntrada.split(":");
            String[] saidaParticionada = horarioSaida.split(":");
            
            int horaEntrada = Integer.parseInt(entradaParticionada[0]);
            int horaSaida = Integer.parseInt(saidaParticionada[0]);
            
            txtValor.setText(String.valueOf(df.format(preco+(3*(horaSaida - horaEntrada)))));
        } else{
            txtValor.setText(String.valueOf(preco));
        }
    }//GEN-LAST:event_cbxIdVeiculoItemStateChanged

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            estadia.setCodigo(Integer.parseInt(txtCodigo.getText()));
            estadia.setData(CriarNovaData(txtData.getText()));
            estadia.setHoraEntrada(CriarNovaTime(txtHoraEntrada.getText()));
            estadia.setHoraSaida(CriarNovaTime(txtHoraSaida.getText()));
            estadia.setDesconto(cbxDesconto.getSelectedItem().toString());
            estadia.setIdVeiculo(vetorVeiculos.get(cbxIdVeiculo.getSelectedIndex()));
            estadia.setIdFuncionario(vetorFuncionarios.get(cbxIdFuncionario.getSelectedIndex()));
            estadia.setValor(Double.parseDouble(txtValor.getText()));
            estadia.setSituacaoPagamento(buttonGroup1.getSelection().toString());

            if (txtData.getText().equals("") || txtHoraEntrada.getText().equals("")
            || txtHoraSaida.getText().equals("") || cbxDesconto.getSelectedItem().equals("Selecione")
            || txtValor.getText().equals("") || buttonGroup1.getSelection().equals(false)) {
                
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
            if (txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "CAMPO ID É OBRIGATORIO!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                estadia.setCodigo(Integer.parseInt(txtCodigo.getText()));
                estadiaBll.remover(estadia.getCodigo());
            }

        } catch (Exception ex) {
            Logger.getLogger(CadastroProprietario.class.getName()).log(Level.SEVERE, null, ex);
        }
        consultar();
        limparCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        Character ch = evt.getKeyChar();
        int comprimentoDeCampo = txtCodigo.getText().length();
        if (comprimentoDeCampo >= 3) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "LIMITE DE 3 DIGITOS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
        
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtDataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "DIGITE SOMENTE NUMEROS!", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtDataKeyTyped

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed

    }//GEN-LAST:event_txtDataActionPerformed

    CadastroFuncionario telaFuncionario;
    CadastroVeiculo telaVeiculo;
    FrmHistorico telaHistorico;
    
    private void btnAddFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFuncionarioActionPerformed
        if(telaFuncionario == null){
            telaFuncionario = new CadastroFuncionario();
            telaFuncionario.setVisible(true);
        } else{
            telaFuncionario.setVisible(true);
            telaFuncionario.setResizable(false);
        }

    }//GEN-LAST:event_btnAddFuncionarioActionPerformed

    private void btnAddVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVeiculoActionPerformed
        if(telaVeiculo == null){
            telaVeiculo = new CadastroVeiculo();
            telaVeiculo.setVisible(true);
        } else{
            telaVeiculo.setVisible(true);
            telaVeiculo.setResizable(false);
        }
    }//GEN-LAST:event_btnAddVeiculoActionPerformed

    
    
    private void btnTelaHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaHistoricoActionPerformed
        if(telaHistorico == null){
            telaHistorico = new FrmHistorico();
            telaHistorico.setVisible(true);
        } else{
            telaHistorico.setVisible(true);
            telaHistorico.setResizable(false);
        }
    }//GEN-LAST:event_btnTelaHistoricoActionPerformed

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEstadia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFuncionario;
    private javax.swing.JButton btnAddVeiculo;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnTelaHistorico;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxDesconto;
    private javax.swing.JComboBox<String> cbxIdFuncionario;
    private javax.swing.JComboBox<String> cbxIdVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbDevendo;
    private javax.swing.JRadioButton rbPago;
    private javax.swing.JTable tblEstadias;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtHoraEntrada;
    private javax.swing.JFormattedTextField txtHoraSaida;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
