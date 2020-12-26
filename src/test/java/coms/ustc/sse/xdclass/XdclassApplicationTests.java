package coms.ustc.sse.xdclass;

import coms.ustc.sse.xdclass.domain.Video;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
class XdclassApplicationTests {

	@Test
	void contextLoads() throws IOException {
////加载核心配置文件
//		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
////获得sqlSession工厂对象
//		SqlSessionFactory sqlSessionFactory = new
//				SqlSessionFactoryBuilder().build(resourceAsStream);
////获得sqlSession对象
//		SqlSession sqlSession = sqlSessionFactory.openSession();
////执行sql语句
//		List<Video> userList = sqlSession.selectList("userMapper.findAll");
////打印结果
//		System.out.println(userList);
////释放资源
//		sqlSession.close();
	}

}
