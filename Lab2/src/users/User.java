package users;

import java.util.Arrays;
import java.util.Objects;

public class User implements Guest {
    private String login;
    private String password;
    private boolean[] rights;

    private String surname;
    private String position;

    public User(String login, String surname, String position) {
        this.login = login;
        rights = new boolean[]{true, true, true, false};
        this.surname = surname;
        this.position = position;
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

    public String getSurname(){
        return surname;
    }

    public String getPosition(){
        return position;
    }

    public void setLogin(String n){
        login = n;
    }

    public void setPassword(String s){
        password = s;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setPosition(String position){
        this.position = position;
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
        return "User{" +
                "login='" + getLogin() + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                ", rights=" + Arrays.toString(getRights()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Guest)) return false;
        Guest guest = (Guest) o;
        return Objects.equals(login, guest.getLogin());
    }
}