package ogr.user12043.kanban12043.model;

import ogr.user12043.kanban12043.utils.DisplayField;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by user12043 on 06.07.2018 - 11:10
 * Part of project: kanban12043
 */
@Entity(name = "TASK")
public class Task {
    @Id
    @SequenceGenerator(name = "seq_task", allocationSize = 1)
    @GeneratedValue(generator = "seq_task", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "KANBAN_COLUMN")
    private KanbanColumn kanbanColumn;

    @ManyToOne
    @JoinColumn(name = "TOPIC")
    private Topic topic;

    @Column(name = "CONTENT")
    @DisplayField(key = "entity.common.content")
    private String content;

    @Column(name = "PRIORITY")
    @DisplayField(key = "entity.task.priority")
    private Integer priority;

    @Column(name = "CREATED_DATE")
    @DisplayField(key = "entity.task.createdDate")
    private Date createdDate;

    @Column(name = "UPDATED_DATE")
    @DisplayField(key = "entity.task.updatedDate")
    private Date updatedDate;

    @Column(name = "DEADLINE")
    @DisplayField(key = "entity.task.deadline")
    private Date deadLine;

    @Column(name = "HAS_DEAD_LINE")
    private Boolean hasDeadLine;

    @Column(name = "FINISH_DATE")
    @DisplayField(key = "entity.task.finishedDate")
    private Date finishDate;

    @Column(name = "STATUS")
    private Integer status;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Tag> tags;

    @Column(name = "PROGRESS")
    private Integer progress;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<SubTask> subTasks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
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

    public Boolean hasDeadLine() {
        return hasDeadLine;
    }

    public void setHasDeadLine(Boolean hasDeadLine) {
        this.hasDeadLine = hasDeadLine;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    // Task statuses
    public enum Status {
        NONE,
        CANCELLED,
        COMPLETED
    }
}
