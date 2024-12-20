/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemasemanaacademica.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Aluno;
import model.Oficina;
import sistemasemanaacademica.dao.PersistenciaJPA;

/**
 *
 * @author 20231PF.CC0021
 */
public class TelaAlunoOficina extends javax.swing.JFrame {
    PersistenciaJPA jpa;
    Aluno aluno;
//    Aluno aluno = null;
    
    /**
     * Creates new form TelaOficina
     */
    public TelaAlunoOficina(java.awt.Frame parent, boolean modal, Aluno aluno) {
        initComponents();
        
//        cmbVinculoOficina.addItem(null);
        
        jpa = new PersistenciaJPA();
        this.aluno = aluno;
        carregarOficinasCadastradas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("checked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        areaFiltros = new javax.swing.JPanel();
        lblBuscaNome = new javax.swing.JLabel();
        txtBuscaNome = new javax.swing.JTextField();
        areaListagem = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstOficinas = new javax.swing.JList<>();
        areaBotoes = new javax.swing.JPanel();
        btnFazerInscricao = new javax.swing.JButton();
        btnDesinscrever = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitulo.setText("Oficinas do Aluno");

        lblBuscaNome.setText("Nome: ");

        txtBuscaNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaNomeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaNomeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout areaFiltrosLayout = new javax.swing.GroupLayout(areaFiltros);
        areaFiltros.setLayout(areaFiltrosLayout);
        areaFiltrosLayout.setHorizontalGroup(
            areaFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, areaFiltrosLayout.createSequentialGroup()
                .addComponent(lblBuscaNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        areaFiltrosLayout.setVerticalGroup(
            areaFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, areaFiltrosLayout.createSequentialGroup()
                .addGap(0, 113, Short.MAX_VALUE)
                .addGroup(areaFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscaNome)
                    .addComponent(txtBuscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jScrollPane1.setViewportView(lstOficinas);

        javax.swing.GroupLayout areaListagemLayout = new javax.swing.GroupLayout(areaListagem);
        areaListagem.setLayout(areaListagemLayout);
        areaListagemLayout.setHorizontalGroup(
            areaListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(areaListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        areaListagemLayout.setVerticalGroup(
            areaListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(areaListagemLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
        );

        btnFazerInscricao.setText("Nova Inscricao");
        btnFazerInscricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFazerInscricaoActionPerformed(evt);
            }
        });

        btnDesinscrever.setText("Desinscrever");
        btnDesinscrever.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesinscreverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout areaBotoesLayout = new javax.swing.GroupLayout(areaBotoes);
        areaBotoes.setLayout(areaBotoesLayout);
        areaBotoesLayout.setHorizontalGroup(
            areaBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(areaBotoesLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(btnFazerInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDesinscrever, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        areaBotoesLayout.setVerticalGroup(
            areaBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, areaBotoesLayout.createSequentialGroup()
                .addGroup(areaBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFazerInscricao)
                    .addComponent(btnDesinscrever))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(areaFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(areaBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(areaListagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaListagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFazerInscricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFazerInscricaoActionPerformed
        TelaCadastroAlunoOficina telaCadastro = new TelaCadastroAlunoOficina(this, rootPaneCheckingEnabled, aluno);
        telaCadastro.setVisible(true);
        
        carregarOficinasCadastradas();
    }//GEN-LAST:event_btnFazerInscricaoActionPerformed

    private void btnDesinscreverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesinscreverActionPerformed
        Oficina oficinaSel = lstOficinas.getSelectedValue();;
        if (oficinaSel != null) {
            try {
                jpa.conexaoAberta();

                int delOp = JOptionPane.showConfirmDialog(this,
                        "Tem certeza que deseja remover " + oficinaSel.getNome() + "?");
                if (delOp == JOptionPane.YES_OPTION) {
                    aluno.getOficinas().size();
                    oficinaSel.getAlunos().size();

                    aluno.removeOficina(oficinaSel);
                    oficinaSel.removeAluno(aluno);
                    
                    jpa.persist(aluno);
                    jpa.persist(oficinaSel);
                }

                jpa.fecharConexao();
                carregarOficinasCadastradas();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao se desinscrever " + oficinaSel + "\n" + e);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma oficina para se desinscrever");
        }
    }//GEN-LAST:event_btnDesinscreverActionPerformed
 
                                     
    
    private void txtBuscaNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaNomeKeyPressed
        
    }//GEN-LAST:event_txtBuscaNomeKeyPressed

    private void txtBuscaNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaNomeKeyReleased
        if(txtBuscaNome.getText().trim().isEmpty()){
            carregarOficinasCadastradas();
        } else{
            jpa.conexaoAberta();
            DefaultListModel modeloLista = new DefaultListModel();
            modeloLista.addAll(jpa.getOficinas(txtBuscaNome.getText().trim()));
            lstOficinas.setModel(modeloLista);

            jpa.fecharConexao();
        }
    }//GEN-LAST:event_txtBuscaNomeKeyReleased

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
            java.util.logging.Logger.getLogger(TelaAlunoOficina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAlunoOficina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAlunoOficina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAlunoOficina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TelaAlunoOficina(this, true).setVisible(true);
//            }
//        });
    }
    
    
  
    
    public void carregarOficinasCadastradas() {
        jpa.conexaoAberta();
        
        DefaultListModel modeloLista = new DefaultListModel();
        modeloLista.addAll(jpa.getOficinasAluno(aluno));
        
        lstOficinas.setModel(modeloLista);
        jpa.fecharConexao();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaBotoes;
    private javax.swing.JPanel areaFiltros;
    private javax.swing.JPanel areaListagem;
    private javax.swing.JButton btnDesinscrever;
    private javax.swing.JButton btnFazerInscricao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscaNome;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<Oficina> lstOficinas;
    private javax.swing.JTextField txtBuscaNome;
    // End of variables declaration//GEN-END:variables
}
