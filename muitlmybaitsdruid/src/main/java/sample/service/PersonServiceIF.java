package sample.service;

import sample.dto.PersonDTO;

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
public interface PersonServiceIF {

    PersonDTO getPersonById(String id);

    int updatePersonById(Map<String,Object> param);
}