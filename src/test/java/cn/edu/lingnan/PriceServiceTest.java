package cn.edu.lingnan;

import cn.edu.lingnan.pojo.Guide;
import cn.edu.lingnan.pojo.Price;
import cn.edu.lingnan.service.PathService;
import cn.edu.lingnan.service.PathServiceMysqlImpl;
import cn.edu.lingnan.service.PriceService;
import cn.edu.lingnan.service.PriceServiceMysqlImpl;
import org.junit.Test;

public class PriceServiceTest {

    PriceService priceService = new PriceServiceMysqlImpl();


    @Test
    public void queryAllPriceTest(){
        for (Price price : priceService.queryAllPrice()) {
            System.out.println(price.toString());
        }
    }

    @Test
    public void updatePriceTest(){
        Price price = new Price();
        price.setGuideId("g11");
        price.setPathId("p03");
        price.setPrice(4000);
        System.out.println(priceService.updatePrice(price));
    }


}
