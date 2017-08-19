/*---------------------------------------------------------------------
 * Copyright (c) 2017, Harel Berger and Damir Bar. All rights reserved.
 * Do not alter or remove copyright notices or this header.
 * 
 * The following code is free to use. You are allowed to modify
 * any part of it.
 *----------------------------------------------------------------------*/

package coding;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 30-Jul-2017
 * 
 * <h1>JSON array to JSON object</h1>
 * 
 * <h3>A single-method class.</h3>
 * 
 * <p>
 * This class is a sophisticated JSON array-to-object converter. The program
 * takes a JSON array as an input, which includes user-names and passwords, and
 * outputs a JSON object which includes an array called "users" of users and
 * hashed passwords separated with colon.
 * </p>
 * 
 * 
 * This program includes only a single main method which relies on the fact that
 * the user has a JSON file within the coding folder called "j.json".
 * 
 * The program is specified to throw "FileNotFoundException" if the file is not
 * found.
 * 
 * The program is specified to throw "IOException" in case an error with
 * input/output occurs.
 * 
 * The program is specified to throw "ParseExecption" if there is an error
 * during parsing a JSON object or array.
 * 
 * @author Damir
 * @author Harel
 * @version 1.1
 * @see org.json.simple
 */

public class PasswordHasher {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		
		try {
			JSONParser parser	  = new JSONParser(); //  A parser which is able to read a JSON object or array.
			JSONObject jsonOutput = new JSONObject(); //  A JSON object to get the new arrangement to it.
			JSONArray outputArr   = new JSONArray();  //  An output JSON array to put the re-mapped items.
			
			//  A JSON array which will be re-mapped later to the output file.
			JSONArray inputArr    = (JSONArray) parser.parse(new FileReader("src/coding/j.json"));

			for (int i = 0; i < inputArr.size(); i++) {

				JSONObject t = (JSONObject) inputArr.get(i); //  A temporary JSON object meant to get information
															 //  from the input array and re-map it for the output.
				
				//  Adding to the output file an item according to description. ("username":"hashed-pass")
				outputArr.add(t.get("username").toString() + ":" + t.get("password").toString().hashCode());
			}
			
			
			//  After finishing iterating the input array, we out put the whole re-mapped array
			//  into the JSON output object.
			jsonOutput.put("users", outputArr);

			try (FileWriter file = new FileWriter("src/coding/users.json")) {
				
				//  Writing the JSON object to a file called "users.json". 
				file.write(jsonOutput.toJSONString());
			}
			
			//  Showing the result. (Non-mandatory)
			System.out.println("\nJSON Object: " + jsonOutput);

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
