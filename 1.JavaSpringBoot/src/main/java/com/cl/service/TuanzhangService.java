package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TuanzhangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TuanzhangView;


/**
 * 团长
 *
 * @author 
 * @email 
 * @date 2024-03-02 16:39:28
 */
public interface TuanzhangService extends IService<TuanzhangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TuanzhangView> selectListView(Wrapper<TuanzhangEntity> wrapper);
   	
   	TuanzhangView selectView(@Param("ew") Wrapper<TuanzhangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TuanzhangEntity> wrapper);
   	

}

