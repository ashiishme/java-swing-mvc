package Model;

import java.io.*;
import java.util.ArrayList;

public class Database {

    private ArrayList<User> userArrayList;

    public Database() {
        userArrayList = new ArrayList<>();
    }

    // adds user to our collection
    public void addUser(User user) {
        userArrayList.add(user);
    }

    // saves user to database file
    public void saveUser(File file) {
        try {
            // user model
            User user;
            String save_data = "";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            int i = 0;
            while( i < userArrayList.size()) {
                user = userArrayList.get(i);
                save_data = user.getFirstname() + ", " + user.getLastname();
                i++;
            }
            bufferedWriter.write(save_data);
            bufferedWriter.newLine();
            // prevents memory leak
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // reads user from database file
    public Object[] loadUsers(File file) {
        Object[] objects;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            // each lines to array
            objects = bufferedReader.lines().toArray();
            bufferedReader.close();
            return objects;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
