package hibernate.dao;

import java.util.List;

public interface HibernateDAO {
    void save(Object entity);

    <T> void delete(Class<T> entityClass, Integer id);

    void merge(Object entity);

    <T> List<T> show(Class<T> entityClass);

    <T> T get(Class<T> entityClass, Integer id);
}
