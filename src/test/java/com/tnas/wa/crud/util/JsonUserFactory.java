package com.tnas.wa.crud.util;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonUserFactory {

	private static final String[][] usersData = {
		{ "Machado de Assis" , "159.753.852-22" },
		{ "Tarsila do Amaral" , "987.654.321-33" }
	};
	
	public static JSONObject getUser(Integer id) throws JSONException {
	
		if (id < 1 || id > usersData.length) {
			throw new IndexOutOfBoundsException("Invalid user ID");
		}
		
		--id;
		var jsonUser = new JSONObject();
		jsonUser.put("name", usersData[id][0]);
		jsonUser.put("document", usersData[id][1]);
		
		return jsonUser;
	}
}
