/**
 * 
 */
package PageTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class TextJustification {

	public List<String> fullJustify(String[] words, int maxWidth) {
		if(words.length > 0){
			String out = "";
			List<String> outList = new ArrayList<String>();
			for(int i=0; i<words.length;){
				if((out.length() + words[i].length() + (out == "" ? 0 : 1) ) <= maxWidth){
					out = out + (out == "" ? "" : " ") + words[i]; 
					i++;
				}
				else{
					if(out.length() < maxWidth)
						out = addSpaces(out, maxWidth);
					outList.add(out);
					out = "";
				}
			}
			if("" != out){
				while(maxWidth > out.length())
					out = out + " ";
				outList.add(out);
			}
			return outList;
		}
		else
			return null;
	}

	private String addSpaces(String var, int l){
		if(var.contains(" ")){
			int i = 0;
			int add = 2;
			while(l > var.length()){
				if(i >= var.length()){
					i = 0;
					add += 1;
				}
				else{
					if(var.charAt(i) == ' '){
						var = var.substring(0, i) + " " + var.substring(i);
						i += add;
					}
					else{
						i += 1;
					}
				}
			}
		}
		else{
			while(l > var.length())
				var = var + " ";
		}
		return var;
	}

	public static void main(String[] args) {
		TextJustification obj = new TextJustification();
		String[] words = {"Here","is","an","example","of","text","justification."};
		int maxWidth = 14;
		obj.fullJustify(words, maxWidth);
	}

}
