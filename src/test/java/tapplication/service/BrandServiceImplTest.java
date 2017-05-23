package tapplication.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tapplication.configuration.ApplicationConfiguration;

import javax.naming.NamingException;

/**
 * Created by alexpench on 22.05.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class, BrandServiceTestConfig.class})
public class BrandServiceImplTest {

    @Test
    public void createTrue() throws NamingException {


    }


}