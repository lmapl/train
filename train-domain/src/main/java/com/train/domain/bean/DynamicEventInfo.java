package com.train.domain.bean;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/15 19:27
 * Description: ${DESCRIPTION}
 */
public class DynamicEventInfo {

    /**
     * 标题
     */
    private String title;

    /**
     * 文案内容
     */
    private String content;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 视频地址
     */
    private String videoUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
