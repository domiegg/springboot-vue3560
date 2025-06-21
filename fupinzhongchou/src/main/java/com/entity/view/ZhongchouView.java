package com.entity.view;

import com.entity.ZhongchouEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 众筹
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zhongchou")
public class ZhongchouView extends ZhongchouEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 众筹类型的值
		*/
		private String zhongchouValue;
		/**
		* 众筹状态的值
		*/
		private String zhongchouZhuangtaiValue;
		/**
		* 快递状态的值
		*/
		private String zhongchouKuaidiValue;



		//级联表 wuzi
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
				* 物资类型的值
				*/
				private String wuziValue;
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
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer wuziDelete;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;

	public ZhongchouView() {

	}

	public ZhongchouView(ZhongchouEntity zhongchouEntity) {
		try {
			BeanUtils.copyProperties(this, zhongchouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 众筹类型的值
			*/
			public String getZhongchouValue() {
				return zhongchouValue;
			}
			/**
			* 设置： 众筹类型的值
			*/
			public void setZhongchouValue(String zhongchouValue) {
				this.zhongchouValue = zhongchouValue;
			}
			/**
			* 获取： 众筹状态的值
			*/
			public String getZhongchouZhuangtaiValue() {
				return zhongchouZhuangtaiValue;
			}
			/**
			* 设置： 众筹状态的值
			*/
			public void setZhongchouZhuangtaiValue(String zhongchouZhuangtaiValue) {
				this.zhongchouZhuangtaiValue = zhongchouZhuangtaiValue;
			}
			/**
			* 获取： 快递状态的值
			*/
			public String getZhongchouKuaidiValue() {
				return zhongchouKuaidiValue;
			}
			/**
			* 设置： 快递状态的值
			*/
			public void setZhongchouKuaidiValue(String zhongchouKuaidiValue) {
				this.zhongchouKuaidiValue = zhongchouKuaidiValue;
			}








				//级联表的get和set wuzi

					/**
					* 获取： 物资编号
					*/
					public String getwuziUuidNumber() {
						return wuziUuidNumber;
					}
					/**
					* 设置： 物资编号
					*/
					public void setwuziUuidNumber(String wuziUuidNumber) {
						this.wuziUuidNumber = wuziUuidNumber;
					}

					/**
					* 获取： 物资名称
					*/
					public String getwuziName() {
						return wuziName;
					}
					/**
					* 设置： 物资名称
					*/
					public void setwuziName(String wuziName) {
						this.wuziName = wuziName;
					}

					/**
					* 获取： 物资照片
					*/
					public String getwuziPhoto() {
						return wuziPhoto;
					}
					/**
					* 设置： 物资照片
					*/
					public void setwuziPhoto(String wuziPhoto) {
						this.wuziPhoto = wuziPhoto;
					}

					/**
					* 获取： 物资类型
					*/
					public Integer getwuziTypes() {
						return wuziTypes;
					}
					/**
					* 设置： 物资类型
					*/
					public void setwuziTypes(Integer wuziTypes) {
						this.wuziTypes = wuziTypes;
					}


						/**
						* 获取： 物资类型的值
						*/
						public String getwuziValue() {
							return wuziValue;
						}
						/**
						* 设置： 物资类型的值
						*/
						public void setwuziValue(String wuziValue) {
							this.wuziValue = wuziValue;
						}

					/**
					* 获取： 物资原价
					*/
					public Double getwuziOldMoney() {
						return wuziOldMoney;
					}
					/**
					* 设置： 物资原价
					*/
					public void setwuziOldMoney(Double wuziOldMoney) {
						this.wuziOldMoney = wuziOldMoney;
					}

					/**
					* 获取： 现价
					*/
					public Double getwuziNewMoney() {
						return wuziNewMoney;
					}
					/**
					* 设置： 现价
					*/
					public void setwuziNewMoney(Double wuziNewMoney) {
						this.wuziNewMoney = wuziNewMoney;
					}

					/**
					* 获取： 物资介绍
					*/
					public String getwuziContent() {
						return wuziContent;
					}
					/**
					* 设置： 物资介绍
					*/
					public void setwuziContent(String wuziContent) {
						this.wuziContent = wuziContent;
					}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getwuziDelete() {
						return wuziDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setwuziDelete(Integer wuziDelete) {
						this.wuziDelete = wuziDelete;
					}








				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}













}
