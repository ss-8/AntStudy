import org.junit.Test;

public class testGetClasspath {

	@Test
	public void test() {
		System.out.println(this.getClass().getClassLoader().getResource(""));
	}
}
