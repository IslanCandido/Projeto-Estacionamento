package view;

import bll.EstadiaBLL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Estadia;

public class frmHistorico extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    EstadiaBLL estadiaBll = new EstadiaBLL();
    Estadia estadia = new Estadia();
    
    public frmHistorico() {
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

        lista = estadiaBll.mostrarEstadiasFinalizadas();

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
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de estadias finalizadas");
        getContentPane().setLayout(null);

        tblEstadiasFinalizadas.setModel(modelo);
        jScrollPane1.setViewportView(tblEstadiasFinalizadas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 690, 310);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Fundo Cadastro 01.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 710, 390);

        setSize(new java.awt.Dimension(726, 401));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHistorico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEstadiasFinalizadas;
    // End of variables declaration//GEN-END:variables
}
