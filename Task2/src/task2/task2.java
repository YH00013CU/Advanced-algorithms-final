package task2;
import java.util.Arrays;

public class task2 {
	

	    public static void main(String[] args) {
	        int[] arr1 = {1, 2, 3,4};
	        int[] arr2 = {1, 2, 3,4,};

	        String result = isSameSet(arr1, arr2);

	        System.out.println(result);
	    }

	    public static String isSameSet(int[] arr1, int[] arr2) {
	        Arrays.sort(arr1);
	        Arrays.sort(arr2);
	        
	        if( Arrays.equals(arr1, arr2))
	        	return "Same";
	        else
	        	return "different ";
	    }
	}


