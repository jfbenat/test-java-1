package fr.selfmed.test.model;
import javax.xml.bind.annotation.XmlAccessorType;
/*
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
*/
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class MyTransaction {
	
	@XmlAttribute
	private int id;
	@XmlAttribute
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = JsonFormat.DEFAULT_TIMEZONE)
    private Date date;
	@JsonIgnore
	private String amount;
	//@JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = ".##")
	private Double debit;
	//@JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = ".##")
	private Double credit;
	private String label;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
		/*
		DecimalFormat df = new DecimalFormat("###.##0,00");
		DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance();
		dfs.setDecimalSeparator('.');
		dfs.setGroupingSeparator(',');
		df.setDecimalFormatSymbols(dfs);
		this.amount = Double.parseDouble(df.format(amount));
		*/
		/*
		System.out.println(amount);
		Double amountDouble = Double.parseDouble(amount);
		this.debit = amountDouble < 0 ? amountDouble * -1 : 0;
		this.credit = amountDouble > 0 ? amountDouble : 0;
		*/
		/*
		this.debit = this.amount < 0 ? this.amount * -1 : 0;
		this.credit = this.amount > 0 ? this.amount : 0;
		*/
	}
	public Double getDebit() {
		return debit;
	}
	public void setDebit(Double debit) {
		this.debit = debit;
		//this.debit = debit < 0 ? debit * -1 : 0;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
		//this.credit = credit > 0 ? credit : 0;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "transaction:" +
				"\n	id: " + id +
				"\n	date: " + date +
				"\n	amount: " + amount +
				"\n	label: " + label + 
				"\n	status: " + status + "\n";
	}

}
