package sdet.GenericUtility;

import java.util.Random;

/**
 * this class contains java specific generic methods
 * @author Dell
 *
 */
public class JavaUtility {
	/**
	 * this method will generate random value for every run
	 * @return
	 */
	
	
	public int getRandomNum() {
	Random ran = new Random();
	int value=ran.nextInt(100);
	return value;
	
	
	}

}
