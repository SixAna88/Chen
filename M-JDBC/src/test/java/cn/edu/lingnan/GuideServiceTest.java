package cn.edu.lingnan;

import cn.edu.lingnan.pojo.Guide;
import cn.edu.lingnan.service.GuideService;
import cn.edu.lingnan.service.GuideServiceMysqlImpl;
import org.junit.Test;

public class GuideServiceTest {

    GuideService guideService = new GuideServiceMysqlImpl();

    @Test
    public void findGuideByNameAndPasswordTest(){
        System.out.println(guideService.findGuideByNameAndPassword("admin","admin"));
    }

    @Test
    public void findGuideByNameTest() {
        for (Guide guide : guideService.findGuideByName("admin")) {
            System.out.println(guide.toString());
        }
    }

    @Test
    public void findGuideByIdTest(){
        System.out.println(guideService.findGuideById("g00"));

    }

    @Test
    public void findAllGuideTest(){
        for (Guide guide : guideService.findAllGuide()) {
            System.out.println(guide.toString());
        }
    }


    @Test
    public void insertGuideTest(){
        Guide guide = new Guide();
        guide.setGuideId("g24");
        guide.setGuideName("admin");
        guide.setPassword("nnn");
        guide.setSuperuser(1);
        guide.setFlag(0);
        if(guideService.insertGuide(guide)==1){
            System.out.println("新增成功！");
        }
    }

    @Test
    public void updateGuideTest(){
        Guide guide = new Guide();
        guide.setGuideId("g05");
        guide.setGuideName("admin");
        guide.setPassword("admin");
        guide.setSuperuser(1);
        guide.setFlag(0);
        System.out.println(guideService.updateGuide(guide));
    }

    @Test
    public void updateGuidePasswordTest(){
        System.out.println(guideService.updateGuidePassword("admin1", "456", "111"));
    }

    @Test
    public void deleteGuideByGidTest(){
        guideService.deleteGuide("g03");
    }

}

