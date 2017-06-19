package webmagic.test;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

public class HttpClientTest {
	@Test
	public void test() throws IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://movie.douban.com/subject/1291560/");
		httpGet.addHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
		CookieStore cookieStore = new BasicCookieStore();
		HttpClientContext httpClientContext = new HttpClientContext();
		httpClientContext.setCookieStore(cookieStore);
		CloseableHttpResponse execute = client.execute(httpGet, httpClientContext);
		Header[] allHeaders = execute.getAllHeaders();
		for (Header header : allHeaders) {
			System.out.println(header.getName() + "---" + header.getValue());
		}
	}
}
