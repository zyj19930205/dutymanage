package cn.jx.chinunicom.dutymanage.util;

import java.util.Arrays;
import java.util.List;

public enum  DutyDays {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3),
    THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(0);

    public static List<Integer> COMMON_DUTY_DAY= Arrays.asList(1,2,3,5,6,0);
    public static List<Integer> HOLIDAYS_DUTY_DAY= Arrays.asList(1,2,3,4,5,6,0);
    public static Integer THURSDAY_DUTY_DAY=4;
    public static List<Integer> WEEKEND_DUTY_DAY=Arrays.asList(6,0);

    private int day;
    private String typeName;

    DutyDays(int typeId) {
        this.day = typeId;
    }

    public int getDay() {
        return day;
    }
}
