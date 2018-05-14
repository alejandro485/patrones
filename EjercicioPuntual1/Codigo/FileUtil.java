import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class FileUtil {
	public Vector fileToVector(String fileName) {
		Vector v = new Vector();
		String inputLine;
		try {
			File inFile = new File(fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));
			inputLine = br.readLine();
			
			while (inputLine != null) {
				v.addElement(inputLine);
				inputLine = br.readLine();
			}
			br.close();
		}
		catch (FileNotFoundException ex) {}
		catch (IOException ex) {}
		return v;
	}
}
