package com.lolineet.standard.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 
 * </p>
 *
 * @author YUKI.N
 * @since 2023-01-09
 */
@Data
@ApiModel(value = "Video对象", description = "")
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("视频名称")
    private String name;

    @ApiModelProperty("播放地址")
    private String url;

    @ApiModelProperty("视频封面")
    private String imageUrl;

    @TableField(exist = false)
    @ApiModelProperty("文件")
    private MultipartFile file;

    @ApiModelProperty("桶名称")
    private String bucketName;


    @ApiModelProperty("分区id")
    private Long districtId;

}
