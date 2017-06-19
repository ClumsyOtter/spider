package per.cr.spider.douban.service;

import java.util.List;

import per.cr.spider.douban.pojo.Movie;

public interface MovieService {
	public void add(Movie movie);

	public Movie getMovieById(int id);

	List<Movie> pageById(int start, int end);

	String page(String page, String rows);

	String pageByRateSort(String page, String rows, String colum, String sort);

	public String search(String page, String rows, String colum, String data);

	public String moiveChart(String type);
}
