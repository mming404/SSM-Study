import com.ysm.mybatis.mapper.UserMapper;
import com.ysm.mybatis.pojo.User;
import com.ysm.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void testInsert() throws IOException {
        //获取核心输入流
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(stream);
        //自动提交事务
        SqlSession sqlSession = sessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.insertUser());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        final SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.updateUser());
        sqlSession.close();
    }
    @Test
    public void testDelete(){
        final SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.deleteUser());
        sqlSession.close();
    }

    @Test
    public void testSelect(){
        final SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        final User user = userMapper.getUserById();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testSelectAllUser(){
        final SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        final List<User> users = userMapper.listAllUser();
        users.forEach(System.out::println);
        sqlSession.close();
    }

}
