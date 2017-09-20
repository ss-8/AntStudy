package com.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;
import org.junit.Test;

import com.aaa.json.AccessMessage;

public class testJson {

	@Test
	public void test() {
		AccessMessage am=new AccessMessage("aaaa","bbbb",1L);
		ObjectMapper mapper = new ObjectMapper();
		String json="";
		try {
			json = mapper.writeValueAsString(am);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
		AccessMessage am1=new AccessMessage();
		json="{\"token\":\"aaaa\",\"ip\":\"bbbb\",\"type\":1}";
		try {
			am1=mapper.readValue(json, AccessMessage.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(am1.getType());
		System.out.println(am1.getType()==null);
		System.out.println(json);
		
	}

}
