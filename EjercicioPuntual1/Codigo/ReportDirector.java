
public class ReportDirector {
	
	private IReportBuilder builder;
	
	ReportDirector(IReportBuilder b) {
		this.builder = b;
	}
	
	public void build() {
		this.builder.buildTittle();
		this.builder.buildHeader();
		this.builder.buildContent();
		this.builder.buildFooter();
	}

}
