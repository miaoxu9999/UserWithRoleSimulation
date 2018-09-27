package User;

import repast.simphony.context.Context;
import repast.simphony.space.graph.Network;
import util.Util;

public class BadUser extends User{
	public BadUser(Context<Object> context, Network<Object> network) {
		// TODO Auto-generated constructor stub
		super(context, network);
	}

	@Override
	int giveScore() {
		// TODO Auto-generated method stub
		return Util.getRandom(1, 3);
	}

}
