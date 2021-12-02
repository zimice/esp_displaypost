package url;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class urlParser {
    public static boolean isValidinput_urlAddress(String input_url) {

		String zeroTo255 = "(\\d{1,2}|(0|1)\\" + "d{2}|2[0-4]\\d|25[0-5])";
		String regex = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;

		Pattern p = Pattern.compile(regex);
		if (input_url == null) {
			return false;
		}
		Matcher m = p.matcher(input_url);
		return m.matches();
	}
}
