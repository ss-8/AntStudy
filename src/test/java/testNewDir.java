import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class testNewDir {

	@Test
	public void test() {
		File f=new File("D:\\aa\\");
		if(!f.exists())
			f.mkdirs();
		else
			System.out.println("file exists");
	}

}
