package ogr.user12043.kanban12043.dao;

import ogr.user12043.kanban12043.model.KanbanColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KanbanColumnDao extends JpaRepository<KanbanColumn, Integer> {

}
