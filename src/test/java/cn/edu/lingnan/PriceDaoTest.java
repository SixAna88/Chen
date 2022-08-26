package cn.edu.lingnan;

import cn.edu.lingnan.dao.PriceDao;
import cn.edu.lingnan.dao.PriceDaoMysqlImpl;
import cn.edu.lingnan.pojo.Guide;
import cn.edu.lingnan.pojo.Path;
import cn.edu.lingnan.pojo.Price;
import org.junit.Test;

public class PriceDaoTest {
    PriceDao priceDao = new PriceDaoMysqlImpl();

    @Test
    public void deletePriceByGid(){
        System.out.println(priceDao.deletePriceByGid("g11"));
    }

    @Test
    public void updatePriceTest(){
        Price price = new Price();
        price.setGuideId("g01");
        price.setPathId("p00");
        price.setPrice(1000);

        if(priceDao.updatePrice(price)==1){
            System.out.println("修改成功！");
        }else
            System.out.println("修改失败！");
    }

    @Test
    public void selectPriceByGid(){
        System.out.println(priceDao.selectPriceByGid("g01"));
    }

    @Test
    public void selectPriceNumberByGid(){
        System.out.println(priceDao.selectPriceNumberByPid("p00"));
    }

    @Test
    public void insertPrice(){
        Price price = new Price();
        price.setGuideId("g11");
        price.setPathId("p00");
        price.setPrice(1000);
        System.out.println(priceDao.insertPrice(price));
    }
}
