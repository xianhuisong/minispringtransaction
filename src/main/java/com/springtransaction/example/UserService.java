package com.springtransaction.example;

import javax.sql.DataSource;

public class UserService {

    private UserAccountDao userAccountDao;
    private UserOrderDao userOrderDao;
    private TransactionManager transactionManager;

    public UserService(DataSource dataSource) {
        this.userAccountDao = new UserAccountDao(dataSource);
        this.userOrderDao = new UserOrderDao(dataSource);
        this.transactionManager = new TransactionManager(dataSource);
    }

    public void action() {

        try {
            transactionManager.start();
            userAccountDao.buy();
            userOrderDao.order();
            transactionManager.close();
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback();
        }
    }
}
