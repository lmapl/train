package com.train.web.dao;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/15 19:27
 * Description: ${DESCRIPTION}
 */
public class DynamicEventDao {

    private Integer id;//id
    private String  nickName;//	昵称	用户昵称/机构名称/教师名称
    private  String portrait;//	头像	 用户头像、机构头像，教师头像


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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
}
