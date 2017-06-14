import java.awt.Rectangle;
import org.junit.Test;

public class testFinal {

	@Test
	public void test() {
		final Rectangle r = new Rectangle(12, 12, 12, 12);
		System.out.println(r.height);
	}
}
