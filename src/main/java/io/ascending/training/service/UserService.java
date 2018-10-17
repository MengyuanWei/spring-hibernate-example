package io.ascending.training.service;

import io.ascending.training.dao.UserDao;
import io.ascending.training.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public User save(User target){
        return userDao.save(target);
    }

    @Transactional(readOnly = true)
    public User findById(Long userId){
        return userDao.findById(userId);
    }

    @Transactional(readOnly = true)
    public List<User> findAll(){
        return userDao.findAll();
    }

}
