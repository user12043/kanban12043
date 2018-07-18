package ogr.user12043.kanban12043.model;

import ogr.user12043.kanban12043.utils.DisplayField;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

    @ManyToMany(mappedBy = "tags")
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
