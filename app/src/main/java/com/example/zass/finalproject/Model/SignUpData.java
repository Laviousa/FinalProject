package com.example.zass.finalproject.Model;

/**
 * Created by zass on 3/2/2019.
 */


public class SignUpData {
private String id;
    private String name;
    private String age;
    private String email;
    private String password;

public SignUpData(){};
public SignUpData(String id,String name, String age,String email, String password)

{
    this.id=id;
    this.name=name;
    this.age=age;
    this.email=email;
    this.password=password;


}

public String getId()
{
    return id;
}

public void setId(String id)
{
    this.id=id;
}

public String getName()
{
    return name;
}

public void setName(String name)
{
    this.name=name;
}

public String getAge()
{
    return age;
}

public void setAge()
{
    this.age=age;
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
}
