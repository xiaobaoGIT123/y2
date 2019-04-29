package cn.bdqn.pojo;
//房子
public class House {
    private Integer hid;
    private String housePicture;//房子图片 可以放多张
    private String houseLabel;//房子标签  阳台 洗手间 一室一厅  二室一厅等等 多
    private Integer houseStatus;//房子状态???  0待租 1已租
    private String houseTime;//发布时间
    private Integer houseUser;//拥有者 user uid
    private Integer houseTypeId;//房子类型id
    private String houseAddress;//地址
    private String housePrice;//价格

    private String houseDescribe;//描述
    private String houseTitle;//标题
    private String houseArea;//面积

    public String getHouseTitle() {
        return houseTitle;
    }

    public void setHouseTitle(String houseTitle) {
        this.houseTitle = houseTitle;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public String getHouseDescribe() {
        return houseDescribe;
    }

    public void setHouseDescribe(String houseDescribe) {
        this.houseDescribe = houseDescribe;
    }

    private User user;   //拥有者对象

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(String housePrice) {
        this.housePrice = housePrice;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHousePicture() {
        return housePicture;
    }

    public void setHousePicture(String housePicture) {
        this.housePicture = housePicture;
    }

    public String getHouseLabel() {
        return houseLabel;
    }

    public void setHouseLabel(String houseLabel) {
        this.houseLabel = houseLabel;
    }

    public Integer getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(Integer houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getHouseTime() {
        return houseTime;
    }

    public void setHouseTime(String houseTime) {
        this.houseTime = houseTime;
    }

    public Integer getHouseUser() {
        return houseUser;
    }

    public void setHouseUser(Integer houseUser) {
        this.houseUser = houseUser;
    }

    public Integer getHouseTypeId() {
        return houseTypeId;
    }

    public void setHouseTypeId(Integer houseTypeId) {
        this.houseTypeId = houseTypeId;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }
}
