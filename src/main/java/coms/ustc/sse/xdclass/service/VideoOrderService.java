package coms.ustc.sse.xdclass.service;

public interface VideoOrderService {
    /**
     * 下单接口
     * @param userId
     * @param videoId
     * @return
     */
    int save(int userId, int videoId);
}
