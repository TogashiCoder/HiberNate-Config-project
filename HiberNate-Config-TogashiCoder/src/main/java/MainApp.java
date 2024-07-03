import hibernate.dao.HibernateDAO;
import hibernate.dao.HibernateDAOImpl;
import model.MyEntity;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        HibernateDAO dao = new HibernateDAOImpl();

        // Save a new entity
        MyEntity newEntity = new MyEntity();
        newEntity.setName("Sample Name");
        dao.save(newEntity);
        System.out.println("Saved Entity: " + newEntity.getId());

//        // Get an entity by ID
        MyEntity retrievedEntity = dao.get(MyEntity.class, newEntity.getId().intValue());
        if (retrievedEntity != null) {
            System.out.println("Retrieved Entity: " + retrievedEntity.getName());
        } else {
            System.out.println("Entity with ID " + newEntity.getId() + " not found.");
        }

//        // Show all entities
        List<MyEntity> entities = dao.show(MyEntity.class);
        System.out.println("All Entities:");
        for (MyEntity e : entities) {
            System.out.println(e.getName());
        }

//        // Update an entity
        retrievedEntity.setName("Updated Name");
        dao.merge(retrievedEntity);
//
//        // Delete an entity
        dao.delete(MyEntity.class, retrievedEntity.getId().intValue());
        System.out.println("Deleted Entity with ID: " + retrievedEntity.getId());
    }
}
