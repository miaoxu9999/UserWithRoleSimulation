package User;

import repast.simphony.context.Context;
import repast.simphony.space.graph.Network;

public class SilenceUser extends User{
	public SilenceUser (Context<Object> context, Network<Object> network) {
		super(context, network);
	}

	@Override
	int giveScore() {
		// TODO Auto-generated method stub
		return 0;
	}

}
