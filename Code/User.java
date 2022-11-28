package Code;


/**
 * An class to store user information such as First Name and Email
 * @Author Mark.txt Andrey Rubio
 * */
public class User {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isAdmin() {

        return isAdmin;

    }
    public void setAdmin(boolean admin) {

        isAdmin = admin;

    }

    private String email;
    private String userName;
    private  boolean isAdmin;

    User(String email, String userName, Boolean Admin){
        this.email = email;
        this.userName = userName;
        this.isAdmin = Admin;
    }



}

