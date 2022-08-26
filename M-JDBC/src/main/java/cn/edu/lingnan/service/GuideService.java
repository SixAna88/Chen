package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.Guide;

import java.util.List;
import java.util.Vector;

public interface GuideService {
    //查询操作
    Vector<Guide> findAllGuide();

    Guide findGuideByNameAndPassword(String guideName, String guidePassword);

    Vector<Guide> findGuideByName(String guideName);

    Guide findGuideById(String guideId);

    //新增操作
    int insertGuide(Guide guide);

    //删除操作
    boolean deleteGuide(String guideId);

    //修改操作
    int updateGuide(Guide guide);

    //修改密码
    boolean updateGuidePassword(String guide, String oldPassword, String newPassword);


}
