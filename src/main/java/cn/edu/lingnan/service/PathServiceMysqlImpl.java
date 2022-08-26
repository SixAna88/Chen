package cn.edu.lingnan.service;


import cn.edu.lingnan.dao.*;
import cn.edu.lingnan.pojo.Path;
import cn.edu.lingnan.pojo.Price;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class PathServiceMysqlImpl implements PathService {

    PathDao  pathDao = new PathDaoMysqlImlp();
    PriceDao priceDao = new PriceDaoMysqlImpl();

    public Vector<Path> queryAllPath() {
        return pathDao.queryAllPath();
    }

    public Path selectPathByPid(String pathId) {
        return pathDao.selectPathByPid(pathId);
    }


    public int updatePath(Path path) {
        return pathDao.updatePath(path);
    }

    public int insertPath(Path path) {
        return pathDao.insertPath(path);
    }



    public boolean deletePathByPid(String pathId) {

        //根据导游编号，删除价格记录【处理价格表】
        if(priceDao.deletePriceByPid(pathId)){
            System.out.println("【Debug】价格表处理完成！");
        }
        //根据导游编号，删除导游记录【处理导游表】
        return pathDao.deletePathByPid(pathId);
    }

}
