package per.cr.spider.meituan.pojo;

import java.io.Serializable;

public class Shop implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer sid;

	private String sname;

	private String sphone;

	private Double sgrade;

	private String stype;

	private Integer sregion;

	private Integer srode;

	private String saddress;

	private String slink;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Double getSgrade() {
		return sgrade;
	}

	public void setSgrade(Double sgrade) {
		this.sgrade = sgrade;
	}

	public Integer getSregion() {
		return sregion;
	}

	public void setSregion(Integer sregion) {
		this.sregion = sregion;
	}

	public Integer getSrode() {
		return srode;
	}

	public void setSrode(Integer srode) {
		this.srode = srode;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress == null ? null : saddress.trim();
	}

	public String getSlink() {
		return slink;
	}

	public void setSlink(String slink) {
		this.slink = slink == null ? null : slink.trim();
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
}