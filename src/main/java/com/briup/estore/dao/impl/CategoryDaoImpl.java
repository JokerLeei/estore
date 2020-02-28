package com.briup.estore.dao.impl;

import com.briup.estore.bean.Category;
import com.briup.estore.bean.CategoryExample;
import com.briup.estore.bean.ex.RootCategory;
import com.briup.estore.bean.ex.SecoundCategory;
import com.briup.estore.dao.CategoryDao;
import com.briup.estore.mapper.CategoryMapper;
import com.briup.estore.mapper.ex.CategoryEXMapper;
import com.briup.util.MybatisSqlSessionFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<RootCategory> findRootAndSecoundCategories() {
        CategoryEXMapper mapper = MybatisSqlSessionFactory.getMapper(CategoryEXMapper.class);
        return mapper.findRootAndSecoundCategories();
    }

    /*@Override
    public List<Category> findRootAndSecoundCategoriesByCategoryId(Integer categoryId) {
        CategoryMapper mapper = MybatisSqlSessionFactory.getMapper(CategoryMapper.class);

        // 返回结果
        List<Category> result=new ArrayList<>();

        // 查询二级分类：
        Category SecoundCategory = mapper.selectByPrimaryKey(categoryId);
        result.add(SecoundCategory);

        // 查询一级分类：
        // 获取二级分类的父分类id
        Integer parentId = SecoundCategory.getParentId();
        Category rootCategory = mapper.selectByPrimaryKey(parentId);
        result.add(rootCategory);

        // 列表顺序倒置
        Collections.reverse(result);
        result.forEach(System.out::println);

        return result;
    }*/

    @Override
    public RootCategory findRootCategoryWithBooksByCategoryId(Integer categoryId) {
        CategoryEXMapper mapper = MybatisSqlSessionFactory.getMapper(CategoryEXMapper.class);
        return mapper.findRootCategoryWithBooksByCategoryId(categoryId);
    }

    @Override
    public SecoundCategory findSecoundCategoryWithBooksByCategoryId(Integer categoryId) {
        CategoryEXMapper mapper = MybatisSqlSessionFactory.getMapper(CategoryEXMapper.class);
        return mapper.findSecoundCategoryWithBooksByCategoryId(categoryId);
    }

}
