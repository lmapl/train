package com.train.domain.entity;

import java.util.Date;

public class DynamicEvent {
    /**
     * id
     */
    private Integer id;

    /**
     * 发布人d
     */
    private Integer userid;

    /**
     * 标题
     */
    private Integer title;

    /**
     * 文案内容
     */
    private Integer content;

    /**
     * 图片地址
     */
    private Integer imgurl;

    /**
     * 视频地址
     */
    private Integer videourl;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * id
     * @return id id
     */
    public Integer getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 发布人d
     * @return userId 发布人d
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 发布人d
     * @param userid 发布人d
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 标题
     * @return title 标题
     */
    public Integer getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(Integer title) {
        this.title = title;
    }

    /**
     * 文案内容
     * @return content 文案内容
     */
    public Integer getContent() {
        return content;
    }

    /**
     * 文案内容
     * @param content 文案内容
     */
    public void setContent(Integer content) {
        this.content = content;
    }

    /**
     * 图片地址
     * @return imgurl 图片地址
     */
    public Integer getImgurl() {
        return imgurl;
    }

    /**
     * 图片地址
     * @param imgurl 图片地址
     */
    public void setImgurl(Integer imgurl) {
        this.imgurl = imgurl;
    }

    /**
     * 视频地址
     * @return videoUrl 视频地址
     */
    public Integer getVideourl() {
        return videourl;
    }

    /**
     * 视频地址
     * @param videourl 视频地址
     */
    public void setVideourl(Integer videourl) {
        this.videourl = videourl;
    }

    /**
     * 创建人
     * @return create_by 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建人
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人
     * @return update_by 修改人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 修改人
     * @param updateBy 修改人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", imgurl=").append(imgurl);
        sb.append(", videourl=").append(videourl);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}