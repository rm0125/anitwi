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
			AnimeInfoModel info = new AnimeInfoModel();
			for (int j = 0; j < childNodes.getLength(); j++) {
				Node child = childNodes.item(j);
				if (child.getNodeName().equals("title")) {
					info.setTitle(child.getTextContent());
				} else if (child.getNodeName().equals("url")) {
					info.setUrl(child.getTextContent());
				} else if (child.getNodeName().equals("time")) {
					info.setTime(child.getTextContent());
				} else if (child.getNodeName().equals("station")) {
					info.setStation(child.getTextContent());
				} else if (child.getNodeName().equals("state")) {
					info.setState(child.getTextContent());
				} else if (child.getNodeName().equals("next")) {
					info.setNext(child.getTextContent());
				} else if (child.getNodeName().equals("episode")) {
					info.setEpisode(child.getTextContent());
				} else if (child.getNodeName().equals("cable")) {
					info.setCable(child.getTextContent());
				} else if (child.getNodeName().equals("today")) {
					info.setToday(child.getTextContent());
				} else if (child.getNodeName().equals("week")) {
					info.setWeek(child.getTextContent());
				}
			}
			infoList.add(info);
		}
		return infoList;
	}
}
