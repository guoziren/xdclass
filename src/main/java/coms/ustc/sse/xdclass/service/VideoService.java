package coms.ustc.sse.xdclass.service;

import coms.ustc.sse.xdclass.model.entity.Video;
import coms.ustc.sse.xdclass.model.entity.VideoBanner;

import java.util.List;

public interface VideoService {

    List<Video> listVideo();

    List<VideoBanner> listBanner();

    Video findDetailById(int videoId);
}
