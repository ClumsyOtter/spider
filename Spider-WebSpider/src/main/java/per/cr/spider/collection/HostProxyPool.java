package per.cr.spider.collection;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

/*
 * 维护一个代理池
 */
public class HostProxyPool {

	/**
	 * 这个IP是否有用
	 */
	public static boolean isLive(String host, int port) {
		HttpHost httpHost = new HttpHost(host, port);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://www.baidu.com");
		httpGet.addHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:53.0) Gecko/20100101 Firefox/53.0");
		try {
			CloseableHttpResponse httpResponse = client.execute(httpHost, httpGet);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == 200)
				return true;
		} catch (IOException e) {
		}
		return false;
	}

	/**
	 * 爬取代理ip
	 */
	public void spiderProxyIP(String url) {

	}

	@Test
	public void test() throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://www.data5u.com");
		httpGet.addHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393");
		CloseableHttpResponse execute = httpClient.execute(httpGet);
		HttpEntity entity = execute.getEntity();
		String string = EntityUtils.toString(entity);
		Document document = Jsoup.parse(string);
		String ip = document.select("div.wlist ul.l2 span:nth-child(1) li").html();
		String port = document.select("div.wlist ul.l2 span:nth-child(2) li").html();
		String[] ips = ip.split("\n");
		String[] ports = port.split("\n");
		for (int i = 0; i < ips.length; i++) {
			System.out.println(isLive(ips[i], Integer.parseInt(ports[i])) == true ? "有用" : "无用");
		}

	}
}
