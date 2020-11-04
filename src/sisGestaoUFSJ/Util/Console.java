package sisGestaoUFSJ.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

	@SuppressWarnings("finally")
	public static String readLine() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";

		try {
			s = br.readLine();
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid Format!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return s;
		}
	}

	public static void printf(String text) {
		System.out.printf(text);
	}

	public static void println(String text) {
		System.out.println(text);
	}
}
