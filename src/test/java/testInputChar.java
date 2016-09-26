
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class testInputChar {

	@Test
	public void test() {
		System.out.println("请在3秒内切换到输入焦点");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<String> commandList = new ArrayList<String>();
		commandList.add("asdfasdfasdf");
		commandList.add("asdfasdf");
		commandList.add("cd /export/Instances/cvweb/server1/");
		commandList.add("tail -f logs/catalina.out");
		for (String command : commandList) {
			try {
				Thread.sleep(2000);
				processKey(command);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static Boolean processKey(String str) {
		try {
			Robot r = new Robot();
			String[] nar = str.split("|");
			for (String ones : nar) {
				Boolean isPressShift = isShift(ones.charAt(0));
				Integer keycode = MykeyEvent.getKeyEvent(ones.toLowerCase().charAt(0));
				if (isPressShift) {
					r.keyPress(KeyEvent.VK_SHIFT);
				}
				r.keyPress(keycode);
				r.keyRelease(keycode);
				if (isPressShift) {
					r.keyRelease(KeyEvent.VK_SHIFT);
				}
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			return true;
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// 判断是否需要按shift
	private static Boolean isShift(char c) {
		String symbol = "~!@#$%^&*()_+{}|:\"<>?";
		for (String sone : symbol.split("|")) {
			if (c == sone.charAt(0)) {
				return true;
			}
		}
		if (Character.isLetter(c)) {
			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}

	public static class MykeyEvent {

		public static Integer getKeyEvent(char c) {
			Integer keycode = null;
			switch (c) {
			case 'a':
				keycode = KeyEvent.VK_A;
				break;
			case 'b':
				keycode = KeyEvent.VK_B;
				break;
			case 'c':
				keycode = KeyEvent.VK_C;
				break;
			case 'd':
				keycode = KeyEvent.VK_D;
				break;
			case 'e':
				keycode = KeyEvent.VK_E;
				break;
			case 'f':
				keycode = KeyEvent.VK_F;
				break;
			case 'g':
				keycode = KeyEvent.VK_G;
				break;
			case 'h':
				keycode = KeyEvent.VK_H;
				break;
			case 'i':
				keycode = KeyEvent.VK_I;
				break;
			case 'j':
				keycode = KeyEvent.VK_J;
				break;
			case 'k':
				keycode = KeyEvent.VK_K;
				break;
			case 'l':
				keycode = KeyEvent.VK_L;
				break;
			case 'm':
				keycode = KeyEvent.VK_M;
				break;
			case 'n':
				keycode = KeyEvent.VK_N;
				break;
			case 'o':
				keycode = KeyEvent.VK_O;
				break;
			case 'p':
				keycode = KeyEvent.VK_P;
				break;
			case 'q':
				keycode = KeyEvent.VK_Q;
				break;
			case 'r':
				keycode = KeyEvent.VK_R;
				break;
			case 's':
				keycode = KeyEvent.VK_S;
				break;
			case 't':
				keycode = KeyEvent.VK_T;
				break;
			case 'u':
				keycode = KeyEvent.VK_U;
				break;
			case 'v':
				keycode = KeyEvent.VK_V;
				break;
			case 'w':
				keycode = KeyEvent.VK_W;
				break;
			case 'x':
				keycode = KeyEvent.VK_X;
				break;
			case 'y':
				keycode = KeyEvent.VK_Y;
				break;
			case 'z':
				keycode = KeyEvent.VK_Z;
				break;
			case '0':
				keycode = KeyEvent.VK_0;
				break;
			case '1':
				keycode = KeyEvent.VK_1;
				break;
			case '2':
				keycode = KeyEvent.VK_2;
				break;
			case '3':
				keycode = KeyEvent.VK_3;
				break;
			case '4':
				keycode = KeyEvent.VK_4;
				break;
			case '5':
				keycode = KeyEvent.VK_5;
				break;
			case '6':
				keycode = KeyEvent.VK_6;
				break;
			case '7':
				keycode = KeyEvent.VK_7;
				break;
			case '8':
				keycode = KeyEvent.VK_8;
				break;
			case '9':
				keycode = KeyEvent.VK_9;
				break;

			case '!':
				keycode = KeyEvent.VK_1;
				break;
			case '@':
				keycode = KeyEvent.VK_2;
				break;
			case '#':
				keycode = KeyEvent.VK_3;
				break;
			case '$':
				keycode = KeyEvent.VK_4;
				break;
			case '%':
				keycode = KeyEvent.VK_5;
				break;
			case '^':
				keycode = KeyEvent.VK_6;
				break;
			case '&':
				keycode = KeyEvent.VK_7;
				break;
			case '*':
				keycode = KeyEvent.VK_8;
				break;
			case '(':
				keycode = KeyEvent.VK_9;
				break;
			case ')':
				keycode = KeyEvent.VK_0;
				break;
			case '.':
				keycode = KeyEvent.VK_PERIOD;
				break;
			case '/':
				keycode = KeyEvent.VK_SLASH;
				break;
			case '-':
				keycode = KeyEvent.VK_MINUS;
				break;
			case '_':
				keycode = KeyEvent.VK_MINUS;
				break;
			case ' ':
				keycode = KeyEvent.VK_SPACE;
				break;
			}

			return keycode;
		}
	}
}
