package cn.edu.lingnan;

import cn.edu.lingnan.dao.PathDao;
import cn.edu.lingnan.dao.PathDaoMysqlImlp;
import cn.edu.lingnan.pojo.Path;
import org.junit.Test;

public class PathDaoTest {

    PathDao pathDao = new PathDaoMysqlImlp();

    @Test
    public void selectPathByPid(){
        System.out.println(pathDao.selectPathByPid("p00"));
    }

    @Test
    public void queryAllPathTest(){
        System.out.println(pathDao.queryAllPath());
    }

    @Test
    public void deletePathByPid(){
        System.out.println(pathDao.deletePathByPid("p02"));
    }

    @Test
    public void updatePath(){
        Path path = new Path();
        path.setPathId("p00");
        path.setPathName("route1");
        path.setFlag(1);
        if(pathDao.updatePath(path)==1){
            System.out.println("修改成功！");
        }else
            System.out.println(path.getPathId() + "路线修改失败！");
    }


    @Test
    public void insertPath(){
        Path path = new Path();
        path.setPathId("p05");
        path.setPathName("route5");
        path.setFlag(0);
        pathDao.insertPath(path);
    }
}
