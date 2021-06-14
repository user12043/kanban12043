package ogr.user12043.kanban12043.dao;

import ogr.user12043.kanban12043.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user12043 on 10.07.2018 - 15:18
 * Part of project: kanban12043
 */
@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {
}
