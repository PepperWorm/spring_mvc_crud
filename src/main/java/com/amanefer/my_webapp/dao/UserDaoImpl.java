package com.amanefer.my_webapp.dao;

import com.amanefer.my_webapp.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(User.class, id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user) {
        Session session = sessionFactory.getCurrentSession();

        User updatedUser = session.get(User.class, id);

        updatedUser.setName(user.getName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setDepartment(user.getDepartment());
        updatedUser.setSalary(user.getSalary());
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.remove(session.get(User.class, id));
    }
}
