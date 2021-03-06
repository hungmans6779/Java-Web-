package com.spring.orm.dao;

import java.util.List;

import com.spring.orm.entity.Cat;

/*
 *  Cat 的 DAO 介面
 */
public interface ICatDao {

  /*
   *  儲存物件
   *  @param Cat 物件
   */
  public void createCat(Cat cat);
  
  
  /*
   *  查詢所有物件
   *  @return Cat List 物件
   */
  public List<Cat> listCats();
  
  
  /*
   *  傳回物件數量
   *  @param int 數量
   */
  public int getCatsCount();
  
  
  /*
   *  根據名字查詢物件
   *  @return Cat 物件
   */
  public Cat findCatByName(String name);
  
  
}
