package com.entity.model;

import com.entity.wuziEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物资
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class wuziModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 物资编号
     */
    private String wuziUuidNumber;


    /**
     * 物资名称
     */
    private String wuziName;


    /**
     * 物资照片
     */
    private String wuziPhoto;


    /**
     * 物资类型
     */
    private Integer wuziTypes;


    /**
     * 物资原价
     */
    private Double wuziOldMoney;


    /**
     * 现价
     */
    private Double wuziNewMoney;


    /**
     * 物资介绍
     */
    private String wuziContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer wuziDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：物资编号
	 */
    public String getwuziUuidNumber() {
        return wuziUuidNumber;
    }


    /**
	 * 设置：物资编号
	 */
    public void setwuziUuidNumber(String wuziUuidNumber) {
        this.wuziUuidNumber = wuziUuidNumber;
    }
    /**
	 * 获取：物资名称
	 */
    public String getwuziName() {
        return wuziName;
    }


    /**
	 * 设置：物资名称
	 */
    public void setwuziName(String wuziName) {
        this.wuziName = wuziName;
    }
    /**
	 * 获取：物资照片
	 */
    public String getwuziPhoto() {
        return wuziPhoto;
    }


    /**
	 * 设置：物资照片
	 */
    public void setwuziPhoto(String wuziPhoto) {
        this.wuziPhoto = wuziPhoto;
    }
    /**
	 * 获取：物资类型
	 */
    public Integer getwuziTypes() {
        return wuziTypes;
    }


    /**
	 * 设置：物资类型
	 */
    public void setwuziTypes(Integer wuziTypes) {
        this.wuziTypes = wuziTypes;
    }
    /**
	 * 获取：物资原价
	 */
    public Double getwuziOldMoney() {
        return wuziOldMoney;
    }


    /**
	 * 设置：物资原价
	 */
    public void setwuziOldMoney(Double wuziOldMoney) {
        this.wuziOldMoney = wuziOldMoney;
    }
    /**
	 * 获取：现价
	 */
    public Double getwuziNewMoney() {
        return wuziNewMoney;
    }


    /**
	 * 设置：现价
	 */
    public void setwuziNewMoney(Double wuziNewMoney) {
        this.wuziNewMoney = wuziNewMoney;
    }
    /**
	 * 获取：物资介绍
	 */
    public String getwuziContent() {
        return wuziContent;
    }


    /**
	 * 设置：物资介绍
	 */
    public void setwuziContent(String wuziContent) {
        this.wuziContent = wuziContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getwuziDelete() {
        return wuziDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setwuziDelete(Integer wuziDelete) {
        this.wuziDelete = wuziDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
