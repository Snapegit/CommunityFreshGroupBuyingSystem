package com.cl.dao;

import com.cl.entity.ZitidianshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZitidianshenqingView;


/**
 * 自提点申请
 * 
 * @author 
 * @email 
 * @date 2024-03-02 16:39:28
 */
public interface ZitidianshenqingDao extends BaseMapper<ZitidianshenqingEntity> {
	
	List<ZitidianshenqingView> selectListView(@Param("ew") Wrapper<ZitidianshenqingEntity> wrapper);

	List<ZitidianshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<ZitidianshenqingEntity> wrapper);
	
	ZitidianshenqingView selectView(@Param("ew") Wrapper<ZitidianshenqingEntity> wrapper);
	

}
