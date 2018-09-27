package Service;



public class Service {
	private static long counter = 0;
	private final long id = counter++;
	private double score= 0;
	int feedbacknum = 0;
	//沉默的人数
	int  silencenum = 0;
	
	@Override
	public String toString()
	{
		return "id: " + this.id + " score:"+ score;
	}
	
	
	
	public void  setScore(int sc) {
		feedbacknum++;
		if(sc != 0)
		{
			this.score = (this.score * (feedbacknum -1) + sc) / feedbacknum;
		}
		else
		{
			silencenum++;
			if (silencenum % 100 == 0) {
				double zf = getIncreaseReputation(silencenum);
				score += zf;
			}
			
			
		}
	}
	
	public double getScore() {
		return score;
	}
	
	double getIncreaseReputation(int num)
	{
		double res = 1 -  Math.exp(-num / 100);
		System.out.println("res的值" + res);
		return res;
	}
}
