package sample.dao;

import org.apache.ibatis.annotations.Mapper;
import sample.dto.JobDetailDTO;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 18/5/28
 * \* Time: 下午4:12
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Mapper
public interface JobDao {

    int addJobDetail(JobDetailDTO jobDetailDTO);

}