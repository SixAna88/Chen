package cn.edu.lingnan.service;

import cn.edu.lingnan.dao.*;
import cn.edu.lingnan.pojo.Path;
import cn.edu.lingnan.pojo.Price;

import java.util.List;
import java.util.Vector;

public class PriceServiceMysqlImpl implements PriceService {

    PriceDao priceDao = new PriceDaoMysqlImpl();


    public Vector<Price> queryAllPrice() {
        return priceDao.queryAllPrice();
    }

    public List<Price> selectPriceByGid(String guideId) {
        return priceDao.selectPriceByGid(guideId);
    }

    public List<Price> selectPriceByPid(String pathId) {
        return priceDao.selectPriceByPid(pathId);
    }

    public int selectPriceNumberByPid(String pathId) {
        return priceDao.selectPriceNumberByPid(pathId);
    }

    public boolean deletePriceByGid(String guideId) {
        return priceDao.deletePriceByGid(guideId);
    }

    public boolean deletePriceByPid(String pathId) {
        return priceDao.deletePriceByPid(pathId);
    }

    public boolean deletePriceByGidAndPid(String guideId, String pathId) {
        return priceDao.deletePriceByGidAndPid(guideId, pathId);
    }

    public int updatePrice(Price price) {
        return priceDao.updatePrice(price);
    }

    public int insertPrice(Price price) {
        return priceDao.insertPrice(price);
    }
}
