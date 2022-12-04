public class Person {
    private String username;
    private String password;
    //private String email;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

//    public String getEmail() {
//        return email;
//    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
//        this.email = email;
    }

}
