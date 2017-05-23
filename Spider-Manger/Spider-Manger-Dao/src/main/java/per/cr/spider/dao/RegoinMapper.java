package per.cr.spider.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import per.cr.spider.pojo.Regoin;
import per.cr.spider.pojo.RegoinExample;

public interface RegoinMapper {
    int countByExample(RegoinExample example);

    int deleteByExample(RegoinExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Regoin record);

    int insertSelective(Regoin record);

    List<Regoin> selectByExample(RegoinExample example);

    Regoin selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Regoin record, @Param("example") RegoinExample example);

    int updateByExample(@Param("record") Regoin record, @Param("example") RegoinExample example);

    int updateByPrimaryKeySelective(Regoin record);

    int updateByPrimaryKey(Regoin record);
}