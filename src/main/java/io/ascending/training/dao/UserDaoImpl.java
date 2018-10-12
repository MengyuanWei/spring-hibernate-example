package io.ascending.training.dao;

import io.ascending.training.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User save(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    public List<User> findAll() {
        String hql = "FROM User";
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery(hql);
        return query.getResultList();
    }

    @Override
    public User findByIdEager(Long id) {
        String hql = "FROM User u JOIN FETCH u.images where u.id = ?1";
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery(hql).setParameter(1,id);
        return query.getSingleResult();
    }
}
