package com.cl.entity.view;

import com.cl.entity.ZitidianshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 自提点申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-02 16:39:28
 */
@TableName("zitidianshenqing")
public class ZitidianshenqingView  extends ZitidianshenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZitidianshenqingView(){
	}
 
 	public ZitidianshenqingView(ZitidianshenqingEntity zitidianshenqingEntity){
 	try {
			BeanUtils.copyProperties(this, zitidianshenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
