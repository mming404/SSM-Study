import com.github.pagehelper.PageHelper;
import com.ysm.mybatis.mapper.DynamicSQLMapper;
import com.ysm.mybatis.mapper.SpecialSQLMapper;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testSelectUserByName(){
        final SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        final User user = userMapper.getUserByName("ysm");
        System.out.println(user);
//        sqlSession.clearCache();
        final User user1 = userMapper.getUserByName("ysm");

        System.out.println(user1);
        sqlSession.close();
    }

    @Test
    public void testAddUser(){
        final SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.addUser(new User(null, "原神高手")));
        sqlSession.close();
    }


    @Test
    public void testAddUsersCount(){
        final SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.getUsersCount());
        sqlSession.close();
    }

    @Test
    public void testSelectUserToMap(){
        final SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        final Map<String, Object> user = userMapper.getUserById2(8);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testSelectUserByLike(){
        final SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        final SpecialSQLMapper specialSQLMapper = sqlSession.getMapper(SpecialSQLMapper.class);
        final List<User> users = specialSQLMapper.getUserLike("m");
        users.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testAddUserGetKey(){
        final SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        final SpecialSQLMapper specialSQLMapper = sqlSession.getMapper(SpecialSQLMapper.class);
        final User user = new User(null, "原神高手ysm");
        specialSQLMapper.insertUserGetKey(user);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void testGetUserByCondition(){
        final SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        final DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        final List<User> users = dynamicSQLMapper.getUserByCondition(new User(null, ""));
        users.forEach(System.out::println);
        sqlSession.close();
    }

    /**
     * 测试批量插入
     */
    @Test
    public void testInsertMoreUser(){
        final SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        final DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        final ArrayList<User> users = new ArrayList<>();
        users.add(new User(null,"ysm11"));
        users.add(new User(null,"ysm12"));
        users.add(new User(null,"ysm13"));
        dynamicSQLMapper.insertMoreUser(users);
        users.forEach(System.out::println);
        sqlSession.close();
    }

    /**
     * 测试批量删除
     */
    @Test
    public void testDeleteMoreUser(){
        final SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        final DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        dynamicSQLMapper.deleteMoreUser(new Integer[]{13,14,15});

        sqlSession.close();
    }

    /**
     * 测试分页查询
     */
    @Test
    public void testPage(){
        final SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        PageHelper.startPage(1,4);
        final List<User> users = userMapper.listAllUser();
        users.forEach(System.out::println);
        sqlSession.close();
    }
}
