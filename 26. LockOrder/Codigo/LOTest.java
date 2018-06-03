
public class LOTest extends Thread{
	private Directory source;
	private Directory destiny;
	private String name;
	private static FileSysUtil_Rev flur;

	public static void main(String[] args) {
		Directory src = new Directory("src");
		Directory des = new Directory("des");
		flur = new FileSysUtil_Rev();
		LOTest lOTest1 = new LOTest(src, des, "lOTest1");
		LOTest lOTest2 = new LOTest(src, des, "lOTest2");
		lOTest1.start();
		lOTest2.start();
	}
	
	public LOTest(Directory src,Directory des, String n) {
		source = src;
		destiny = des;
		name = n;
	}
	
	public void run() {
		System.out.println("->"+name);
		flur.moveContents(source, destiny);
	}

}
