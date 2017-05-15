/**
 * 
 */
package LeetCodeProblems;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class CompareVersionNumbers {

//	public int compareVersion(String version1, String version2) {
//		if(version1.length() != 0 && version2.length() != 0){
//			int dot1 = version1.length(), dot2 = version2.length();
//			for(int i=0; i<version1.length(); i++){
//				if(version1.charAt(i) == '.'){
//					dot1 = i;
//					break;
//				}
//			}
//			for(int i=0; i<version2.length(); i++){
//				if(version2.charAt(i) == '.'){
//					dot2 = i;
//					break;
//				}
//			}
//			
//			if(Integer.parseInt(version1.substring(0, dot1).replaceFirst("^0+(?!$)", ""))
//					> Integer.parseInt(version2.substring(0, dot2).replaceFirst("^0+(?!$)", "")))
//				return 1;
//			else if(Integer.parseInt(version1.substring(0, dot1).replaceFirst("^0+(?!$)", ""))
//					< Integer.parseInt(version2.substring(0, dot2).replaceFirst("^0+(?!$)", "")))
//				return -1;
//			else{
//				if(Integer.parseInt(version1.substring(dot1+1).replaceFirst("^0+(?!$)", ""))
//						> Integer.parseInt(version2.substring(dot2+1).replaceFirst("^0+(?!$)", "")))
//					return 1;
//				else if(Integer.parseInt(version1.substring(dot1+1).replaceFirst("^0+(?!$)", ""))
//						< Integer.parseInt(version2.substring(dot2+1).replaceFirst("^0+(?!$)", "")))
//					return -1;
//				else return 0;
//			}
//		}
//		else return -2;
//	}
	
	public int compareVersion(String version1, String version2) {
		String[] levels1 = version1.split("\\.");
		String[] levels2 = version2.split("\\.");
		
		int len = Math.max(levels1.length, levels2.length);
		
		for(int i=0; i<len; i++){
			Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
			Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
			int compare = v1.compareTo(v2);
			if(compare != 0)
				return compare;
		}
		
		return 0;
	}

	public static void main(String[] args) {
		CompareVersionNumbers obj = new CompareVersionNumbers();
		System.out.println(obj.compareVersion("01.9", "1"));
	}

}
