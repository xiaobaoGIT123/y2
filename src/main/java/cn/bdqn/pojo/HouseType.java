package cn.bdqn.pojo;
//房子类型
public class HouseType {
    private Integer tid;
    private String type;//房子类型  单间/一室一厅/二室一厅/二室二厅/三室一厅/四室一厅/其它类型

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
