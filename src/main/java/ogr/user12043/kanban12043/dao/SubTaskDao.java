package ogr.user12043.kanban12043.dao;

import ogr.user12043.kanban12043.model.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user12043 on 10.07.2018 - 15:01
 * Part of project: kanban12043
 */
public interface SubTaskDao extends JpaRepository<SubTask, Integer> {
}
