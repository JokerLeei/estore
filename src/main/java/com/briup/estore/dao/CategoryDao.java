package com.briup.estore.dao;

import com.briup.estore.bean.Category;
import com.briup.estore.bean.ex.RootCategory;
import com.briup.estore.bean.ex.SecoundCategory;

import java.util.List;

public interface CategoryDao {
    // 查找出所有顶级图书分类
    List<RootCategory> findRootAndSecoundCategories();

    /**
     * @param categoryId 分类id
     * @return  返回一个List<Category>，其get(0)为根分类，get(1)为二级分类
     */
    // 根据categoryId查出其一级分类和二级分类
    /*List<Category> findRootAndSecoundCategoriesByCategoryId(Integer categoryId);*/

    // 根据categoryId找出所有根Category(包括其子categoryList和bookList)
    RootCategory findRootCategoryWithBooksByCategoryId(Integer categoryId);

    // 根据categoryId找出所有二级Category(包括其父category对象和bookList)
    SecoundCategory findSecoundCategoryWithBooksByCategoryId(Integer categoryId);

}
