import org.junit.Test;

public class testDiGui {

	@Test
	public void test() {
		System.out.println(age(5));
	}

	public int age(int x) {
		System.out.println("--"+x);
		if (x == 1) {
			return 2;
		} else {
			int a=(age(x - 1) + 2);
			System.out.println(x+"---"+a);
			return a;
		}
	}
}
