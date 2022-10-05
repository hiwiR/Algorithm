public class Main {

    public static void main(String[] args) {
        // find GCD between n1 and n2


        System.out.println(findGCDE(18, 24));

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
}
