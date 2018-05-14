
public class Course implements IVisitable {
	private String name;
	private String code;
	private String type;
	private String category;
	Course(String _code, String _name, String _type, String _category) {
		this.code = _code;
		this.name = _name;
		this.type = _type;
		this.category = _category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public void accept(IVisitorDataReport vdr) {
		// TODO Auto-generated method stub
		vdr.visit(this);
	}
}
