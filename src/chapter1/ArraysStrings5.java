/**
 * 
 */
package chapter1;

/**
 * @author triptibishnoi
 *
 */
public class ArraysStrings5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String var = "The rotation can be performed in layers, where you perform a cyclic swap on the edges on each layer. In the  rst for loop, we rotate the  rst layer (outermost edges). We rotate the edges by doing a four-way swap  rst on the corners, then on the element clockwise from the edges, then on the element three steps away.";
		final long startTime1 = System.nanoTime();
		int index;
		int len = var.length();
		if(null != var){
			index = var.indexOf(' ');
			while (index >=0 && index<len-1){
				var = var.substring(0,index) + "%20" + var.substring(index+1);
				index = var.indexOf(' ');
			}
		}
		final long duration1 = System.nanoTime() - startTime1;
		System.out.println(var);
		System.out.println(", duration: " + duration1);
		System.out.println("starting>>>>>>>>>>>>>>>>>>>>>>>>");
		String str = "The rotation can be performed in layers, where you perform a cyclic swap on the edges on each layer. In the  rst for loop, we rotate the  rst layer (outermost edges). We rotate the edges by doing a four-way swap  rst on the corners, then on the element clockwise from the edges, then on the element three steps away.";
		final long startTime2 = System.nanoTime();
		char[] chr = str.toCharArray();
		int l = chr.length;
		int count = 0;
		for(int i =0; i<l; i++) {
			if(chr[i] == ' ')
				count+=1;
		}
		int newL = l+count*2;
		char[] newChr = new char[newL];
		for(int i=l-1; i>=0; i--){
			if(chr[i]==' '){
				newChr[newL-1] = '0';
				newChr[newL-2] = '2';
				newChr[newL-3] = '%';
				newL = newL-3;
			}
			else{
				newChr[newL-1] = chr[i];
				newL = newL-1;
			}
		}
		final long duration2 = System.nanoTime() - startTime2;
		System.out.println(String.valueOf(newChr) );
		System.out.println(", duration: " + duration2);
	}
}
