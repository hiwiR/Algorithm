import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println(findGCDE(18, 24));
        //int[] arr = new int[]{ 68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46 };
        int[] arr = new int[]{ 3,34,4,12,5,2};
        //System.out.println(IntStream.of(arr).anyMatch(x->x==3));
//        boolean[][] test = subSet(arr,9);
//        for (boolean[] x : test)
//        {
//            for (boolean y : x)
//            {
//                System.out.print(y + " ");
//            }
//            System.out.println();
//        }

//        int[] arr1 = new int[]{1, 4, 5, 8, 17};
//        int[] arr2 = new int[]{2, 4, 8, 11, 13, 21, 23, 25};
//        System.out.println(Arrays.toString(merge(arr1,arr2)));

        /*List<Integer> inputSet = new ArrayList<>();
        inputSet.add(1);inputSet.add(2);inputSet.add(3);
        System.out.println(powerSet(inputSet).toString());*/

        System.out.println(recursiveFactorial(5));

    }
    public static int findGCD(int n,int m){
        int gcd  = 1;
        int limit = n>m?m:n;
        for(int i=2;i<=limit;i++){
            if(n%i == 0 && m%i == 0)
                gcd = i;
        }
        return gcd;
    }

    public static int findGCDE(int n,int m){
        while(n != m){
            if(n > m){
                n -=m;
            }else{
                m-=n;
            }
        }
        return n;
    }
//    public static boolean subSetSum(int[] arr,int sum){
//        for(int i= 0;i<arr.length;i++){
//            int tempSum=arr[i];
//            for(int j =i+1;j<arr.length;j++){
//                if(tempSum + arr[j] == sum)
//                    return true;
//                else if(tempSum + arr[j] > sum)
//                    continue;
//                tempSum += arr[j];
//                }
//            }
//        return false;
//        }

//        public static boolean subSetSumTest(int[] arr,int sum){
//        int totalSum = Arrays.stream(arr).sum();
//        for( int i=0;i<arr.length;i++){
//            if(totalSum - arr[i] > sum){
//                totalSum -= arr[i];
//                for(int j =i+1;j<arr.length;j++){
//                    if(totalSum -arr[i] >sum)
//                        totalSum -= arr[i];
//                    else if (totalSum -arr[i]==sum) {
//                        return true;
//                    }
//                    else
//                        totalSum -= arr[j];
//                    }
//                }
//            }
//        return false;
//        }
    public static boolean[][]  subSet(int arr[], int sum){
        boolean[][] test = new boolean[arr.length+1][sum+1];
        for(int i =0;i< arr.length+1;i++){
            for(int j=0;j<sum+1;j++){
                if( (i == 0 && j == 0) || (j==0))
                    test[i][j] = true;
                else if (i == 0 && j!=0) {
                    test[i][j] = false;
                } else if (test[i-1][j] == true || (arr[i-1]==j)) {
                    test[i][j] = true;
                } else if (arr[i-1] > j) {
                    test[i][j] = false;
                }
                else if( arr[i-1] < j ){
                    int dif  = j-arr[i-1];
                   if(IntStream.of(arr).anyMatch(x->x == dif )){
                        if( test[i-1][j-arr[i-1]] == true){
                       test[i][j] = true;
                            }
                    }
                }
                else{
                    test[i][j] = false;
                }
            }
        }
        return test;
    }

    public static int[] merge(int[] arr1, int[] arr2){
        int [] result =  new int[arr1.length+ arr2.length];
        int index =0;
        int[] remaining = arr1.length > arr2.length ? Arrays.copyOfRange(arr1,arr2.length,arr1.length) : Arrays.copyOfRange(arr2,arr1.length,arr2.length);
        int min = Math.min(arr1.length,arr2.length);
        for(int i=0;i<min;i++){
                if(arr1[i]<arr2[i]){
                    result[index++] = arr1[i];
                    result[index++]=arr2[i];
                }
                else {
                    result[index++] = arr2[i];
                    result[index++]=arr1[i];
            }
        }
        System.arraycopy(remaining,0,result,Math.min(arr1.length,arr2.length)*2,remaining.length);
        return result;
    }

    public static List<Set> powerSet(List<Integer> input){
        List<Set> P = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        P.add(s);
        Set t = new HashSet<>();
        while(!input.isEmpty()){
            int f = input.remove(0);
            int size = P.size();
            for(int i=0;i<size;i++){
                if(!P.get(i).isEmpty()){
                t = (Set.of(f,P.get(i)));
                 }
                else {
                    t= Set.of(f);
                }
                P.add(t);
            }
        }
        return P;
    }
    public static int recursiveFactorial(int n){
        if(n == 1 || n==0)
            return 1;
        return n*recursiveFactorial(n-1);
    }
    public static int
}
