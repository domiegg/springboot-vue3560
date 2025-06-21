package com.entity.vo;

import com.entity.wuziEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuzi")
public class wuziVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 物资编号
     */

    @TableField(value = "wuzi_uuid_number")
    private String wuziUuidNumber;


    /**
     * 物资名称
     */

    @TableField(value = "wuzi_name")
    private String wuziName;


    /**
     * 物资照片
     */

    @TableField(value = "wuzi_photo")
    private String wuziPhoto;


    /**
     * 物资类型
     */

    @TableField(value = "wuzi_types")
    private Integer wuziTypes;


    /**
     * 物资原价
     */

    @TableField(value = "wuzi_old_money")
    private Double wuziOldMoney;


    /**
     * 现价
     */

    @TableField(value = "wuzi_new_money")
    private Double wuziNewMoney;


    /**
     * 物资介绍
     */

    @TableField(value = "wuzi_content")
    private String wuziContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "wuzi_delete")
    private Integer wuziDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：物资编号
	 */
    public String getwuziUuidNumber() {
        return wuziUuidNumber;
    }


    /**
	 * 获取：物资编号
	 */

    public void setwuziUuidNumber(String wuziUuidNumber) {
        this.wuziUuidNumber = wuziUuidNumber;
    }
    /**
	 * 设置：物资名称
	 */
    public String getwuziName() {
        return wuziName;
    }


    /**
	 * 获取：物资名称
	 */

    public void setwuziName(String wuziName) {
        this.wuziName = wuziName;
    }
    /**
	 * 设置：物资照片
	 */
    public String getwuziPhoto() {
        return wuziPhoto;
    }


    /**
	 * 获取：物资照片
	 */

    public void setwuziPhoto(String wuziPhoto) {
        this.wuziPhoto = wuziPhoto;
    }
    /**
	 * 设置：物资类型
	 */
    public Integer getwuziTypes() {
        return wuziTypes;
    }


    /**
	 * 获取：物资类型
	 */

    public void setwuziTypes(Integer wuziTypes) {
        this.wuziTypes = wuziTypes;
    }
    /**
	 * 设置：物资原价
	 */
    public Double getwuziOldMoney() {
        return wuziOldMoney;
    }


    /**
	 * 获取：物资原价
	 */

    public void setwuziOldMoney(Double wuziOldMoney) {
        this.wuziOldMoney = wuziOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getwuziNewMoney() {
        return wuziNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setwuziNewMoney(Double wuziNewMoney) {
        this.wuziNewMoney = wuziNewMoney;
    }
    /**
	 * 设置：物资介绍
	 */
    public String getwuziContent() {
        return wuziContent;
    }


    /**
	 * 获取：物资介绍
	 */

    public void setwuziContent(String wuziContent) {
        this.wuziContent = wuziContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getwuziDelete() {
        return wuziDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setwuziDelete(Integer wuziDelete) {
        this.wuziDelete = wuziDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
