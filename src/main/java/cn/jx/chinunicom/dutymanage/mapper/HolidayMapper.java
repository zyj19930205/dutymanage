package cn.jx.chinunicom.dutymanage.mapper;

import cn.jx.chinunicom.dutymanage.entity.Holiday;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HolidayMapper extends BaseMapper<Holiday> {
    List<Date> getHoliday_in_dutyScope(Date begin,Date end);
    List<Date> getHolidayByHolidayType(int holidayType);
    List<Date> getHolidayByTypeAndYear(@Param("HolidayType") int holidayType,@Param("year") String year);
}
