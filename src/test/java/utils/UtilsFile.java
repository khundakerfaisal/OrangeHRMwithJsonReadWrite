package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class UtilsFile {
    public static void saveEmployee(String userName,String password,String confirmPassword) throws IOException, ParseException {
        String filePath="src/test/resources/employee.json";
        JSONParser parser=new JSONParser();
        JSONArray addedEmployee= (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject addedEmpObject=new JSONObject();
        addedEmpObject.put("UserName",userName);
        addedEmpObject.put("Password",password);
        addedEmpObject.put("ConfirmPassword",confirmPassword);
        addedEmployee.add(addedEmpObject);
        FileWriter writer=new FileWriter(filePath);
        writer.write(addedEmployee.toJSONString());
        writer.flush();
        writer.close();

    }
    public static JSONObject getEmployee() throws IOException, ParseException {
        String filePath="src/test/resources/employee.json";
        JSONParser parser=new JSONParser();
        JSONArray lastAddedEmployee= (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject lastAddedObject= (JSONObject) lastAddedEmployee.get(lastAddedEmployee.size()-1);
        return lastAddedObject;
    }


//    public static void saveEmployee(String firstName, String middleName, String lastName, String userName, String password, String confirmPassword) throws IOException, ParseException {
//        String filePath="src/test/resources/employee.json";
//        JSONParser parser=new JSONParser();
//        JSONArray lastEmployeeArray= (JSONArray) parser.parse(new FileReader(filePath));
//        JSONObject lastNameObject=new JSONObject();
//        lastNameObject.put("FirstName",firstName);
//        lastNameObject.put("MiddleName",middleName);
//        lastNameObject.put("LastName",lastName);
//        lastNameObject.put("UserName",userName);
//        lastNameObject.put("Password",password);
//        lastNameObject.put("ConfirmPassword",confirmPassword);
//        lastEmployeeArray.add(lastNameObject);
//
//        FileWriter writer=new FileWriter(filePath);
//        writer.write(lastEmployeeArray.toJSONString());
//        writer.flush();
//        writer.close();
//    }
//
//    public static JSONObject getEmployee() throws IOException, ParseException {
//        String filePath="./src/test/resources/employee.json";
//        JSONParser parser=new JSONParser();
//        JSONArray EmployeeData= (JSONArray) parser.parse(new FileReader(filePath));
//        JSONObject lastEmployeeData= (JSONObject) EmployeeData.get(EmployeeData.size()-1);
//        return lastEmployeeData;
//    }
}
