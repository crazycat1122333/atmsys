package Bean;

import java.sql.Date;

public class accountBean {
	private String Uaccount;
	private String Uname;
	private String Upassword;
	private Date Uopentime;
	private String Uopencity;
	private String Ustatus;
	private double Ubalance;
	private String Utype;
	private double Uover;
	private boolean Usalesstatus;
	private int UgetMax;
	private double UtransferMax;
	private String Ubanktype;
	public int getUgetMax() {
		return UgetMax;
	}
	public void setUgetMax(int ugetMax) {
		UgetMax = ugetMax;
	}
	public double getUtransferMax() {
		return UtransferMax;
	}
	public void setUtransferMax(double utransferMax) {
		UtransferMax = utransferMax;
	}
	
	/*public accountBean(String Uaccount, String Uname, String Upassword,
			Date Uopentime, String Uopencity, String Ustatus, double Ubalance,
			double Uavailablebalance, double Ulimite, String Utype, String Uover,
			boolean Usalesstatus) {
		this.Uaccount=Uaccount;
		this.Uname=Uname;
		this.Upassword=Upassword;
		this.Uopentime=Uopentime;
		this.Uopencity=Uopencity;
		this.Ustatus=Ustatus;
		this.Ubalance=Ubalance;
		this.Uavailablebalance=Uavailablebalance;
		this.Ulimite=Ulimite;
		this.Utype=Utype;
		this.Uover=Uover;
		this.Usalesstatus=Usalesstatus;
		
		
		
	}*/
	public void check(String id,String pwd){
		
		
	}
	public String getUaccount() {
		return Uaccount;
	}
	public void setUaccount(String uaccount) {
		Uaccount = uaccount;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getUpassword() {
		return Upassword;
	}
	public void setUpassword(String upassword) {
		Upassword = upassword;
	}
	public Date getUopentime() {
		return Uopentime;
	}
	public void setUopentime(Date uopentime) {
		Uopentime = uopentime;
	}
	public String getUopencity() {
		return Uopencity;
	}
	public void setUopencity(String uopencity) {
		Uopencity = uopencity;
	}
	public String getUstatus() {
		return Ustatus;
	}
	public void setUstatus(String ustatus) {
		Ustatus = ustatus;
	}
	public double getUbalance() {
		return  Ubalance;
	}
	public void setUbalance(double ubalance) {
		Ubalance = ubalance;
	}
	
	
	public String getUtype() {
		return Utype;
	}
	public void setUtype(String utype) {
		Utype = utype;
	}
	public double getUover() {
		return Uover;
	}
	public void setUover(double d) {
		Uover = d;
	}
	public boolean isUsalesstatus() {
		return Usalesstatus;
	}
	public void setUsalesstatus(boolean usalesstatus) {
		Usalesstatus = usalesstatus;
	}
	public String getUbanktype() {
		return Ubanktype;
	}
	public void setUbanktype(String ubanktype) {
		Ubanktype = ubanktype;
	}

}
