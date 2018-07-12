package ogr.user12043.kanban12043.model;

import ogr.user12043.kanban12043.view.DisplayField;

import javax.persistence.*;

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
    private int id;
    @Column(name = "NAME")
    @DisplayField(key = "entity.common.name")
    private String name;
    @Column(name = "COLOR")
    @DisplayField(key = "entity.tag.color")
    private int color;
    @Column(name = "IS_DEFAULT")
    @DisplayField(key = "entity.common.isDefault")
    private boolean isDefault;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
