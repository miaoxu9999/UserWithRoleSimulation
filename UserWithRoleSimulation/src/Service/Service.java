package Service;

import java.util.HashSet;

import javax.media.j3d.Sound;

import org.antlr.runtime.tree.DoubleLinkTree;

import FeedBack.FeedBack;
import User.SilenceUser;
import simphony.util.Main;

public class Service {
	private static long counter = 0;
	private final long id = counter++;
	private double score= 0;
	int feedbacknum = 0;
	//³ÁÄ¬µÄÈËÊý
	int  silencenum = 0;
	HashSet<Long> SilenceUser = new HashSet<>();
	
	@Override
	public String toString()
	{
		return "id: " + this.id + " score:"+ score;
	}
	
	
	
	public void  setFeedBack(FeedBack feedBack) {
		int sc = feedBack.getScore();
		long userid = feedBack.getUserid();
		feedbacknum++;
		if(sc != 0)
		{
			this.score = (this.score * (feedbacknum -1) + sc) / feedbacknum;
		}
		else
		{
			silencenum = SilenceUser.size() ;
			if ((silencenum + 1) % 100 == 0 && !SilenceUser.contains(userid) ){
				double zf = getIncreaseReputation(silencenum);
				score += zf;
			}
			
			SilenceUser.add(userid);
		}
		
	}
	
	public double getScore() {
		return score;
	}
	
	double getIncreaseReputation(int num)
	{
		double tem = Math.exp((-1.0 * num) / 1000);
		double res = 1.0 -  tem;
		return res;
	}
	
	
}
