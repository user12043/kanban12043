package ogr.user12043.kanban12043.view;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import ogr.user12043.kanban12043.dao.*;
import ogr.user12043.kanban12043.model.*;
import ogr.user12043.kanban12043.utils.Constants;
import ogr.user12043.kanban12043.utils.Utils;
import org.springframework.data.domain.Sort;

import javax.swing.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by user12043 on 05.07.2018 - 09:38
 * Part of project: kanban12043
 */
public class TaskDialog extends javax.swing.JDialog {
    private Task task;

    private TopicDao topicDao = DaoUtil.getTopicDao();
    private List<Topic> topics = topicDao.findAll();

    private KanbanColumnDao kanbanColumnDao = DaoUtil.getKanbanColumnDao();
    private List<KanbanColumn> kanbanColumns = kanbanColumnDao.findAll(new Sort(Sort.Direction.ASC, "ordinal", "id"));

    private TagDao tagDao = DaoUtil.getTagDao();
    private List<Tag> tags = tagDao.findAll();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker datePicker_deadline;
    private javax.swing.JButton jButton_save;
    private javax.swing.JComboBox<String> jComboBox_kanbanColumn;
    private javax.swing.JComboBox<String> jComboBox_priority;
    private javax.swing.JComboBox<String> jComboBox_topic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_content;
    private javax.swing.JLabel jLabel_deadline;
    private javax.swing.JLabel jLabel_kanbanColumn;
    private javax.swing.JLabel jLabel_priority;
    private javax.swing.JLabel jLabel_progress;
    private javax.swing.JLabel jLabel_tags;
    private javax.swing.JLabel jLabel_topic;
    private javax.swing.JList<String> jList_tags;
    private javax.swing.JScrollPane jScrollPane_content;
    private javax.swing.JScrollPane jScrollPane_tags;
    private javax.swing.JSpinner jSpinner_progress;
    private javax.swing.JTextArea jTextArea_content;
    private ogr.user12043.kanban12043.view.settings.partial.RootPanel rootPanel_subTasks;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form TaskDialog
     */
    public TaskDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        rootPanel_subTasks.setTableModel(Utils.generateTableModelFromList(new ArrayList<>(), SubTask.class, true));
        rootPanel_subTasks.editing(false);
        addSubTaskEvents();
    }

    public void setTask(Task task) {
        jTextArea_content.setText(task.getContent());
        jComboBox_priority.setSelectedIndex(task.getPriority());
        jSpinner_progress.setValue(task.getProgress());
        if (task.hasDeadLine()) {
            datePicker_deadline.setDate(task.getDeadLine().toLocalDate());
        }

        Topic topic = task.getTopic();
        if (topic != null) {
            for (int i = 0; i < topics.size(); i++) {
                Topic t = topics.get(i);
                if (t.getId().equals(topic.getId())) {
                    jComboBox_topic.setSelectedIndex(i + 1);
                    break;
                }
            }
        } else {
            jComboBox_topic.setSelectedIndex(0);
        }

        jComboBox_kanbanColumn.setSelectedIndex((task.getKanbanColumn().getOrdinal()));
        jList_tags.setSelectedIndices(new int[]{});
        for (Tag tag : task.getTags()) {
            for (int i = 0; i < tags.size(); i++) {
                Tag t = tags.get(i);
                if (t.getId().equals(tag.getId())) {
                    jList_tags.addSelectionInterval(i, i);
                    break;
                }
            }
        }
        for (SubTask subTask : task.getSubTasks()) {
            rootPanel_subTasks.getTableModel().addRow(new Object[]{subTask.getContent(), subTask.getCompleted()});
        }

        this.task = task;
    }

    private void addSubTaskEvents() {
        rootPanel_subTasks.addAddListener(e -> {
            rootPanel_subTasks.getTableModel().addRow(new Vector());
            rootPanel_subTasks.getTable().editCellAt(rootPanel_subTasks.getTable().getRowCount() - 1, 0);
            rootPanel_subTasks.getTable().grabFocus();
        });

        rootPanel_subTasks.addDeleteListener(e -> {
            final int index = rootPanel_subTasks.getTable().getSelectedRow();
            if (index != -1) {
                rootPanel_subTasks.getTableModel().removeRow(index);
            } else {
                Utils.errorDialog(this, Utils.getTag("messages.error.notSelected"));
            }
        });
    }

    private ComboBoxModel<String> topicsComboBoxModel() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement(Utils.getTag("none"));
        for (Topic topic : topics) {
            model.addElement(topic.getName());
        }
        return model;
    }

    private ComboBoxModel<String> kanbanColumsComboBoxModel() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (KanbanColumn kanbanColumn : kanbanColumns) {
            model.addElement(kanbanColumn.getName());
        }
        return model;
    }

    private ListModel<String> tagsComboBoxModel() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Tag tag : tags) {
            model.addElement(tag.getName());
        }
        return model;
    }

    private DatePicker datePicker() {
        DatePickerSettings pickerSettings = new DatePickerSettings(Constants.locale);
        pickerSettings.setAllowKeyboardEditing(false);
        DatePicker picker = new DatePicker(pickerSettings);
        pickerSettings.setVetoPolicy(date -> !date.isBefore(LocalDate.now()));
        return picker;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane_content = new javax.swing.JScrollPane();
        jTextArea_content = new javax.swing.JTextArea();
        jComboBox_topic = Utils.getComboBox();
        jLabel_topic = new javax.swing.JLabel();
        jLabel_kanbanColumn = new javax.swing.JLabel();
        jComboBox_kanbanColumn = Utils.getComboBox();
        rootPanel_subTasks = new ogr.user12043.kanban12043.view.settings.partial.RootPanel();
        jLabel_priority = new javax.swing.JLabel();
        jComboBox_priority = Utils.getComboBox();
        jButton_save = new javax.swing.JButton();
        jLabel_progress = new javax.swing.JLabel();
        jSpinner_progress = Utils.getSpinner(0, 100);
        jScrollPane_tags = new javax.swing.JScrollPane();
        jList_tags = new javax.swing.JList<>();
        jLabel_tags = new javax.swing.JLabel();
        datePicker_deadline = datePicker();
        jLabel_deadline = new javax.swing.JLabel();
        jLabel_content = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jTextArea_content.setColumns(20);
        jTextArea_content.setRows(5);
        jScrollPane_content.setViewportView(jTextArea_content);

        jComboBox_topic.setModel(topicsComboBoxModel());

        jLabel_topic.setText(Utils.getTag("entity.topic") + "\t: ");

        jLabel_kanbanColumn.setText(Utils.getTag("entity.kanbanColumn") + "\t: ");

        jComboBox_kanbanColumn.setModel(kanbanColumsComboBoxModel());

        jLabel_priority.setText(Utils.getTag("entity.task.priority") + "\t: ");

        jComboBox_priority.setModel(new DefaultComboBoxModel<String>(Constants.priorities));

        jButton_save.setText(Utils.getTag("options.save"));
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_saveActionPerformed(evt);
            }
        });

        jLabel_progress.setText(Utils.getTag("entity.task.progress") + "\t: ");

        jList_tags.setModel(tagsComboBoxModel());
        jScrollPane_tags.setViewportView(jList_tags);
        for (int i = 0; i < tags.size(); i++) {
            Tag tag = tags.get(i);
            if (tag.getDefault()) {
                jList_tags.addSelectionInterval(i, i);
            }
        }

        jLabel_tags.setText(Utils.getTag("entity.tags") + "\t: ");

        jLabel_deadline.setText(Utils.getTag("entity.task.deadline") + "\t: ");

        jLabel_content.setText(Utils.getTag("entity.common.content"));

        jLabel1.setText(Utils.getTag("entity.subTasks"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton_save)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel_topic)
                                                                                .addComponent(jLabel_kanbanColumn)
                                                                                .addComponent(jLabel_priority))
                                                                        .addComponent(jLabel_deadline))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jComboBox_topic, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jComboBox_kanbanColumn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jComboBox_priority, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(datePicker_deadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                                        .addComponent(jScrollPane_content))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel_content)
                                                .addGap(156, 156, 156)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel_progress)
                                                        .addComponent(jLabel_tags))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jScrollPane_tags, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addComponent(jSpinner_progress, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(rootPanel_subTasks, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_content)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(rootPanel_subTasks, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jScrollPane_content, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jComboBox_topic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel_topic))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jComboBox_kanbanColumn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel_kanbanColumn))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jComboBox_priority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel_priority))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(datePicker_deadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel_deadline)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel_progress)
                                                        .addComponent(jSpinner_progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel_tags)
                                                        .addComponent(jScrollPane_tags, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(jButton_save)
                                .addContainerGap())
        );

        for (int i = 0; i < topics.size(); i++) {
            Topic topic = topics.get(i);
            if (topic.getDefault()) {
                jComboBox_topic.setSelectedIndex(i + 1);
            }
        }

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        if (this.task == null) {
            task = new Task();
            task.setCreatedDate(Date.valueOf(LocalDate.now()));
        } else {
            task.setUpdatedDate(Date.valueOf(LocalDate.now()));
        }
        String taskContent = jTextArea_content.getText();
        task.setContent((taskContent.isEmpty()) ? Constants.defaultName : taskContent);
        task.setPriority(jComboBox_priority.getSelectedIndex());
        task.setProgress((Integer) jSpinner_progress.getValue());
        task.setStatus(jComboBox_priority.getSelectedIndex());
        final LocalDate deadline = datePicker_deadline.getDate();
        if (deadline != null) {
            task.setHasDeadLine(true);
            task.setDeadLine(Date.valueOf(deadline));
        }

        final int selectedTopicIndex = jComboBox_topic.getSelectedIndex();
        if (selectedTopicIndex > 0) {
            task.setTopic(topics.get(selectedTopicIndex - 1));
        } else {
            task.setTopic(null);
        }

        final int selectedKanbanColumnIndex = jComboBox_kanbanColumn.getSelectedIndex();
        if (selectedKanbanColumnIndex > -1) {
            task.setKanbanColumn(kanbanColumns.get(selectedKanbanColumnIndex));
        }

        final int[] selectedTagsIndices = jList_tags.getSelectedIndices();
        if (selectedTagsIndices.length != 0) {
            task.setTags(new ArrayList<>());
            for (int selectedTagIndex : selectedTagsIndices) {
                task.getTags().add(tags.get(selectedTagIndex));
            }
        } else {
            task.setTags(null);
        }

        final int subtaskCount = rootPanel_subTasks.getTable().getRowCount();
        if (subtaskCount > 0) {
            task.setSubTasks(new ArrayList<>());
            for (int i = 0; i < subtaskCount; i++) {
                SubTask subTask = new SubTask();
                final String subTaskContent = (String) rootPanel_subTasks.getTableModel().getValueAt(i, 0);
                final Boolean completed = (Boolean) rootPanel_subTasks.getTableModel().getValueAt(i, 1);
                subTask.setContent((subTaskContent.isEmpty()) ? Constants.defaultName : subTaskContent);
                subTask.setCompleted(completed);
                task.getSubTasks().add(subTask);
            }
        }

        TaskDao taskDao = DaoUtil.getTaskDao();
        taskDao.save(task);
        dispose();
    }//GEN-LAST:event_jButton_saveActionPerformed
}
