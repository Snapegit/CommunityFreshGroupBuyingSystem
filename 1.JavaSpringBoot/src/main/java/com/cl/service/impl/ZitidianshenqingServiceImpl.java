package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ZitidianshenqingDao;
import com.cl.entity.ZitidianshenqingEntity;
import com.cl.service.ZitidianshenqingService;
import com.cl.entity.view.ZitidianshenqingView;

@Service("zitidianshenqingService")
public class ZitidianshenqingServiceImpl extends ServiceImpl<ZitidianshenqingDao, ZitidianshenqingEntity> implements ZitidianshenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZitidianshenqingEntity> page = this.selectPage(
                new Query<ZitidianshenqingEntity>(params).getPage(),
                new EntityWrapper<ZitidianshenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZitidianshenqingEntity> wrapper) {
		  Page<ZitidianshenqingView> page =new Query<ZitidianshenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZitidianshenqingView> selectListView(Wrapper<ZitidianshenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZitidianshenqingView selectView(Wrapper<ZitidianshenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
