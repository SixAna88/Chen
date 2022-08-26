package cn.edu.lingnan.pojo;

import java.sql.Date;

public class newInfo {
    private String newsId;
    private  String newsTitle;
    private  String newsContent;
    private  int    typeId;
    private  Date   newsPublish;
    private  String newsSource;
    private  String remark;

    public newInfo() {
    }

    @Override
    public String toString() {
        return "newInfo{" +
                "newsId='" + newsId + '\'' +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\'' +
                ", typeId=" + typeId +
                ", newsPublish=" + newsPublish +
                ", newsSource='" + newsSource + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Date getNewsPublish() {
        return newsPublish;
    }

    public void setNewsPublish(Date newsPublish) {
        this.newsPublish = newsPublish;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
