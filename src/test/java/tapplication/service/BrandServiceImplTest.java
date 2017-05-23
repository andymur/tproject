package tapplication.service;

import org.aspectj.lang.annotation.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tapplication.configuration.ApplicationConfiguration;

import javax.jms.ConnectionFactory;
import javax.naming.NamingException;

/**
 * Created by alexpench on 22.05.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BrandServiceTestConfig.class})
public class BrandServiceImplTest {

    @BeforeClass
    public static void init() throws NamingException {
        SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();

        builder.bind( "java:/ConnectionFactory" , Mockito.mock(ConnectionFactory.class));
        builder.activate();
    }

    @Test
    public void createTrue() throws NamingException {

    }


}