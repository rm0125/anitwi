package jp.hakoika.study.anitwi;

import java.util.List;

import jp.hakoika.study.anitwi.animeinfo.AnimeInfoLogic;
import jp.hakoika.study.anitwi.animeinfo.AnimeInfoModel;
import jp.hakoika.study.anitwi.client.HttpClient;

import org.w3c.dom.Document;

public class AnitwiMail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String url = "http://animemap.net/api/table/hokkaidou.xml";

		HttpClient client = new HttpClient();
		Document document = client.getXml(url);

		AnimeInfoLogic logic = new AnimeInfoLogic();
		List<AnimeInfoModel> animeInfoList = logic.createAnimeInfo(document);

	}
}
