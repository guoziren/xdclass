package coms.ustc.sse.xdclass.controller;

import coms.ustc.sse.xdclass.domain.Video;
import coms.ustc.sse.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService mVideoService;

    @RequestMapping("/list")
    public List<Video> listVideo(){
        return mVideoService.listVideo();
    }
}
