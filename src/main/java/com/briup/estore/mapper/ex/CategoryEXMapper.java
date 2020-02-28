package com.briup.estore.mapper.ex;

import com.briup.estore.bean.ex.RootCategory;
import com.briup.estore.bean.ex.SecoundCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryEXMapper {
    List<RootCategory> findRootAndSecoundCategories();

    RootCategory findRootCategoryWithBooksByCategoryId(@Param("categoryId") Integer categoryId);

    SecoundCategory findSecoundCategoryWithBooksByCategoryId(@Param("categoryId") Integer categoryId);
}
