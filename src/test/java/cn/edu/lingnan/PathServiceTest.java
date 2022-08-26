package cn.edu.lingnan;

import cn.edu.lingnan.dao.GuideDao;
import cn.edu.lingnan.dao.GuideDaoMysqlImpl;
import cn.edu.lingnan.dao.PathDao;
import cn.edu.lingnan.dao.PathDaoMysqlImlp;
import cn.edu.lingnan.pojo.Path;
import cn.edu.lingnan.service.GuideService;
import cn.edu.lingnan.service.GuideServiceMysqlImpl;
import cn.edu.lingnan.service.PathService;
import cn.edu.lingnan.service.PathServiceMysqlImpl;
import org.junit.Test;

public class PathServiceTest {

    PathService pathService = new PathServiceMysqlImpl();

    @Test
    public void selectPathByPidTest(){
        System.out.println(pathService.selectPathByPid("p00"));
    }

    @Test
    public void updatePath(){
        Path path = new Path();
        path.setPathName("route2");
        path.setFlag(1);
        path.setPathId("p12");
        pathService.updatePath(path);
    }

    @Test
    public void insertPath(){
        Path path = new Path();
        path.setPathId("p12");
        path.setPathName("route12");
        path.setFlag(0);
        System.out.println(pathService.insertPath(path));
    }

    @Test
    public void deletePathByPid(){
        System.out.println(pathService.deletePathByPid("p12"));
    }

    @Test
    public void queryAllTest(){
        pathService.queryAllPath();
    }

}
