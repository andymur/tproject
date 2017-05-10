package tapplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.*;


//*
// * Created by alexpench on 21.04.17.
//

@Component
public class MessageSender {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(mappedName = "java:/ConnectionFactory")
    ConnectionFactory jmsConnectionFactory;

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(String msg) {
        jmsTemplate.setConnectionFactory(jmsConnectionFactory);
        jmsTemplate.send(session -> {
            logger.info("Send message =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            ObjectMessage objectMessage = session.createObjectMessage(msg);
            logger.info("Sent =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            return objectMessage;
        });
    }
}
