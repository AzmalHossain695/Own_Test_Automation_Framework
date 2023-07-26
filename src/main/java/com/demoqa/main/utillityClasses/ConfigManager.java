package com.demoqa.main.utillityClasses;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager {
	private static String browserName;
	private static List<String> chromeArgList;
	private static String url;
	private static String firefoxArg;
	private static int wait;
	
	static {
		try {
			FileReader reader = new FileReader(".\\src\\main\\resources\\configfiles\\configdata.json");
			JsonObject config = JsonParser.parseReader(reader).getAsJsonObject();
			browserName = config.get("browser").getAsString();
			JsonArray chromeArgArray = config.getAsJsonArray("chromearguments");
			chromeArgList = new ArrayList<String>();
			for (JsonElement argument : chromeArgArray) {
			    chromeArgList.add(argument.getAsString());
			}
			firefoxArg = config.get("firefoxarguments").getAsString();
			url = config.get("url").getAsString();
			wait = config.get("wait").getAsInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getBrowsername() {
		return browserName;
	}
	public static List<String> getChromeArgs() {
		return chromeArgList;
	}
	public static String getFirefoxArgs() {
		return firefoxArg;
	}
	public static String getUrl() {
		return url;
	}
	public static int getWait() {
		return wait;
	}
}
