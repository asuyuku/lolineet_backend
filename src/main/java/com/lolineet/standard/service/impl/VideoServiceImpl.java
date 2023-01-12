package com.lolineet.standard.service.impl;

import com.lolineet.standard.base.Cloud;
import com.lolineet.standard.entity.Anime;
import com.lolineet.standard.entity.AnimeVideoMiddle;
import com.lolineet.standard.entity.Video;
import com.lolineet.standard.exception.LolineetException;
import com.lolineet.standard.mapper.AnimeMapper;
import com.lolineet.standard.mapper.AnimeVideoMiddleMapper;
import com.lolineet.standard.mapper.VideoMapper;
import com.lolineet.standard.service.IVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lolineet.standard.util.ExtractVideoFirstFrameUtil;
import com.lolineet.standard.util.MinioUtil;
import io.minio.ObjectWriteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author YUKI.N
 * @since 2023-01-09
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {

    @Autowired
    private MinioUtil minioUtil;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private AnimeMapper animeMapper;

    @Autowired
    private AnimeVideoMiddleMapper animeVideoMiddleMapper;

    @Override
    public String uploadVideo(Long districtId,MultipartFile file) {
        String bucket = "lolineet";
        String url= minioUtil.uploadFileSingle(bucket, file);
        String imageUrl = "";
        try {
            String imageName = ExtractVideoFirstFrameUtil.ffmpegExtractImageForVideoStream(file.getInputStream());
            imageUrl=minioUtil.putObject(bucket,imageName,imageName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Video video = new Video();
        video.setBucketName(bucket);
        video.setId(Cloud.id.next());
        video.setDistrictId(districtId);
        video.setName( file.getOriginalFilename());
        video.setUrl(url);
        video.setImageUrl(imageUrl);
        videoMapper.insert(video);
        return url;
    }

    @Override
    public void bindVideoAnime(Long videoId, Long animeId) {

    }
}
