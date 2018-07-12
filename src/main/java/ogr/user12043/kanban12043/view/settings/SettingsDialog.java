package ogr.user12043.kanban12043.view.settings;

import ogr.user12043.kanban12043.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.table.DefaultTableModel;

/**
 * Created by user12043 on 10.07.2018 - 16:52
 * Part of project: kanban12043
 */
public class SettingsDialog extends javax.swing.JDialog {
    private static final Logger LOGGER = LogManager.getLogger(SettingsDialog.class);
    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane_settings;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form SettingsDialog
     */
    public SettingsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        buildContent();
        setTitle(Utils.getTag("toolbar.settings"));
    }

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
            java.util.logging.Logger.getLogger(SettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SettingsDialog dialog = new SettingsDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private void buildContent() {
        try {
            jTabbedPane_settings.add(new KanbanColumnSettings());
        } catch (Exception e) {
            LOGGER.error("An error occurred on build settings", e);
        }
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane_settings = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTabbedPane_settings, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTabbedPane_settings, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
}