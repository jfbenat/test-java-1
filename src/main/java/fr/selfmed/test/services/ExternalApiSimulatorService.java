package fr.selfmed.test.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
/*
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
*/
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.xml.bind.JAXB;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.selfmed.test.model.MyRoot;
import fr.selfmed.test.model.MyTransaction;

@Service
public class ExternalApiSimulatorService {
    //public String callApi(String URI) {
    public String callApi(String uri) throws IOException, InterruptedException {
        String apiResponse = "";

        //TODO
        // Source : http://zetcode.com/java/getpostrequest/
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        apiResponse = response.body();
        
        return apiResponse;
    }

	public String getAsJsonFormat(String xmlInput) throws ParseException {
		String output = "";
	    // Source : https://www.novixys.com/blog/convert-xml-json/
		MyRoot root = JAXB.unmarshal(new StringReader(xmlInput), MyRoot.class);
		Double amountDouble;
		Double debit;
		Double credit;
		for (MyTransaction myTransaction : root.getTransactions()) {
			/*
			DecimalFormat df = new DecimalFormat(",##");
			DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance();
			dfs.setDecimalSeparator('.');
			dfs.setGroupingSeparator(',');
			df.setDecimalFormatSymbols(dfs);
			amountDouble = Double.parseDouble(df.format(myTransaction.getAmount()));
			*/
			NumberFormat nfIn = NumberFormat.getNumberInstance(Locale.FRANCE);
			double amountFR = nfIn.parse(myTransaction.getAmount()).doubleValue();
			NumberFormat nfOut = NumberFormat.getNumberInstance(Locale.UK);
			nfOut.setMaximumFractionDigits(2);
			amountDouble = Double.parseDouble(nfOut.format(amountFR));
			debit = amountDouble < 0 ? amountDouble * -1 : 0;
			credit = amountDouble > 0 ? amountDouble : 0;
			myTransaction.setDebit(debit);
			myTransaction.setCredit(credit);
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			output = mapper.writeValueAsString(root);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}

	public String getAsSelfmedFormat(String xmlInput) {
		String output = "";
		MyRoot root = JAXB.unmarshal(new StringReader(xmlInput), MyRoot.class);
		for (MyTransaction myTransaction : root.getTransactions()) {
			output += myTransaction.toString();
		}
		return output;
	}
}