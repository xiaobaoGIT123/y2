package cn.bdqn.pojo;
//用户
public class User {
    private Integer uid;
    private  String userName;//用户名
    private  String passWord;//密码
    private  String phone;//电话   唯一
    private  Integer role;//角色  0普通用户 1房东
    private  Integer accountStatus;//账号状态   	0正常 1封号
    private  Integer userStatus;//用户状态	0在线 1离线
    private  String sex;//性别 0男 1女
    private  Integer age;//年龄
    private  String userCardId;//身份证号
    private  String headPicture;//头像  默认男女头像
    private  Integer reportCount;	//举报次数

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(String userCardId) {
        this.userCardId = userCardId;
    }

    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }

    public Integer getReportCount() {
        return reportCount;
    }

    public void setReportCount(Integer reportCount) {
        this.reportCount = reportCount;
    }


    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", accountStatus=" + accountStatus +
                ", userStatus=" + userStatus +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", userCardId='" + userCardId + '\'' +
                ", headPicture='" + headPicture + '\'' +
                ", reportCount=" + reportCount +
                '}';
    }
}
