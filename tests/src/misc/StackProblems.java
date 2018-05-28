package misc;

import model.MyInt;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Map;


/**
 * Created by msharafat on 5/26/18.
 */
public class StackProblems {

    public static void main(String []s){
         //int len = findMaxLen("()()((((((()");
        // System.out.println(len);
        String infix= "3+4-7*8";
        infixToPostFix(infix);

    }

    public void maxValidParanthesisLength(String s){
        int len=0;

        //parenthesisUtil( s, len, 0);
    }

    /*
    String s = "(()()((((()((()))))))"
    "()()())))))))"
                0123456789
     */
//    private boolean parenthesisUtil(String s , MyInt len, MyInt i){
//
//        if (s.charAt(i) == ')'){
//            return true;
//        }
//        //MyInt maxLen= new MyInt(0);
//        MyInt currentIntex= new MyInt(i);
//        while(i.getValue()<s.length()){
//            MyInt currentIntex= new MyInt(i);
//            if(s.charAt(i) == '('){
//                boolean flag= parenthesisUtil(s, len, i.increment());
//                if(flag){
//                    int currentLength = i.getValue() - currentIntex.getValue() + 1;
//                    if(currentLength > len.getValue()){
//                        len.setValue(currentLength);
//                    }
//
//                }
//            }
//
//       }
//        return false;
//    }

     /*
    String s = "(()()((((()((()))))))"
    "()()())))))))"
    ")()())"
                0123456789
     */

//    public int maxValidParanthesisLength2(String s){
//
//        Stack stack = new Stack();
//        int i =0;
//        int len = 0;
//        int maxLen=0;
//        while(i<s.length()){
//            if(s.charAt(i) == '('){
//                stack.push(i);
//            }
//            else{
//                if(stack.isEmpty()) continue;
//                int j = (int)stack.pop();
//                if(s.charAt(j) ==')'){
//                    len = i-j+1;
//                    if(len > maxLen)
//                        maxLen = len;
//                }
//
//            }
//
//        }
//
//    }

    static int findMaxLen(String str)
    {
        int n = str.length();

        // Create a stack and push -1 as initial index to it.
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        // Initialize result
        int result = 0;

        // Traverse all characters of given string
        for (int i=0; i<n; i++)
        {
            // If opening bracket, push index of it
            if (str.charAt(i) == '(')
                stk.push(i);

            else // If closing bracket, i.e.,str[i] = ')'
            {
                // Pop the previous opening bracket's index
                stk.pop();

                // Check if this length formed with base of
                // current valid substring is more than max
                // so far
                if (!stk.empty())
                    result = Math.max(result, i - stk.peek());

                    // If stack is empty. push current index as
                    // base for next valid substring (if any)
                else stk.push(i);
            }
        }

        return result;
    }

    /*
    a+b + d*(b-c)
     */
   //ab

    public static  void infixToPostFix(String s){
        Stack<Character> stack = new Stack<>();
        String output= "";
        int i =0;
        while(i < s.length()){
            Character c = s.charAt(i);
            if(c-'0'  >= 0 && c-'9' <=9){
                output = output + c.toString();
            }
            else{
                if(stack.isEmpty()){
                    stack.push(c); i++; continue;
                }
                if(c == '(') {
                    stack.push(c);
                    i++; continue;
                }

                if(c == ')'){

                    while(!stack.isEmpty() && stack.peek() != '('){
                        Character op = stack.pop();
                        output = output + op.toString();
                    }
                    if(!stack.isEmpty()) stack.pop();
                    i++; continue;
                }
                boolean f = checkPrecedence(c,stack.peek());
                if(f){
                    stack.push(c);
                }
                else{
                    while(!stack.isEmpty() && checkPrecedence(stack.peek(),c)){
                        Character op = stack.pop();
                        output = output + op.toString();
                    }
                }
            }
            i++;
        }
        while(!stack.isEmpty()){
            output = output + stack.pop();
        }
        System.out.println("PostFix :: "+output);

    }

    public static boolean checkPrecedence(Character a, Character b){
        Map<Character,Integer> map = new HashMap<>();
        map.put('(',1);
        map.put(')',1);
        map.put('/',3);
        map.put('*',3);
        map.put('+',2);
        map.put('-',2);

        if(map.get(a) >= map.get(b))
            return true;
        return false;

    }
}
