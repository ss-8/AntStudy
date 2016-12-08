import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class testRegular {

	@Test
	public void test() {
		String line = "This order was placed for QT3000! OK?";
		Pattern r = Pattern.compile("*or+");
		// 现在创建 matcher 对象
		Matcher m = r.matcher(line);

		if (m.find()) {
			for (int i = 0; i < m.groupCount(); i++)
				System.out.println("Found value: " + m.group(i));
		} else {
			System.out.println("NO MATCH");
		}
	}

}
