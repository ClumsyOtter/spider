package per.cr.spider.douban.pojo;

import java.io.Serializable;

public class Movie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6778864377310452163L;

	private Integer mid;

	private String mname;

	private String minfo;

	private Double mrate;

	private Integer mpls;

	private String slink;

	private Integer mdate;

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname == null ? null : mname.trim();
	}

	public String getMinfo() {
		return minfo;
	}

	public void setMinfo(String minfo) {
		this.minfo = minfo == null ? null : minfo.trim();
	}

	public Double getMrate() {
		return mrate;
	}

	public void setMrate(Double mrate) {
		this.mrate = mrate;
	}

	public Integer getMpls() {
		return mpls;
	}

	public void setMpls(Integer mpls) {
		this.mpls = mpls;
	}

	public String getSlink() {
		return slink;
	}

	public void setSlink(String slink) {
		this.slink = slink == null ? null : slink.trim();
	}

	public Integer getMdate() {
		return mdate;
	}

	public void setMdate(Integer mdate) {
		this.mdate = mdate;
	}
}