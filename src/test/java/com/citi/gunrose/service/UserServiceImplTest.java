package java.com.citi.gunrose.service;

import com.citi.gunrose.dao.UserDao;
import com.citi.gunrose.persistence.model.User;
import com.citi.gunrose.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by miaochangfu on 2017/8/10.
 */
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService = new UserServiceImpl();

    @Mock(name = "userDao")
    private UserDao userDao;

    @Before
    public void  setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testQueryList() {
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setUserId(1);
        user.setEmail("wq");
        user.setPassword("ppp");
        user.setUserName("name");
        list.add(user);
        when(userDao.queryList(Mockito.any(User.class))).thenReturn(list);

        List<User> users = userService.queryList(user);

        Assert.assertNotNull(users);
    }
}
