package coms.ustc.sse.xdclass.mapper;

import coms.ustc.sse.xdclass.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;

public interface VideoOrderMapper {

    /**
     * 查询用户是否购买过此商品
     * @return
     */
    VideoOrder findByUserIdAndVideoIdAndState(@Param("user_id") int userId,@Param("video_id") int videoId,@Param("state") int state);

    /**
     * 下单
     */
    int saveOrder(VideoOrder videoOrder);
}
