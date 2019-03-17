package wen.animal.tools;

import java.io.File;
import java.io.IOException;

public class Directory {
	public static String getPath(String path) throws IOException {
		File root = new File("");
		
		return root.getCanonicalFile() + path;
	}
	
}
