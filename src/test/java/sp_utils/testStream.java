package sp_utils;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import com.sp.utils.StreamUtil;

public class testStream {
	
	@Test
	public void t() {
		InputStream stream = testStream.class.getResourceAsStream("/plan.txt");
		List<String> list = StreamUtil.readLine(stream);
		for (String string : list) {
			System.out.println(string);
		}
	}
}
