package com.demoqa.main.utillityClasses;

import org.json.JSONArray;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.HashMap;
import org.json.JSONObject;
import java.util.ArrayList;

public class TestDataManager {	
	private JSONArray tableData;
	private Map<String, List<JSONObject>> userData;
	private String expectedAlertTextClickButtonToSeeAlert;
	private String expectedConfirmBoxAlertText;
	private String expectedConfirmBoxTextOnPage;
	private String expectedPromptAlertText;
	private String expectedIFrameText;

	public TestDataManager() {		
		FileReader fileReader;
		try {
			fileReader = new FileReader(".\\src\\test\\resources\\testdatafiles\\testdata.json");
			StringBuilder stringBuilder = new StringBuilder();
			int character;
			while ((character = fileReader.read()) != -1) {
				stringBuilder.append((char) character);
			}
			String jsonData = stringBuilder.toString();
			fileReader.close();
			JSONObject jsonObject = new JSONObject(jsonData);
			JSONObject expectedStrings = jsonObject.getJSONObject("expectedStrings");
            expectedAlertTextClickButtonToSeeAlert = expectedStrings.getString("expectedAlertTextClickButtonToSeeAlert");
            expectedConfirmBoxAlertText = expectedStrings.getString("expectedConfirmBoxAlertText");
            expectedConfirmBoxTextOnPage = expectedStrings.getString("expectedConfirmBoxTextOnPage");
            expectedPromptAlertText = expectedStrings.getString("expectedPromptAlertText");
            expectedIFrameText = expectedStrings.getString("expectedIFrameText");
			tableData = jsonObject.getJSONArray("table");
			userData = new HashMap<>();
            for (int i = 0; i < tableData.length(); i++) {
                JSONObject user = tableData.getJSONObject(i);
                String userId = Integer.toString(user.getInt("user"));
                List<JSONObject> userList = userData.getOrDefault(userId, new ArrayList<JSONObject>());
                userList.add(user);
                userData.put(userId, userList);
            }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getExpectedAlertTextClickButtonToSeeAlert() {
		return expectedAlertTextClickButtonToSeeAlert;
	}
	public String getExpectedConfirmBoxAlertText() {
		return expectedConfirmBoxAlertText;
	}
	public String getExpectedConfirmBoxTextOnPage() {
		return expectedConfirmBoxTextOnPage;
	}
	public String getExpectedPromptAlertText() {
		return expectedPromptAlertText;
	}
	public String getExpectedIframeText() {
		return expectedIFrameText;
	}
	public String getRandomText() {
		String inputRandomText = UUID.randomUUID().toString();
		return inputRandomText;
	}
	public JSONObject getUserData(int userIndex) {
		return tableData.getJSONObject(userIndex);
	}
	public Map<String, List<JSONObject>> getUserDataList() {
		return userData;
	}
	public int getNumberOfUsers() {
		return userData.size();
	}	
}
