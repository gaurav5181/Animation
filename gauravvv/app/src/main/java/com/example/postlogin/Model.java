package com.example.postlogin;

public class Model {


    private Integer connection;

    private Integer result;

    private Userdata userdata;

    public Integer getConnection() {
        return connection;
    }

    public void setConnection(Integer connection) {
        this.connection = connection;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Userdata getUserdata() {
        return userdata;
    }

    public void setUserdata(Userdata userdata) {
        this.userdata = userdata;
    }


    public class Userdata {


        private String id;

        private String name;

        private String email;

        private String password;

        public String getId() {
            return id;
        }

        public void setId(String id) {
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

    }
}