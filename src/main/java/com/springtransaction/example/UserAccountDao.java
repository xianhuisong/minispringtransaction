package com.springtransaction.example;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class UserAccountDao {

    private DataSource dataSource;

    public UserAccountDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void buy() throws SQLException {
        Connection connection = SingleThreadConnectionHolder.getConnection(dataSource);

        System.out.println("当前用户购买线程:" + Thread.currentThread().getName() + ",使用管道(hashcode)" + connection.hashCode());
    }

}
