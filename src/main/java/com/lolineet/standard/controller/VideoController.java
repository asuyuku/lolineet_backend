package com.lolineet.standard.controller;

import com.lolineet.standard.base.Result;
import com.lolineet.standard.entity.Video;
import com.lolineet.standard.service.IVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author YUKI.N
 * @since 2023-01-09
 */
@Api(tags = "视频接口")
@RestController
@RequestMapping("/standard/video")
public class VideoController {
    @Autowired
    private IVideoService videoService;

    @ApiOperation("上传视频")
    @PostMapping(name = "/uploadVideo",consumes = "multipart/*",headers = "content-type=multipart/form-data")
    public Result uploadVideo(Long districtId,@ApiParam(name = "file",value = "文件") MultipartFile file) {
        String fileUrl = videoService.uploadVideo(districtId,file);
        return Result.ok("上传成功",fileUrl);
    }

    @ApiOperation("绑定视频和番剧")
    @PostMapping("/bindVideoAnime")
    public Result bindVideoAnime(Long videoId, Long animeId) {
        return null;
    }

    @ApiOperation("获取视频详情")
    @GetMapping("/getVideoDetail")
    public Result<Video> getVideoDetail(Long videoId) {
        Video video = videoService.getById(videoId);
        return Result.ok(video);
    }
}
