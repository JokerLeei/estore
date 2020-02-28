package com.briup.estore.service;

import com.briup.estore.bean.ex.RootCategory;
import com.briup.estore.bean.ex.SecoundCategory;

import java.util.List;

public interface CategoryService {
    List<RootCategory> findRootAndSecoundCategories();

    /*List<Category> findRootAndSecoundCategoriesByCategoryId(Integer categoryId);*/

    RootCategory findRootCategoryWithBooksByCategoryId(Integer categoryId);

    SecoundCategory findSecoundCategoryWithBooksByCategoryId(Integer categoryId);

}
