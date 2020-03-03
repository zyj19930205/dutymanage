package cn.jx.chinunicom.dutymanage.entity;

import lombok.Data;

import java.util.List;

@Data
public class ResultMsg<T> {

    private final static int STATUS_OK=0;
    private final static int STATUS_ERROR=1;

    private int code;
    private long count;
    private String msg;
    private T data;

    public ResultMsg(int code, long count, T data) {
        this.code = code;
        this.count = count;
        this.data = data;
    }

    public ResultMsg(int code, long count, String msg) {
        this.code = code;
        this.count = count;
        this.msg = msg;
    }

    public ResultMsg(int code,String msg) {
        this.msg = msg;
        this.code = code;
    }

    public static <T> ResultMsg<T> createBySuccess(long count, T data){
        return new ResultMsg<T>(ResultMsg.STATUS_OK,count,data);
    }

    public static <T> ResultMsg<T> createBySuccess(){
        return new ResultMsg<T>(ResultMsg.STATUS_OK,"成功");
    }

    public static <T> ResultMsg<T> createByFail(){
        return new ResultMsg<T>(ResultMsg.STATUS_ERROR,"失败");
    }

    public static <T> ResultMsg<T> createByNull(long count, String msg){
        return new ResultMsg<T>(ResultMsg.STATUS_ERROR,count,msg);
    }

}
