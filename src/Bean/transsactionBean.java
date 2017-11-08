package Bean;

import java.math.BigDecimal;
import java.sql.Date;

public class transsactionBean {
	private String transsaction;
	private String Taccount;
	private String Type;
	private BigDecimal Tmoney;
	private String Tfee;
	private Date Ttime;
	private String TargetAccount;
	
	public String getTargetAccount() {
		return TargetAccount;
	}
	public void setTargetAccount(String targetAccount) {
		TargetAccount = targetAccount;
	}
	public String getTranssaction() {
		return transsaction;
	}
	public void setTranssaction(String transsaction) {
		this.transsaction = transsaction;
	}
	public String getTaccount() {
		return Taccount;
	}
	public void setTaccount(String taccount) {
		Taccount = taccount;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public BigDecimal getTmoney() {
		return Tmoney;
	}
	public void setTmoney(BigDecimal bigDecimal) {
		Tmoney = bigDecimal;
	}
	public String getTfee() {
		return Tfee;
	}
	public void setTfee(String tfee) {
		Tfee = tfee;
	}
	public Date getTtime() {
		return Ttime;
	}
	public void setTtime(Date ttime) {
		Ttime = ttime;
	}

	
	

}
