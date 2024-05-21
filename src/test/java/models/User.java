package models;

import java.util.Objects;

public class User {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String postalCode;

    public static class Builder {
        private User simpleUser;

        public Builder() {
            this.simpleUser = new User();
        }

        public Builder withUsername(String username) {
            simpleUser.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            simpleUser.password = password;
            return this;
        }

        public Builder withFirstName(String firstName) {
            simpleUser.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            simpleUser.lastName = lastName;
            return this;
        }

        public Builder withPostalCode(String postalCode) {
            simpleUser.postalCode = postalCode;
            return this;
        }

        public User build() {
            return simpleUser;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.
                equals(user.username) && password.equals(user.password)
                && firstName.equals(user.firstName) && lastName.equals(user.lastName)
                && postalCode.equals(user.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, firstName, lastName, postalCode);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
