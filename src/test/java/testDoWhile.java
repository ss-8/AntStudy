import org.junit.Test;

public class testDoWhile {

	@Test
	public void test() {
		int i=0;
		do{
			i++;
			System.out.println(i);
			if(i>10)
				break;
		}while(true);
	}

}
