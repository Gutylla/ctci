/**
 * 
 */
package org.managedBeans;

import java.util.Arrays;

/**
 * @author triptibishnoi
 *
 */
public class HashFunction {

	String[] myArray;
	int arraySize;
	
	public static void main(String[] args) {
		HashFunction myFunc = new HashFunction(10);
		String[] arrayToUse = {"9","29","39","49","59","69","79"};
		myFunc.hashFunction1(arrayToUse, myFunc.myArray);
		for(int n =0; n<myFunc.myArray.length; n++){
			System.out.println("Loc: " + n + ", Data: " + myFunc.myArray[n]);
		}
		myFunc.findKey("10");
		myFunc.findKey("69");
	}

	public void hashFunction1(String[] arrayStrings, String[] myArray){
		String newEleVal;
		int index;
		int size = arrayStrings.length;
		for(int n =0; n< size; n++){
			newEleVal = arrayStrings[n];
			index = Integer.parseInt(newEleVal)% 10;
			System.out.println("val: " + newEleVal + ", mod: "+ index);
			while(!myArray[index].equalsIgnoreCase("-1")){
				index ++;
				index %= 10; //to cycle back, if the index reaches the end index
			}
			myArray[index] = newEleVal;
		}
	}

	public String findKey(String key){
		int index = Integer.parseInt(key)%10;
		while (myArray[index]!="-1"){
			if(myArray[index]==key){
				System.out.println("found key " + key + " at " + index);
				return "found";
			}
			index++;
			index%=10;
		}
		System.out.println("not found the key");
		return null;
	}
	
	HashFunction(int size){
		arraySize = size;
		myArray = new String[arraySize];
		Arrays.fill(myArray, "-1"); //to be able to see which part of array is empty
	}
}
