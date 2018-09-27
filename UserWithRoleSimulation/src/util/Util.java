package util;

import java.util.Random;

import repast.simphony.random.RandomHelper;

public class Util {
	public static int getRandom(int min, int max){
	    Random random = new Random();
//	    int s = random.nextInt(max) % (max - min + 1) + min;
	    int s = RandomHelper.nextIntFromTo(min, max);
	    return s;

	}
}
