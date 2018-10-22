package com.springtransaction.example;

import org.apache.commons.dbcp.BasicDataSource;

public class Test {

    public static final String jdbcDriver = "com.mysql.jdbc.Driver";
    public static final String jdbcURL = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false";
    public static final String userName = "root";
    public static final String password = "root";

    public static void main(String[] args) {
        BasicDataSource basicDataSouce = new BasicDataSource();

        basicDataSouce.setDriverClassName(jdbcDriver);
        basicDataSouce.setUsername(userName);
        basicDataSouce.setPassword(password);
        basicDataSouce.setUrl(jdbcURL);

        final UserService userService = new UserService(basicDataSouce);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                userService.action();
            }).start();

        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
