package coms.ustc.sse.xdclass.controller;

import coms.ustc.sse.xdclass.model.entity.Video;
import coms.ustc.sse.xdclass.model.entity.VideoBanner;
import coms.ustc.sse.xdclass.service.VideoService;
import coms.ustc.sse.xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService mVideoService;

    /**
     * 视频列表
     * @return
     */
    @RequestMapping("/list")
    public JsonData listVideo(){
        List<Video> videos = mVideoService.listVideo();
        System.out.println("size = " +videos.size());
        return JsonData.bulidSuccess(videos);
    }

    @GetMapping("list_banner")
    public JsonData indexBanner() {
        List<VideoBanner> videoBanners = mVideoService.listBanner();
        int a = 1 / 0;
        return JsonData.bulidSuccess(videoBanners);
    }

    @GetMapping("find_detail_by_id")
    public JsonData findDetailById(@RequestParam(value = "video_id",required = true) int videoId ){
        Video video = mVideoService.findDetailById(videoId);
        return JsonData.bulidSuccess(video);
    }
}
