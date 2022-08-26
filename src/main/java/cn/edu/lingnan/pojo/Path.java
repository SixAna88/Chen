package cn.edu.lingnan.pojo;

public class Path {
    private String pathId;
    private String pathName;
    private Integer flag;

    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Path = {" +
                "pathId='" + pathId + '\'' +
                ", pathName='" + pathName + '\'' +
                ", flag=" + flag +
                '}';
    }
}
