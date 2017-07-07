package sample.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sample.dto.PersonDTO;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/4/19
 * \* Time: 下午6:24
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Mapper
public interface PersonDao {

    PersonDTO getPersonById(Integer id);

}