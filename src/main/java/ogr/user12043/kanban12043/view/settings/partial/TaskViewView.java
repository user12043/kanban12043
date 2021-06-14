package ogr.user12043.kanban12043.view.settings.partial;

import ogr.user12043.kanban12043.dao.*;
import ogr.user12043.kanban12043.model.KanbanColumn;
import ogr.user12043.kanban12043.model.Tag;
import ogr.user12043.kanban12043.model.TaskView;
import ogr.user12043.kanban12043.model.Topic;
import ogr.user12043.kanban12043.utils.Constants;
import ogr.user12043.kanban12043.utils.Utils;
import org.springframework.data.domain.Sort;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user12043 on 15.07.2018 - 16:09
 * Part of project: kanban12043
 */
public class TaskViewView extends javax.swing.JDialog {
    private TaskView taskView;
    private int currentOrdinal;
    private List<KanbanColumn> kanbanColumns;
    private List<Topic> topics;
    private List<Tag> tags;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_backgroundColor;
    private javax.swing.JButton jButton_cancel;
    private javax.swing.JButton jButton_foregroundColor;
    private javax.swing.JButton jButton_save;
    private javax.swing.JLabel jLabel_backgroundColor;
    private javax.swing.JLabel jLabel_foregroundColor;
    private javax.swing.JLabel jLabel_kanbanColumns;
    private javax.swing.JLabel jLabel_name;
    private javax.swing.JLabel jLabel_tags;
    private javax.swing.JLabel jLabel_topics;
    private javax.swing.JList<String> jList_kanbanColumns;
    private javax.swing.JList<String> jList_tags;
    private javax.swing.JList<String> jList_topics;
    private javax.swing.JScrollPane jScrollPane_kanbanColumns;
    private javax.swing.JScrollPane jScrollPane_tags;
    private javax.swing.JScrollPane jScrollPane_topics;
    private javax.swing.JTextField jTextField_name;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form TaskViewView
     */
    public TaskViewView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setTaskView(TaskView taskView) {
        this.taskView = taskView;
        jTextField_name.setText(taskView.getName());
        jButton_foregroundColor.setBackground(taskView.getForegroundColor());
        jButton_backgroundColor.setBackground(taskView.getBackgroundColor());
        for (KanbanColumn kanbanColumn : taskView.getKanbanColumns()) {
            int index = ((DefaultListModel<String>) jList_kanbanColumns.getModel()).indexOf(kanbanColumn.getName());
            jList_kanbanColumns.addSelectionInterval(index, index);
        }
        for (Tag tag : taskView.getTags()) {
            int index = ((DefaultListModel<String>) jList_tags.getModel()).indexOf(tag.getName());
            jList_tags.addSelectionInterval(index, index);
        }
        for (Topic topic : taskView.getTopics()) {
            int index = ((DefaultListModel<String>) jList_topics.getModel()).indexOf(topic.getName());
            jList_topics.addSelectionInterval(index, index);
        }
        jTextField_name.selectAll();
    }

    public void setOrdinal(int ordinal) {
        this.currentOrdinal = ordinal;
    }

    private ListModel<String> kanbanColumnsListModel() {
        DefaultListModel<String> model = new DefaultListModel<>();
        KanbanColumnDao kanbanColumnDao = DaoUtil.getKanbanColumnDao();
        kanbanColumns = kanbanColumnDao.findAll(Sort.by("id").ascending());
        for (KanbanColumn column : kanbanColumns) {
            model.addElement(column.getName());
        }
        return model;
    }

    private ListModel<String> topicsListModel() {
        DefaultListModel<String> model = new DefaultListModel<>();
        TopicDao dao = DaoUtil.getTopicDao();
        topics = dao.findAll(Sort.by("id").ascending());
        for (Topic topic : topics) {
            model.addElement(topic.getName());
        }
        return model;
    }

