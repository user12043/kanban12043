package ogr.user12043.kanban12043.model;

import ogr.user12043.kanban12043.utils.DisplayField;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Created by user12043 on 06.07.2018 - 11:16
 * Part of project: kanban12043
 */
@Entity(name = "KANBAN_COLUMN")
public class KanbanColumn {
    @Id
    @SequenceGenerator(name = "seq_kanban_column", allocationSize = 1)
    @GeneratedValue(generator = "seq_kanban_column", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", length = 50)
    @DisplayField(key = "entity.common.name")
    private String name;

    @Column(name = "COLUMN_LIMIT")
    @DisplayField(key = "entity.kanbanColumn.columnLimit")
    private Integer columnLimit;

    @Column(name = "ORDINAL")
    private Integer ordinal; // Change sort property "ordinal" on KanbanColumnSettings.refreshTable when change this property's name

    @ManyToMany(targetEntity = TaskView.class, mappedBy = "kanbanColumns")
    private List<TaskView> taskViews;

    @OneToMany(targetEntity = Task.class, mappedBy = "kanbanColumn", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Task> tasks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getColumnLimit() {
        return columnLimit;
    }

    public void setColumnLimit(Integer limit) {
        this.columnLimit = limit;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer order) {
        this.ordinal = order;
    }

    public List<TaskView> getTaskViews() {
        return taskViews;
    }

    public void setTaskViews(List<TaskView> taskViews) {
        this.taskViews = taskViews;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
