package com.akhkyamiev.spring.springboot.dao;

import com.akhkyamiev.spring.springboot.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> listAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public User getUser(int Id) {
        return entityManager.find(User.class, Id);
    }
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }
    public void update(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }
    public void delete(int id) {
        User user = getUser(id);
        entityManager.remove(user);
        entityManager.flush();
    }

}
