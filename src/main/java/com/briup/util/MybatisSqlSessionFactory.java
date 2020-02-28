package com.briup.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisSqlSessionFactory {

	private static String CONFIG_FILE_LOCATION = "mybatis-config.xml";
	private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    private static SqlSessionFactory sessionFactory;
    private static String configFile = CONFIG_FILE_LOCATION;
    static {
    	try {
    		InputStream stream = Resources.getResourceAsStream(configFile);
			sessionFactory = new SqlSessionFactoryBuilder().build(stream);
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
    }
    private MybatisSqlSessionFactory() {
    }
	
    public static SqlSession getSession()  {
    	SqlSession session = getSession(false);
    	return session;
    }
    /**
             * 获取映射接口的实现类对象 
     * */
    public static <T> T getMapper(Class<T> t) {
    	return getSession(true).getMapper(t);
    }
    public static SqlSession getSession(boolean autoCommit)  {
    	SqlSession sqlSession = threadLocal.get();
		if (sqlSession == null) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			sqlSession = (sessionFactory != null) ? sessionFactory.openSession(autoCommit)
					: null;
			threadLocal.set(sqlSession);
		}

        return sqlSession;
    }

	public static void rebuildSessionFactory() {
		try {
			InputStream stream = Resources.getResourceAsStream(configFile);
			sessionFactory = new SqlSessionFactoryBuilder().build(stream);
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}

    public static void closeSession(){
        SqlSession session = threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

	public static SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setConfigFile(String configFile) {
		MybatisSqlSessionFactory.configFile = configFile;
		sessionFactory = null;
	}


}
