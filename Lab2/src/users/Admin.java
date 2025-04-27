package users;

import java.util.Arrays;
import java.util.Objects;

public class Admin implements Guest {
    private String login;
    private String password;
    private boolean[] rights;

    private String additionalPassword;

    public Admin(String login, String additionalPassword) {
        this.login = login;
        rights = new boolean[]{true, true, true, true};
        this.additionalPassword = additionalPassword;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean[] getRights() {
        return Arrays.copyOf(rights, rights.length);
    }

    public void setLogin(String n){
        login = n;
    }

    public void setPassword(String s){
        password = s;
    }

    public void setRights(boolean[] rights) {
        this.rights = Arrays.copyOf(rights, rights.length);
    }

    public String getAdditionalPassword(){
        return additionalPassword;
    }

    public void setAdditionalPassword(String password){
        additionalPassword = password;
    }

    public boolean login(){
        System.out.println("User " + login + " logged in successfully.");
        return true;
    }

    public boolean outLog(){
        System.out.println("User " + login + " logged out successfully.");
        return true;
    }

    public boolean load_File(){
        System.out.println("Loaded info from file successfully.");
        return true;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "login='" + getLogin() + '\'' +
                ", rights=" + Arrays.toString(getRights()) +
                ", additionalPassword='" + additionalPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Guest)) return false;
        Guest guest = (Guest) o;
        return Objects.equals(login, guest.getLogin());
    }
}