package ogr.user12043.kanban12043.model;

import ogr.user12043.kanban12043.utils.DisplayField;

import javax.persistence.*;

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
    @DisplayField("Id")
    private int id;

    @Column(name = "NAME", length = 50)
    @DisplayField(key = "entity.common.name")
    private String name;

    @Column(name = "COLUMN_LIMIT")
    @DisplayField(key = "entity.kanbanColumn.columnLimit")
    private int columnLimit;

    @Column(name = "ORDINAL")
    private int ordinal; // Change sort property "ordinal" on KanbanColumnSettings.refreshTable when change this property's name

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

    public int getColumnLimit() {
        return columnLimit;
    }

    public void setColumnLimit(int limit) {
        this.columnLimit = limit;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int order) {
        this.ordinal = order;
    }
}
