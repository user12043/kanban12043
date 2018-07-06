package ogr.user12043.kanban12043.model;

import java.awt.*;
import java.util.List;

/**
 * Created by user12043 on 06.07.2018 - 11:18
 * Part of project: kanban12043
 */
public class TaskView {
    private String id;
    private String name;
    private Color foregroundColor;
    private Color backgroundColor;
    private List<Column> columns;
    private List<Topic> topics;
    private List<Tag> tags;
    private int[] statuses;
}
