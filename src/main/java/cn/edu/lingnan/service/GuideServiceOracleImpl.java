package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.Guide;

import java.util.List;
import java.util.Vector;

public class GuideServiceOracleImpl implements GuideService {
    public Vector<Guide> findAllGuide() {
        return null;
    }

    public Guide findGuideByNameAndPassword(String guideName, String guidePassword) {
        return null;
    }

    public Vector<Guide> findGuideByName(String guideName) {
        return null;
    }

    public Guide findGuideById(String guideId) {
        return null;
    }

    public int insertGuide(Guide guide) {
        return 0;
    }

    public boolean deleteGuide(String guideId) {
        return false;
    }

    public int updateGuide(Guide guide) {
        return 0;
    }

    public boolean updateGuidePassword(String guide, String oldPassword, String newPassword) {
        return false;
    }
}
