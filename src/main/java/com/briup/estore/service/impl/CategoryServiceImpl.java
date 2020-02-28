package com.briup.estore.service.impl;

import com.briup.estore.bean.Category;
import com.briup.estore.bean.ex.RootCategory;
import com.briup.estore.bean.ex.SecoundCategory;
import com.briup.estore.dao.CategoryDao;
import com.briup.estore.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @Override
    public List<RootCategory> findRootAndSecoundCategories() {
        return categoryDao.findRootAndSecoundCategories();
    }

    /*@Override
    public List<Category> findRootAndSecoundCategoriesByCategoryId(Integer categoryId) {
        return categoryDao.findRootAndSecoundCategoriesByCategoryId(categoryId);
    }*/

    @Override
    public RootCategory findRootCategoryWithBooksByCategoryId(Integer categoryId) {
        return categoryDao.findRootCategoryWithBooksByCategoryId(categoryId);
    }

    @Override
    public SecoundCategory findSecoundCategoryWithBooksByCategoryId(Integer categoryId) {
        return categoryDao.findSecoundCategoryWithBooksByCategoryId(categoryId);
    }

}
