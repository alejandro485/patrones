
public class Student implements IVisitable{
	private String firstName;
	private String lastName;
	private String code;
	private String career;
	private String semesterAdmission;
	Student(String _code, String _firstName, String _lastName, String _career, String _semesterAdmission) {
		this.code = _code;
		this.firstName = _firstName;
		this.lastName = _lastName;
		this.career = _career;
		this.semesterAdmission = _semesterAdmission;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getSemesterAdmission() {
		return semesterAdmission;
	}
	public void setSemesterAdmission(String semesterAdmission) {
		this.semesterAdmission = semesterAdmission;
	}
	@Override
	public void accept(IVisitorDataReport vdr) {
		// TODO Auto-generated method stub
		vdr.visit(this);
	}
}
