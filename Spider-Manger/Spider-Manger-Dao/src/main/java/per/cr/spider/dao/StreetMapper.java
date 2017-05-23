package per.cr.spider.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import per.cr.spider.pojo.Street;
import per.cr.spider.pojo.StreetExample;

public interface StreetMapper {
    int countByExample(StreetExample example);

    int deleteByExample(StreetExample example);

    int deleteByPrimaryKey(Integer stid);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer stid);

    int updateByExampleSelective(@Param("record") Street record, @Param("example") StreetExample example);

    int updateByExample(@Param("record") Street record, @Param("example") StreetExample example);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);
}