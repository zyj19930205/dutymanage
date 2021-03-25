package cn.jx.chinunicom.dutymanage.service.impl;

import cn.jx.chinunicom.dutymanage.entity.Bo.DateWithEmp;
import cn.jx.chinunicom.dutymanage.entity.Bo.SimpleDateWithEmp;
import cn.jx.chinunicom.dutymanage.entity.Bo.TempDutyResultBo;
import cn.jx.chinunicom.dutymanage.entity.FormalDutyResult;
import cn.jx.chinunicom.dutymanage.entity.ResultMsg;
import cn.jx.chinunicom.dutymanage.entity.TempDutyResult;
import cn.jx.chinunicom.dutymanage.mapper.FormalDutyMapper;
import cn.jx.chinunicom.dutymanage.mapper.TempDutyResultMapper;
import cn.jx.chinunicom.dutymanage.service.FormalDutyResultService;
import cn.jx.chinunicom.dutymanage.util.DutyUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FormalDutyResultServiceImpl implements FormalDutyResultService {


    @Autowired
    TempDutyResultMapper tempDutyResultMapper;
    @Autowired
    FormalDutyMapper formalDutyMapper;



    /**
     * 根据排班表生成excel
     * @param
     */
    @Override
    public void GenerateExcelTableForDuty() throws IOException {

//        int evening_duty_code[]={3,5,8,9,11};
//        int morning_duty_code[]={2,6,7};
        List<Integer> evening_duty_code= Arrays.asList(3,5,8,9,11);
        List<Integer> morning_duty_code= Arrays.asList(2,4);
        //获取所有晚班数据
        QueryWrapper<TempDutyResult> tempDutyResultQueryWrapper=new QueryWrapper<>();
        tempDutyResultQueryWrapper.orderByAsc("dutyDate");
        tempDutyResultQueryWrapper.in("dutyTypeId",evening_duty_code);
        List<TempDutyResult> tempDutyResults=tempDutyResultMapper.selectList(tempDutyResultQueryWrapper);
        //转换晚班数据到新集合中
        List<SimpleDateWithEmp> simpleDateWithEmps=new ArrayList<>();
        for(TempDutyResult tempDutyResult:tempDutyResults){
            String str_date=DutyUtils.DateToStr(tempDutyResult.getDutyDate());
            SimpleDateWithEmp simpleDateWithEmp=new SimpleDateWithEmp(str_date,tempDutyResult.getEmpName());
            simpleDateWithEmps.add(simpleDateWithEmp);
        }
        //获取所有白班的数据
        QueryWrapper<TempDutyResult> tempDutyResultQueryWrapper1=new QueryWrapper<>();
        tempDutyResultQueryWrapper1.orderByAsc("dutyDate");
        tempDutyResultQueryWrapper1.in("dutyTypeId",morning_duty_code);
        List<TempDutyResult> tempDutyResults_morning=tempDutyResultMapper.selectList(tempDutyResultQueryWrapper1);
        //转换晚班数据到新集合中
        List<SimpleDateWithEmp> simpleDateWithEmps_mo=new ArrayList<>();
        for(TempDutyResult tempDutyResult:tempDutyResults_morning){
            String str_date=DutyUtils.DateToStr(tempDutyResult.getDutyDate());
            SimpleDateWithEmp simpleDateWithEmp=new SimpleDateWithEmp(str_date,tempDutyResult.getEmpName());
            simpleDateWithEmps_mo.add(simpleDateWithEmp);
        }
        System.out.println(simpleDateWithEmps_mo.size()+":"+simpleDateWithEmps_mo);




        //开始制作excel
        String filePath = "C://Users/37980/Desktop/2020-07.xlsx";
//        String filePath = "/Users/zouyujie/Documents/工作/开发/2021-1.xlsx";
        FileInputStream excelFileInputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(excelFileInputStream);//拿到文件转化为javapoi可操纵类型
        excelFileInputStream.close();

        XSSFSheet sheet = workbook.getSheetAt(0);
        int date_line_divid=5;

        //第一行
        Row row1 = sheet.createRow(0);
        Cell cell1 = row1.createCell(0);
        cell1.setCellValue("2021年2月部门值班表");



        //填充所有日期，每隔7个换一行，每行间隔5
        List<List<SimpleDateWithEmp>> lists=splitList(simpleDateWithEmps,7);//获取分割后的集合组
//        System.out.println(lists);
        int n=1;//控制日期行
        for(int i=0;i<lists.size();i++){
            Row row=sheet.getRow(n);//日期行
            Row row_mo=sheet.getRow(n+1);
            Row row2=sheet.getRow(n+2);//晚班行
            for(int j=0;j<lists.get(i).size();j++){
                Cell cell=row.getCell(j+2);//插入日期，要从第二列开始
                cell.setCellValue(lists.get(i).get(j).getDate());
                Cell cell2=row2.getCell(j+2);//插入晚班人员，仍然要从第二列开始
                cell2.setCellValue(lists.get(i).get(j).getName());
            }
            n=n+5;
        }


        int k=1;
        //插入白班人员
        for(int i=0;i<lists.size();i++){//控制行循环
            Row row=sheet.getRow(k);//日期行
            Row row2=sheet.getRow(k+1);//白班行
            for(int j=0;j<7;j++){//控制列循环
                Cell cell=row.getCell(j+2);
                String date=cell.getStringCellValue();
                for(int l=0;l<simpleDateWithEmps_mo.size();l++){
                    Cell cell2=row2.getCell(j+2);
                    String current_date=simpleDateWithEmps_mo.get(l).getDate();
                    if(date.equals(current_date)){//如果日期相符，则插入白班人员
                        cell2.setCellValue(simpleDateWithEmps_mo.get(l).getName());
                    }
                }
            }
            k=k+5;
        }


        FileOutputStream excelFileOutPutStream = new FileOutputStream("C://Users/37980/Desktop/2020-07.xlsx");//写数据到这个路径上
        workbook.write(excelFileOutPutStream);
        excelFileOutPutStream.flush();
        excelFileOutPutStream.close();
    }

    @Override
    public List<FormalDutyResult> getFormalDutyResult() {
        return formalDutyMapper.selectList(null);
    }

    @Override
    public ResultMsg getFormalDutyResultByPage(int page, int limit) {
        Page<FormalDutyResult> formalDutyResultPage=new Page<>(page,limit);
        IPage<FormalDutyResult> iPage=formalDutyMapper.getFormalDutyResultByPage(formalDutyResultPage);
        List<FormalDutyResult> formalDutyResults=iPage.getRecords();
        List<TempDutyResultBo> tempDutyResultBos=changeResultToBo(formalDutyResults);
        ResultMsg resultMsg=ResultMsg.createBySuccess(iPage.getTotal(),tempDutyResultBos);
        return resultMsg;
    }

    private List<TempDutyResultBo> changeResultToBo(List<FormalDutyResult> tempDutyResults) {
        List<TempDutyResultBo> formalDutyResultBos=new ArrayList<>();
        TempDutyResultBo tempDutyResultBo;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        for(FormalDutyResult tempDutyResult:tempDutyResults){
            tempDutyResultBo=new TempDutyResultBo();
            tempDutyResultBo.setId(tempDutyResult.getId());
            tempDutyResultBo.setEmpId(tempDutyResult.getEmpId());
            tempDutyResultBo.setEmpName(tempDutyResult.getEmpName());
            tempDutyResultBo.setDutyDate(sdf.format(tempDutyResult.getDutyDate()));
            tempDutyResultBo.setDutyTypeId(tempDutyResult.getDutyTypeId());
            tempDutyResultBo.setTypeName(tempDutyResult.getTypeName());
            formalDutyResultBos.add(tempDutyResultBo);
        }
        return formalDutyResultBos;
    }

    /**
     * 按指定大小，分隔集合，将集合按规定个数分为n个部分
     *
     * @param list
     * @param len
     * @return
     */
    public static List<List<SimpleDateWithEmp>> splitList(List<SimpleDateWithEmp> list, int len) {
        if (list == null || list.size() == 0 || len < 1) {
            return null;
        }

        List<List<SimpleDateWithEmp>> result = new ArrayList<List<SimpleDateWithEmp>>();


        int size = list.size();
        int count = (size + len - 1) / len;


        for (int i = 0; i < count; i++) {
            List<SimpleDateWithEmp> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
            result.add(subList);
        }
        return result;
    }
}
