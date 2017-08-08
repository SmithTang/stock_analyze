package com.citi.gunrose.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by miaochangfu on 2017/8/7.
 */
public  class DateFormat {


    public static void main(String[] args){

        //s = 201105311440,type = "yyyyMMddhhmm"
        dateFormat("201105311440","yyyyMMddhhmm");
        //Tue May 31 14:40:50 CST 2011

      // System.out.print(d1.getHours());
    }

    public static boolean dateFormat(String s, String type)  {


        SimpleDateFormat sim=new SimpleDateFormat(type);

        try {
            Date d=sim.parse(s);
            Date d1 = new java.sql.Timestamp(d.getTime());//日期和时间
            Date d2 = new java.sql.Time(d.getTime());//时间
            Date d3 = new java.sql.Date(d.getTime());//日期

            System.out.print(d1);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return true;
    }
}
