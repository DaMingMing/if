import com.kira.service.UserInfoService;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * Created by rensh on 2016/7/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class TestUserInfoService {

    private static final Logger LOGGER = Logger
            .getLogger(TestUserInfoService.class);
    @Autowired
    private UserInfoService userService;

//    @Test
//    public void testQueryById1() {
//        LOGGER.info(userService);
//        UserInfo userInfo = userService.getUserById(new Integer(1));
//        System.out.print(userInfo.toString());
//        LOGGER.info(userInfo.toString());
//    }



}
