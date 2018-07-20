package ogr.user12043.kanban12043.view;

import ogr.user12043.kanban12043.utils.Constants;
import ogr.user12043.kanban12043.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;

/**
 * Created by user12043 on 19.07.2018 - 13:42
 * Part of project: kanban12043
 */
public class TimerPanel extends javax.swing.JPanel {
    private static final Logger LOGGER = LogManager.getLogger(TimerPanel.class);
    private Timer timer;
    private int second;
    private int minute;
    private Clip clip;
    private int normalButtonSize = 30;
    private int smallButtonSize = 25;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_longBreak;
    private javax.swing.JButton jButton_shortBreak;
    private javax.swing.JButton jButton_start;
    private javax.swing.JButton jButton_stop;
    private javax.swing.JLabel jLabel_minute;
    private javax.swing.JLabel jLabel_second;
    private javax.swing.JLabel jLabel_separate;
    // End of variables declaration//GEN-END:variables


    /**
     * Creates new form TimerPanel
     */
    public TimerPanel() {
        initComponents();
        initTimer();
    }

    private void initTimer() {
        timer = new Timer(1000, e -> {
            if (second == 0) {
                if (minute == 0) {
                    timer.stop();
                    toggleSound();
                    Utils.infoDialog(this, Utils.getTag("messages.info.timeEnd"));
                    toggleSound();
                } else {
                    second = 59;
                    minute--;
                }
            } else {
                second--;
            }
            jLabel_second.setText((second < 10) ? ("0" + second) : ("" + second));
            jLabel_minute.setText((minute < 10) ? ("0" + minute) : ("" + minute));
        });
        timer.setInitialDelay(0);
    }

    private void toggleSound() {
        try {
            // Get clip object
            if (clip == null) {
                clip = AudioSystem.getClip();
            }
            // Set position to beginning
//            clip.setFramePosition(0);

            // Open file
            if (!clip.isOpen()) {
                clip.open(Utils.getAudioStream("timeUp.wav", getClass()));
            }

            // Toggle playing
            if (!clip.isRunning()) {
                clip.start();
            } else {
                clip.stop();
            }
        } catch (Exception e) {
            LOGGER.error("Can not play sound!: ", e);
        }
    }

    private ImageIcon startIcon() {
        Image image = Utils.getImage("start.png", getClass());
        image = image.getScaledInstance(normalButtonSize, normalButtonSize, Image.SCALE_DEFAULT);
        return new ImageIcon(image);
    }

    private ImageIcon shortBreakIcon() {
        Image image = Utils.getImage("pause.png", getClass());
        image = image.getScaledInstance(smallButtonSize, smallButtonSize, Image.SCALE_DEFAULT);
        return new ImageIcon(image);
    }

    private ImageIcon longBreakIcon() {
        Image image = Utils.getImage("pause.png", getClass());
        image = image.getScaledInstance(normalButtonSize, normalButtonSize, Image.SCALE_DEFAULT);
        return new ImageIcon(image);
    }

    private ImageIcon stopIcon() {
        Image image = Utils.getImage("stop.png", getClass());
        image = image.getScaledInstance(normalButtonSize, normalButtonSize, Image.SCALE_DEFAULT);
        return new ImageIcon(image);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_second = new javax.swing.JLabel();
        jLabel_minute = new javax.swing.JLabel();
        jLabel_separate = new javax.swing.JLabel();
        jButton_start = Utils.getColorableButton();
        jButton_longBreak = Utils.getColorableButton();
        jButton_stop = Utils.getColorableButton();
        jButton_shortBreak = Utils.getColorableButton();

        jLabel_second.setFont(jLabel_second.getFont().deriveFont(jLabel_second.getFont().getSize() + 25f));
        jLabel_second.setText("00");

        jLabel_minute.setFont(jLabel_minute.getFont().deriveFont(jLabel_minute.getFont().getSize() + 25f));
        jLabel_minute.setText("00");

        jLabel_separate.setFont(jLabel_separate.getFont().deriveFont(jLabel_separate.getFont().getSize() + 25f));
        jLabel_separate.setText(":");

        jButton_start.setIcon(startIcon());
        jButton_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_startActionPerformed(evt);
            }
        });
        jButton_start.setSize(normalButtonSize, normalButtonSize);

        jButton_longBreak.setIcon(longBreakIcon());
        jButton_longBreak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_longBreakActionPerformed(evt);
            }
        });

        jButton_stop.setIcon(stopIcon());
        jButton_stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_stopActionPerformed(evt);
            }
        });

        jButton_shortBreak.setIcon(shortBreakIcon());
        jButton_shortBreak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_shortBreakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel_minute)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel_separate)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel_second)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_start, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_shortBreak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_longBreak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_stop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel_minute)
                                .addComponent(jLabel_separate)
                                .addComponent(jLabel_second))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton_shortBreak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton_start, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                                .addComponent(jButton_longBreak, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                                .addComponent(jButton_stop, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_startActionPerformed
        if (!timer.isRunning()) {
            timer.start();
        }
        minute = Constants.POMODORO_INTERVAL;
        second = 0;
    }//GEN-LAST:event_jButton_startActionPerformed

    private void jButton_shortBreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_shortBreakActionPerformed
        if (!timer.isRunning()) {
            timer.start();
        }
        minute = Constants.SHORT_BREAK_INTERVAL;
        second = 0;
    }//GEN-LAST:event_jButton_shortBreakActionPerformed

    private void jButton_longBreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_longBreakActionPerformed
        if (!timer.isRunning()) {
            timer.start();
        }
        minute = Constants.LONG_BREAK_INTERVAL;
        second = 0;
    }//GEN-LAST:event_jButton_longBreakActionPerformed

    private void jButton_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_stopActionPerformed
        if (timer.isRunning()) {
            timer.stop();
        }
        jLabel_minute.setText("00");
        jLabel_second.setText("00");
    }//GEN-LAST:event_jButton_stopActionPerformed
}