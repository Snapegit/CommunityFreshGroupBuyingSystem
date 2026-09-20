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
 * 取货信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-02 16:39:28
 */
@TableName("quhuoxinxi")
public class QuhuoxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public QuhuoxinxiEntity() {
		
	}
	
	public QuhuoxinxiEntity(T t) {
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
	 * 团长账号
	 */
					
	private String tuanzhangzhanghao;
	
	/**
	 * 团长姓名
	 */
					
	private String tuanzhangxingming;
	
	/**
	 * 自提点名称
	 */
					
	private String zitidianmingcheng;
	
	/**
	 * 商品分类
	 */
					
	private String shangpinfenlei;
	
	/**
	 * 商品名称
	 */
					
	private String shangpinmingcheng;
	
	/**
	 * 数量
	 */
					
	private String shuliang;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 取货时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date quhuoshijian;
	
	
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
	 * 设置：商品分类
	 */
	public void setShangpinfenlei(String shangpinfenlei) {
		this.shangpinfenlei = shangpinfenlei;
	}
	/**
	 * 获取：商品分类
	 */
	public String getShangpinfenlei() {
		return shangpinfenlei;
	}
	/**
	 * 设置：商品名称
	 */
	public void setShangpinmingcheng(String shangpinmingcheng) {
		this.shangpinmingcheng = shangpinmingcheng;
	}
	/**
	 * 获取：商品名称
	 */
	public String getShangpinmingcheng() {
		return shangpinmingcheng;
	}
	/**
	 * 设置：数量
	 */
	public void setShuliang(String shuliang) {
		this.shuliang = shuliang;
	}
	/**
	 * 获取：数量
	 */
	public String getShuliang() {
		return shuliang;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：取货时间
	 */
	public void setQuhuoshijian(Date quhuoshijian) {
		this.quhuoshijian = quhuoshijian;
	}
	/**
	 * 获取：取货时间
	 */
	public Date getQuhuoshijian() {
		return quhuoshijian;
	}

}
