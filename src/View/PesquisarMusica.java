
package View;

import Controller.ControllerMusica;
import Model.ModelMusica;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;


public class PesquisarMusica extends javax.swing.JFrame {

    Controller.ControllerMusica controller = new Controller.ControllerMusica();

    
    /**
     * Creates new form PesquisarMusica
     */
    public PesquisarMusica() {
        initComponents();   
    }
 private void buscarMusicas() {
        String termo = tf_pesquisa.getText();
        List<ModelMusica> lista = controller.buscarMusicas(termo);

        for (ModelMusica m : lista) {
        controller.salvarHistorico(m);
}
        
        String[] colunas = {"Nome", "Artista", "Gênero", "Curtida"};

        DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) {
                    return Boolean.class; 
                }
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3; 
            }
        };

        for (ModelMusica m : lista) {
            Object[] linha = {
                m.getNome(),
                m.getArtista(),
                m.getGenero(),
                m.isCurtida()
            };
            modelo.addRow(linha);
        }

        tabela_pesquisa.setModel(modelo);

        modelo.addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 3) {
                int row = e.getFirstRow();
                String nomeMusica = (String) modelo.getValueAt(row, 0);
                Boolean curtida = (Boolean) modelo.getValueAt(row, 3);
                controller.atualizarCurtida(nomeMusica, curtida);
            }
        });
        
        
    }

    public ControllerMusica getController() {
        return controller;
    }

    public void setController(ControllerMusica controller) {
        this.controller = controller;
    }

    public JTable getTabela_pesquisa() {
        return tabela_pesquisa;
    }

    public void setTabela_pesquisa(JTable tabela_pesquisa) {
        this.tabela_pesquisa = tabela_pesquisa;
    }

    public JTextField getTf_pesquisa() {
        return tf_pesquisa;
    }

    public void setTf_pesquisa(JTextField tf_pesquisa) {
        this.tf_pesquisa = tf_pesquisa;
    }

    public JButton getBt_buscar() {
        return bt_buscar;
    }

    public void setBt_buscar(JButton bt_buscar) {
        this.bt_buscar = bt_buscar;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public ControllerMusica getC() {
        return c;
    }

    public void setC(ControllerMusica c) {
        this.c = c;
    }

    public JButton getbt_buscar() {
        return bt_buscar;
    }

    public void setbt_buscar(JButton bt_buscar) {
        this.bt_buscar = bt_buscar;
    }


    public JTable gettabela_pesquisa() {
        return tabela_pesquisa;
    }

    public void settabela_pesquisa(JTable tabela_pesquisa) {
        this.tabela_pesquisa = tabela_pesquisa;
    }

    public JTextField gettf_pesquisa() {
        return tf_pesquisa;
    }

    public void settf_pesquisa(JTextField tf_pesquisa) {
        this.tf_pesquisa = tf_pesquisa;
    }

    public JButton getVisualizar_curtidas() {
        return visualizar_curtidas;
    }

    public void setVisualizar_curtidas(JButton visualizar_curtidas) {
        this.visualizar_curtidas = visualizar_curtidas;
    }

    

  private void mostrarPlaylistCurtidas() {
    List<ModelMusica> lista = controller.buscarCurtidas();

    String[] colunas = {"Nome", "Artista", "Gênero", "Curtida"};

    DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 3) {
                return Boolean.class;
            }
            return String.class;
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 3; // Permite editar só a coluna Curtida
        }
    };

    for (ModelMusica m : lista) {
        Object[] linha = {
            m.getNome(),
            m.getArtista(),
            m.getGenero(),
            m.isCurtida()
        };
        modelo.addRow(linha);
    }

    tabela_pesquisa.setModel(modelo);

    modelo.addTableModelListener(e -> {
        if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 3) {
            int row = e.getFirstRow();
            String nomeMusica = (String) modelo.getValueAt(row, 0);
            Boolean curtida = (Boolean) modelo.getValueAt(row, 3);
            controller.atualizarCurtida(nomeMusica, curtida);
        }
    });
}

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_pesquisa = new javax.swing.JTextField();
        bt_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_pesquisa = new javax.swing.JTable();
        visualizar_curtidas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tf_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_pesquisaActionPerformed(evt);
            }
        });

        bt_buscar.setText("Buscar");
        bt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscarActionPerformed(evt);
            }
        });

        tabela_pesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Artista", "Gênero", "Curtida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela_pesquisa);

        visualizar_curtidas.setText("Visualizar Músicas Curtidas");
        visualizar_curtidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizar_curtidasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(tf_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(visualizar_curtidas)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_buscar))
                .addGap(11, 11, 11)
                .addComponent(visualizar_curtidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_pesquisaActionPerformed
        buscarMusicas();
    }//GEN-LAST:event_tf_pesquisaActionPerformed

    private void bt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscarActionPerformed
        buscarMusicas();
    }//GEN-LAST:event_bt_buscarActionPerformed

    private void visualizar_curtidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizar_curtidasActionPerformed
        mostrarPlaylistCurtidas();
    }//GEN-LAST:event_visualizar_curtidasActionPerformed
                                     
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
            java.util.logging.Logger.getLogger(PesquisarMusica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisarMusica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisarMusica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisarMusica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisarMusica().setVisible(true);
            }
        });
    }
    private ControllerMusica c;
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_buscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_pesquisa;
    private javax.swing.JTextField tf_pesquisa;
    private javax.swing.JButton visualizar_curtidas;
    // End of variables declaration//GEN-END:variables
}
