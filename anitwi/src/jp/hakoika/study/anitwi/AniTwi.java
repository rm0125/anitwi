package jp.hakoika.study.anitwi;
import java.util.List;

import twitter4j.DirectMessage;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class AniTwi {

	public static void main(String[] args) throws TwitterException {
		Twitter twitter = TwitterFactory.getSingleton();
		List<Status> statuses = twitter.getHomeTimeline();
		System.out.println("Showing home timeline.");
		for (Status status : statuses) {
			System.out.println(status.getUser().getName() + ":" + status.getText());
		}

	    // このファクトリインスタンスは再利用可能でスレッドセーフです
	    Twitter sender = TwitterFactory.getSingleton();
	    DirectMessage message = sender.sendDirectMessage(sender.getId(), "abc");
	    System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientScreenName());
	}

}
