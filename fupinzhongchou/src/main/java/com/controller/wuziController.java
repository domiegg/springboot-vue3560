
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 物资
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wuzi")
public class wuziController {
    private static final Logger logger = LoggerFactory.getLogger(wuziController.class);

    @Autowired
    private wuziService wuziService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("wuziDeleteStart",1);params.put("wuziDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = wuziService.queryPage(params);

        //字典表数据转换
        List<wuziView> list =(List<wuziView>)page.getList();
        for(wuziView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        wuziEntity wuzi = wuziService.selectById(id);
        if(wuzi !=null){
            //entity转view
            wuziView view = new wuziView();
            BeanUtils.copyProperties( wuzi , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody wuziEntity wuzi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wuzi:{}",this.getClass().getName(),wuzi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<wuziEntity> queryWrapper = new EntityWrapper<wuziEntity>()
            .eq("wuzi_uuid_number", wuzi.getwuziUuidNumber())
            .eq("wuzi_name", wuzi.getwuziName())
            .eq("wuzi_types", wuzi.getwuziTypes())
            .eq("shangxia_types", wuzi.getShangxiaTypes())
            .eq("wuzi_delete", wuzi.getwuziDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        wuziEntity wuziEntity = wuziService.selectOne(queryWrapper);
        if(wuziEntity==null){
            wuzi.setShangxiaTypes(1);
            wuzi.setwuziDelete(1);
            wuzi.setCreateTime(new Date());
            wuziService.insert(wuzi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody wuziEntity wuzi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,wuzi:{}",this.getClass().getName(),wuzi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<wuziEntity> queryWrapper = new EntityWrapper<wuziEntity>()
            .notIn("id",wuzi.getId())
            .andNew()
            .eq("wuzi_uuid_number", wuzi.getwuziUuidNumber())
            .eq("wuzi_name", wuzi.getwuziName())
            .eq("wuzi_types", wuzi.getwuziTypes())
            .eq("shangxia_types", wuzi.getShangxiaTypes())
            .eq("wuzi_delete", wuzi.getwuziDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        wuziEntity wuziEntity = wuziService.selectOne(queryWrapper);
        if("".equals(wuzi.getwuziPhoto()) || "null".equals(wuzi.getwuziPhoto())){
                wuzi.setwuziPhoto(null);
        }
        if(wuziEntity==null){
            wuziService.updateById(wuzi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<wuziEntity> list = new ArrayList<>();
        for(Integer id:ids){
            wuziEntity wuziEntity = new wuziEntity();
            wuziEntity.setId(id);
            wuziEntity.setwuziDelete(2);
            list.add(wuziEntity);
        }
        if(list != null && list.size() >0){
            wuziService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<wuziEntity> wuziList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            wuziEntity wuziEntity = new wuziEntity();
//                            wuziEntity.setwuziUuidNumber(data.get(0));                    //物资编号 要改的
//                            wuziEntity.setwuziName(data.get(0));                    //物资名称 要改的
//                            wuziEntity.setwuziPhoto("");//详情和图片
//                            wuziEntity.setwuziTypes(Integer.valueOf(data.get(0)));   //物资类型 要改的
//                            wuziEntity.setwuziOldMoney(data.get(0));                    //物资原价 要改的
//                            wuziEntity.setwuziNewMoney(data.get(0));                    //现价 要改的
//                            wuziEntity.setwuziContent("");//详情和图片
//                            wuziEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            wuziEntity.setwuziDelete(1);//逻辑删除字段
//                            wuziEntity.setCreateTime(date);//时间
                            wuziList.add(wuziEntity);


                            //把要查询是否重复的字段放入map中
                                //物资编号
                                if(seachFields.containsKey("wuziUuidNumber")){
                                    List<String> wuziUuidNumber = seachFields.get("wuziUuidNumber");
                                    wuziUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> wuziUuidNumber = new ArrayList<>();
                                    wuziUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("wuziUuidNumber",wuziUuidNumber);
                                }
                        }

                        //查询是否重复
                         //物资编号
                        List<wuziEntity> wuziEntities_wuziUuidNumber = wuziService.selectList(new EntityWrapper<wuziEntity>().in("wuzi_uuid_number", seachFields.get("wuziUuidNumber")).eq("wuzi_delete", 1));
                        if(wuziEntities_wuziUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(wuziEntity s:wuziEntities_wuziUuidNumber){
                                repeatFields.add(s.getwuziUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [物资编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wuziService.insertBatch(wuziList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = wuziService.queryPage(params);

        //字典表数据转换
        List<wuziView> list =(List<wuziView>)page.getList();
        for(wuziView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        wuziEntity wuzi = wuziService.selectById(id);
            if(wuzi !=null){


                //entity转view
                wuziView view = new wuziView();
                BeanUtils.copyProperties( wuzi , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody wuziEntity wuzi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wuzi:{}",this.getClass().getName(),wuzi.toString());
        Wrapper<wuziEntity> queryWrapper = new EntityWrapper<wuziEntity>()
            .eq("wuzi_uuid_number", wuzi.getwuziUuidNumber())
            .eq("wuzi_name", wuzi.getwuziName())
            .eq("wuzi_types", wuzi.getwuziTypes())
            .eq("shangxia_types", wuzi.getShangxiaTypes())
            .eq("wuzi_delete", wuzi.getwuziDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        wuziEntity wuziEntity = wuziService.selectOne(queryWrapper);
        if(wuziEntity==null){
            wuzi.setwuziDelete(1);
            wuzi.setCreateTime(new Date());
        wuziService.insert(wuzi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
