import org.junit.Test;

public class testCpu {

	@Test
	public void test() {
		//System.out.println(Runtime.getRuntime().availableProcessors());
		long s=System.currentTimeMillis();
		System.out.println(Math.sqrt(25));
		System.out.println(System.currentTimeMillis()-s);
	}
}
