package com.my.mybatis;

import com.my.mybatis.Util.SqlSessionFactoryUtil;
import com.my.mybatis.dao.MyBatisMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by User
 * Location Path : com.my.mybatis
 * User: jianyuan.yang
 * Date: 13-2-23
 * Time: 下午7:47
 */
public class MybatisTest {

    /**
     * 饿汉 单例 构造
     */
    static SqlSessionFactory sqlSessionFactory ;
    static{
        String resource = "mybatis-config.xml";
        try{
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            throw new Error(e.getMessage());
        }
    }


    public static void main(String[] args) {

        com.my.mybatis.pojo.MyBatis myBatis = new com.my.mybatis.pojo.MyBatis();
        myBatis.setName("test");
        myBatis.setAge("age");
        myBatis.setSex("sex");

       // XML 配置文件包含对 MyBatisMapper 系统的核心设置,包含获取数据库连接实例的数据源
        SqlSession session = null ;
        try {
            session = SqlSessionFactoryUtil.getInstance().openSession();
            MyBatisMapper mapper = session.getMapper(MyBatisMapper.class);
            mapper.insertMyBatis(myBatis);

            //提交事务，否则不会实际添加到数据库中
            session.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(null != session){
              session.close();
            }
        }

    }
}
