import java.util.StringTokenizer;
import java.util.Vector;

public class ReportBuilderStudents implements IReportBuilder {
	
	private Report reportStudents;
	
	ReportBuilderStudents() {
		this.reportStudents = new Report();
	}

	@Override
	public void buildTittle() {
		// TODO Auto-generated method stub
		this.reportStudents.setTittle("Reporte de estudiantes");
	}

	@Override
	public void buildHeader() {
		// TODO Auto-generated method stub
		Vector headers = new Vector();
		headers.add("Codigo");
		headers.add("Nombre");
		headers.add("Apellido");
		headers.add("Carrera");
		headers.add("Semestre");
		this.reportStudents.setHeader(headers);
	}

	@Override
	public void buildContent() {
		// TODO Auto-generated method stub
		FileUtil fileUtil = new FileUtil();
		Vector v = fileUtil.fileToVector("src/students.txt");
		Vector data = new Vector();
		for (int i = 0; i < v.size(); i++) {
			String str = (String) v.elementAt(i);
			StringTokenizer st = new StringTokenizer(str, ",");
			data.add(new Student(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()));
		}
		this.reportStudents.setContent(data);
	}

	@Override
	public void buildFooter() {
		// TODO Auto-generated method stub
		this.reportStudents.setFooter("Pie de pagina de reporte de estudiantes");
	}

	@Override
	public Report getReport() {
		// TODO Auto-generated method stub
		return this.reportStudents;
	}

}
