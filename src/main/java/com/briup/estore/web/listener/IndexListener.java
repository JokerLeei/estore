package com.briup.estore.web.listener;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.ex.RootCategory;
import com.briup.estore.dao.impl.BookDaoImpl;
import com.briup.estore.dao.impl.CategoryDaoImpl;
import com.briup.estore.service.BookService;
import com.briup.estore.service.CategoryService;
import com.briup.estore.service.impl.BookServiceImpl;
import com.briup.estore.service.impl.CategoryServiceImpl;
import com.briup.util.MybatisSqlSessionFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.List;

@WebListener()
public class IndexListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public IndexListener() {
    }

    /**
     * 当容器(Tomcat)启动时，查找出所有 书籍 和 分类 ，并将结果存入application(ServletContext)域中
     *
     * @param sce ServletContextEvent对象
     */
    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        // 获取List<Book> 对象
        // 将这个对象 setAttribute 到 jsp
        BookService bookService = new BookServiceImpl(new BookDaoImpl());
        List<Book> bookList = null;
        try {
            bookList = bookService.findAllBooks();
            bookList.forEach(System.out::println);
        } catch (Exception e) {
            sce.getServletContext().setAttribute("bookMsg", e.getMessage());
        }
        sce.getServletContext().setAttribute("bookList", bookList);


        // 获取List<RootCategory> 对象 ----- 主页面最左侧栏
        // 将这个对象 setAttribute 到 jsp
        CategoryService categoryService = new CategoryServiceImpl(new CategoryDaoImpl());
        List<RootCategory> rootCategories = categoryService.findRootAndSecoundCategories();

        System.out.println("rootCategories:");
        rootCategories.forEach(System.out::println);

        sce.getServletContext().setAttribute("rootCategories", rootCategories);

    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        MybatisSqlSessionFactory.closeSession();
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
