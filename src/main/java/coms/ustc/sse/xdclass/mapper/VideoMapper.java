package coms.ustc.sse.xdclass.mapper;

import coms.ustc.sse.xdclass.model.entity.Video;
import coms.ustc.sse.xdclass.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper {
    /**
     * 视频列表
     * @return
     */
    List<Video> listVideo();

    /**
     * 轮播图列表
     * @return
     */
    List<VideoBanner> listBanners();

    /**
     * 查询视频详情信息，包含有章 集信息
     * @param videoId
     * @return
     */
    Video findDetailById(@Param("video_id") int videoId);

    /**
     * 简单查询
     * @param videoId
     * @return
     */
    Video findById(int videoId);
}
