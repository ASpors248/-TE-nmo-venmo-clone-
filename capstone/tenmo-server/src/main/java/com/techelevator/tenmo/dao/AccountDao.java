package com.techelevator.tenmo.dao;

import java.math.BigDecimal;

public interface AccountDao {


    BigDecimal getBalance(String userName);

    BigDecimal transferTo();

    long getUserIdByUserName(String userName);

    public long getAccountIdByUserId(long UserId);

    public long getUserIdByAccountId(long accountId);

    public String getUsernameByAccountID(long accountID);
}
