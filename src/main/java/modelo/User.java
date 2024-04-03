package modelo;

public class User {
    private int id;
    private String name, email, password, created_at;

    public User() {}

    public User(int id, String name, String email, String password, String created_at) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String toString() {
        return "["
                    +
                        "ID: " + this.id + "\t" +
                        "Nombre:" + this.name + "\t"
                    +
                "]";
    }
}
