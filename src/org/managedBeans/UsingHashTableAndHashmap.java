/**
 * 
 */
package org.managedBeans;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author triptibishnoi
 *
 */
public class UsingHashTableAndHashmap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hashtable<Integer,String> myHT = new Hashtable<Integer,String>(); 
		HashMap<Integer, String> myHM = new HashMap<Integer,String>();
		int n =0;
		while(n<10) {
     		myHM.put(n, "t"+n);
     		n++;
		}
		System.out.println(myHM);
		
	}

}
