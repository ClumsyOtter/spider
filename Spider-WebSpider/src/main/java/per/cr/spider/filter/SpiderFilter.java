package per.cr.spider.filter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.junit.Test;

import per.cr.spider.collection.RegexQueue;

/*
 * 数据筛选
 */
public class SpiderFilter {
	private static Logger logger = Logger.getLogger(SpiderFilter.class);

	// 筛选网页
	public static List<String> filter(String result, String regex) {
		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(result);
			while (matcher.find()) {
				arrayList.add(matcher.group());
			}
		} catch (Exception e) {
			logger.error("筛选失败");
		}
		return arrayList;
	}

	// 按照顺序筛选网页
	public static List<String> filters(RegexQueue regex, String html) {
		int i = regex.length() % 2;
		ArrayList<String> arrayList = new ArrayList<>();
		ArrayList<String> arrayList2 = new ArrayList<>();
		arrayList2.add(html);
		refilters(regex, arrayList2, arrayList);
		if (i == 0)
			return arrayList2;
		return arrayList;
	}

	// 递归筛选
	private static void refilters(RegexQueue regex, List<String> htmls, List<String> strs) {
		if (regex.peek() == null || htmls == null || htmls.size() == 0)
			return;
		for (String html : htmls) {
			if (html == null)
				return;
			Pattern pattern = Pattern.compile(regex.peek());
			Matcher matcher = pattern.matcher(html);
			while (matcher.find()) {
				String string = matcher.group();
				strs.add(string);
			}
		}
		regex.poll();
		htmls.clear();
		refilters(regex, strs, htmls);
	}

	@Test
	public void test() throws IOException {
		File file = new File("F:/spider/shopMsg.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "gbk");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		StringBuffer stringBuffer = new StringBuffer();
		while (bufferedReader.ready()) {
			stringBuffer.append(bufferedReader.readLine());
		}
		String string = new String(stringBuffer);
		RegexQueue regexQueue = new RegexQueue();
		regexQueue.push("class=\"sale\">.{1,10}</span>|class=\"title\">.{1,50}</span>|;<strong>[0-9]{1,5}</strong>");
		regexQueue.push(">.+<");
		List<String> filters = filters(regexQueue, string);
		for (String string2 : filters) {
			System.out.println(string2.substring(1, string2.indexOf("<")));
		}
		bufferedReader.close();

	}

	public void fliterres() throws IOException {
		File file = new File("F:/spider/shopMsg.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "gbk");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		StringBuffer stringBuffer = new StringBuffer();
		while (bufferedReader.ready()) {
			stringBuffer.append(bufferedReader.readLine());
		}
		String string = new String(stringBuffer);
		RegexQueue regexQueue = new RegexQueue();
		regexQueue.push("class=\"sale\">.{1,10}</span>|class=\"title\">.{1,50}</span>|;<strong>[0-9]{1,5}</strong>");
		regexQueue.push(">.+<");
		List<String> filters = filters(regexQueue, string);
		for (String string2 : filters) {
			System.out.println(string2.substring(1, string2.indexOf("<")));
		}
		bufferedReader.close();
	}
}
