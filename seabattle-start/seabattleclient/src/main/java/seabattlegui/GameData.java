package seabattlegui;

import models.User;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class GameData {

    private ArrayList<User> users;

    public GameData(){
        users = new ArrayList<User>();
    }

    public User addUser(String username, String password, ISeaBattleGUI application, boolean singleplayer){
        User user = new User(username, password, application, singleplayer);
        user.id = users.size()+1;
        users.add(user);
        return user;
    }
    public User getUser(int id){
        User returningUser = null;
        for (User user: users) {
            if(user.id == 1){
                returningUser = user;
            }
        }
        return returningUser;
    }
}
