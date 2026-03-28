import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromeTriplets {

    public static int[] palindromeTriplets(String[] words){
        List<Integer> resultList = new ArrayList<>();

        for(int i = 0; i < words.length; i++){ // first word
            for(int j = 0; j < words.length; j++){ // second word
                for(int k = 0; k < words.length; k++){ // check third word
                    if(i != j && j != k && i != k){ // indices must be different
                        String combined = (words[i] + words[j] + words[k]).toLowerCase(); // combine words in i + j + k order
                        if(isPalindrome(combined)){ // check if palindrome
                            resultList.add(i);
                            resultList.add(j);
                            resultList.add(k);
                        }
                    }
                }
            }
        }

        int[] result = new int[resultList.size()]; // return int[]
        for(int i = 0; i < resultList.size(); i++){
            result[i] = resultList.get(i);
        }

        return result;
    }



    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() -1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){ // if forward and backwards is same
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void printTriplets(int[] result) { // printing triplets
        System.out.print("[ ");
        for (int i = 0; i < result.length; i += 3) {
            System.out.print("{" + result[i] + ", " + result[i+1] + ", " + result[i+2] + "}");
            if (i + 3 < result.length) System.out.print(" , ");
        }
        System.out.println(" ]");
    }

    public static void main(String[] args){
        String[] words = {"race", "car", "ecar", ""};

        printTriplets(palindromeTriplets(words));


    }

}
