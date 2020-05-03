package view;



import bll.EstadiaBLL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Estadia;

public class FrmHistorico extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    EstadiaBLL estadiaBll = new EstadiaBLL();
    Estadia estadia = new Estadia();
    
    FrmEmitirCupom telaComprovante;
    
    int codigo;
    String data;
    String horaEntrada;
    String horaSaida;
    String desconto;
    String veiculo;
    String funcionario;
    double valor;
    String situacao;
    boolean preecamp = true;
    
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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
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
        jScrollPane1.setBounds(10, 90, 800, 300);

        btnEmitirCupom.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEmitirCupom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Icone emitir cupom.png"))); // NOI18N
        btnEmitirCupom.setToolTipText("Emitir cupom");
        btnEmitirCupom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmitirCupom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirCupomActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmitirCupom);
        btnEmitirCupom.setBounds(760, 40, 50, 40);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(30, 40, 430, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Pesquisar.png"))); // NOI18N
        jButton1.setToolTipText("Pesquisar");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(460, 40, 40, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Tela de Fundo Historico 02.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 860, 420);

        setSize(new java.awt.Dimension(838, 440));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmitirCupomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirCupomActionPerformed
        if(telaComprovante == null){
            telaComprovante = new FrmEmitirCupom();
            telaComprovante.setVisible(true);
        } else{
            telaComprovante.setVisible(true);
            telaComprovante.setResizable(false);
        }
        
    }//GEN-LAST:event_btnEmitirCupomActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblEstadiasFinalizadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstadiasFinalizadasMouseClicked
        int linha = tblEstadiasFinalizadas.getSelectedRow();
        JOptionPane.showMessageDialog(null, linha);
        
        if (linha > -1) {
            /* Captura o modelo da tabela */
            modelo = (DefaultTableModel) tblEstadiasFinalizadas.getModel();

            /* Copia os dados do registro selecionado para os campos texto */
            codigo = Integer.parseInt(modelo.getValueAt(linha, 0).toString());
            data = modelo.getValueAt(linha, 1).toString();
            horaEntrada = modelo.getValueAt(linha, 2).toString();
            horaSaida = modelo.getValueAt(linha, 3).toString();
            desconto = modelo.getValueAt(linha, 4).toString();
            veiculo = modelo.getValueAt(linha, 5).toString();
            funcionario = modelo.getValueAt(linha, 6).toString();
            valor = Double.parseDouble(modelo.getValueAt(linha, 7).toString());
            situacao = modelo.getValueAt(linha, 8).toString();
            preecamp = true;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblEstadiasFinalizadas;
    // End of variables declaration//GEN-END:variables
}
