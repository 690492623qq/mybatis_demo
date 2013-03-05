package com.my.mybatis.Util;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by User
 * Location Path : com.my.mybatis.Util
 * User: jianyuan.yang
 * Date: 13-2-23
 * Time: 下午10:50
 */

/**
 * 构造 单例 SqlSessionFactory
 */
public class SqlSessionFactoryUtil {

    static SqlSessionFactory sqlSessionFactory ;

    /**
     * mybatis 的配置文件
     */
    final static String resource = "mybatis-config.xml" ;

    /**
     * 懒汉 方式 构造单例子
     * @return   SqlSessionFactory
     * */
    public static synchronized SqlSessionFactory getInstance(){
        if(null == sqlSessionFactory){
            try{
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }catch (Exception e){
                throw new Error(e.getMessage());
            }
        }
        return sqlSessionFactory ;
    }

}
