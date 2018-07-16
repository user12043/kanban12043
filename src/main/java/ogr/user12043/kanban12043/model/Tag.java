package ogr.user12043.kanban12043.model;

import ogr.user12043.kanban12043.utils.DisplayField;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

/**
 * Created by user12043 on 06.07.2018 - 11:17
 * Part of project: kanban12043
 */
@Entity(name = "TAG")
public class Tag {
    @Id
    @SequenceGenerator(name = "seq_tag", allocationSize = 1)
    @GeneratedValue(generator = "seq_tag", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    @DisplayField(key = "entity.common.name")
    private String name;

    @Column(name = "COLOR")
    @DisplayField(key = "entity.tag.color")
    private Color color;

    @Column(name = "IS_DEFAULT")
    @DisplayField(key = "entity.common.isDefault")
    private Boolean isDefault;

    @ManyToMany(targetEntity = TaskView.class, mappedBy = "tags")
    private List<TaskView> taskViews;

    @ManyToMany(targetEntity = Task.class, mappedBy = "tags")
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Boolean isDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
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
