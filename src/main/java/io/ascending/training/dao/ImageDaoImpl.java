package io.ascending.training.dao;

import io.ascending.training.domain.Image;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDaoImpl implements ImageDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Image save(Image img) {
        sessionFactory.getCurrentSession().save(img);
        return img;
    }
}
