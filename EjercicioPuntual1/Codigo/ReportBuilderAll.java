import java.util.StringTokenizer;
import java.util.Vector;

public class ReportBuilderAll implements IReportBuilder {

	private Report report;
	
	ReportBuilderAll() {
		this.report = new Report();
	}
	
	@Override
	public void buildTittle() {
		// TODO Auto-generated method stub
		this.report.setTittle("Toda la lista de informacion");
	}

	@Override
	public void buildHeader() {
		// TODO Auto-generated method stub
		Vector headers = new Vector();
		headers.add("Codigo");
		headers.add("Nombre");
		headers.add("Tipo");
		headers.add("Categoria");
		headers.add("Semestre");
		this.report.setHeader(headers);
	}

	@Override
	public void buildContent() {
		// TODO Auto-generated method stub
		Vector data = new Vector();
		FileUtil fileUtil = new FileUtil();
		
		Vector v1 = fileUtil.fileToVector("src/courses.txt");
		for (int i = 0; i < v1.size(); i++) {
			String str = (String) v1.elementAt(i);
			StringTokenizer st = new StringTokenizer(str, ",");
			data.add(new Course(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()));
		};
		
		Vector v2 = fileUtil.fileToVector("src/students.txt");
		for (int i = 0; i < v2.size(); i++) {
			String str = (String) v2.elementAt(i);
			StringTokenizer st = new StringTokenizer(str, ",");
			data.add(new Student(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()));
		}
		
		this.report.setContent(data);
	}

	@Override
	public void buildFooter() {
		// TODO Auto-generated method stub
		this.report.setFooter("Pie de pagina de toda la informacion");
	}

	@Override
	public Report getReport() {
		// TODO Auto-generated method stub
		return this.report;
	}

}
