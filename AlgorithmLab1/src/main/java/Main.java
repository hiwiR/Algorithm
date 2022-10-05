import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println(findGCDE(18, 24));
        //int[] arr = new int[]{ 68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46 };
        int[] arr = new int[]{ 3,34,4,12,5,2};
        //System.out.println(IntStream.of(arr).anyMatch(x->x==3));
        boolean[][] test = subSet(arr,9);
        for (boolean[] x : test)
        {
            for (boolean y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println();
        }


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
//                else if(arr[i-1]==j){
//                    test[i][j] = true;
//                }
                else if( arr[i-1] < j){
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
}
