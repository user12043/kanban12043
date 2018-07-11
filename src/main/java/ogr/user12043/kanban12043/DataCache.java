package ogr.user12043.kanban12043;

import ogr.user12043.kanban12043.dao.*;
import ogr.user12043.kanban12043.model.*;
import ogr.user12043.kanban12043.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user12043 on 11.07.2018 - 09:02
 * Part of project: kanban12043
 */
public class DataCache {
    //<editor-fold desc="Data lists" defaultstate="collapsed">
    public static List<KanbanColumn> kanbanColumns = new ArrayList<>();
    public static List<SubTask> subTasks = new ArrayList<>();
    public static List<Tag> tags = new ArrayList<>();
    public static List<Task> tasks = new ArrayList<>();
    public static List<TaskView> taskViews = new ArrayList<>();
    public static List<Topic> topics = new ArrayList<>();
    //</editor-fold>
    //<editor-fold desc="Dao objects" defaultstate="collapsed">
    private static KanbanColumnDao kanbanColumnDao = Constants.context.getBean("kanbanColumnDao", KanbanColumnDao.class);
    private static SubTaskDao subTaskDao = Constants.context.getBean("subTaskDao", SubTaskDao.class);
    private static TagDao tagDao = Constants.context.getBean("tagDao", TagDao.class);
    private static TaskDao taskDao = Constants.context.getBean("taskDao", TaskDao.class);
    private static TaskViewDao taskViewDao = Constants.context.getBean("taskViewDao", TaskViewDao.class);
    private static TopicDao topicDao = Constants.context.getBean("topicDao", TopicDao.class);

    public static void refresh() {
        kanbanColumns = kanbanColumnDao.findAll();
        subTasks = subTaskDao.findAll();
        tags = tagDao.findAll();
        tasks = taskDao.findAll();
        taskViews = taskViewDao.findAll();
        topics = topicDao.findAll();
    }

    public static void flush() {
        kanbanColumnDao.saveAll(kanbanColumns);
        subTaskDao.saveAll(subTasks);
        tagDao.saveAll(tags);
        taskDao.saveAll(tasks);
        taskViewDao.saveAll(taskViews);
        topicDao.saveAll(topics);
    }
    //</editor-fold>
}
