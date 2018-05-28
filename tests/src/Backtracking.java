/**
 * Created by msharafat on 4/7/18.
 */
import java.util.List;

public class Backtracking {

    public static void main(String arg[]){
        Backtracking b= new Backtracking();
        int a[][] = new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};

       b.nQueenProblem(a,7,7);
    }

    public List<String> nQueenProblem(int a[][], int r , int c){

        String s="";
        for(int j=0;j<c;j++){
             a = new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};

            nQueen(a,0,j,r,c,s);
        }

        return null;
    }

    public String nQueen(int a[][], int i, int j, int r, int c, String s){
        if(i>r){
            System.out.println();
            System.out.println(s);
            s="";
            return s;
        }
         //i=0;
        int count=0;
        while(count++ <=c){
            //printMatrix(a,r,c);
            if(isSafe(a,i,j)){
                a[i][j] =1;
               // System.out.print(i+","+j+"   ");
                s=s.concat(i+","+j+"   ");
                nQueen(a,i+1,j,r,c,s);
                s=s.replace(i+","+j+"   ","");
                //a[i][j] =0;
                //printMatrix(a,r,c);
                return s;

            }
            else {
                j=j<c?j+1:j%c;
            }
        }

        return s;

    }

    private boolean isSafe(int a[][], int i , int j){
        for(int k=j;k>=0;k--){
            if(a[i][k] ==1){
             //   System.out.println((i)+","+(j)+" is not safe");
                return false;
            }
        }

        for(int k=i;k>=0;k--){
            if(a[k][j] ==1){
              //  System.out.println((i)+","+(j)+" is not safe");

                return false;
            }
        }
        int k=i,l=j;
        while(k>=0 && l >=0){

            if(a[k--][l--] == 1) {
               // System.out.println((i)+","+(j)+" is not safe");
                return false;
            }
        }

       // System.out.println((i)+","+(j)+" is safe");
        return true;
    }

    private void printMatrix(int a[][], int r, int c){
        int i=0,j=0;
        System.out.println("-------------Printing Matrix----------------");

        while(i<=r){
            System.out.println();
            while(j<=c){
                System.out.print(a[i][j++]+"  ");
            }
            i++;j=0;
        }
    }
}
