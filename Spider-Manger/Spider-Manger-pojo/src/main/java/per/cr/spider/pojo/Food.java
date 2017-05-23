package per.cr.spider.pojo;

import java.io.Serializable;
import java.util.Date;

public class Food implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer fid;

    private Integer fsid;

    private String fname;

    private Double fprice;

    private Integer fsale;

    private Date fdate;

    private String flink;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFsid() {
        return fsid;
    }

    public void setFsid(Integer fsid) {
        this.fsid = fsid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public Double getFprice() {
        return fprice;
    }

    public void setFprice(Double fprice) {
        this.fprice = fprice;
    }

    public Integer getFsale() {
        return fsale;
    }

    public void setFsale(Integer fsale) {
        this.fsale = fsale;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    public String getFlink() {
        return flink;
    }

    public void setFlink(String flink) {
        this.flink = flink == null ? null : flink.trim();
    }
}