package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ZitidianshenqingEntity;
import com.cl.entity.view.ZitidianshenqingView;

import com.cl.service.ZitidianshenqingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 自提点申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-02 16:39:28
 */
@RestController
@RequestMapping("/zitidianshenqing")
public class ZitidianshenqingController {
    @Autowired
    private ZitidianshenqingService zitidianshenqingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZitidianshenqingEntity zitidianshenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("tuanzhang")) {
			zitidianshenqing.setTuanzhangzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZitidianshenqingEntity> ew = new EntityWrapper<ZitidianshenqingEntity>();

		PageUtils page = zitidianshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zitidianshenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZitidianshenqingEntity zitidianshenqing, 
		HttpServletRequest request){
        EntityWrapper<ZitidianshenqingEntity> ew = new EntityWrapper<ZitidianshenqingEntity>();

		PageUtils page = zitidianshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zitidianshenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZitidianshenqingEntity zitidianshenqing){
       	EntityWrapper<ZitidianshenqingEntity> ew = new EntityWrapper<ZitidianshenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zitidianshenqing, "zitidianshenqing")); 
        return R.ok().put("data", zitidianshenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZitidianshenqingEntity zitidianshenqing){
        EntityWrapper< ZitidianshenqingEntity> ew = new EntityWrapper< ZitidianshenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zitidianshenqing, "zitidianshenqing")); 
		ZitidianshenqingView zitidianshenqingView =  zitidianshenqingService.selectView(ew);
		return R.ok("查询自提点申请成功").put("data", zitidianshenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZitidianshenqingEntity zitidianshenqing = zitidianshenqingService.selectById(id);
		zitidianshenqing = zitidianshenqingService.selectView(new EntityWrapper<ZitidianshenqingEntity>().eq("id", id));
        return R.ok().put("data", zitidianshenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZitidianshenqingEntity zitidianshenqing = zitidianshenqingService.selectById(id);
		zitidianshenqing = zitidianshenqingService.selectView(new EntityWrapper<ZitidianshenqingEntity>().eq("id", id));
        return R.ok().put("data", zitidianshenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZitidianshenqingEntity zitidianshenqing, HttpServletRequest request){
    	zitidianshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zitidianshenqing);
        zitidianshenqingService.insert(zitidianshenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZitidianshenqingEntity zitidianshenqing, HttpServletRequest request){
    	zitidianshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zitidianshenqing);
        zitidianshenqingService.insert(zitidianshenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZitidianshenqingEntity zitidianshenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zitidianshenqing);
        zitidianshenqingService.updateById(zitidianshenqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZitidianshenqingEntity> list = new ArrayList<ZitidianshenqingEntity>();
        for(Long id : ids) {
            ZitidianshenqingEntity zitidianshenqing = zitidianshenqingService.selectById(id);
            zitidianshenqing.setSfsh(sfsh);
            zitidianshenqing.setShhf(shhf);
            list.add(zitidianshenqing);
        }
        zitidianshenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zitidianshenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
