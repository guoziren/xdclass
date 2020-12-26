package coms.ustc.sse.xdclass.controller;

import coms.ustc.sse.xdclass.model.request.VideoOrderRequest;
import coms.ustc.sse.xdclass.service.VideoOrderService;
import coms.ustc.sse.xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 视频订单
 */
@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {

    @Autowired
    private VideoOrderService videoOrderService;
    /**
     * 下单接口
     * @return
     */
    @RequestMapping("/save")
    public JsonData saveOrder(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute(UserController.USER_ID);
        int rows = videoOrderService.save(userId, videoOrderRequest.getVideoId());
        if (rows == 0) {
            return JsonData.buildError("下单失败");
        } else {
            return JsonData.bulidSuccess("下单成功");
        }
    }
}
