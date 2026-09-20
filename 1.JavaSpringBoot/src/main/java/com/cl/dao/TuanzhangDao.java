package com.cl.dao;

import com.cl.entity.TuanzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TuanzhangView;


/**
 * 团长
 * 
 * @author 
 * @email 
 * @date 2024-03-02 16:39:28
 */
public interface TuanzhangDao extends BaseMapper<TuanzhangEntity> {
	
	List<TuanzhangView> selectListView(@Param("ew") Wrapper<TuanzhangEntity> wrapper);

	List<TuanzhangView> selectListView(Pagination page,@Param("ew") Wrapper<TuanzhangEntity> wrapper);
	
	TuanzhangView selectView(@Param("ew") Wrapper<TuanzhangEntity> wrapper);
	

}
