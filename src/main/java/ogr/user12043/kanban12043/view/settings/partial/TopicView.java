package ogr.user12043.kanban12043.view.settings.partial;

import ogr.user12043.kanban12043.dao.TopicDao;
import ogr.user12043.kanban12043.model.Topic;
import ogr.user12043.kanban12043.utils.Constants;
import ogr.user12043.kanban12043.utils.Utils;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by user12043 on 12.07.2018 - 17:59
 * Part of project: kanban12043
 */
public class TopicView extends javax.swing.JDialog {
    private Topic topic;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_backgroundColor;
    private javax.swing.JButton jButton_cancel;
    private javax.swing.JButton jButton_foregroundColor;
    private javax.swing.JButton jButton_save;
    private javax.swing.JCheckBox jCheckBox_isDefault;
    private javax.swing.JLabel jLabel_backgroundColor;
    private javax.swing.JLabel jLabel_foregroundColor;
    private javax.swing.JLabel jLabel_isDefault;
    private javax.swing.JLabel jLabel_name;
    private javax.swing.JTextField jTextField_name;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form TagView
     */
    public TopicView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
        jTextField_name.setText(topic.getName());
        jTextField_name.selectAll();
        jButton_foregroundColor.setBackground(topic.getForegroundColor());
        jButton_backgroundColor.setBackground(topic.getBackgroundColor());
        jCheckBox_isDefault.setSelected(topic.isDefault());
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
        jLabel_isDefault = new javax.swing.JLabel();
        jCheckBox_isDefault = new javax.swing.JCheckBox();
        jLabel_backgroundColor = new javax.swing.JLabel();
        jButton_backgroundColor = Utils.getColorableButton();

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

        jLabel_isDefault.setText(Utils.getTag("entity.common.isDefault"));

        jLabel_backgroundColor.setText(Utils.getTag("entity.common.backgroundColor") + "\t: ");

        jButton_backgroundColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backgroundColorActionPerformed(evt);
            }
        });

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
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel_isDefault, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel_foregroundColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel_backgroundColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton_foregroundColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                        .addComponent(jCheckBox_isDefault, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                        .addComponent(jTextField_name, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton_backgroundColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_foregroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton_foregroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_backgroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton_backgroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_isDefault, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCheckBox_isDefault, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_save)
                                        .addComponent(jButton_cancel))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_saveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        final TopicDao dao = Constants.context.getBean("topicDao", TopicDao.class);
        if (topic == null) {
            topic = new Topic();
        }
        String name = jTextField_name.getText();
        if (name.isEmpty()) {
            name = Constants.defaultName;
        }
        topic.setName(name);
        topic.setForegroundColor(jButton_foregroundColor.getBackground());
        topic.setBackgroundColor(jButton_backgroundColor.getBackground());
        topic.setDefault(jCheckBox_isDefault.isSelected());

        dao.save(topic);
        dispose();
    }//GEN-LAST:event_jButton_saveActionPerformed

    private void jButton_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_jButton_cancelActionPerformed

    private void jButton_foregroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_foregroundColorActionPerformed
        Color color = Utils.selectColor(this, jButton_foregroundColor.getBackground());
        jButton_foregroundColor.setBackground(color);
    }//GEN-LAST:event_jButton_foregroundColorActionPerformed

    private void jButton_backgroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backgroundColorActionPerformed
        Color color = Utils.selectColor(this, jButton_backgroundColor.getBackground());
        jButton_backgroundColor.setBackground(color);
    }//GEN-LAST:event_jButton_backgroundColorActionPerformed
}
