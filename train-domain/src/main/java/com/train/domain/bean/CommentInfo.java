package com.train.domain.bean;

import java.util.Date;

public class CommentInfo {
    /**
     * id
     */
    private Integer id;

    /**
     * 发布人d
     */
    private Integer userId;

    /**
     * 类型			1 学生对教师评论 2 机构对教师评论 3学生对机构评论 4 教师对机构评论 5 对动态评论 6 对课程评论
     */
    private Integer type;

    /**
     * 被评论的内容id 用户id、机构id，教师id，动态id，课程id等
     */
    private String contentid;

    /**
     * 文案内容
     */
    private String content;

    /**
     * 默认有效 无效后不展示，例如敏感词汇被禁止后改为无效
     */
    private Integer valid;

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
     * @return user_Id 发布人d
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 发布人d
     * @param userId 发布人d
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 类型			1 学生对教师评论 2 机构对教师评论 3学生对机构评论 4 教师对机构评论 5 对动态评论 6 对课程评论
     * @return type 类型			1 学生对教师评论 2 机构对教师评论 3学生对机构评论 4 教师对机构评论 5 对动态评论 6 对课程评论
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型			1 学生对教师评论 2 机构对教师评论 3学生对机构评论 4 教师对机构评论 5 对动态评论 6 对课程评论
     * @param type 类型			1 学生对教师评论 2 机构对教师评论 3学生对机构评论 4 教师对机构评论 5 对动态评论 6 对课程评论
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 被评论的内容id 用户id、机构id，教师id，动态id，课程id等
     * @return contentId 被评论的内容id 用户id、机构id，教师id，动态id，课程id等
     */
    public String getContentid() {
        return contentid;
    }

    /**
     * 被评论的内容id 用户id、机构id，教师id，动态id，课程id等
     * @param contentid 被评论的内容id 用户id、机构id，教师id，动态id，课程id等
     */
    public void setContentid(String contentid) {
        this.contentid = contentid == null ? null : contentid.trim();
    }

    /**
     * 文案内容
     * @return content 文案内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 文案内容
     * @param content 文案内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 默认有效 无效后不展示，例如敏感词汇被禁止后改为无效
     * @return valid 默认有效 无效后不展示，例如敏感词汇被禁止后改为无效
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * 默认有效 无效后不展示，例如敏感词汇被禁止后改为无效
     * @param valid 默认有效 无效后不展示，例如敏感词汇被禁止后改为无效
     */
    public void setValid(Integer valid) {
        this.valid = valid;
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
        sb.append(", userId=").append(userId);
        sb.append(", type=").append(type);
        sb.append(", contentid=").append(contentid);
        sb.append(", content=").append(content);
        sb.append(", valid=").append(valid);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}