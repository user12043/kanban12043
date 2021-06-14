package ogr.user12043.kanban12043.view.settings;

import ogr.user12043.kanban12043.Main;
import ogr.user12043.kanban12043.dao.DaoUtil;
import ogr.user12043.kanban12043.dao.TagDao;
import ogr.user12043.kanban12043.dao.TaskDao;
import ogr.user12043.kanban12043.model.Tag;
import ogr.user12043.kanban12043.model.Task;
import ogr.user12043.kanban12043.utils.Utils;
import ogr.user12043.kanban12043.view.settings.partial.TagView;
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
public class TagSettings extends javax.swing.JPanel {
    private static final Logger LOGGER = LogManager.getLogger(TagSettings.class);
    private final TagDao tagDao = DaoUtil.getTagDao();
    private final TaskDao taskDao = DaoUtil.getTaskDao();
    private List<Tag> tags = new ArrayList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ogr.user12043.kanban12043.view.settings.partial.RootPanel rootPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form TagSettings
     */
    public TagSettings() {
        initComponents();
        setName(Utils.getTag("entity.tags"));
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
        tags = tagDao.findAll(Sort.by("id").ascending());
        DefaultTableModel tableModel = Utils.generateTableModelFromList(tags, Tag.class, false);
        rootPanel.setTableModel(tableModel);
    }

    private void add(ActionEvent evt) {
        TagView view = new TagView(Main.mainPane, true);
        view.setTitle(Utils.getTag("options.add"));
        view.setVisible(true);
        refreshTable();
    }

    private void edit(ActionEvent e) {
        final int index = rootPanel.getTable().getSelectedRow();
        if (index == -1) {
            Utils.errorDialog(this, Utils.getTag("messages.error.notSelected"));
            return;
        }
        TagView view = new TagView(Main.mainPane, true);
        view.setTitle(Utils.getTag("options.edit"));
        view.setTag(tags.get(index));
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
            Tag tag = tags.get(index);

            // First delete the tag from associated tasks
            List<Task> tasks = tag.getTasks();
            for (Task task : tasks) {
                task.getTags().remove(tag);
                taskDao.save(task);
            }
            tagDao.delete(tag);
            refreshTable();
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
}
