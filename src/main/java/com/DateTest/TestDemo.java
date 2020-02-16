package com.DateTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
时间、 日历 测试
 */
public class TestDemo {
    public static void main(String[] args) throws ParseException {

        //日历
        //获取日历对象
        Calendar calendar = Calendar.getInstance();//多态的形式，返回对象。 返回一个calendar的子类对象
        System.out.println(calendar); // 月份从0开始
        System.out.println(calendar.get(Calendar.YEAR));
        // Calendar add操作， 根据日历规则，减去某个时间量,set 对某个值进行设置。
        // 三年前的今天
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -3);
        System.out.println(c);

        //时间格式操作
        Date d = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d_sdf = sdf1.format(d);
        System.out.println(d_sdf);
        String dateStr = "2020年7月23日 23点13分40s";
        System.out.println(dateStr);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分sss");
        System.out.println(sdf2.parse(dateStr));

        System.out.println(sdf1.format(sdf2.parse(dateStr)));
        int[] years = new int[] {1234,1456,1679,1800,1996,2004,2008,2023,2016,2020};
        Scanner scanner = new Scanner(System.in);
        System.out.println("plz input year");
        int year = scanner.nextInt();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, 2);
        cal.set(Calendar.DATE, 1);
        //对日子进行修改， 加-1天，为前一天。

        cal.add(Calendar.DATE, -1);

        System.out.println(year + "年的二月份有：" + cal.get(Calendar.DATE) + " 天");
    }
}
