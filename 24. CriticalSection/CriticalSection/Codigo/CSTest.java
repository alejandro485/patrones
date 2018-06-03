
public class CSTest extends Thread {
	private FileLogger fl;

	public static void main(String[] args) {
		CSTest csTest1 = new CSTest();
		CSTest csTest2 = new CSTest();
		csTest1.start();
		csTest2.start();
	}

	public void run() {
		fl = FileLogger.getFileLogger();
		fl.log("mensaje");
		System.out.println("Mensaje guardado");
	}
	
}
