package view;


public class Menu extends javax.swing.JFrame {
    CadastroProprietario telaProprietario;
    CadastroFuncionario telaFuncionario;
    CadastroPlano telaPlano;
    CadastroVeiculo telaVeiculo;
    FrmEstadia telaEstadia;
    FrmHistorico telaHistorico;

    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelImagemdeFundo = new javax.swing.JLabel();
        BarraDeMenu = new javax.swing.JMenuBar();
        MenuCadastros = new javax.swing.JMenu();
        jMenuItemCadastroProprietarios = new javax.swing.JMenuItem();
        jMenuItemCadastroFuncionarios = new javax.swing.JMenuItem();
        jMenuItemCadastroVeiculos = new javax.swing.JMenuItem();
        jMenuItemCadastroPlanos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuEstadias = new javax.swing.JMenu();
        jMenuItemEstadias = new javax.swing.JMenuItem();
        MenuHistorico = new javax.swing.JMenu();
        jMenuItemHistoricoEstadias = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu principal");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabelImagemdeFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Tela de Fundo menu.png"))); // NOI18N
        getContentPane().add(jLabelImagemdeFundo);
        jLabelImagemdeFundo.setBounds(0, 0, 1140, 590);

        BarraDeMenu.setBorder(null);
        BarraDeMenu.setToolTipText("");
        BarraDeMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        MenuCadastros.setBorder(null);
        MenuCadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Icone de Cadastro.png"))); // NOI18N
        MenuCadastros.setToolTipText("Cadastros");
        MenuCadastros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItemCadastroProprietarios.setText("Cadastrar Proprietários");
        jMenuItemCadastroProprietarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemCadastroProprietarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroProprietariosActionPerformed(evt);
            }
        });
        MenuCadastros.add(jMenuItemCadastroProprietarios);

        jMenuItemCadastroFuncionarios.setText("Cadastrar Funcionários");
        jMenuItemCadastroFuncionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemCadastroFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroFuncionariosActionPerformed(evt);
            }
        });
        MenuCadastros.add(jMenuItemCadastroFuncionarios);

        jMenuItemCadastroVeiculos.setText("Cadastrar Veículos");
        jMenuItemCadastroVeiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemCadastroVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroVeiculosActionPerformed(evt);
            }
        });
        MenuCadastros.add(jMenuItemCadastroVeiculos);

        jMenuItemCadastroPlanos.setText("Cadastrar Planos");
        jMenuItemCadastroPlanos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemCadastroPlanos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroPlanosActionPerformed(evt);
            }
        });
        MenuCadastros.add(jMenuItemCadastroPlanos);

        BarraDeMenu.add(MenuCadastros);
        BarraDeMenu.add(jMenu2);

        MenuEstadias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Icone de Estacionamento.png"))); // NOI18N
        MenuEstadias.setToolTipText("Estadia");
        MenuEstadias.setContentAreaFilled(false);
        MenuEstadias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItemEstadias.setText("Controlar Estadias");
        jMenuItemEstadias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemEstadias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEstadiasActionPerformed(evt);
            }
        });
        MenuEstadias.add(jMenuItemEstadias);

        BarraDeMenu.add(MenuEstadias);

        MenuHistorico.setBorder(null);
        MenuHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Icone de historicos.png"))); // NOI18N
        MenuHistorico.setToolTipText("Histórico");
        MenuHistorico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItemHistoricoEstadias.setText("Histórico de Estadias");
        jMenuItemHistoricoEstadias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemHistoricoEstadias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHistoricoEstadiasActionPerformed(evt);
            }
        });
        MenuHistorico.add(jMenuItemHistoricoEstadias);

        BarraDeMenu.add(MenuHistorico);

        setJMenuBar(BarraDeMenu);

        setSize(new java.awt.Dimension(1142, 682));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadastroProprietariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroProprietariosActionPerformed
        if(telaProprietario == null){
            telaProprietario = new CadastroProprietario();
            telaProprietario.setVisible(true);
        } else{
            telaProprietario.setVisible(true);
            telaProprietario.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItemCadastroProprietariosActionPerformed

    private void jMenuItemCadastroFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroFuncionariosActionPerformed
        if(telaFuncionario == null){
            telaFuncionario = new CadastroFuncionario();
            telaFuncionario.setVisible(true);
        } else{
            telaFuncionario.setVisible(true);
            telaFuncionario.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItemCadastroFuncionariosActionPerformed

    private void jMenuItemCadastroPlanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroPlanosActionPerformed
        if(telaPlano == null){
            telaPlano = new CadastroPlano();
            telaPlano.setVisible(true);
        } else{
            telaPlano.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemCadastroPlanosActionPerformed

    private void jMenuItemCadastroVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroVeiculosActionPerformed
        if(telaVeiculo == null){
            telaVeiculo = new CadastroVeiculo();
            telaVeiculo.setVisible(true);
        } else{
            telaVeiculo.setVisible(true);
            telaVeiculo.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItemCadastroVeiculosActionPerformed

    private void jMenuItemEstadiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEstadiasActionPerformed
        if(telaEstadia == null){
            telaEstadia = new FrmEstadia();
            telaEstadia.setVisible(true);
        } else{
            telaEstadia.setVisible(true);
            telaEstadia.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItemEstadiasActionPerformed

    private void jMenuItemHistoricoEstadiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHistoricoEstadiasActionPerformed
        if(telaHistorico == null){
            telaHistorico = new FrmHistorico();
            telaHistorico.setVisible(true);
        } else{
            telaHistorico.setVisible(true);
            telaHistorico.setResizable(false);
        }
    }//GEN-LAST:event_jMenuItemHistoricoEstadiasActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraDeMenu;
    private javax.swing.JMenu MenuCadastros;
    private javax.swing.JMenu MenuEstadias;
    private javax.swing.JMenu MenuHistorico;
    private javax.swing.JLabel jLabelImagemdeFundo;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItemCadastroFuncionarios;
    private javax.swing.JMenuItem jMenuItemCadastroPlanos;
    private javax.swing.JMenuItem jMenuItemCadastroProprietarios;
    private javax.swing.JMenuItem jMenuItemCadastroVeiculos;
    private javax.swing.JMenuItem jMenuItemEstadias;
    private javax.swing.JMenuItem jMenuItemHistoricoEstadias;
    // End of variables declaration//GEN-END:variables
}
