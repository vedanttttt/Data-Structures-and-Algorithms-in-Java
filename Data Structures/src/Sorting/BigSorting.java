//Sorting string array of numbers which may contains very big numbers
//This can be done using comparators
package Sorting;
 
import java.util.Arrays;
import java.util.Comparator;
 
public class BigSorting {
 
    public static void main(String[] args) {
        
        String[] strNumberArray = {
            "1", "11", "121", "112", "13", "101", "115"
        };
        
        //sort array using custom comparator
        Arrays.sort(strNumberArray, new StringNumberComparator());
        
        System.out.println(Arrays.toString(strNumberArray));        
        
    }
}
    
class StringNumberComparator implements Comparator<String>{
 
    
    public int compare(String strNumber1, String strNumber2) {
 
        //convert String to int first
        int number1 = Integer.parseInt( strNumber1 );
        int number2 = Integer.parseInt( strNumber2 );
        
        //compare numbers
        if( number1 > number2 ){
            return 1;
        }else if( number1 < number2 ){
            return -1;
        }else{
            return 0;
        }
    }
    
}