    private ListModel<String> tagsListModel() {
        DefaultListModel<String> model = new DefaultListModel<>();
        TagDao dao = DaoUtil.getTagDao();
        tags = dao.findAll(Sort.by("id").ascending());
        for (Tag tag : tags) {
            model.addElement(tag.getName());
        }
        return model;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_save = new javax.swing.JButton();
        jButton_cancel = new javax.swing.JButton();
        jTextField_name = new javax.swing.JTextField();
        jLabel_name = new javax.swing.JLabel();
        jLabel_foregroundColor = new javax.swing.JLabel();
        jButton_foregroundColor = Utils.getColorableButton();
        jLabel_backgroundColor = new javax.swing.JLabel();
        jButton_backgroundColor = Utils.getColorableButton();
        jScrollPane_kanbanColumns = new javax.swing.JScrollPane();
        jList_kanbanColumns = new javax.swing.JList<>();
        jLabel_kanbanColumns = new javax.swing.JLabel();
        jLabel_topics = new javax.swing.JLabel();
        jScrollPane_topics = new javax.swing.JScrollPane();
        jList_topics = new javax.swing.JList<>();
        jScrollPane_tags = new javax.swing.JScrollPane();
        jList_tags = new javax.swing.JList<>();
        jLabel_tags = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setResizable(false);

        jButton_save.setText(Utils.getTag("options.save"));
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_saveActionPerformed(evt);
            }
        });

        jButton_cancel.setText(Utils.getTag("options.cancel"));
        jButton_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelActionPerformed(evt);
            }
        });

        jLabel_name.setText(Utils.getTag("entity.common.name") + "\t: ");

        jLabel_foregroundColor.setText(Utils.getTag("entity.common.foregroundColor") + "\t: ");

        jButton_foregroundColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_foregroundColorActionPerformed(evt);
            }
        });

        jLabel_backgroundColor.setText(Utils.getTag("entity.common.backgroundColor") + "\t: ");

        jButton_backgroundColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backgroundColorActionPerformed(evt);
            }
        });

        jList_kanbanColumns.setModel(kanbanColumnsListModel());
        jScrollPane_kanbanColumns.setViewportView(jList_kanbanColumns);

        jLabel_kanbanColumns.setText(Utils.getTag("entity.kanbanColumns") + "\t: ");

        jLabel_topics.setText(Utils.getTag("entity.topics") + "\t: ");

        jList_topics.setModel(topicsListModel());
        jScrollPane_topics.setViewportView(jList_topics);

        jList_tags.setModel(tagsListModel());
        jScrollPane_tags.setViewportView(jList_tags);

        jLabel_tags.setText(Utils.getTag("entity.tags") + "\t: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton_save)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton_cancel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel_name, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel_foregroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel_backgroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel_kanbanColumns, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addComponent(jLabel_topics, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addComponent(jLabel_tags, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jButton_foregroundColor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton_backgroundColor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane_kanbanColumns, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane_topics, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane_tags, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton_foregroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_foregroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton_backgroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_backgroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_kanbanColumns, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane_kanbanColumns, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_topics, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane_topics, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_tags, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane_tags, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton_cancel)
                                        .addComponent(jButton_save))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_jButton_cancelActionPerformed

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        final TaskViewDao dao = DaoUtil.getTaskViewDao();
        if (taskView == null) {
            taskView = new TaskView();
        }
        String name = jTextField_name.getText();
        taskView.setName((name.isEmpty()) ? Constants.defaultName : name);
        taskView.setForegroundColor(jButton_foregroundColor.getBackground());
        taskView.setBackgroundColor(jButton_backgroundColor.getBackground());
        taskView.setKanbanColumns(new ArrayList<>());
        for (int i : jList_kanbanColumns.getSelectedIndices()) {
            taskView.getKanbanColumns().add(kanbanColumns.get(i));
        }
        taskView.setTags(new ArrayList<>());
        for (int i : jList_tags.getSelectedIndices()) {
            taskView.getTags().add(tags.get(i));
        }
        taskView.setTopics(new ArrayList<>());
        for (int i : jList_topics.getSelectedIndices()) {
            taskView.getTopics().add(topics.get(i));
        }
        taskView.setOrdinal(currentOrdinal);

        dao.save(taskView);
        dispose();
    }//GEN-LAST:event_jButton_saveActionPerformed

    private void jButton_foregroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_foregroundColorActionPerformed
        Color color = Utils.selectColor(this, jButton_foregroundColor.getBackground());
        jButton_foregroundColor.setBackground(color);
    }//GEN-LAST:event_jButton_foregroundColorActionPerformed

    private void jButton_backgroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backgroundColorActionPerformed
        Color color = Utils.selectColor(this, jButton_backgroundColor.getBackground());
        jButton_backgroundColor.setBackground(color);
    }//GEN-LAST:event_jButton_backgroundColorActionPerformed
}
