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

import com.cl.entity.QuhuoxinxiEntity;
import com.cl.entity.view.QuhuoxinxiView;

import com.cl.service.QuhuoxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 取货信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-02 16:39:28
 */
@RestController
@RequestMapping("/quhuoxinxi")
public class QuhuoxinxiController {
    @Autowired
    private QuhuoxinxiService quhuoxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QuhuoxinxiEntity quhuoxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("tuanzhang")) {
			quhuoxinxi.setTuanzhangzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			quhuoxinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QuhuoxinxiEntity> ew = new EntityWrapper<QuhuoxinxiEntity>();

		PageUtils page = quhuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quhuoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QuhuoxinxiEntity quhuoxinxi, 
		HttpServletRequest request){
        EntityWrapper<QuhuoxinxiEntity> ew = new EntityWrapper<QuhuoxinxiEntity>();

		PageUtils page = quhuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quhuoxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QuhuoxinxiEntity quhuoxinxi){
       	EntityWrapper<QuhuoxinxiEntity> ew = new EntityWrapper<QuhuoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( quhuoxinxi, "quhuoxinxi")); 
        return R.ok().put("data", quhuoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QuhuoxinxiEntity quhuoxinxi){
        EntityWrapper< QuhuoxinxiEntity> ew = new EntityWrapper< QuhuoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( quhuoxinxi, "quhuoxinxi")); 
		QuhuoxinxiView quhuoxinxiView =  quhuoxinxiService.selectView(ew);
		return R.ok("查询取货信息成功").put("data", quhuoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QuhuoxinxiEntity quhuoxinxi = quhuoxinxiService.selectById(id);
		quhuoxinxi = quhuoxinxiService.selectView(new EntityWrapper<QuhuoxinxiEntity>().eq("id", id));
        return R.ok().put("data", quhuoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QuhuoxinxiEntity quhuoxinxi = quhuoxinxiService.selectById(id);
		quhuoxinxi = quhuoxinxiService.selectView(new EntityWrapper<QuhuoxinxiEntity>().eq("id", id));
        return R.ok().put("data", quhuoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QuhuoxinxiEntity quhuoxinxi, HttpServletRequest request){
    	quhuoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(quhuoxinxi);
        quhuoxinxiService.insert(quhuoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QuhuoxinxiEntity quhuoxinxi, HttpServletRequest request){
    	quhuoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(quhuoxinxi);
        quhuoxinxiService.insert(quhuoxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QuhuoxinxiEntity quhuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quhuoxinxi);
        quhuoxinxiService.updateById(quhuoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        quhuoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
