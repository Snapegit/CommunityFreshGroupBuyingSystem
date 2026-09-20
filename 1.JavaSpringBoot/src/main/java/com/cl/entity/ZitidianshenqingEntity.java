package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 自提点申请
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-02 16:39:28
 */
@TableName("zitidianshenqing")
public class ZitidianshenqingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZitidianshenqingEntity() {
		
	}
	
	public ZitidianshenqingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 自提点名称
	 */
					
	private String zitidianmingcheng;
	
	/**
	 * 地址
	 */
					
	private String dizhi;
	
	/**
	 * 团长账号
	 */
					
	private String tuanzhangzhanghao;
	
	/**
	 * 团长姓名
	 */
					
	private String tuanzhangxingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：自提点名称
	 */
	public void setZitidianmingcheng(String zitidianmingcheng) {
		this.zitidianmingcheng = zitidianmingcheng;
	}
	/**
	 * 获取：自提点名称
	 */
	public String getZitidianmingcheng() {
		return zitidianmingcheng;
	}
	/**
	 * 设置：地址
	 */
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	/**
	 * 获取：地址
	 */
	public String getDizhi() {
		return dizhi;
	}
	/**
	 * 设置：团长账号
	 */
	public void setTuanzhangzhanghao(String tuanzhangzhanghao) {
		this.tuanzhangzhanghao = tuanzhangzhanghao;
	}
	/**
	 * 获取：团长账号
	 */
	public String getTuanzhangzhanghao() {
		return tuanzhangzhanghao;
	}
	/**
	 * 设置：团长姓名
	 */
	public void setTuanzhangxingming(String tuanzhangxingming) {
		this.tuanzhangxingming = tuanzhangxingming;
	}
	/**
	 * 获取：团长姓名
	 */
	public String getTuanzhangxingming() {
		return tuanzhangxingming;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}

}
