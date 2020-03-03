package cn.jx.chinunicom.dutymanage.util;

public enum DutyRules {
    不参与值班(1),假日白班(2),周四晚班(3),周末白班(4),普通晚班(5),
    周六白班(6),周日白班(7),周六晚班(8),周日晚班(9),特殊值班(10),假日晚班(11),白班(999),晚班(1000);

    private String StatusName;
    private int StatusCode;

    DutyRules(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public int getStatusCode() {
        return StatusCode;
    }
}
