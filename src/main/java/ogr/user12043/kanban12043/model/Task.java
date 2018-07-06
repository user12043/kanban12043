package ogr.user12043.kanban12043.model;

import java.util.Date;
import java.util.List;

/**
 * Created by user12043 on 06.07.2018 - 11:10
 * Part of project: kanban12043
 */
public class Task {
    private String id;
    private Column column;
    private Topic topic;
    private String content;
    private int priority;
    private Date createdDate;
    private Date updatedDate;
    private Date deadLine;
    private boolean hasDeadLine;
    private Date finishDate;
    private int status;
    private List<Tag> tags;
    private int progress;
    private List<SubTask> subTasks;

    // Priority levels
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MEDIUM = 0;
    public static final int PRIORITY_HIGH = 1;

    // Task statuses
    public static final int STATUS_COMPLETED = 1;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_CANCELLED = -1;
}
