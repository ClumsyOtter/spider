package webmagic.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IOtest {
	public static void main(String[] args) throws IOException {
		File file = new File("F:/spider/shopList.txt");
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.append("F:/spider/shopList.txt");
		fileWriter.close();
	}

}
