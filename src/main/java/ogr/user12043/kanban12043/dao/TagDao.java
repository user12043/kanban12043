package ogr.user12043.kanban12043.dao;

import ogr.user12043.kanban12043.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user12043 on 10.07.2018 - 14:35
 * Part of project: kanban12043
 */
@Repository
public interface TagDao extends JpaRepository<Tag, Integer> {

}
