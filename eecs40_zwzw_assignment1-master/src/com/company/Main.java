
package com.company;

import java.util.Scanner;

public class Main {
    public int Bracketsnumber;
    public String express;


    public int Bnumber(String s){
        for (int i = 0; i < s.length(); i++)
        {
            char temp = s.charAt(i);
            if (temp == '(')
            {
                Bracketsnumber ++;
            }
        }
        return Bracketsnumber;
    }


    public String Operationon(String s,int m){
        String res = s;
        for (int i = m; i>0; i--)
        {
            int rightbracket = res.indexOf(')');
            int leftbracket = res.indexOf(')'); //location of rightbracket;
            for ( ; res.charAt(leftbracket)!='('; leftbracket--){
            }
            String subs = res.substring(leftbracket+1,rightbracket);
            String subs_re2 = Cal (subs);

            String subs_re1 = res.substring(0,leftbracket);
            String subs_re3 = res.substring(rightbracket+1);
            res = subs_re1 + subs_re2 + subs_re3;
        }
        res = Cal(res);
        return  res;
    }

    public static String Cal(String s)
    {

        int theplaceofoperator=0,typeofcalculation=9;
        boolean the_first_one_is_positive=true,the_second_one_is_positive=true;
        int frontnumbeer,backnumbeer;
        if(s.charAt(0)=='-')
            the_first_one_is_positive=false;
        if(the_first_one_is_positive)
        {
            for(int i=0; i<s.length() ;i++)
            {
                if(s.charAt(i)==('+'))
                {
                    theplaceofoperator =i;
                    typeofcalculation =0;
                    break;
                }
                if(s.charAt(i)==('-'))
                {
                    theplaceofoperator =i;
                    typeofcalculation =1;
                    break;
                }
                if(s.charAt(i)==('*'))
                {
                    theplaceofoperator =i;
                    typeofcalculation =2;
                    break;
                }
                if(s.charAt(i)==('/'))
                {
                    theplaceofoperator =i;
                    typeofcalculation =3;
                    break;
                }
            }
            if(s.charAt(theplaceofoperator+1)=='-')
                the_second_one_is_positive=false;
        }
        else
        {
            for(int i=1; i<s.length() ;i++)
            {
                if(s.charAt(i)==('+'))
                {
                    theplaceofoperator =i;
                    typeofcalculation =0;
                    break;
                }
                if(s.charAt(i)==('-'))
                {
                    theplaceofoperator =i;
                    typeofcalculation =1;
                    break;
                }
                if(s.charAt(i)==('*'))
                {
                    theplaceofoperator =i;
                    typeofcalculation =2;
                    break;
                }
                if(s.charAt(i)==('/'))
                {
                    theplaceofoperator =i;
                    typeofcalculation =3;
                    break;
                }
            }
            if(s.charAt(theplaceofoperator+1)=='-')
                the_second_one_is_positive=false;
        }

        if(the_first_one_is_positive)
        {
            String front = s.substring(0,theplaceofoperator) ;
            frontnumbeer = Integer.parseInt(front );
            if(the_second_one_is_positive)
            {
                String back = s.substring(theplaceofoperator+1);
                backnumbeer = Integer.parseInt(back );
            }
            else
            {
                String back = s.substring(theplaceofoperator+2);
                backnumbeer = Integer.parseInt(back );
                backnumbeer=-backnumbeer;
            }

        }
        else
        {
            String front = s.substring(1,theplaceofoperator) ;
            frontnumbeer = Integer.parseInt(front );
            frontnumbeer = - frontnumbeer;
            if(the_second_one_is_positive)
            {
                String back = s.substring(theplaceofoperator+1);
                backnumbeer = Integer.parseInt(back );
            }
            else
            {
                String back = s.substring(theplaceofoperator+2);
                backnumbeer = Integer.parseInt(back );
                backnumbeer=-backnumbeer;
            }
        }


        int resultnumber=0;
        switch(typeofcalculation)
        {
            case 0: resultnumber=frontnumbeer+backnumbeer;
                break;
            case 1: resultnumber=frontnumbeer-backnumbeer;
                break;
            case 2: resultnumber=frontnumbeer*backnumbeer;
                break;
            case 3: resultnumber=frontnumbeer/backnumbeer;
                break;
            default:  System.out.println("no calculation");
                break;

        }
        String result = Integer.toString(resultnumber);
        return result ;

    }
    public static void log(String s){
        System.out.println(s);
    }






    public static void main(String[] args){

        System.out.println("please input the expression :");
        Scanner in = new Scanner(System.in);
        String express = in.nextLine();

        Main calculator = new Main();
        //calculator.Getinput()buzhishigansha;
        int number = calculator.Bnumber( express);

        String re = calculator.Operationon(express,number);

        System.out.println("Result is "+ re);

    }

}
