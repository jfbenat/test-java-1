package fr.selfmed.test.model;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement(name = "root")
public class MyRoot {
	
	@XmlElement(name = "transaction")
	private List<MyTransaction> transactions = new ArrayList<MyTransaction>();

	public List<MyTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<MyTransaction> transactions) {
		this.transactions = transactions;
	}}
