import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.turtle.dao.SysLogDao;

public class TestSpring extends TestBase{
	
	@Test
	public void testCtx() {
		//ctx.getBean(name)
		System.out.println(ctx);
	}
	
	@Test
	public void testDataSource() {
		System.out.println(ctx.getBean("dataSource", DataSource.class));
	}
	
	@Test
	public void testSqlSessionFactory() {
		System.out.println(ctx.getBean("sqlSessionFactory",SqlSessionFactory.class));
	}
	
	@Test
	public void testDeleteLogByIds() {
		SysLogDao sysLogDao = ctx.getBean("sysLogDao", SysLogDao.class);
		int rows = sysLogDao.deleteObjects(38,37);
		System.out.println("删除的行数为"+rows);
	}
}
