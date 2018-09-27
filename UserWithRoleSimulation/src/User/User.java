package User;

import java.util.List;

import Service.Service;
import ServiceResponsitory.ServiceResponsitory;
import repast.simphony.context.Context;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.space.graph.Network;


/**
 * 
 * @author mx
 *
 */
public abstract class User {
	private static long counter = 0;
	private final long id = counter++;
	
	Context<Object> context;
	Network<Object> network;
	
	public User (Context<Object> context, Network<Object> network) {
		this.context = context;
		this.network = network;
	}
	
	/**
	 * 抽象函数
	 * 给定用户评分
	 * @return
	 */
	abstract int giveScore();
	@Override
	public String toString()
	{
		return "id: " + this.id;
	}
	
	@ScheduledMethod(start = 1, interval = 2, priority = 1)
	public void chooseService()
	{
		List<Service> services = ServiceResponsitory.getList();
		for(Service s: services)
		{
			if (!network.isAdjacent(this, s))
			{
				network.addEdge(this,s);
				int score = this.giveScore();
				System.out.println(s);
				s.setScore(score);
			}
		}
	}
	
	@ScheduledMethod(start = 2, interval = 2, priority = 1)
	public void deleteLinkWithService()
	{
		network.removeEdges();
	}
	
}
