package skunk.domain;
import org.junit.Test;

public class TestDie
{

	@Test
	public void test()
	{
		//fail("Not yet implemented");
	}

	@Test(expected=RuntimeException.class)
	public void test2()
	{
		throw new RuntimeException();
	}
}
