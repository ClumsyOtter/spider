package per.cr.spider.meituan.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import per.cr.spider.meituan.pojo.Food;
import per.cr.spider.meituan.pojo.FoodExample;

public interface FoodMapper {
    int countByExample(FoodExample example);

    int deleteByExample(FoodExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Food record);

    int insertSelective(Food record);

    List<Food> selectByExample(FoodExample example);

    Food selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Food record, @Param("example") FoodExample example);

    int updateByExample(@Param("record") Food record, @Param("example") FoodExample example);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);
}