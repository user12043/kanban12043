package ogr.user12043.kanban12043.view.settings;

import ogr.user12043.kanban12043.Main;
import ogr.user12043.kanban12043.dao.KanbanColumnDao;
import ogr.user12043.kanban12043.model.KanbanColumn;
import ogr.user12043.kanban12043.utils.Constants;
import ogr.user12043.kanban12043.utils.Utils;
import ogr.user12043.kanban12043.view.settings.partial.KanbanColumnView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Sort;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user12043 on 11.07.2018 - 17:20
 * Part of project: kanban12043
 */
public class KanbanColumnSettings extends javax.swing.JPanel {
    private static final Logger LOGGER = LogManager.getLogger(KanbanColumnSettings.class);
    private final KanbanColumnDao dao = Constants.context.getBean("kanbanColumnDao", KanbanColumnDao.class);
    private List<KanbanColumn> kanbanColumns = new ArrayList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_down;
    private javax.swing.JButton jButton_up;
    private ogr.user12043.kanban12043.view.settings.partial.RootPanel rootPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form KanbanColumnSettings
     */
    public KanbanColumnSettings() {
        initComponents();
        setName(Utils.getTag("entity.kanbanColumns"));
        refreshTable();
        addActions();
    }

    private void addActions() {
        // Button actions
        rootPanel.addAddListener(this::add);
        rootPanel.addEditListener(this::edit);
        /*rootPanel.addDeleteListener(e -> {
            delete(e);
        });*/
        rootPanel.addDeleteListener(this::delete);
    }

    private void refreshTable() {
        kanbanColumns = dao.findAll(new Sort(Sort.Direction.ASC, "ordinal", "id"));
        DefaultTableModel tableModel = Utils.generateTableModelFromList(kanbanColumns, KanbanColumn.class);
        rootPanel.setTableModel(tableModel);
    }

    private void add(ActionEvent evt) {
        KanbanColumnView view = new KanbanColumnView(Main.mainPane, true);
        view.setTitle(Utils.getTag("options.add"));
        view.setOrdinal(rootPanel.getTable().getRowCount());
        view.setVisible(true);
        refreshTable();
    }

    private void edit(ActionEvent e) {
        final int index = rootPanel.getTable().getSelectedRow();
        if (index == -1) {
            Utils.errorDialog(this, Utils.getTag("messages.error.notSelected"));
            return;
        }
        KanbanColumnView view = new KanbanColumnView(Main.mainPane, true);
        view.setTitle(Utils.getTag("options.edit"));
        view.setKanbanColum(kanbanColumns.get(index));
        view.setOrdinal(index);
        view.setVisible(true);
        refreshTable();
    }

    private void delete(ActionEvent e) {
        final int index = rootPanel.getTable().getSelectedRow();
        if (index == -1) {
            Utils.errorDialog(this, Utils.getTag("messages.error.notSelected"));
            return;
        }
        if (Utils.confirmDialog(this)) {
            List<KanbanColumn> changedKanbanColumns = new ArrayList<>();
            for (int i = index + 1; i < kanbanColumns.size(); i++) {
                KanbanColumn kanbanColumn = kanbanColumns.get(i);
                kanbanColumn.setOrdinal(kanbanColumn.getOrdinal() - 1);
                changedKanbanColumns.add(kanbanColumn);
            }
            dao.delete(kanbanColumns.get(index));
            dao.saveAll(changedKanbanColumns);
            refreshTable();
        }
    }

    private void indexChange(int offset) {
        int index = rootPanel.getTable().getSelectedRow();
        if (index != -1) {
            KanbanColumn kanbanColumn1 = kanbanColumns.get(index);
            KanbanColumn kanbanColumn2 = kanbanColumns.get(index + offset);
            kanbanColumn1.setOrdinal(index + offset);
            kanbanColumn2.setOrdinal(index);
            dao.save(kanbanColumn1);
            dao.save(kanbanColumn2);
            refreshTable();
            rootPanel.getTable().changeSelection(index + offset, 0, true, false);
        } else {
            Utils.errorDialog(this, Utils.getTag("messages.error.notSelected"));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new ogr.user12043.kanban12043.view.settings.partial.RootPanel();
        jButton_up = new javax.swing.JButton();
        jButton_down = new javax.swing.JButton();

        jButton_up.setText(Utils.getTag("options.up"));
        jButton_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_upActionPerformed(evt);
            }
        });

        jButton_down.setText(Utils.getTag("options.down"));
        jButton_down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_downActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton_up, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton_down, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(85, 85, 85)
                                                .addComponent(jButton_up)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton_down)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_upActionPerformed
        indexChange(-1);
    }//GEN-LAST:event_jButton_upActionPerformed

    private void jButton_downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_downActionPerformed
        indexChange(1);
    }//GEN-LAST:event_jButton_downActionPerformed
}
