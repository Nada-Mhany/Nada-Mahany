package Helpers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJson {

    //This class read the data in the json file
    public String firstName;
    public String surName;
    public String email;
    public String reenteremail;
    public String password;
    public String dateDay;
    public String dateMonth;
    public String dateYear;
    public String phoneNumber;

    public ReadJson() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        //The file path is in the helper package
        FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/accountCredentials/validAccounts.json");
        //Read JSON file
        Object obj = jsonParser.parse(reader);
        JSONObject datajsonoj= (JSONObject)obj;
        firstName = (String) datajsonoj.get("firstName");
        surName = (String) datajsonoj.get("surName");
        email = (String) datajsonoj.get("email");
        reenteremail = (String) datajsonoj.get("reenter_email");
        password = (String) datajsonoj.get("password");
        dateDay = (String) datajsonoj.get("dateDay");
        dateMonth = (String) datajsonoj.get("dateMonth");
        dateYear = (String) datajsonoj.get("dateYear");
        phoneNumber = (String) datajsonoj.get("phoneNumber");

    }
}
