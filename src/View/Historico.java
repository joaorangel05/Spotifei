
package View;

import Controller.ControllerMusica;
import Model.ModelMusica;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Historico extends javax.swing.JFrame {

    
    ControllerMusica controller = new ControllerMusica();
    /**
     * Creates new form Historico
     */
    public Historico() {
        initComponents();
        carregarHistorico();
    }

private void carregarHistorico() {
        List<ModelMusica> lista = controller.buscarHistorico();

        String[] colunas = {"Nome", "Artista", "Gênero", "Curtida"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 3 ? Boolean.class : String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (ModelMusica m : lista) {
            modelo.addRow(new Object[]{
                m.getNome(),
                m.getArtista(),
                m.getGenero(),
                m.isCurtida()
            });
        }

        tabelaHistorico.setModel(modelo);
    }

private void carregarTabela(List<ModelMusica> lista) {
    String[] colunas = {"Nome", "Artista", "Gênero", "Curtida"};
    DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnIndex == 3 ? Boolean.class : String.class;
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    for (ModelMusica m : lista) {
        modelo.addRow(new Object[]{
            m.getNome(),
            m.getArtista(),
            m.getGenero(),
            m.isCurtida()
        });
    }

    tabelaHistorico.setModel(modelo);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaHistorico = new javax.swing.JTable();
        ultimas_musicas = new javax.swing.JButton();
        musicas_curtidas = new javax.swing.JButton();
        musicas_descurtidas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaHistorico);

        ultimas_musicas.setText("Ultimas Músicas Buscadas");
        ultimas_musicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ultimas_musicasActionPerformed(evt);
            }
        });

        musicas_curtidas.setText("Músicas Curtidas");
        musicas_curtidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicas_curtidasActionPerformed(evt);
            }
        });

        musicas_descurtidas.setText("Músicas Descurtidas");
        musicas_descurtidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicas_descurtidasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(musicas_curtidas)
                        .addGap(31, 31, 31)
                        .addComponent(musicas_descurtidas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(ultimas_musicas)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(musicas_curtidas)
                    .addComponent(musicas_descurtidas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ultimas_musicas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ultimas_musicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultimas_musicasActionPerformed
    List<ModelMusica> lista = controller.buscarHistorico();
    carregarTabela(lista);
    }//GEN-LAST:event_ultimas_musicasActionPerformed

    private void musicas_curtidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicas_curtidasActionPerformed
    List<ModelMusica> lista = controller.buscarCurtidas(); 

    carregarTabela(lista);
    }//GEN-LAST:event_musicas_curtidasActionPerformed

    private void musicas_descurtidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicas_descurtidasActionPerformed
    List<ModelMusica> lista = controller.buscarDescurtidas();

    carregarTabela(lista);
    }//GEN-LAST:event_musicas_descurtidasActionPerformed

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
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton musicas_curtidas;
    private javax.swing.JButton musicas_descurtidas;
    private javax.swing.JTable tabelaHistorico;
    private javax.swing.JButton ultimas_musicas;
    // End of variables declaration//GEN-END:variables
}
