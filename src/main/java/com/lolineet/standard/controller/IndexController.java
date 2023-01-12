package com.lolineet.standard.controller;

import com.lolineet.standard.base.Result;
import com.lolineet.standard.entity.District;
import com.lolineet.standard.entity.Video;
import com.lolineet.standard.service.IDistrictService;
import com.lolineet.standard.service.IVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * IndexController
 *
 * @author YUKI.N
 * @version 1.0
 * @description
 * @date 2023/1/12 16:01
 */

@Api(tags = "首页接口")
@RestController
@RequestMapping("/index")
public class IndexController {

    @Resource
    private IVideoService videoService;
    @Resource
    private IDistrictService districtService;

    @GetMapping("/recommend")
    @ApiOperation("获取推荐视频")
    public Result recommend() {
        //获取全部视频
        List<Video> videoList = videoService.list();
        District district  = new District();
        district.setId(1L);
        district.setName("推荐");
        district.setVideoList(videoList);
        List<District> districtList = new ArrayList<>();
        districtList.add(district);
        return Result.ok(districtList);

    }
}
