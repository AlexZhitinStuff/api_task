package Resources;

public class Users {

    public static String createUser(){

        String res = "/api/users";
        return res;
    }

    public static String getUser(int id){
        String user_id = Integer.toString(id);

        String res = "/api/users/"+user_id;
        return res;
    }

    public static String updateUser(int id){
        String user_id = Integer.toString(id);

        String res = "/api/users/"+user_id;
        return res;
    }

    public static String deleteUser(int id){
        String user_id = Integer.toString(id);

        String res = "/api/users/"+user_id;
        return res;
    }




}
