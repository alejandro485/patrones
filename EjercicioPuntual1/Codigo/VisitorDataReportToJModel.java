import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class VisitorDataReportToJModel implements IVisitorDataReport{

	private DefaultTableModel model;
	
	VisitorDataReportToJModel(Vector headers) {
		this.model = new DefaultTableModel();
		this.model.setColumnIdentifiers(headers);
	}
	
	@Override
	public void visit(Course c) {
		// TODO Auto-generated method stub
		Vector row = new Vector();
		row.add(c.getCode());
		row.add(c.getName());
		row.add(c.getType());
		row.add(c.getCategory());
		this.model.addRow(row);
	}

	@Override
	public void visit(Student st) {
		// TODO Auto-generated method stub
		Vector row = new Vector();
		row.add(st.getCode());
		row.add(st.getFirstName());
		row.add(st.getLastName());
		row.add(st.getCareer());
		row.add(st.getSemesterAdmission());
		this.model.addRow(row);
	}
	
	public DefaultTableModel getModel() {
		return this.model;
	}

}
