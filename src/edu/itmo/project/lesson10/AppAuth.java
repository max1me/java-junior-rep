package edu.itmo.project.lesson10;

public non-sealed class AppAuth implements Auth {
/*public sealed class AppAuth implements Auth permits FormAuth {*/
/*public final class AppAuth implements Auth {*/
    @Override
    public boolean login(String username, String password) {
      return false;
    }

    @Override
    public boolean logout() {
        return false;
    }
}