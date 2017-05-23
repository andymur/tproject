package tapplication.service;

import org.junit.BeforeClass;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * Created by alexpench on 22.05.17.
 */
@Configuration
public class BrandServiceTestConfig {

    public BrandServiceTestConfig() throws NamingException {
    }

    @BeforeClass
    public static void init() throws NamingException {
        Hashtable env = new Hashtable();
        env.put("ConnectionFactory", "java:/ConnectionFactory");
        Context ctx = new InitialContext(env);
    }

    @Bean
    public WebApiService webApiService() {
        return Mockito.mock(WebApiService.class);
    }

    @Bean
    public MessageSender sender() throws NamingException {
        return Mockito.mock(MessageSender.class);
    }

    @Bean
    @Resource(mappedName = "java:/ConnectionFactory")
    public ConnectionFactory connectionFactory() throws NamingException {
        return Mockito.mock(ConnectionFactory.class);
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        return Mockito.mock(JmsTemplate.class);
    }

    Context initialContext = new InitialContext();
}
