import Service.Service;
import ServiceResponsitory.ServiceResponsitory;
import User.BadUser;
import User.GoodUser;
import User.NormalUser;
import User.SilenceUser;
import User.User;
import repast.simphony.context.Context;
import repast.simphony.context.space.continuous.ContinuousSpaceFactory;
import repast.simphony.context.space.continuous.ContinuousSpaceFactoryFinder;
import repast.simphony.context.space.graph.NetworkBuilder;
import repast.simphony.context.space.grid.GridFactory;
import repast.simphony.context.space.grid.GridFactoryFinder;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.continuous.RandomCartesianAdder;
import repast.simphony.space.graph.Network;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridBuilderParameters;
import repast.simphony.space.grid.SimpleGridAdder;
import repast.simphony.space.grid.WrapAroundBorders;

public class Builder implements ContextBuilder<Object>{

	@Override
	public Context build(Context<Object> context) {
		// TODO Auto-generated method stub
		context.setId("UserWithRoleSimulation");
		
		NetworkBuilder<Object> networkBuilder = new NetworkBuilder<>(
				"AgentServiceNetwork", context, true);
		networkBuilder.buildNetwork();
		
		ContinuousSpaceFactory spaceFactory = ContinuousSpaceFactoryFinder.createContinuousSpaceFactory(null);
		ContinuousSpace<Object> space = spaceFactory.createContinuousSpace(
				"space", context, new RandomCartesianAdder<Object>(), new repast.simphony.space.continuous.WrapAroundBorders(), 50,
				50);
		Network<Object> network = (Network<Object>) context.getProjection("AgentServiceNetwork");
		//生成1个GoodUser
		int goodusernum =  100;
		int badusernum = 200;
		int normalusernum = 50;
		int silenceusernum = 650;
		for (int i = 0; i < goodusernum; i++) {
			User user = new GoodUser(context, network);
			context.add(user);
		}
		//生成1个BadUser
		
		for (int i = 0; i < badusernum; i++) {
			User user = new BadUser(context, network);
			context.add(user);
		}
		
		for (int i = 0; i < normalusernum; i++) {
			User user = new NormalUser(context, network);
			context.add(user);
		}
		
		for (int i = 0; i < silenceusernum; i++) {
			User user = new SilenceUser(context, network);
			context.add(user);
		}
		
		Service service = new Service();
		ServiceResponsitory.add(service);
		context.add(service);
		
		
		
		return context;
	}

}
