package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.QuhuoxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QuhuoxinxiView;


/**
 * 取货信息
 *
 * @author 
 * @email 
 * @date 2024-03-02 16:39:28
 */
public interface QuhuoxinxiService extends IService<QuhuoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QuhuoxinxiView> selectListView(Wrapper<QuhuoxinxiEntity> wrapper);
   	
   	QuhuoxinxiView selectView(@Param("ew") Wrapper<QuhuoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QuhuoxinxiEntity> wrapper);
   	

}

