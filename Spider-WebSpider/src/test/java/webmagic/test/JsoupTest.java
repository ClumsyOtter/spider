package webmagic.test;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.springframework.stereotype.Service;

@Service
public class JsoupTest {
	@Test
	public void get() throws IOException, Exception {
		File file = new File("F:/spider/shopMsg.txt");
		Document doc = Jsoup.parse(file, "gbk");
		// 获取bean
		String html = doc.select(".star span").html();
		String[] split = html.split("\n\n");
		for (int i = 0; i < split.length; i++) {
			if (split[i].equals("(评价人数不足)") || split[i].equals("(目前无人评价)")) {
				System.out.println("-1");
				System.out.println("0");
			} else {
				String[] split2 = split[i].split("\n");
				System.out.println(split2[0]);
				Pattern pattern = Pattern.compile("\\d+");
				Matcher matcher = pattern.matcher(split2[1]);
				while (matcher.find()) {
					System.out.println(matcher.group());
				}

			}
		}
	}
}
