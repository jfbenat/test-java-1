//package fr.selfmed.test;
//
//import java.io.IOException;
//
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonDeserializer;
//
//public class AmountDeserializer extends JsonDeserializer<String> {
//
//	@Override
//	public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
//		String str = p.getText();
//		Double amountDouble = Double.parseDouble(str);
//		 = amountDouble < 0 ? amountDouble * -1 : 0;
//		 = amountDouble > 0 ? amountDouble : 0;
//
//}
