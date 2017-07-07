package sample.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import sample.redis.CacheDuration;
import sample.service.PersonServiceIF;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/5/7
 * \* Time: 下午3:16
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Service
public class PersonSeriviceImpl implements PersonServiceIF {

    private Logger logger = LoggerFactory.getLogger(PersonSeriviceImpl.class);

    @Cacheable(value = "personCache1")
    @CacheDuration(duration = 30)
    public String getNameFromDB() {
        logger.info("~~~~~~~~~logger info~~~~~~~~~~~");
        return "hi";
    }

}