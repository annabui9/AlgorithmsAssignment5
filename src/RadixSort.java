import java.util.ArrayList;
import java.util.List;

public class RadixSort {


    public static String[] radixSort(String[] s){
        if(s.length == 0){ //if array is empty
            System.out.println("The array is empty.");
            return s;
        }

        int maxString = 0;
        for(int i = 0; i < s.length; i++){ // find the length of longest string
            maxString = Math.max(maxString, s[i].length());
        }

        for(int charPos = maxString - 1; charPos >= 0; charPos--){ // start from the right
            sortBuckets(s, charPos);
        }

        return s;
    }

    public static void sortBuckets(String[] s, int charPos){
        int n = s.length; // length of new array
        List<String>[] buckets = new ArrayList[256]; // looked this up, there are 256 ASCII characters, and they are ordered alphabetically (a<b<c..)

        for(int i = 0; i < 256; i++){
            buckets[i] = new ArrayList<>(); // creating 256 buckets for each character
        }

        for(int i = 0; i < s.length; i++){
            if(charPos < s[i].length()){ // if position in question is within string in question, add string to correct bucket (sorting by charPos)
                buckets[s[i].charAt(charPos)].add(s[i]); // put into bucket -- using values from ASCII table, which is ordered
            }else{
                buckets[0].add(s[i]); // if position in question is not in string in question (so string is shorter than maxString), put in 0 bucket -- representing null/empty space
            }
        }

        int inBucketIndex = 0;
        for(int i = 0; i < buckets.length; i++){ // add elements back into s in order
            for(int j = 0; j < buckets[i].size(); j++){
                s[inBucketIndex] = buckets[i].get(j);
                inBucketIndex++;
            }
        }

    }

    public static void printStringArray(String[] s){
        for (int i = 0; i < s.length; i++) {
            if(i == s.length - 1){
                System.out.println(s[i]); // last element -- no comma
            } else {
                System.out.print(s[i] + ", "); // not last element --add comma
            }
        }
    }

    public static void main(String[] args){
        String[] input = {"google", "gojo", "amazingly", "jogo", "luna", "pup", "solas", "solo", "pupperino", "amaterasu", "amazon", "puppy", "hydra", "amazonia", "vueltiao"};

        printStringArray(radixSort(input));

    }


}
