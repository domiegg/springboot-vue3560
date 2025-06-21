package com.entity.view;

import com.entity.wuziEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 物资
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("wuzi")
public class wuziView extends wuziEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 物资类型的值
		*/
		private String wuziValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public wuziView() {

	}

	public wuziView(wuziEntity wuziEntity) {
		try {
			BeanUtils.copyProperties(this, wuziEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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











}
