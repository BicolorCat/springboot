package sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.dao.PersonDao;
import sample.dto.PersonDTO;
import sample.service.PersonServiceIF;

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
    public PersonDTO getPersonById(String id) {
        return personDao.getPersonById(Integer.valueOf(id));
    }
}