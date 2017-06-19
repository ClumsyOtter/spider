package per.cr.spider.meituan.pojo;

import java.io.Serializable;

public class Regoin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer rid;

	private String sname;

	private Integer rfaid;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname == null ? null : sname.trim();
	}

	public Integer getRfaid() {
		return rfaid;
	}

	public void setRfaid(Integer rfaid) {
		this.rfaid = rfaid;
	}
}