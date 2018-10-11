package io.ascending.training.dao;


import io.ascending.training.domain.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserDaoImplTest extends DaoTestBase {

    @Test
    public void saveTest(){
        User expectedResult = new User();
        expectedResult.setEmail("test@gmail.com");
        expectedResult.setPassword("password123");
        expectedResult.setConfirmPassword("password123");
        userDao.save(expectedResult);
        List<User> actualResult = userDao.findAll();
        assertEquals(actualResult.size(),1);
        assertEquals(expectedResult.getId(),actualResult.get(0).getId());
    }

}
