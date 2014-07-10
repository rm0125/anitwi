package jp.hakoika.study.anitwi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jp.hakoika.study.anitwi.animeinfo.AnimeInfoLogic;
import jp.hakoika.study.anitwi.animeinfo.AnimeInfoModel;
import jp.hakoika.study.anitwi.client.HttpClient;

import org.w3c.dom.Document;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class AnitwiMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String url = "http://animemap.net/api/table/hokkaidou.xml";

		Date current = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String todayStr = sdf.format(current);

		HttpClient client = new HttpClient();
		Document document = client.getXml(url);

		AnimeInfoLogic logic = new AnimeInfoLogic();
		List<AnimeInfoModel> animeInfoList = logic.createAnimeInfo(document);

		try {
			Twitter twitter = TwitterFactory.getSingleton();

			for (AnimeInfoModel animeInfo : animeInfoList) {
				String tweet = animeInfo.getTitle() + "\n";
				tweet += todayStr + " " +animeInfo.getTime() + "放送開始（" + animeInfo.getStation() + "）";
				Status status = twitter.updateStatus(tweet);
				System.out.println("Successfully updated the status to [" + status.getText() + "].");
			}

			twitter.updateStatus("tweet test");
		} catch (TwitterException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
