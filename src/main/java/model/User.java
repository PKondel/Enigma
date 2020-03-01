package model;

public class User {
    private String login;
    private String password;
    private String email;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class UserBuilder {
        private String login;
        private String password;
        private String email;

        public UserBuilder buildLogin(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder buildPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder buildEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            User user = new User();
            user.setLogin(this.login);
            user.setPassword(this.password);
            user.setEmail(this.email);
            return user;
        }
    }
}
