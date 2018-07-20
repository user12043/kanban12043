package ogr.user12043.kanban12043.utils;

import ogr.user12043.kanban12043.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.List;

/**
 * Created by user12043 on 04.07.2018 - 19:19
 * Part of project: kanban12043
 */
public class Utils {
    private static final Logger logger = LogManager.getLogger(Utils.class);

    /**
     * Build the spring context
     */
    public static void buildContext() {
        try {
            Constants.context = new ClassPathXmlApplicationContext("application-context.xml");
        } catch (BeansException e) {
            logger.error("Error creating context", e);
            Utils.errorDialog(null, Utils.getTag("messages.error.createContextError") + "\n" + e.getCause().toString());
            System.exit(1);
        }
    }

    /**
     * read whole file
     *
     * @param fileName Filename to read
     * @return file content
     * @throws IOException I/O error occurs
     */
    public static String readFile(String fileName) throws IOException {
        StringBuilder builder;
        File file = new File(fileName);
        if (!file.exists()) {
            return "";
        }
        try (FileReader reader = new FileReader(file)) {
            builder = new StringBuilder();
            while (reader.ready()) {
                builder.append((char) reader.read());
            }
        }
        return builder.toString();
    }

    /**
     * @return Current system locale
     */
    private static Locale getLocale() {
        if (Constants.locale == null) {
            Constants.locale = Locale.forLanguageTag(Properties.lang);
        }
        return Constants.locale;
    }

    private static ResourceBundle getLangResource() {
        //<editor-fold desc="Load resource if null" defaultstate="collapsed">
        if (Constants.langResourceBundle == null) {
            Constants.langResourceBundle = ResourceBundle.getBundle((Constants.languageDirectory + "/" + Constants.args_languageArgumentName), new ResourceBundle.Control() {
                @Override
                public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload) throws IOException {
                    String bundleName = toBundleName(baseName, getLocale());
                    String resourceName = toResourceName(bundleName, "properties");
                    ResourceBundle bundle = null;
                    InputStream stream = null;
                    if (reload) {
                        URL url = loader.getResource(resourceName);
                        if (url != null) {
                            URLConnection connection = url.openConnection();
                            if (connection != null) {
                                connection.setUseCaches(false);
                                stream = connection.getInputStream();
                            }
                        }
                    } else {
                        stream = loader.getResourceAsStream(resourceName);
                    }

                    if (stream != null) {
                        try {
                            bundle = new PropertyResourceBundle(new InputStreamReader(stream, "UTF-8"));
                        } finally {
                            stream.close();
                        }
                    } else {
                        File file = new File(resourceName);
                        if (file.exists()) {
                            stream = new FileInputStream(file);
                            bundle = new PropertyResourceBundle(new InputStreamReader(stream, "UTF-8"));
                            stream.close();
                        }
                    }
                    return bundle;
                }
            });
        }
        //</editor-fold>

