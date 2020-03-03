package cn.jx.chinunicom.dutymanage.util;

import cn.jx.chinunicom.dutymanage.entity.Bo.DateWithEmp;
import cn.jx.chinunicom.dutymanage.entity.Bo.SimpleDateWithEmp;
import cn.jx.chinunicom.dutymanage.entity.TempDutyResult;
import org.apache.ibatis.annotations.Param;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DutyUtils {
    public static int[] StringToInt(String[] arrs){
        int[] ints=new int[arrs.length];
        for(int i=0;i<arrs.length;i++){
            ints[i]=Integer.parseInt(arrs[i]);
        }
        return ints;
    }

    public static Date StringToDate(String date) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date new_Date=sdf.parse(date);
        return new_Date;
    }
    public static String DateToStr(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-d");
        String str_date=sdf.format(date);
        return str_date;
    }

    /*
   获取指定区间内的所有日期
    */
    public static List<Date> getDates(Date beginDate, Date endDate) throws ParseException {
        List<Date> old_dates=new ArrayList<>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        Date start_Date=sdf.parse(beginDate);
//        Date end_Date=sdf.parse(endDate);
        Calendar begin=Calendar.getInstance();
        Calendar end=Calendar.getInstance();
        begin.setTime(beginDate);
        end.setTime(endDate);
        while(begin.before(end)||begin.equals(end)){
            old_dates.add(begin.getTime());
            begin.add(Calendar.DAY_OF_WEEK,1);
        }
        return old_dates;
    }

    /*
  获取参数中的日期是星期几
   */
    public static int getDatesWeek(Date date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int week=calendar.get(Calendar.DAY_OF_WEEK);
        return week-1;
    }


    public List<Date> getWeekList(List<Date> dutyDays,List<Integer> day_week){
        List<Date> date_weeks=new ArrayList<>();
        for(Date date:dutyDays){
            int tempDate=DutyUtils.getDatesWeek(date);
            if(day_week.contains(tempDate)){
                date_weeks.add(date);
            }
        }
        return date_weeks;
    }

    public static List<SimpleDateWithEmp> changeToSimpleFormat(List<DateWithEmp> dateWithEmps){
        List<SimpleDateWithEmp> simpleDateWithEmps=new ArrayList<>();
        for(DateWithEmp dateWithEmp:dateWithEmps){
            SimpleDateWithEmp simpleDateWithEmp=new SimpleDateWithEmp(DutyUtils.DateToStr(dateWithEmp.getDutyDate()),dateWithEmp.getEmployee().getName()+dateWithEmp.getEmployee().getRemarks());
            simpleDateWithEmps.add(simpleDateWithEmp);
        }
        return simpleDateWithEmps;
    }

    public static List<SimpleDateWithEmp> TempDutychangeToSimpleFormat(List<TempDutyResult> tempDutyResults){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-d");
        List<SimpleDateWithEmp> simpleDateWithEmps=new ArrayList<>();
        for(TempDutyResult tempDutyResult:tempDutyResults){
            SimpleDateWithEmp simpleDateWithEmp=new SimpleDateWithEmp(sdf.format(tempDutyResult.getDutyDate()),tempDutyResult.getEmpName());
            simpleDateWithEmps.add(simpleDateWithEmp);
        }
        return simpleDateWithEmps;
    }

}
