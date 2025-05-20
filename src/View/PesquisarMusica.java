
package View;

import Controller.ControllerMusica;
import Controller.ControllerPlaylist;
import Model.ModelMusica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PesquisarMusica extends JFrame {

    private ControllerMusica controllerMusica;
    private ControllerPlaylist controllerPlaylist;

    private JComboBox<String> cmbTipoBusca;
    private JTextField txtBusca;
    private JButton btnBuscar;
    private JButton btnCurtir;
    private JButton btnPlaylist;
    private JTable tabela;

    public PesquisarMusica() {
        controllerMusica = new ControllerMusica();
        controllerPlaylist = new ControllerPlaylist("Curtidas");

        initComponents();
        atualizarTabela(controllerMusica.getTodasMusicas());
    }

    private void initComponents() {
        setTitle("Pesquisar Músicas");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(720, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblBusca = new JLabel("Buscar por:");
        lblBusca.setBounds(20, 20, 80, 25);
        add(lblBusca);

        cmbTipoBusca = new JComboBox<>(new String[]{"Nome", "Artista", "Gênero"});
        cmbTipoBusca.setBounds(100, 20, 100, 25);
        add(cmbTipoBusca);

        txtBusca = new JTextField();
        txtBusca.setBounds(210, 20, 200, 25);
        add(txtBusca);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(420, 20, 100, 25);
        add(btnBuscar);

        btnCurtir = new JButton("Curtir/Descurtir");
        btnCurtir.setBounds(530, 20, 140, 25);
        add(btnCurtir);

        btnPlaylist = new JButton("Ver Playlist");
        btnPlaylist.setBounds(530, 60, 140, 25);
        add(btnPlaylist);

        tabela = new JTable();
        tabela.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Nome", "Artista", "Gênero", "Curtida"}
        ));
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(20, 100, 650, 240);
        add(scrollPane);

        // Ações dos botões
        btnBuscar.addActionListener(e -> {
            String termo = txtBusca.getText().trim();
            String tipo = (String) cmbTipoBusca.getSelectedItem();

            List<ModelMusica> resultado;
            if ("Nome".equals(tipo)) {
                resultado = controllerMusica.buscarPorNome(termo);
            } else if ("Artista".equals(tipo)) {
                resultado = controllerMusica.buscarPorArtista(termo);
            } else {
                resultado = controllerMusica.buscarPorGenero(termo);
            }

            atualizarTabela(resultado);
        });

        btnCurtir.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                String nomeMusica = (String) tabela.getValueAt(linha, 0);
                controllerMusica.alternarCurtida(nomeMusica);
                atualizarTabela(controllerMusica.getTodasMusicas());
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma música para curtir ou descurtir.");
            }
        });

        btnPlaylist.addActionListener(e -> {
            controllerPlaylist.atualizarPlaylist(controllerMusica.getTodasMusicas());
            List<ModelMusica> playlist = controllerPlaylist.getPlaylist().getMusicas();
            atualizarTabela(playlist);
        });
    }

    private void atualizarTabela(List<ModelMusica> musicas) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);

        for (ModelMusica m : musicas) {
            modelo.addRow(new Object[]{
                    m.getNome(),
                    m.getArtista(),
                    m.getGenero(),
                    m.isCurtida() ? "Sim" : "Não"
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PesquisarMusica().setVisible(true);
        });
    }
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
