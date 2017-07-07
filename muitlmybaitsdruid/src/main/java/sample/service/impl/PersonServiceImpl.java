package sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.dao.PersonDao;
import sample.datasource.TargetDataSource;
import sample.dto.PersonDTO;
import sample.service.PersonServiceIF;

import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/4/19
 * \* Time: 下午6:46
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Service
public class PersonServiceImpl implements PersonServiceIF{

    @Autowired
    private PersonDao personDao;

    @Override
    @TargetDataSource(name = "reader")
    public PersonDTO getPersonById(String id) {
        return personDao.getPersonById(id);
    }

    @Override
    @TargetDataSource(name = "root")
    @Transactional
    public int updatePersonById(Map<String, Object> param) {
        int result = personDao.updatePersonById(param);
        return result;
    }
}