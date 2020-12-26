package coms.ustc.sse.xdclass.service;

import coms.ustc.sse.xdclass.mapper.VideoMapper;
import coms.ustc.sse.xdclass.mapper.VideoOrderMapper;
import coms.ustc.sse.xdclass.model.entity.Video;
import coms.ustc.sse.xdclass.model.entity.VideoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {
    @Autowired
    private VideoOrderMapper videoOrderMapper;
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public int save(int userId, int videoId) {
        // 判断是否已经购买
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId, videoId, 1);
        if (videoOrder != null) {
            return 0;
        }
        // 没有购买 查出视频信息
        Video video = videoMapper.findById(videoId);
        // 构造订单信息
        VideoOrder newVideoOrder = new VideoOrder();
        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setState(1);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setVideoTitle(video.getTitle());
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        return videoOrderMapper.saveOrder(newVideoOrder);
    }
}
