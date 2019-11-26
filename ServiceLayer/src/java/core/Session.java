package core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Session {

    private String currentUser;
    private boolean isLoggedIn;

    public Session() {
        currentUser = "";
        isLoggedIn = false;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public boolean isUserLoggedIn() {
        return isLoggedIn;
    }

    public void login(String userid, String password, ServletContext c) throws FileNotFoundException, IOException, ParseException {
        try {
            boolean done = false;
//            Object myObject = new JSONParser().parse(new FileReader("C:\\Users\\Maximilien Fathi\\Documents\\SOEN 387\\Assignment 2\\src\\conf\\users.json"));
            Object myObject = new JSONParser().parse(new FileReader(c.getRealPath(c.getInitParameter("users"))));
            JSONObject myJSONObject = (JSONObject) myObject;
            JSONArray myJSONArray = (JSONArray) myJSONObject.get("users");
            Iterator it = myJSONArray.iterator();
            Iterator<Map.Entry> myIterator = null;
            while (it.hasNext() && !done) {
                myIterator = ((Map) it.next()).entrySet().iterator();
                boolean isFound = false;
                while (myIterator.hasNext() && !done) {
                    Map.Entry userInfo = myIterator.next();
                    if (userInfo.getValue().toString().equals(password) && !isFound) {
                        isFound = true;
                    } else if (isFound && userInfo.getValue().toString().equals(userid)) {
                        this.isLoggedIn = true;
                        this.currentUser = userid;
                        break;
                    } else {
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void logout() {
        currentUser = "";
        isLoggedIn = false;
    }
}
