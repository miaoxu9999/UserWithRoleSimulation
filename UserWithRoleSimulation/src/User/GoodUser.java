package User;



import repast.simphony.context.Context;
import repast.simphony.space.graph.Network;

import util.Util;;

public class GoodUser extends User{
	public GoodUser(Context<Object> context, Network<Object> network) {
		// TODO Auto-generated constructor stub
		super(context, network);
	}

	@Override
	int giveScore() {
		// TODO Auto-generated method stub
		return Util.getRandom(3, 5);
	}
	
	public static void main(String[] args) {
	 for (int i = 0; i < 5; i++) {
		 System.out.println(Util.getRandom(4, 5));
	}
	}

}
