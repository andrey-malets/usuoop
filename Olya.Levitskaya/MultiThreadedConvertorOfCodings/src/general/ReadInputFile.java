package general;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadInputFile {

	public static void dumpStreamFast(InputStream is) throws IOException {
		byte[] buffer = new byte[1000];
		while (is.available() > 0) {
			int iCount = is.read(buffer);
			if (iCount > 0) {
				for (int iIdx = 0; iIdx < iCount; iIdx++) {
					System.out.println(Integer.toHexString(iIdx));
				}
			}

		}
	}

	public static void test(String args) {
		File file = new File(args);
		try {
			InputStream is = new FileInputStream(file);
			try {
				BufferedInputStream bis = new BufferedInputStream(is);
				try {
					dumpStreamFast(bis);
				} finally {
					bis.close();
				}
			} finally {
				is.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}