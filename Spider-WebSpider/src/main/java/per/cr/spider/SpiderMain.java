package per.cr.spider;

/*
 * 爬虫主程序
 */
public class SpiderMain {
	public static void main(String[] args) {
		Thread thread = new Thread(new Spider());
		thread.start();
	}
}
