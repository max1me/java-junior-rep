package edu.itmo.project.lesson10;

public sealed interface Auth
permits GAuth, AppAuth {
    boolean login(String username, String password);
    boolean logout();

    static Auth getAuth(String authType) {
        Auth auth;
        if (authType.equals("github")) {
            auth = new GAuth();
        } else {
            auth =new AppAuth();
        }
        return auth;
    }
}


