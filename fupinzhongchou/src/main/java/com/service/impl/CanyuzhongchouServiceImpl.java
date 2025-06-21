package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.CanyuzhongchouDao;
import com.entity.CanyuzhongchouEntity;
import com.entity.view.CanyuzhongchouView;
import com.service.CanyuzhongchouService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 参与的众筹 服务实现类
 */
@Service("canyuzhongchouService")
@Transactional
public class CanyuzhongchouServiceImpl extends ServiceImpl<CanyuzhongchouDao, CanyuzhongchouEntity> implements CanyuzhongchouService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<CanyuzhongchouView> page =new Query<CanyuzhongchouView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
