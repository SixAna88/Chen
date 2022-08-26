package cn.edu.lingnan.pojo;

import java.sql.Date;

public class newsComment {
    private Integer comId;
    private Integer newsId;
    private Integer userId;
    private String commContent;
    private Date createDate;


    public newsComment() {
    }

    public newsComment(Integer comId, Integer newsId, Integer userId, String commContent, Date createDate) {
        this.comId = comId;
        this.newsId = newsId;
        this.userId = userId;
        this.commContent = commContent;
        this.createDate = createDate;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommContent() {
        return commContent;
    }

    public void setCommContent(String commContent) {
        this.commContent = commContent;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "newsComment{" +
                "comId=" + comId +
                ", newsId=" + newsId +
                ", userId=" + userId +
                ", commContent='" + commContent + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}