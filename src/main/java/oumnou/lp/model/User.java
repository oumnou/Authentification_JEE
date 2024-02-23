package oumnou.lp.model;

import java.io.Serializable;
public class User implements Serializable{
    private String name;
    private String lastName;
    private String username;
    private String email;
    private String password;

    public User(String email,String password,String name,String lastName,String username){
        this.email=email;
        this.password=password;
        this.name=name;
        this.lastName=lastName;
        this.username=username;

    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getUsername() {
        return username;
    }

    public void setIdUsername(String username) {
        this.username = username;
    }


}
