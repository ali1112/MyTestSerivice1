import java.util.*;

public class Solution2 {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Scanner in = new Scanner(System.in);
        Integer exec = null;
        Integer cust = null;
        try {
            exec = Integer.parseInt(in.nextLine());
            cust = Integer.parseInt(in.nextLine());
        } catch (Exception e) {
            throw new Exception();
        }

        Integer startTime[] = new Integer[cust];
        Integer endTime[] = new Integer[cust];

        for (int i = 0; i < cust; i++) {
            String timeStamps = in.nextLine();
            String timeStampTokens[] = timeStamps.split(" ");
            try {
                if (timeStampTokens.length == 2) {
                    startTime[i] = Integer.parseInt(timeStampTokens[0]);
                    endTime[i] = Integer.parseInt(timeStampTokens[1]);
                }

            } catch (Exception e) {
                throw new Exception();
            }

            // Call call = new Call(i,startTime[i],endTime[i]);
        }

        if (!(startTime.length > 0 && endTime.length > 0)) {
            return;
        }
        //Arrays.sort(startTime);
        //Arrays.sort(endTime);

        int count = 0;
        int start = 0;
        int end = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int max = 0;

        while (i < cust && j < cust) {
            start = startTime[i];
            end = endTime[j];
            if (start < end) {
                count++;
                i++;
                max = maxOf(count, max);

            } else {
                count--;
                j++;
            }
        }
        System.out.println(max - exec);

    }

    private static int maxOf(int a, int b) {
        if (a > b) return a;
        else return b;
    }


}

class Call {
    int id;
    int startTime;
    int endtime;

    public Call(int id, int startTime, int endtime) {
        this.id = id;
        this.startTime = startTime;
        this.endtime = endtime;
    }
}