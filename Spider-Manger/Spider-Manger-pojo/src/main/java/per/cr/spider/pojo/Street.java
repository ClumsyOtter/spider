package per.cr.spider.pojo;

import java.io.Serializable;

public class Street implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer stid;

	private String stname;

	private Integer stfaid;

	public Integer getStid() {
		return stid;
	}

	public void setStid(Integer stid) {
		this.stid = stid;
	}

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname == null ? null : stname.trim();
	}

	public Integer getStfaid() {
		return stfaid;
	}

	public void setStfaid(Integer stfaid) {
		this.stfaid = stfaid;
	}
}