package view;

import bll.EstadiaBLL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Estadia;

public class FrmHistorico extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    EstadiaBLL estadiaBll = new EstadiaBLL();
    Estadia estadia = new Estadia();

    public FrmHistorico() {
        criarTabela();
        consultar();
        initComponents();

    }

    private void criarTabela() {
        tblEstadiasFinalizadas = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Data");
        modelo.addColumn("Horário de Entrada");
        modelo.addColumn("Horário de Saída");
        modelo.addColumn("Desconto");
        modelo.addColumn("Veículo");
        modelo.addColumn("Funcionário");
        modelo.addColumn("Valor");
        modelo.addColumn("Situação");

        tblEstadiasFinalizadas.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblEstadiasFinalizadas.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblEstadiasFinalizadas.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblEstadiasFinalizadas.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblEstadiasFinalizadas.getColumnModel().getColumn(4).setPreferredWidth(30);
        tblEstadiasFinalizadas.getColumnModel().getColumn(5).setPreferredWidth(30);
        tblEstadiasFinalizadas.getColumnModel().getColumn(6).setPreferredWidth(30);
        tblEstadiasFinalizadas.getColumnModel().getColumn(7).setPreferredWidth(30);
        tblEstadiasFinalizadas.getColumnModel().getColumn(8).setPreferredWidth(30);
    }

    private void consultar() {
        modelo.setNumRows(0);
        List<Estadia> lista = new ArrayList<Estadia>();

        lista = estadiaBll.getEstadiasPagas();

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstadiasFinalizadas = new javax.swing.JTable();
        btnEmitirCupom = new javax.swing.JButton();
        txtDadosEstadia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de estadias");
        getContentPane().setLayout(null);

        tblEstadiasFinalizadas.setModel(modelo);
        tblEstadiasFinalizadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEstadiasFinalizadasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEstadiasFinalizadas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 800, 280);

        btnEmitirCupom.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEmitirCupom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Icone emitir cupom.png"))); // NOI18N
        btnEmitirCupom.setToolTipText("Emitir comprovante");
        btnEmitirCupom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmitirCupom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirCupomActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmitirCupom);
        btnEmitirCupom.setBounds(720, 20, 50, 40);

        txtDadosEstadia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDadosEstadia.setEnabled(false);
        getContentPane().add(txtDadosEstadia);
        txtDadosEstadia.setBounds(20, 20, 690, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Tela de Fundo Historico 02.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 860, 420);

        setSize(new java.awt.Dimension(829, 397));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    FrmEmitirCupom telaComprovante = new FrmEmitirCupom();
    String dados;

    private void btnEmitirCupomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirCupomActionPerformed

        if (txtDadosEstadia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "SELECIONE UMA ESTADIA!", "Atenção!", JOptionPane.WARNING_MESSAGE);
        } else {
            if (telaComprovante == null) {
                telaComprovante = new FrmEmitirCupom();
                telaComprovante.setVisible(true);
            } else {
                telaComprovante.setVisible(true);
                telaComprovante.setResizable(false);
            }

            String[] dadosRepartidos = dados.split("/");

            telaComprovante.preencherCampos(this, dadosRepartidos[0], dadosRepartidos[1], dadosRepartidos[2],
            dadosRepartidos[3], dadosRepartidos[4], dadosRepartidos[5], dadosRepartidos[6], dadosRepartidos[7]);
            
            txtDadosEstadia.setText("");
        }


    }//GEN-LAST:event_btnEmitirCupomActionPerformed

    private void tblEstadiasFinalizadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstadiasFinalizadasMouseClicked
        int linha = tblEstadiasFinalizadas.getSelectedRow();

        if (linha > -1) {
            /* Captura o modelo da tabela */
            modelo = (DefaultTableModel) tblEstadiasFinalizadas.getModel();

            /* Copia os dados do registro selecionado para os campos texto */
            dados = "  "+modelo.getValueAt(linha, 0).toString() + " / " + modelo.getValueAt(linha, 1).toString()
                    + " / " + modelo.getValueAt(linha, 2).toString() + " / " + modelo.getValueAt(linha, 3).toString()
                    + " / " + modelo.getValueAt(linha, 4).toString() + " / " + modelo.getValueAt(linha, 5).toString()
                    + " / " + modelo.getValueAt(linha, 6).toString() + " / " + modelo.getValueAt(linha, 7).toString() + " R$";

            txtDadosEstadia.setText(dados);

        }
    }//GEN-LAST:event_tblEstadiasFinalizadasMouseClicked

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
            java.util.logging.Logger.getLogger(FrmHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrmHistorico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmitirCupom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEstadiasFinalizadas;
    private javax.swing.JTextField txtDadosEstadia;
    // End of variables declaration//GEN-END:variables
}
