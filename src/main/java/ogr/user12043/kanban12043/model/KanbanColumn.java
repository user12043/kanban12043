package ogr.user12043.kanban12043.model;

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
    private int id;

    @Column(name = "COLUMN_LIMIT")
    private int columnLimit;

    @Column(name = "NAME", length = 50)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getColumnLimit() {
        return columnLimit;
    }

    public void setColumnLimit(int limit) {
        this.columnLimit = limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
