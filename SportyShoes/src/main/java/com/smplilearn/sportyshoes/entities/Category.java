package com.smplilearn.sportyshoes.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	private String categoryTitle;
	private String categoryDecs;
	@OneToMany(mappedBy = "category")
	private List<Product> products = new ArrayList<Product>();
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Category(int categoryId, String categoryTitle, String categoryDecs, List<Product> products) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDecs = categoryDecs;
		this.products = products;
	}


	public Category(int categoryId, String categoryTitle, String categoryDecs) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDecs = categoryDecs;
	}
	public Category(String categoryTitle, String categoryDecs) {
		super();
		this.categoryTitle = categoryTitle;
		this.categoryDecs = categoryDecs;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public String getCategoryDecs() {
		return categoryDecs;
	}
	public void setCategoryDecs(String categoryDecs) {
		this.categoryDecs = categoryDecs;
	}
	
	
	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categoryDecs="
				+ categoryDecs + "]";
	}
	
	

}
