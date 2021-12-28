package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccoutServiceImlp implements AccountService {
    private final Map<String, UserProfile> signedUpUsers = new ConcurrentHashMap<>();

    @Override
    public boolean signIn(String login, String password) {
        UserProfile profile = signedUpUsers.get(login);
        return profile != null && profile.getPassword().equals(password);
    }

    @Override
    public void signUp(String login, String password) {
        signedUpUsers.put(login, new UserProfile(login, password));
    }
}
