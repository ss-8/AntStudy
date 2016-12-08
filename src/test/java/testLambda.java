import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class testLambda {

	@Test
	public void test() {
		String[] atp = { "Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer", "Andy Murray", "Tomas Berdych", "Juan Martin Del Potro" };
		List<String> players = Arrays.asList(atp);
		players.forEach((player) -> System.out.println("<td>" + player + "</td>"));
	}

}
