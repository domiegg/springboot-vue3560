package com.dao;

import com.entity.wuziCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.wuziCollectionView;

/**
 * 物资收藏 Dao 接口
 *
 * @author 
 */
public interface wuziCollectionDao extends BaseMapper<wuziCollectionEntity> {

   List<wuziCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
