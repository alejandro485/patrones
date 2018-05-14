
public class BuilderFactory {

	public final static String NONE = "";
	public final static String STUDENTS = "Estudiantes";
	public final static String COURSES = "Cursos";
	public final static String ALL = "Todo";
	
	public IReportBuilder getReportBuilder(String selection) {
		if (selection.equals(BuilderFactory.STUDENTS)) {
			return new ReportBuilderStudents();
		} else {
			return new ReportBuilderCourses();
		}
	}
	
}
