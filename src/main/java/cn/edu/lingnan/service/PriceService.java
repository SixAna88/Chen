package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.Price;

import java.util.List;
import java.util.Vector;

public interface PriceService {

    //查询操作
    Vector<Price> queryAllPrice();

    List<Price> selectPriceByGid(String guideId);

    List<Price> selectPriceByPid(String pathId);

    //根据路径编号查询价格记录
    int selectPriceNumberByPid(String pathId);

    //删除操作
    boolean deletePriceByGid(String guideId);

    boolean deletePriceByPid(String pathId);

    //删除操作
    boolean deletePriceByGidAndPid(String guideId,String pathId);

    //更新操作
    int updatePrice(Price price);

    //新增操作
    int insertPrice(Price price);

}
