package jp.hakoika.study.anitwi.client;

import static org.junit.Assert.*;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HttpClientTest {

	HttpClient client = new HttpClient();

	@Test
	public void test() {

		String url = "http://animemap.net/api/table/hokkaidou.xml";
		Document actual = client.getXml(url);

		assertNotNull(actual);

		NodeList titleList = actual.getElementsByTagName("title");
		for (int i=0; i< titleList.getLength(); i++) {
			Node item = titleList.item(i);
			System.out.println(item.getTextContent());
		}
	}

}
