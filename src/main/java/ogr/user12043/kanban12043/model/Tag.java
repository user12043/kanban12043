package ogr.user12043.kanban12043.model;

import ogr.user12043.kanban12043.utils.DisplayField;

import javax.persistence.*;
import java.awt.*;

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
    @DisplayField("Id")
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
}
