package webmagic.test;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.BasicClientCookie2;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {
	@Test
	public void test() throws IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://ganzhou.meituan.com/shop/954374");
		httpGet.addHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
		HttpHost host = new HttpHost("175.155.245.15", 808);
		HttpResponse response = client.execute(host, httpGet);
		HttpContext context = new BasicHttpContext();
		CookieStore cookieStore = new BasicCookieStore();
		HttpClientContext httpClientContext = new HttpClientContext();
		httpClientContext.setCookieStore(cookieStore);
		// while (statusCode != 200) {
		// client.close();
		// System.out.println(statusCode);
		// client = HttpClients.createDefault();
		// response = client.execute(httpGet);
		// statusLine = response.getStatusLine();
		// statusCode = statusLine.getStatusCode();
		// }
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity);
	}
}
