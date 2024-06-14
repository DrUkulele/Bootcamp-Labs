package org.example;

import org.apache.commons.dbcp2.BasicDataSource;

public class SalesContractRepository {
    private BasicDataSource basicDataSource;
    public SalesContractRepository(String url, String userName, String password){
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
    }
}

