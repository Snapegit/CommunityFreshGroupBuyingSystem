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


import com.cl.dao.TuanzhangDao;
import com.cl.entity.TuanzhangEntity;
import com.cl.service.TuanzhangService;
import com.cl.entity.view.TuanzhangView;

@Service("tuanzhangService")
public class TuanzhangServiceImpl extends ServiceImpl<TuanzhangDao, TuanzhangEntity> implements TuanzhangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TuanzhangEntity> page = this.selectPage(
                new Query<TuanzhangEntity>(params).getPage(),
                new EntityWrapper<TuanzhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TuanzhangEntity> wrapper) {
		  Page<TuanzhangView> page =new Query<TuanzhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TuanzhangView> selectListView(Wrapper<TuanzhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TuanzhangView selectView(Wrapper<TuanzhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
