package coms.ustc.sse.xdclass.service;

import coms.ustc.sse.xdclass.domain.Video;
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
}
