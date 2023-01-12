package com.lolineet.standard.controller;

import com.lolineet.standard.base.Cloud;
import com.lolineet.standard.base.Result;
import com.lolineet.standard.entity.Anime;
import com.lolineet.standard.service.IAnimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YUKI.N
 * @since 2023-01-09
 */
@Api(tags = "番剧接口")
@RestController
@RequestMapping("/standard/anime")
public class AnimeController {

    @Autowired
    private IAnimeService animeService;

    @ApiOperation("获取番剧列表")
    @GetMapping("/list")
    public Result<List<Anime>> list(){
        List<Anime> animeList = animeService.list();
        return Result.ok(animeList);
    }

    @ApiOperation("新增番剧")
    @PostMapping("/addAnime")
    public Result addAnime(Anime anime){
        anime.setId(Cloud.id.next());
        animeService.save(anime);
        return Result.ok();
    }
}
