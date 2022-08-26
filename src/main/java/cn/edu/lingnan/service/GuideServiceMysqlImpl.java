package cn.edu.lingnan.service;

import cn.edu.lingnan.dao.*;
import cn.edu.lingnan.pojo.Guide;
import cn.edu.lingnan.pojo.Path;
import cn.edu.lingnan.pojo.Price;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GuideServiceMysqlImpl implements GuideService {

    GuideDao guideDao =new GuideDaoMysqlImpl();
    PathDao  pathDao = new PathDaoMysqlImlp();
    PriceDao priceDao = new PriceDaoMysqlImpl();

    //查询操作
    public Vector<Guide> findAllGuide() {
        return guideDao.findAllGuide();
    }

    public Guide findGuideByNameAndPassword(String guideName, String guidePassword) {
        return guideDao.findGuideByNameAndPassword(guideName,guidePassword);
    }

    public Vector<Guide> findGuideByName(String guideName) {
        return guideDao.findGuideByName(guideName);
    }

    public Guide findGuideById(String guideId) {
        return guideDao.findGuideById(guideId);
    }

    //新增操作
    public int insertGuide(Guide guide) {
        return guideDao.insertGuide(guide);
    }

    public boolean deleteGuide(String guideId) {

        //第一步，查找价格表中所有的导游记录
        List<Price> list = priceDao.selectPriceByGid(guideId);
        List<String> pids = new ArrayList<String>();

        //要删除导游记录，先删除与之绑定的路线信息
        for (Price price : list){
            System.out.println("[查询到的所有价格信息]："+ price);
            if(priceDao.selectPriceNumberByPid(price.getPathId())> 0){
                System.out.println("[要删除的路径ID]："+ price.getPathId());
                pids.add(price.getPathId());
            }
        }
        //根据导游编号，删除价格记录【处理价格表】
        if( priceDao.deletePriceByGid(guideId)){
            System.out.println("【Debug】价格表处理完成！");
        }
        //根据路线编号，删除路径记录【处理路线表】
        for (String pid : pids) {
            pathDao.deletePathByPid(pid);
        }
        //根据导游编号，删除导游记录【处理导游表】
        return guideDao.deleteGuideByGid(guideId);
    }

    //修改操作
    public int updateGuide(Guide guide) {
        return guideDao.updateGuide(guide);
    }

    //修改导游信息：修改密码（参数: 导游姓名、旧密码、新密码）
    public boolean updateGuidePassword(String guideName, String oldPassword, String newPassword) {
        String gid = guideDao.findGuideByNameAndPassword(guideName, oldPassword).getGuideId();
        if (gid!=null)
            return guideDao.updateGuidePassword(gid, newPassword);
        return false;
    }
}
