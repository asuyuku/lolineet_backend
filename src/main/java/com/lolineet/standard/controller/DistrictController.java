package com.lolineet.standard.controller;

import com.lolineet.standard.base.Result;
import com.lolineet.standard.entity.District;
import com.lolineet.standard.service.IDistrictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.List;

/**
 * DistrictController
 *
 * @author YUKI.N
 * @version 1.0
 * @description
 * @date 2023/1/15 2:02
 */

@Api("视频分区接口")
@RestController
@RequestMapping("/district")
public class DistrictController {
    @Resource
    private IDistrictService districtService;

    @GetMapping("/getDistrictList")
    @ApiOperation("获取全部分区")
    public Result<List<District>> getAllDistrict(){
        return Result.ok(districtService.list());
    }

}
