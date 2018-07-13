package ogr.user12043.kanban12043.model;

import ogr.user12043.kanban12043.utils.DisplayField;

import javax.persistence.*;

/**
 * Created by user12043 on 06.07.2018 - 11:54
 * Part of project: kanban12043
 */
@Entity(name = "SUBTASK")
public class SubTask {
    @Id
    @SequenceGenerator(name = "seq_subtask", allocationSize = 1)
    @GeneratedValue(generator = "seq_subtask", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;
    @ManyToOne(targetEntity = Task.class)
    @JoinColumn(name = "ROOT_TASK")
    private Task rootTask;
    @Column(name = "CONTENT")
    @DisplayField(key = "entity.common.content")
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Task getRootTask() {
        return rootTask;
    }

    public void setRootTask(Task rootTask) {
        this.rootTask = rootTask;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
