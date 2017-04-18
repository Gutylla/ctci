/**
 * 
 */
package org.managedBeans;

/**
 * @author triptibishnoi
 *
 */
public class UsingStringBuffer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer buff = new StringBuffer();
		StringBuilder buil = new StringBuilder();

		System.out.println(buff.length());
		System.out.println(buil.length());
		buff.append("hello");
		buff.append(1);
		buff.append('T');
		buff.append(true);
		buff.append("Tripti");
		System.out.println(buff.toString());
		System.out.println(buff.length());
	}

}
