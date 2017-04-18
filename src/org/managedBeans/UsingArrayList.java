/**
 * 
 */
package org.managedBeans;

import java.util.ArrayList;

/**
 * @author triptibishnoi
 *
 */
public class UsingArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();
		String siblings = "";
		myList.add(0,"Tripti");
		myList.add(1,"Deepika");
		myList.add(2,"Parteek");
		for(String w: myList){
			siblings +=w +", ";
		}
		System.out.println(siblings);
	}

}
