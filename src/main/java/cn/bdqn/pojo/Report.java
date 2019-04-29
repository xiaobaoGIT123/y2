package cn.bdqn.pojo;

//举报
public class Report {
    private Integer rid;
    private Integer reportUser;//举报人
    private Integer reportByWho;//被举报人
    private String reportType;	//举报内容
    private Integer messageId;//举报的信息

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getReportUser() {
        return reportUser;
    }

    public void setReportUser(Integer reportUser) {
        this.reportUser = reportUser;
    }

    public Integer getReportByWho() {
        return reportByWho;
    }

    public void setReportByWho(Integer reportByWho) {
        this.reportByWho = reportByWho;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }
}
