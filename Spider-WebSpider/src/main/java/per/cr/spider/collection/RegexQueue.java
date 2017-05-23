package per.cr.spider.collection;

import java.util.LinkedList;

/*
 * 正则表达式队列
 * 对字符进行层层筛选
 */
public class RegexQueue {
	private LinkedList<String> linkedList = new LinkedList<>();

	/**
	 * 加入队列
	 * 
	 * @param regex
	 * @return
	 */
	public RegexQueue push(String regex) {
		linkedList.add(regex);
		return this;
	}

	/**
	 * 获取队列头并从队列中移除
	 * 
	 * @return
	 */
	public String poll() {
		return linkedList.poll();
	}

	/**
	 * 获取队列头但不删除
	 * 
	 * @return
	 */
	public String peek() {
		return linkedList.peek();
	}

	public int length() {
		return linkedList.size();
	}
}
