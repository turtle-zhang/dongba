import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBase {
	
	protected ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("spring-config.xml");
	}
}
