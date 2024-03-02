package week4.day1assignment;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;


public class SetInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String companyName = "google";
		 Set<Character> cp=new LinkedHashSet<Character>();
		 for (int i = 0; i < companyName.length(); i++) {
			cp.add(companyName.charAt(i));
			
		}
		 System.out.println("Duplicate removed Set: "+cp);
		 List<Character> lt=new ArrayList<Character>(cp);
		 //System.out.println(lt);
		 System.out.print("unique string: ");
		 for(int j=0;j<lt.size();j++)
		 {
			 System.out.print(lt.get(j));
		 }
		 
		 

	}

}
