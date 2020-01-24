package projDemo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ReadWriteIO {

	public static void write(String fileContent) {
		try (FileOutputStream fileOutputStream = new FileOutputStream("db.txt")) {
			fileOutputStream.write(fileContent.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String read() {
		String output = "";
		try (FileInputStream fileInputStream = new FileInputStream("db.txt")) {
			int ch = fileInputStream.read();
			while (ch != -1) {
				// System.out.print((char) ch);
				output += (char) ch;
				ch = fileInputStream.read();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Creating db file.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

}
