package ogr.user12043.kanban12043.dao;

import ogr.user12043.kanban12043.model.KanbanColumn;
import ogr.user12043.kanban12043.utils.Constants;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class KanbanColumnDao {

    // A get function to get this bean from out of spring context
    public static KanbanColumnDao getDao() {
        return Constants.context.getBean("kanbanColumnDao", KanbanColumnDao.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(KanbanColumn kanbanColumn) {
        entityManager.persist(kanbanColumn);
    }

    @Transactional(readOnly = true)
    public List<KanbanColumn> getAll() {
        return entityManager.createQuery("select kc from KANBAN_COLUMN kc", KanbanColumn.class).getResultList();
    }
}
