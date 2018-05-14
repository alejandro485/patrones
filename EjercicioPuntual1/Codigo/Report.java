import java.util.Enumeration;
import java.util.Vector;

public class Report implements IVisitable{

	private String tittle;
	private Vector content;
	private Vector header;
	private String footer;
	
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public Vector getHeader() {
		return header;
	}
	public void setHeader(Vector header) {
		this.header = header;
	}
	public Vector getContent() {
		return this.content;
	}
	public void setContent(Vector content) {
		this.content = content;
	}
	public String getFooter() {
		return footer;
	}
	public void setFooter(String footer) {
		this.footer = footer;
	}
	@Override
	public void accept(IVisitorDataReport vdr) {
		// TODO Auto-generated method stub
		Enumeration e = this.content.elements();
		while(e.hasMoreElements()) {
			IVisitable visitable = (IVisitable) e.nextElement();
			visitable.accept(vdr);
		}
	}
	
}
