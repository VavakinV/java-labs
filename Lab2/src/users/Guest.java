package users;

public interface Guest {
    String getLogin();
    String getPassword();
    boolean[] getRights();

    void setLogin(String n);
    void setPassword(String s);

    boolean login();
    boolean outLog();
    boolean load_File();
}
