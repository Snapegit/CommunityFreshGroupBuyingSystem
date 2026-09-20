package com.cl.dao;

import com.cl.entity.QuhuoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QuhuoxinxiView;


/**
 * 取货信息
 * 
 * @author 
 * @email 
 * @date 2024-03-02 16:39:28
 */
public interface QuhuoxinxiDao extends BaseMapper<QuhuoxinxiEntity> {
	
	List<QuhuoxinxiView> selectListView(@Param("ew") Wrapper<QuhuoxinxiEntity> wrapper);

	List<QuhuoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<QuhuoxinxiEntity> wrapper);
	
	QuhuoxinxiView selectView(@Param("ew") Wrapper<QuhuoxinxiEntity> wrapper);
	

}
