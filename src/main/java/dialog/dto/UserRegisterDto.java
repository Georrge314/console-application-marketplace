package dialog.dto;

public class UserRegisterDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String pictureUrl; // optional

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserRegisterDto{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        if (pictureUrl != null) {
            sb.append(", pictureUrl='").append(pictureUrl).append('\'');
        }
        sb.append('}');
        return sb.toString();
    }

    public boolean isEmpty() {
        return firstName == null && lastName == null &&
                username == null && email == null &&
                password == null && pictureUrl == null;
    }
}
