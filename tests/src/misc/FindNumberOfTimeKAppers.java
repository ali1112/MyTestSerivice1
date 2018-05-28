package misc;

/**
 * Created by msharafat on 4/15/17.
 */
public class FindNumberOfTimeKAppers {

    public static void  main(String args []){

        FindNumberOfTimeKAppers f = new FindNumberOfTimeKAppers();
        int a[] = {2,21,0,4,5,24};
        int n =100, k =0;

        System.out.println(f.findNumberOFTimesKAppears(a, n, k));
    }

    public int findNumberOFTimesKAppears(int a[], int n ,int k){

        int nDigits= findNumberOFDigits(n);
        int q = 1;
        if( nDigits > 1){

            Double q1 = Math.pow(10.0, new Double(nDigits -1));
            q = q1.intValue();

        }

        int numbberOfTimeK = 0 ;
        int i =0;
        while(i < a.length){

            numbberOfTimeK = numbberOfTimeK + findNumberOfKs(a[i], k, q);
            i++;

        }
        return numbberOfTimeK;

    }

    private int findNumberOFDigits(int n ){
        int i = 1;
        while(n > 9){
            n = n/10;
            i++;
        }
        return  i;
    }
    private int findNumberOfKs(int a, int k, int q){
        int sum = 0;
         if(a > 9){

            while(q >0) {
                if(a > q){
                    int digit = a/q;
                    if(digit == k){
                        sum++;
                    }
                }

                a = a%q;
                q=q/10;
            }


        }

        else{
             if(a == k){
                 sum++;
             }
         }

        return sum;
    }
}
