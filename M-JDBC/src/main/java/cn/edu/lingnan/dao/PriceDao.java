package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Path;
import cn.edu.lingnan.pojo.Price;

import java.util.List;
import java.util.Vector;

public interface PriceDao {

    //查询操作
    /*遍历所有的价格记录*/
    Vector<Price> queryAllPrice();

    /*查询指定导游编号的价格记录*/
    List<Price> selectPriceByGid(String guideId);

    /*查询指定路线编号的价格记录*/
    List<Price> selectPriceByPid(String pathId);

    /*根据指定路线编号，查找价格表中的记录数量*/
    int selectPriceNumberByPid(String pathId);

    //删除操作
    /*根据导游编号，删除价格表中的指定记录*/
    boolean deletePriceByGid(String guideId);

    /*根据路线编号，删除价格表中的指定记录*/
    boolean deletePriceByPid(String pathId);

    /*根据导游编号和路线编号，删除价格表中的指定记录*/
    boolean deletePriceByGidAndPid(String guideId,String pathId);

    //更新操作
    /*修改价格*/
    int updatePrice(Price price);

    //新增操作
    /*添加价格信息*/
    int insertPrice(Price price);
}
