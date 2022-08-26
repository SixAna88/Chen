package cn.edu.lingnan.pojo;

public class Price {
    private String guideId ;
    private String pathId ;
    private Integer price ;

    public String getGuideId() {
        return guideId;
    }

    public void setGuideId(String guideId) {
        this.guideId = guideId;
    }

    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Price{" +
                "guideId='" + guideId + '\'' +
                ", pathId='" + pathId + '\'' +
                ", price=" + price +
                '}';
    }
}
