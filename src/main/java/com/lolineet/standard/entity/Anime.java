package com.lolineet.standard.entity;

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
@ApiModel(value = "Anime对象", description = "")
public class Anime implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("番剧名称")
    private String name;

    @ApiModelProperty("图片链接")
    private String pictureUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "Anime{" +
            "id = " + id +
            ", name = " + name +
            ", pictureUrl = " + pictureUrl +
        "}";
    }
}
