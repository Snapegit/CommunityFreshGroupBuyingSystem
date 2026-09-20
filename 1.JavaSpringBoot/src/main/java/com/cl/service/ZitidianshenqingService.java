package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZitidianshenqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZitidianshenqingView;


/**
 * 自提点申请
 *
 * @author 
 * @email 
 * @date 2024-03-02 16:39:28
 */
public interface ZitidianshenqingService extends IService<ZitidianshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZitidianshenqingView> selectListView(Wrapper<ZitidianshenqingEntity> wrapper);
   	
   	ZitidianshenqingView selectView(@Param("ew") Wrapper<ZitidianshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZitidianshenqingEntity> wrapper);
   	

}

