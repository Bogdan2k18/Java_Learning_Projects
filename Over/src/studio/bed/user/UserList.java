package studio.bed.user;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users = new ArrayList<>();

    public void Add(User user){
        users.add(user);
    }

    public static User Create(String name, int ID) {
       return new User(name, ID);

    }


    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean Remove(User user){
        for(User e : this.users){
            if(e.getID() == user.getID()){
                if(e.getName() == user.getName()) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean HasUser(User user) {
        for (User e : this.users) {
            if (e.getID() == user.getID()) {
                return true;
            }
        }
        return false;
    }

}
