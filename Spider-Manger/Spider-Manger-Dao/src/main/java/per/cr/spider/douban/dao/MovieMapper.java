package per.cr.spider.douban.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import per.cr.spider.douban.pojo.ChartExample;
import per.cr.spider.douban.pojo.Movie;
import per.cr.spider.douban.pojo.MovieExample;

public interface MovieMapper {
	int countByExample(MovieExample example);

	int deleteByExample(MovieExample example);

	int deleteByPrimaryKey(Integer mid);

	int insert(Movie record);

	int insertSelective(Movie record);

	List<Movie> selectByExample(MovieExample example);

	Movie selectByPrimaryKey(Integer mid);

	int updateByExampleSelective(@Param("record") Movie record, @Param("example") MovieExample example);

	int updateByExample(@Param("record") Movie record, @Param("example") MovieExample example);

	int updateByPrimaryKeySelective(Movie record);

	int updateByPrimaryKey(Movie record);

	// 分页
	List<Movie> page(@Param("start") int start, @Param("end") int end);

	// 查询总数
	int count();

	// 带参数查询总数
	int countByParam(@Param("colum") String colum, @Param("data") String data);

	List<Movie> pageBySort(@Param("page") int pagei, @Param("row") int rowsi, @Param("colum") String colum,
			@Param("sort") String sort);

	// 搜索
	List<Movie> search(@Param("page") int pagei, @Param("row") int rowsi, @Param("colum") String colum,
			@Param("data") String data);

	int countByChart(ChartExample chartExample);

}