package com.lolineet.standard.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author YUKI.N
 * @since 2023-01-09
 */
@TableName("anime_video_middle")
@ApiModel(value = "AnimeVideoMiddle对象", description = "")
public class AnimeVideoMiddle implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("番剧id")
    private Long animeId;

    @ApiModelProperty("视频id")
    private Long videoId;

    @ApiModelProperty("集数(标题)")
    private String episode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAnimeId() {
        return animeId;
    }

    public void setAnimeId(Long animeId) {
        this.animeId = animeId;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    @Override
    public String toString() {
        return "AnimeVideoMiddle{" +
            "id = " + id +
            ", animeId = " + animeId +
            ", videoId = " + videoId +
            ", episode = " + episode +
        "}";
    }
}
