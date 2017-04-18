/**
 * 
 */
package chapter1;

/**
 * @author triptibishnoi
 *
 */
public class ArraysStrings4 {


	public static void main(String[] args) {
		String var1 = "aaaaaaaaaaaaaaaaaaaaaaaaaa";
		String var2 = "aaaaaaaaaaaaaaaaaaaaaaaaaa";

		if(null!=var1 && null!= var2 && "" != var1 && "" != var2) {
			int len1 = var1.length();
			int len2 = var2.length();
			char minValue;
			int minIndex;
			char temp;
			char[] varArray1 = var1.toCharArray();
			char[] varArray2 = var2.toCharArray();
			if(len1 == len2) {
				//-----------sort 
				for(int i=0; i<len1; i++){
					minValue = varArray1[i];
					minIndex = i;
					for(int j=i+1; j<len1;j++){
						if(varArray1[j] < minValue){
							minIndex = j;
							minValue = varArray1[j];
						}
					}
					temp = varArray1[i];
					varArray1[i] = minValue;
					varArray1[minIndex] = temp;
				}
				var1 = String.valueOf(varArray1);
				//-------------sort
				for(int i=0; i<len2; i++){
					minValue = varArray2[i];
					minIndex = i;
					for(int j=i+1; j<len2;j++){
						if(varArray2[j] < minValue){
							minIndex = j;
							minValue = varArray2[j];
						}
					}
					temp = varArray2[i];
					varArray2[i] = minValue;
					varArray2[minIndex] = temp;
				}
				var2 = String.valueOf(varArray2);
				//-----------compare
				for(int i=0; i<len1; i++){
					if(var1.charAt(i) != var2.charAt(i)){
						System.out.println("not anagrams");
						break;
					}
				}
				System.out.println("anagrams!!");
			}
			else {
				System.out.println("not anagrams");
			}
		}
		else{
			System.out.println("blank or null");
		}
	}

}
