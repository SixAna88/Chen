package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.Price;

import java.util.List;
import java.util.Vector;

public class PriceServiceOracleImpl implements PriceService{
    public List<Price> selectPriceByGid(String guideId) {
        return null;
    }

    public List<Price> selectPriceByPid(String pathId) {
        return null;
    }

    public Vector<Price> queryAllPrice() {
        return null;
    }

    public int selectPriceNumberByPid(String pathId) {
        return 0;
    }

    public boolean deletePriceByGid(String guideId) {
        return false;
    }

    public boolean deletePriceByPid(String pathId) {
        return false;
    }

    public boolean deletePriceByGidAndPid(String guideId, String pathId) {
        return false;
    }

    public int updatePrice(Price price) {
        return 0;
    }

    public int insertPrice(Price price) {
        return 0;
    }
}
