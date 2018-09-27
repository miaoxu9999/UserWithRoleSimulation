package User;

import repast.simphony.context.Context;
import repast.simphony.space.graph.Network;
import util.Util;

public class NormalUser extends User{
	public NormalUser(Context<Object> context, Network<Object> network) {
		// TODO Auto-generated constructor stub
		super(context, network);
	}

	@Override
	int giveScore() {
		// TODO Auto-generated method stub
		return Util.getRandom(1, 5);
	}

}
