package per.cr.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import per.cr.spider.collection.HostProxyPool;
import per.cr.spider.tools.SpiderTools;

/*
 * 各类爬虫
 */
public class SpiderUtils {
	private static int head = 0;
	// 记录一个UA连续访问次数
	private static int UAcount = 0;
	// 记录代理池位置
	private static int ProxyCount = 0;
	private static Logger logger = Logger.getLogger(SpiderUtils.class);
	// 爬取起点
	private static int point;
	// 爬取大小
	private static int size;
	// 代理池
	private static String host[] = { "212.175.125.100" };
	private static int port[] = { 80 };
	// UA池
	private static String UserAgent[] = {
			"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:53.0) Gecko/20100101 Firefox/53.0",
			"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393",
			"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36",
			"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50",
			"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0;",
			"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0)",
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0)", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)",
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv,2.0.1) Gecko/20100101 Firefox/4.0.1",
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv,2.0.1) Gecko/20100101 Firefox/4.0.1",
			"Mozilla/5.0 (Windows NT 6.1; rv,2.0.1) Gecko/20100101 Firefox/4.0.1",
			"Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; en) Presto/2.8.131 Version/11.11",
			"Opera/9.80 (Windows NT 6.1; U; en) Presto/2.8.131 Version/11.11",
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_0) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11",
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Maxthon 2.0)",
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; TencentTraveler 4.0)",
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SE 2.X MetaSr 1.0; SE 2.X MetaSr 1.0; .NET CLR 2.0.50727; SE 2.X MetaSr 1.0)",
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360SE)" };

	/**
	 * 各种返回状态码解析
	 * 
	 * @param statusCode
	 */
	public static void StatusCode(int statusCode) {
		if (statusCode == 200) {
			logger.info("--访问成功--" + statusCode);
		} else if (statusCode == 403) {
			logger.error("--访问禁止--" + statusCode);
		} else if (statusCode == 404) {
			logger.info("--未找到目标网址--" + statusCode);
		} else if (statusCode == 500) {
			logger.info("--服务器错误--" + statusCode);
		} else {
			logger.error("--未知错误,根据状态码查找资料--" + statusCode);
		}
	}

	/**
	 * 代理池
	 */
	public static Document getDocProxy(String url) {
		// 测试是否可以成功访问
		while (true) {
			try {
				for (int i = ProxyCount; i < host.length; i++)
					if (HostProxyPool.isLive(host[ProxyCount], port[ProxyCount])) {

						// httpclient 下载
						CloseableHttpClient client = HttpClients.createDefault();

						// get方法
						HttpGet httpGet = new HttpGet(url);
						// 代理
						HttpHost hosts = new HttpHost(host[i], port[i]);
						httpGet.addHeader("User-Agent", UserAgent[head]);
						HttpResponse response = client.execute(hosts, httpGet);
						StatusLine statusLine = response.getStatusLine();
						int statusCode = statusLine.getStatusCode();
						// 判断是否允许访问
						while (statusCode != 200) {
							// 访问失败清零
							UAcount = 0;
							logger.info("UA" + head + "--访问次数--" + UAcount);
							StatusCode(statusCode);
							head++;
							if (head >= UserAgent.length) {
								head = 0;
								logger.error("--UA池全部被BAN--");
								ProxyCount++;
								break;
							}
							// 反复链接
							client.close();
							client = HttpClients.createDefault();
							httpGet = new HttpGet(url);
							httpGet.addHeader("User-Agent", UserAgent[head]);
							response = client.execute(httpGet);

							statusLine = response.getStatusLine();
							statusCode = statusLine.getStatusCode();
							// 延时 1-2 S
						}
						logger.info("--UA" + head + "--访问次数--" + UAcount + "--访问状态 --" + statusCode);
						// 成功访问加一
						UAcount++;
						if (UAcount == 25) {
							head++;
							UAcount = 0;
						}
						if (statusCode == 200) {
							HttpEntity entity = response.getEntity();
							String string = EntityUtils.toString(entity);
							return Jsoup.parse(string);
						}
						if (ProxyCount >= host.length) {
							ProxyCount = 0;
							logger.info("代理全部无效 或者网络中断");
							System.exit(0);
						}
					} else {
						ProxyCount++;
						if (ProxyCount >= host.length) {
							ProxyCount = 0;
							logger.info("代理全部无效 或者网络中断");
							System.exit(0);
						}
						logger.info("代理" + host[i] + ":" + port[i] + "无效");
					}

			} catch (Exception e) {
				System.out.println("网络断开 或者 网址错误");
				System.exit(0);
			}
		}
	}

	/**
	 * 获取网页文档 判断是否可以成功访问
	 * 
	 * @param url
	 * @return
	 */
	private static Document getDoc(String url) {
		// 测试是否可以成功访问
		while (true) {
			try {
				// httpclient 下载
				CloseableHttpClient client = HttpClients.createDefault();

				// get方法
				HttpGet httpGet = new HttpGet(url);
				httpGet.addHeader("User-Agent", UserAgent[head]);
				HttpResponse response = client.execute(httpGet);
				StatusLine statusLine = response.getStatusLine();
				int statusCode = statusLine.getStatusCode();
				// 判断是否允许访问
				while (statusCode != 200) {
					// 访问失败清零
					UAcount = 0;
					logger.info("UA" + head + "--访问次数--" + UAcount);
					StatusCode(statusCode);
					head++;
					if (head >= UserAgent.length) {
						head = 0;
						logger.error("--UA池全部被BAN--");

						// 等待10分钟
						Thread.currentThread();
						Thread.sleep(600000);
					}
					// 反复链接
					client.close();
					client = HttpClients.createDefault();
					httpGet = new HttpGet(url);
					httpGet.addHeader("User-Agent", UserAgent[head]);
					response = client.execute(httpGet);
					statusLine = response.getStatusLine();
					statusCode = statusLine.getStatusCode();
					// 延时 1-2 S
					Thread.currentThread();
					Thread.sleep(RadomWaitTime(1000, 1001));
				}
				logger.info("--UA" + head + "--访问次数--" + UAcount + "--访问成功 --" + statusCode);
				// 成功访问加一
				UAcount++;
				if (UAcount == 25) {
					head++;
					UAcount = 0;
				}
				HttpEntity entity = response.getEntity();
				String string = EntityUtils.toString(entity);
				return Jsoup.parse(string);
			} catch (Exception e) {
				System.out.println("网络断开 或者 网址错误");
				System.exit(0);
			}
		}
	}

	/**
	 * 根据配置文件中的point属性来确定起点 point是爬取过程中失败的存储点
	 * 
	 * @param urls
	 * @param regex
	 * @return
	 * @throws Exception
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static List<Document> spiders(List<String> urls) throws Exception {
		List<Document> filter = new ArrayList<>();
		try {
			String propertiseValue = SpiderTools.getPropertiseValue("point");
			String sizes = SpiderTools.getPropertiseValue("size");
			// 读取点
			point = Integer.parseInt(propertiseValue);
			int temp = point;
			// 读取长度
			size = Integer.parseInt(sizes);
			// point + size是否超出范围
			if ((point + size) >= urls.size())
				// 超出就修改size大小
				size = urls.size() - point - 1;
			// 抓取指定数量页面
			for (int i = point; i < temp + size; i++) {
				String url = urls.get(i);
				// 连接
				logger.info("-----连接  --> " + url);
				// 下载
				Document document = getDocProxy(url);
				filter.add(document);
				point++;
				// 抓取间隔
				logger.info("等待" + i);
				Thread.currentThread();
				Thread.sleep(RadomWaitTime());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("网络中断");
			throw new Exception();
		}
		return filter;
	}

	// 是否将url访问完毕
	public static boolean isend(List<String> urls) {
		if (point >= urls.size())
			return true;
		return false;
	}

	/**
	 * 随机获取指定数据范围的随机数
	 * 
	 * @param start
	 *            数据范围起点
	 * @param end
	 *            数据范围终点
	 * @return
	 */
	public static int RadomWaitTime(int start, int end) {
		// 随机函数
		Random random = new Random(System.currentTimeMillis());
		// 5秒到10之间随机
		return start + random.nextInt(end - start);
	}

	/**
	 * 默认范围 5000-10000
	 * 
	 * @return
	 */
	public static int RadomWaitTime() {
		// 随机函数
		Random random = new Random(System.currentTimeMillis());
		// 5秒到10之间随机
		return 5000 + random.nextInt(2000);
	}
}
