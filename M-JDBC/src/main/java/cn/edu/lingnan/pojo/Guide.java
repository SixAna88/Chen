package cn.edu.lingnan.pojo;

public class Guide {
    private String guideId ;
    private String guideName;
    private String password ;
    private Integer superuser;
    private Integer flag;

    public Guide() {
    }

    public Guide(String guideId, String password) {
        this.guideId = guideId;
        this.password = password;
    }

    public String getGuideId() {
        return guideId;
    }

    public void setGuideId(String guideId) {
        this.guideId = guideId;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSuperuser() {
        return superuser;
    }

    public void setSuperuser(Integer superuser) {
        this.superuser = superuser;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Guide{" +
                "guideId='" + guideId + '\'' +
                ", guideName='" + guideName + '\'' +
                ", password='" + password + '\'' +
                ", superuser=" + superuser +
                ", flag=" + flag +
                '}';
    }
}
