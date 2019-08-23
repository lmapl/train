package com.train.domain.entity;

import java.util.Date;

public class Collect {
    /**
     * id
     */
    private Integer id;

    /**
     * 发布人d
     */
    private Integer userId;

    /**
     * type	收藏类型			1 学生对教师收藏 2 机构对教师收藏 3学生对机构收藏 4 教师对机构收藏 5 对动态收藏 6 对课程收藏
     */
    private Integer type;

    /**
     * 收藏的内容id	String	是	用户id、机构id，教师id，动态id，课程id等
     */
    private String collectid;

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
     * type	收藏类型			1 学生对教师收藏 2 机构对教师收藏 3学生对机构收藏 4 教师对机构收藏 5 对动态收藏 6 对课程收藏
     * @return type type	收藏类型			1 学生对教师收藏 2 机构对教师收藏 3学生对机构收藏 4 教师对机构收藏 5 对动态收藏 6 对课程收藏
     */
    public Integer getType() {
        return type;
    }

    /**
     * type	收藏类型			1 学生对教师收藏 2 机构对教师收藏 3学生对机构收藏 4 教师对机构收藏 5 对动态收藏 6 对课程收藏
     * @param type type	收藏类型			1 学生对教师收藏 2 机构对教师收藏 3学生对机构收藏 4 教师对机构收藏 5 对动态收藏 6 对课程收藏
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 收藏的内容id	String	是	用户id、机构id，教师id，动态id，课程id等
     * @return collectId 收藏的内容id	String	是	用户id、机构id，教师id，动态id，课程id等
     */
    public String getCollectid() {
        return collectid;
    }

    /**
     * 收藏的内容id	String	是	用户id、机构id，教师id，动态id，课程id等
     * @param collectid 收藏的内容id	String	是	用户id、机构id，教师id，动态id，课程id等
     */
    public void setCollectid(String collectid) {
        this.collectid = collectid == null ? null : collectid.trim();
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
        sb.append(", collectid=").append(collectid);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}