package io.ascending.training.dao;


import io.ascending.training.domain.Image;
import io.ascending.training.domain.User;
import org.hibernate.FlushMode;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserDaoImplTest extends DaoTestBase {
    @Autowired
    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager em;

    @Test
    @Transactional
    public void saveTest(){
        User expectedResult = new User();
        expectedResult.setUsername("zhang3");
        expectedResult.setEmail("test@gmail.com");
        expectedResult.setPassword("password123");
        expectedResult.setConfirmPassword("password123");
        userDao.save(expectedResult);
        List<User> actualResult = userDao.findAll();
        assertEquals(actualResult.size(),1);
        assertEquals(expectedResult.getId(),actualResult.get(0).getId());
    }

    @Test
    @Transactional
    public void findByIdEagerTest(){
        User expectedResult = new User();
        expectedResult.setUsername("zhang3");
        expectedResult.setEmail("test@gmail.com");
        expectedResult.setPassword("password123");
        expectedResult.setConfirmPassword("password123");
        userDao.save(expectedResult);
        Image img = new Image();
        img.setExtension("png");
        img.setUrl("https://test");
        img.setTitle("testImage");
        img.setUser(expectedResult);
        imageDao.save(img);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(expectedResult);
        User actualResult = userDao.findByIdEager(expectedResult.getId());
        assertEquals(actualResult.getImages().size(),1);
    }


}
