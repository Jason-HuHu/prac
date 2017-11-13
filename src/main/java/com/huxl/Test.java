package com.huxl;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test
{
    public static void main(String[] args) throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("testStr","00000");
        testJson(jsonObject);
        //testParseLong("2199820929");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //比较两个日期
        Date date1 = new Date();
        Date date2 = sdf.parse("20170904");
        System.out.println(compareDate(date1,date2));
//      afterToday();

//        try {
//            formatDate(new Date());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(nvl("source", "\'CRE\'"));
//        System.out.println("\'CRE\'");
    }

/*    public static String nvl(String param, String val) {
        String sqlFunc = "nvl(" + param + "," + val + ")";
        if (StringUtils.equalsIgnoreCase("ORACLE", "ORACLE")) {
            sqlFunc = "nvl(" + param + "," + val + ")";
        } else if (StringUtils.equalsIgnoreCase("MYSQL","MYSQL")) {
            sqlFunc = "ifnull(" + param + "," + val + ")";
        }
        return sqlFunc;
    }*/


    public static void formatDate(Date date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        System.out.println(dateFormat.format(date));

        Date date1 = dateFormat.parse("20140909");
        System.out.println(date1.getTime());

    }

    /**
     * 判断一个日期是否在今天之后
     * @return
     */
    public static boolean afterToday() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        Date date1 = sdf.parse("20170904");
        Date date1 = new Date();
        Date date2 = sdf.parse("20170905");
        String dateTmp = sdf.format(date1);
        date1 = sdf.parse(dateTmp);
        System.out.println(sdf.format(date1));
        System.out.println(sdf.format(date2));

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        calendar1.setTime(date1);
        calendar2.setTime(date2);

        if (calendar1.after(calendar2)){
            System.out.println("date1 is after date2");
            return true;
        }
        if (calendar1.before(calendar2)){
            System.out.println("date1 is before date2");
            return true;
        }
        if (calendar1.equals(calendar2)){
            System.out.println("date1 is equals date2");
            return true;
        }
        return true;
    }

    /**
     * 比较两个日期的先后，比较格式为yyyyMMdd
     * @param date1 日期一
     * @param date2 日期二
     */
    private static boolean compareDate(Date date1, Date date2) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String strDate1 = sdf.format(date1);
        String strDate2 = sdf.format(date2);

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(sdf.parse(strDate1));
        calendar2.setTime(sdf.parse(strDate2));

        return calendar1.equals(calendar2);

    }

    private static void testParseLong(String str) {
        System.out.println(Long.parseLong(str));
    }

    private static void testJson(JSONObject content) {
        String str = content.getString("testStr");
        System.out.println(Long.parseLong(str));
    }
}
