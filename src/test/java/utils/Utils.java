package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static void saveEmployee(String firstName, String middleName, String lastName, String userName, String password, String confirmPassword) throws IOException, ParseException {
        String filePath="src/test/resources/employee.json";
        JSONParser parser=new JSONParser();
        JSONArray lastEmployeeArray= (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject lastNameObject=new JSONObject();
        lastNameObject.put("FirstName",firstName);
        lastNameObject.put("MiddleName",middleName);
        lastNameObject.put("LastName",lastName);
        lastNameObject.put("UserName",userName);
        lastNameObject.put("Password",password);
        lastNameObject.put("ConfirmPassword",confirmPassword);
        lastEmployeeArray.add(lastNameObject);

        FileWriter writer=new FileWriter(filePath);
        writer.write(lastEmployeeArray.toJSONString());
        writer.flush();
        writer.close();
    }

    public static JSONObject getEmployee() throws IOException, ParseException {
        String filePath="./src/test/resources/employee.json";
        JSONParser parser=new JSONParser();
        JSONArray EmployeeData= (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject lastEmployeeData= (JSONObject) EmployeeData.get(EmployeeData.size()-1);
        return lastEmployeeData;
    }
}
