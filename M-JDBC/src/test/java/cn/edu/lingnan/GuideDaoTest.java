package cn.edu.lingnan;

import cn.edu.lingnan.dao.GuideDao;
import cn.edu.lingnan.dao.GuideDaoMysqlImpl;
import cn.edu.lingnan.pojo.Guide;
import org.junit.Test;

public class GuideDaoTest {
    GuideDao guideDao = new GuideDaoMysqlImpl();

    @Test
    public void findGuideByNameAndPasswordTest() {
        System.out.println(guideDao.findGuideByNameAndPassword("admin", "admin"));
    }

    @Test
    public void findGuideByNameTest() {
        for (Guide guide : guideDao.findGuideByName("admin1")) {
            System.out.println(guide.toString());
        }
    }

    @Test
    public void findStudentByIdTest() {
        System.out.println(guideDao.findGuideById("g00"));
    }

    @Test
    public void findAllGuideTest() {
        for (Guide guide : guideDao.findAllGuide()) {
            System.out.println(guide.toString());
        }
    }

    @Test
    public void insertGuideTest() {
        Guide guide = new Guide();
        guide.setGuideId("g24");
        guide.setGuideName("admin23");
        guide.setPassword("nnn");
        guide.setSuperuser(1);
        guide.setFlag(0);
        if (guideDao.insertGuide(guide) == 1) {
            System.out.println("新增成功！");
        }
    }

    @Test
    public void updateGuideTest() {
        Guide guide = new Guide();
        guide.setGuideId("g16");
        guide.setGuideName("admin23");
        guide.setPassword("admin");
        guide.setSuperuser(1);
        guide.setFlag(0);
        int i = guideDao.updateGuide(guide);
        switch(i){
            case -1:
            System.out.println("【温馨提示】：未找到该用户");
            break;
            case 0:
            System.out.println("【温馨提示】:您输入的用户名已被其他用户使用！");
            break;
            default:
            System.out.println("【温馨提示】：修改成功！");
            break;
        }
    }

    @Test
    public void deleteStudentTest() {
        System.out.println(guideDao.deleteGuideByGid("g05"));
    }
}