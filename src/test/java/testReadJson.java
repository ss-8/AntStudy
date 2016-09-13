import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class testReadJson {

	@Test
	public void test() {
		File file = new File("D:\\Develop\\txt_file\\imagesJson.txt");
		String encoding = "UTF-8";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("D:\\Develop\\txt_file\\imagesList.txt")));
			InputStreamReader readtypes = new InputStreamReader(new FileInputStream(file), encoding);
			BufferedReader bufferedReader = new BufferedReader(readtypes);
			String lineTxt = null;
			Integer row = 0;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				System.out.println(lineTxt);
				JSONObject jsonObject=new JSONObject(lineTxt);
				JSONArray jsonArray=new JSONArray(jsonObject.get("dataValue").toString());
				for(Object j:jsonArray){
					JSONObject jo=(JSONObject)j;
					System.out.println(jo.get("name")+" "+jo.get("path"));
					writer.write(jo.get("name")+" "+jo.get("path")+"\n");
				}
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
