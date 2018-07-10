package ogr.user12043.kanban12043.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by user12043 on 06.07.2018 - 11:10
 * Part of project: kanban12043
 */
@Entity
public class Task {
    @Id
    @SequenceGenerator(name = "seq_task", allocationSize = 1)
    @GeneratedValue(generator = "seq_task", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int id;
    @ManyToOne(targetEntity = KanbanColumn.class)
    @JoinColumn(name = "KANBAN_COLUMN")
    private KanbanColumn kanbanColumn;
    @ManyToOne(targetEntity = Topic.class)
    @JoinColumn(name = "TOPIC")
    private Topic topic;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "PRIORITY")
    private int priority;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "UPDATED_DATE")
    private Date updatedDate;
    @Column(name = "DEADLINE")
    private Date deadLine;
    @Column(name = "HAS_DEAD_LINE")
    private boolean hasDeadLine;
    @Column(name = "FINISH_DATE")
    private Date finishDate;
    @Column(name = "STATUS")
    private int status;
    @OneToMany(targetEntity = Tag.class)
    @JoinColumn(name = "TAG")
    private List<Tag> tags;
    @Column(name = "PROGRESS")
    private int progress;
    @OneToMany(targetEntity = SubTask.class, mappedBy = "rootTask")
    private List<SubTask> subTasks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KanbanColumn getKanbanColumn() {
        return kanbanColumn;
    }

    public void setKanbanColumn(KanbanColumn kanbanColumn) {
        this.kanbanColumn = kanbanColumn;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isHasDeadLine() {
        return hasDeadLine;
    }

    public void setHasDeadLine(boolean hasDeadLine) {
        this.hasDeadLine = hasDeadLine;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    // Priority levels
    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    // Task statuses
    public enum Status {
        NONE,
        CANCELLED,
        COMPLETED
    }
}
