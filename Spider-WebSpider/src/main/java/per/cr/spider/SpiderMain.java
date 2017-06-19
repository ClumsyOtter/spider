package per.cr.spider;

import java.io.IOException;

/*
 * 爬虫主程序
 */
public class SpiderMain {
	public static void main(String[] args) throws IOException, InterruptedException {
		SpiderTouBan spiderTouBan = new SpiderTouBan();
		spiderTouBan.spiderStart();
	}
}
