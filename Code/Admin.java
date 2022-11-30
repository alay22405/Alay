package Code;


/**
 * A variation of the User class.  Has Administrative powers.
 * @Author Mark Andrey Rubio
 * */
public class Admin extends User{
    Admin(String email, String userName){
        super(email, userName, true);
    }

}
