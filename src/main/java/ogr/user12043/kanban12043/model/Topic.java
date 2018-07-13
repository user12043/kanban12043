package ogr.user12043.kanban12043.model;

import ogr.user12043.kanban12043.utils.DisplayField;

import javax.persistence.*;
import java.awt.*;

/**
 * Created by user12043 on 06.07.2018 - 11:17
 * Part of project: kanban12043
 */
@Entity(name = "TOPIC")
public class Topic {
    @Id
    @SequenceGenerator(name = "seq_topic", allocationSize = 1)
    @GeneratedValue(generator = "seq_topic", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    @DisplayField("Id")
    private Integer id;
    @Column(name = "NAME")
    @DisplayField(key = "entity.common.name")
    private String name;
    @Column(name = "FOREGROUND_COLOR")
    @DisplayField(key = "entity.common.foregroundColor")
    private Integer foregroundColor;
    @Column(name = "BACKGROUND_COLOR")
    @DisplayField(key = "entity.common.backgroundColor")
    private Integer backgroundColor;
    @Column(name = "IS_DEFAULT")
    @DisplayField(key = "entity.common.isDefault")
    private Boolean isDefault;

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

    public Integer getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Integer foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public Integer getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Integer backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Boolean isDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }
}
