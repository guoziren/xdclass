package coms.ustc.sse.xdclass.service;

import coms.ustc.sse.xdclass.model.entity.Video;
import coms.ustc.sse.xdclass.model.entity.VideoBanner;
import coms.ustc.sse.xdclass.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper mVideoMapper;
    @Override
    public List<Video> listVideo() {
        return mVideoMapper.listVideo();
    }

    @Override
    public List<VideoBanner> listBanner() {
        return mVideoMapper.listBanners();
    }

    @Override
    public Video findDetailById(int videoId) {
        // TODO 需要使用Mybatis 关联复杂查询
        return mVideoMapper.findDetailById(videoId);
    }
}