        return Constants.langResourceBundle;
    }

    /**
     * Finds given key's string from language file. If key does not exists, returns "unnamed"
     *
     * @param key String's key
     * @return String
     */
    public static String getTag(String key) {
        String tag;
        try {
            tag = getLangResource().getString(key);
        } catch (Exception e) {
            logger.error("Can not get tag from lang resource for key: " + key + ", for locale: " + Properties.lang);
            tag = Constants.defaultName;
        }
        return tag;
    }

    /**
     * Generates a table model with data for JTable from an entity. Entity fields must annotated
     * with @DisplayField annotation in order to get display names
     *
     * @param list        table data
     * @param entityClass display entity
     * @param <T>         entity type
     * @return generated table model
     */
    public static <T> DefaultTableModel generateTableModelFromList(List<T> list, Class entityClass, boolean editable) {
        Field[] declaredFields = entityClass.getDeclaredFields();
        List<Field> displayFields = new ArrayList<>();

        // Get fields with annotation
        for (Field field : declaredFields) {
            final DisplayField annotation = field.getAnnotation(DisplayField.class);
            if (annotation != null) {
                displayFields.add(field);
            }
        }

        List<Class<?>> fieldClasses = new ArrayList<>();
        Vector<String> columnIdentifiers = new Vector<>();
        for (Field field : displayFields) {
            fieldClasses.add(field.getType());
            final DisplayField annotation = field.getAnnotation(DisplayField.class);
            String name;
            if (!annotation.key().isEmpty()) {
                name = Utils.getTag(annotation.key());
            } else {
                name = annotation.value();
            }
            columnIdentifiers.add(name);
        }
        DefaultTableModel tableModel = new DefaultTableModel() {
            // Make table non editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return editable;
            }

            // Set column types
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return fieldClasses.get(columnIndex);
            }
        };
        tableModel.setColumnIdentifiers(columnIdentifiers);
        for (T t : list) {
            Vector<Object> rowVector = new Vector<>();
            for (Field field : displayFields) {
                try {
                    field.setAccessible(true);
                    rowVector.add(field.get(t));
                } catch (Exception e) {
                    logger.error("Can not get field value: " + field.getName());
                }
            }
            tableModel.addRow(rowVector);
        }

        return tableModel;
    }

    //
    public static TableCellRenderer cellRendererForColor() {
        return new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JTextField cell = new JTextField();
                cell.setBackground((Color) value);
                return cell;
            }
        };
    }

    public static void errorDialog(Component parent, String message) {
        String[] options = new String[]{getTag("options.ok")};
        JOptionPane.showOptionDialog(parent, message, getTag("messages.error"), JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
    }

    public static boolean confirmDialog(Component parent) {
        String[] options = new String[]{getTag("options.yes"), getTag("options.no")};
        final int i = JOptionPane.showOptionDialog(parent, getTag("messages.confirm"), "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return (i == 0);
    }

    public static void infoDialog(Component parent, String message) {
        String[] options = new String[]{getTag("options.ok")};
        JOptionPane.showOptionDialog(parent, message, getTag("messages.info"), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }

    public static Color selectColor(Dialog parent, Color initialColor) {
        JColorChooser chooser = new JColorChooser(initialColor);
        JDialog dialog = new JDialog(parent, true);
        dialog.setLayout(new FlowLayout());
        dialog.add(chooser);
        JButton button = new JButton(Utils.getTag("options.ok"));
        button.addActionListener(e -> dialog.dispose());
        dialog.add(button);
        dialog.pack();
        dialog.setLocationByPlatform(true);
        dialog.setResizable(false);
        dialog.setVisible(true);
        return chooser.getColor();
    }

    public static void setTheme(int themeIndex) {
        if (themeIndex < 0 || themeIndex >= Constants.themes.length) {
            return;
        }
        try {
            String className = Constants.themes[themeIndex];
            Class.forName(className);
            UIManager.setLookAndFeel(className);
//            SwingUtilities.updateComponentTreeUI(Main.mainPane);
        } catch (ClassNotFoundException e) {
            Utils.errorDialog(Main.mainPane, Utils.getTag("messages.error.theme.themeNotFound"));
            Properties.updateProperty(Constants.args_themeArgumentName, 1);
            Properties.theme = 0;
        } catch (IllegalAccessException | InstantiationException e) {
            Utils.errorDialog(Main.mainPane, Utils.getTag("messages.error.theme.loadError"));
            Properties.updateProperty(Constants.args_themeArgumentName, 1);
            Properties.theme = 0;
        } catch (UnsupportedLookAndFeelException e) {
            Utils.errorDialog(Main.mainPane, Utils.getTag("messages.error.theme.unsupported"));
            Properties.updateProperty(Constants.args_themeArgumentName, 1);
            Properties.theme = 0;
        }
    }

    public static JButton getColorableButton() {
        JButton button = new JButton();
        // Prevent theme's colors
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
        return button;
    }

    public static JSpinner getSpinner(int minValue, int maxvalue) {
        JSpinner spinner = new JSpinner();
        spinner.addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int rotation = e.getWheelRotation();
                if (rotation < 0) {
                    spinner.setValue(spinner.getNextValue());
                } else {
                    spinner.setValue(spinner.getPreviousValue());
                }
            }
        });
        spinner.addChangeListener(e -> {
            if (minValue != -1 && ((int) spinner.getValue()) < minValue) {
                spinner.setValue(minValue);
            } else if (maxvalue != -1 && ((int) spinner.getValue()) > maxvalue) {
                spinner.setValue(maxvalue);
            }
        });

        return spinner;
    }

    public static JComboBox getComboBox() {
        JComboBox comboBox = new JComboBox();
        comboBox.addMouseWheelListener(e -> {
            JComboBox source = (JComboBox) e.getSource();
            final int index = source.getSelectedIndex() + e.getWheelRotation();
            if (index >= 0 && index < source.getItemCount()) {
                source.setSelectedIndex(index);
            }
        });
        return comboBox;
    }

    public static Image getImage(String name, Class clazz) {
        ImageIcon imageIcon = new ImageIcon(name);
        if (imageIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            // Get image from jar file
            URL resource = clazz.getClassLoader().getResource(Constants.resourceDirectory + "/" + name);
            if (resource != null) {
                imageIcon = new ImageIcon(resource);
            }
        }
        return imageIcon.getImage();
    }

    public static AudioInputStream getAudioStream(String name, Class clazz) throws IOException, UnsupportedAudioFileException {
        AudioInputStream inputStream;
        BufferedInputStream bufferedInputStream;
        final String path = Constants.resourceDirectory + "/" + name;

        File audioFile = new File(path);
        if (audioFile.exists()) {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(audioFile));
        } else {
            bufferedInputStream = new BufferedInputStream(clazz.getClassLoader().getResourceAsStream(path));
        }

        inputStream = AudioSystem.getAudioInputStream(bufferedInputStream);
        return inputStream;
    }
}
