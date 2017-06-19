package per.cr.spider.douban.pojo;

public class ChartExample {
	private String colum_regix;
	private String colum_limit;
	private double start;
	private double end;
	private String regix;

	public void setLimit(String colum, double a, double b) {
		setColum_limit(colum);
		setStart(a);
		setEnd(b);
	}

	public void setRsgix(String colum, String regix) {
		setColum_regix(colum);
		setRegix(regix);
	}

	public double getStart() {
		return start;
	}

	public void setStart(double start) {
		this.start = start;
	}

	public double getEnd() {
		return end;
	}

	public void setEnd(double end) {
		this.end = end;
	}

	public String getRegix() {
		return regix;
	}

	public void setRegix(String regix) {
		this.regix = regix;
	}

	public String getColum_regix() {
		return colum_regix;
	}

	public void setColum_regix(String colum_regix) {
		this.colum_regix = colum_regix;
	}

	public String getColum_limit() {
		return colum_limit;
	}

	public void setColum_limit(String colum_limit) {
		this.colum_limit = colum_limit;
	}

}
