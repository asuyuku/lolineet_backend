package com.lolineet.standard.service;

import com.lolineet.standard.entity.Video;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YUKI.N
 * @since 2023-01-09
 */
public interface IVideoService extends IService<Video> {

    Video uploadVideo(MultipartFile file);

    void bindVideoAnime(Long videoId, Long animeId);
}
