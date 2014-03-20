package jp.hakoika.study.anitwi.animeinfo;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AnimeInfoLogic {

	/**
	 * @param args
	 */
	public List<AnimeInfoModel> createAnimeInfo(Document document) {

		List<AnimeInfoModel> infoList = new ArrayList<AnimeInfoModel>();

		NodeList items = document.getElementsByTagName("item");
		for (int i=0; i < items.getLength(); i++) {
			Node item = items.item(i);
			NodeList childNodes = item.getChildNodes();
			for (int j = 0; j < childNodes.getLength(); j++) {
				AnimeInfoModel info = new AnimeInfoModel();
				Node child = childNodes.item(j);
				if (child.getNodeName().equals("title")) {

				}


			}
		}

		return infoList;
	}
}
