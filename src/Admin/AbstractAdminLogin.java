package Admin;

public abstract class AbstractAdminLogin implements AdminInterface {
    protected String adminUsername = "admin";
    protected String adminPassword = "admin123";

    @Override
    public boolean login(String username, String password) {
        return adminUsername.equals(username) && adminPassword.equals(password);
    }

    // Abstract method for additional admin functionality if needed
    public abstract void logout();
}
