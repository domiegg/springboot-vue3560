package com.dao;

import com.entity.wuziEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.wuziView;

/**
 * 物资 Dao 接口
 *
 * @author 
 */
public interface wuziDao extends BaseMapper<wuziEntity> {

   List<wuziView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
