import java.util.StringTokenizer;
import java.util.Vector;

public class ReportBuilderCourses implements IReportBuilder {

	private Report reportCourses;
	
	ReportBuilderCourses() {
		this.reportCourses = new Report();
	}
	
	@Override
	public void buildTittle() {
		// TODO Auto-generated method stub
		this.reportCourses.setTittle("Reporte de asignaturas");
	}

	@Override
	public void buildHeader() {
		// TODO Auto-generated method stub
		Vector headers = new Vector();
		headers.add("Codigo");
		headers.add("Nombre");
		headers.add("Tipo");
		headers.add("Categoria");
		this.reportCourses.setHeader(headers);
	}

	@Override
	public void buildContent() {
		// TODO Auto-generated method stub
		FileUtil fileUtil = new FileUtil();
		Vector v = fileUtil.fileToVector("src/courses.txt");
		Vector data = new Vector();
		for (int i = 0; i < v.size(); i++) {
			String str = (String) v.elementAt(i);
			StringTokenizer st = new StringTokenizer(str, ",");
			data.add(new Course(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()));
		};
		this.reportCourses.setContent(data);
	}

	@Override
	public void buildFooter() {
		// TODO Auto-generated method stub
		this.reportCourses.setFooter("Pie de pagina de reporte de asignaturas");
	}

	@Override
	public Report getReport() {
		// TODO Auto-generated method stub
		return this.reportCourses;
	}

}
