package com.train.domain.entity;

import java.util.Date;

public class AddrArea {
    /**
     * 
     */
    private Integer id;

    /**
     * 层级划分： 1地区 2 省份；3市 ；4县区；
     */
    private Integer type;

    /**
     * 
     */
    private String addrName;

    /**
     * 
     */
    private Integer fatherId;

    /**
     * 0 无效 1 有效 
     */
    private Integer isEnable;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Integer sort;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 层级划分： 1地区 2 省份；3市 ；4县区；
     * @return type 层级划分： 1地区 2 省份；3市 ；4县区；
     */
    public Integer getType() {
        return type;
    }

    /**
     * 层级划分： 1地区 2 省份；3市 ；4县区；
     * @param type 层级划分： 1地区 2 省份；3市 ；4县区；
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 
     * @return addr_name 
     */
    public String getAddrName() {
        return addrName;
    }

    /**
     * 
     * @param addrName 
     */
    public void setAddrName(String addrName) {
        this.addrName = addrName == null ? null : addrName.trim();
    }

    /**
     * 
     * @return father_id 
     */
    public Integer getFatherId() {
        return fatherId;
    }

    /**
     * 
     * @param fatherId 
     */
    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    /**
     * 0 无效 1 有效 
     * @return is_enable 0 无效 1 有效 
     */
    public Integer getIsEnable() {
        return isEnable;
    }

    /**
     * 0 无效 1 有效 
     * @param isEnable 0 无效 1 有效 
     */
    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 
     * @return create_time 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return sort 
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 
     * @param sort 
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
        sb.append(", type=").append(type);
        sb.append(", addrName=").append(addrName);
        sb.append(", fatherId=").append(fatherId);
        sb.append(", isEnable=").append(isEnable);
        sb.append(", createTime=").append(createTime);
        sb.append(", sort=").append(sort);
        sb.append("]");
        return sb.toString();
    }
}