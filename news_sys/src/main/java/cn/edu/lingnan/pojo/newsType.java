package cn.edu.lingnan.pojo;

import java.sql.Date;

public class newsType {
    private int    typeId;
    private String typeName;
    private Date   createDate;

    public newsType() {
    }

    @Override
    public String toString() {
        return "newsType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
