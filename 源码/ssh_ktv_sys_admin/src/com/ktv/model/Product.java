package com.ktv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_product")
public class Product{
    private int id;
    private String name;//商品名称
    private double price;//商品价格
    private String image;//商品图片
    private String remark; //商品描述
    private CategorySec categorySec;//跟二级分类关联
    private int  isDelete; //0:不删除 1：删除
    private Category category;//一级分类
    
    @Id
    @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	 @ManyToOne
	 @JoinColumn(name="categorySec_id")
	public CategorySec getCategorySec() {
		return categorySec;
	}
	public void setCategorySec(CategorySec categorySec) {
		this.categorySec = categorySec;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	 @ManyToOne
	 @JoinColumn(name="category_id")
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
    
  


    
  
    
  
   
}