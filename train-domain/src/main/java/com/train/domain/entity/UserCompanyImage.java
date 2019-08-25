package com.train.domain.entity;

import java.util.Date;

public class UserCompanyImage {
    /**
     * id，自增主键
     */
    private Integer id;

    /**
     * 机构id
     */
    private Integer userCompanyId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * 高度
     */
    private Integer high;

    /**
     * 宽度
     */
    private Integer witdh;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人，默认系统
     */
    private String createBy;

    /**
     * 最后一次修改时间
     */
    private Date updateTime;

    /**
     * 最后一次修改人
     */
    private String updateBy;

    /**
     * id，自增主键
     * @return id id，自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * id，自增主键
     * @param id id，自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 机构id
     * @return user_company_id 机构id
     */
    public Integer getUserCompanyId() {
        return userCompanyId;
    }

    /**
     * 机构id
     * @param userCompanyId 机构id
     */
    public void setUserCompanyId(Integer userCompanyId) {
        this.userCompanyId = userCompanyId;
    }

    /**
     * 排序
     * @return sort 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 图片地址
     * @return image_url 图片地址
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 图片地址
     * @param imageUrl 图片地址
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * 高度
     * @return high 高度
     */
    public Integer getHigh() {
        return high;
    }

    /**
     * 高度
     * @param high 高度
     */
    public void setHigh(Integer high) {
        this.high = high;
    }

    /**
     * 宽度
     * @return witdh 宽度
     */
    public Integer getWitdh() {
        return witdh;
    }

    /**
     * 宽度
     * @param witdh 宽度
     */
    public void setWitdh(Integer witdh) {
        this.witdh = witdh;
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
     * 创建人，默认系统
     * @return create_by 创建人，默认系统
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建人，默认系统
     * @param createBy 创建人，默认系统
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 最后一次修改时间
     * @return update_time 最后一次修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 最后一次修改时间
     * @param updateTime 最后一次修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 最后一次修改人
     * @return update_by 最后一次修改人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 最后一次修改人
     * @param updateBy 最后一次修改人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
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
        sb.append(", userCompanyId=").append(userCompanyId);
        sb.append(", sort=").append(sort);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", high=").append(high);
        sb.append(", witdh=").append(witdh);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append("]");
        return sb.toString();
    }
}