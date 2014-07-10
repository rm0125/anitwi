package jp.hakoika.study.anitwi.animeinfo;

import static org.junit.Assert.*;

import java.util.List;

import jp.hakoika.study.anitwi.client.HttpClient;

import org.junit.Test;
import org.w3c.dom.Document;

public class AnimeInfoLogicTest {

	AnimeInfoLogic logic = new AnimeInfoLogic();

	HttpClient client = new HttpClient();

	@Test
	public void test() {

		String url = "http://animemap.net/api/table/hokkaidou.xml";
		Document document = client.getXml(url);

		List<AnimeInfoModel> actual = logic.createAnimeInfo(document);
		assertEquals(7, actual.size());

		AnimeInfoModel info = actual.get(0);
		assertEquals("ノブナガ・ザ・フール", info.getTitle());
		assertEquals("http://animemap.net/time/title/1842/", info.getUrl());
		assertEquals("26:35", info.getTime());
		assertEquals("TVh", info.getStation());
		assertEquals("onair", info.getState());
		assertEquals("最終回", info.getNext());
		assertEquals("?", info.getEpisode());
		assertEquals("0", info.getCable());
		assertEquals("0", info.getToday());
		assertEquals("火曜日", info.getWeek());

		info = actual.get(1);
		assertEquals("ニセコイ", info.getTitle());
		assertEquals("http://animemap.net/time/title/1862/", info.getUrl());
		assertEquals("26:05", info.getTime());
		assertEquals("TVh", info.getStation());
		assertEquals("onair", info.getState());
		assertEquals("11話", info.getNext());
		assertEquals("?", info.getEpisode());
		assertEquals("0", info.getCable());
		assertEquals("0", info.getToday());
		assertEquals("水曜日", info.getWeek());
	}
}
