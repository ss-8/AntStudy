import org.junit.Test;

public class testEgg {

	@Test
	public void test() {
		long s = System.currentTimeMillis();
		int i = 1;
		while (true) {
			if (i % 2 == 1) {
				if (i % 3 == 0) {
					if (i % 4 == 1) {
						if (i % 5 == 4) {
							if (i % 6 == 3) {
								if (i % 7 == 0) {
									if (i % 8 == 1) {
										if (i % 9 == 0) {
											System.out.println(i);
										}
									}
								}
							}
						}
					}
				}
			}
			i++;
			if(i==100000){
				break;
			}
		}
	}
}
