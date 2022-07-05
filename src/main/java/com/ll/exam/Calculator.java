package com.ll.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Calculator {
    public static int calc(String s) {

        s=s.replaceAll("\\s+","");

        String numStr = s.replaceAll("[^0-9]", " ");
        String opStr = s.replaceAll("[0-9]", " ");
        StringTokenizer st = new StringTokenizer(numStr);

        ArrayList<Integer>nums = new ArrayList<>();
        while(st.hasMoreTokens()){
            nums.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Character> ops = new ArrayList<>();
        st = new StringTokenizer(opStr);

        while(st.hasMoreTokens()){
            ops.add(st.nextToken().charAt(0));
        }

        int num=0;
        while(!ops.isEmpty()){
            boolean isMul = ops.contains('*');
            boolean isDiv = ops.contains('/');
            int idx=0;
            if(isMul || isDiv){
                int m = ops.indexOf('*');
                int d = ops.indexOf('/');
//                System.out.println(m+" "+d);
                if(m!=-1&&d!=-1){
                    idx = m>d?d:m;
                }
                else{
                    idx = m==-1?d:m;
                }
            }
            char c= ops.get(idx);
            int n1=nums.get(idx);
            int n2 = nums.get(idx+1);
            int temp=0;
            switch (c){
                case '+':temp+=calcPlus(n1,n2);
                    break;
                case '-':temp+=calcMinus(n1,n2);
                    break;
                case '/':temp+=calcDiv(n1,n2);
                    break;
                case '*':temp+=calcMul(n1,n2);
                    break;
            }
            nums.remove(idx);
            nums.remove(idx);
            nums.add(idx,temp);
            ops.remove(idx);
        }
        return nums.get(0);
    }

    private static int calcDiv(int no1, int no2) {
        return no1/no2;
    }

    private static int calcMul(int no1, int no2) {
        return no1*no2;
    }

    private static int calcPlus(int no1, int no2) {
        return no1 + no2;
    }

    private static int calcMinus(int no1, int no2) {
        return no1 - no2;
    }
}
