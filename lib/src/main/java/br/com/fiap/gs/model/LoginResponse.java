package br.com.fiap.gs.model;

public class LoginResponse {
    private TokenJwt token;
    private int userId;

    public LoginResponse () {}

    public LoginResponse(TokenJwt token, int userId) {
        this.token = token;
        this.userId = userId;
    }

    public TokenJwt getToken() {
        return token;
    }

    public void setToken(TokenJwt token) {
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}