package sample.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sample.datasource.TargetDataSource;
import sample.dto.PersonDTO;

import java.util.Map;

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

    PersonDTO getPersonById(@Param("id") String id);

    int updatePersonById(Map<String,Object> param);

}