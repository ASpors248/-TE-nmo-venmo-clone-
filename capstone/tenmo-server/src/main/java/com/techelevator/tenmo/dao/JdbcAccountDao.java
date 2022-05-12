package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;

@Component
public class JdbcAccountDao implements AccountDao{

    private BigDecimal balance;
    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao (DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public BigDecimal getBalance(String userName) {
        long userId = getUserIdByUserName(userName);

        String sql = "SELECT balance FROM account " +
                "JOIN tenmo_user ON account.user_id = tenmo_user.user_id " +
                "WHERE account.user_id = ? ;";

        BigDecimal balance = jdbcTemplate.queryForObject(sql,BigDecimal.class, userId);

        return balance;
    }

    @Override
    public BigDecimal transferTo() {
                return null;
    }

    public long getAccountIdByUserId (long UserId) {
        String sql = "SELECT account_id FROM account WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql,long.class,UserId);

    }

    @Override
    public long getUserIdByAccountId(long accountId) {
        String sql = "SELECT user_id FROM account WHERE account_id = ?";
        return jdbcTemplate.queryForObject(sql,long.class,accountId);
    }

    @Override
    public long getUserIdByUserName (String userName) {    // this is used for the token authorization in getBalance
        String sql = "Select user_id FROM tenmo_user WHERE username = ? ";
        return jdbcTemplate.queryForObject(sql,long.class, userName);
    }

    @Override
    public String getUsernameByAccountID(long accountID) {
        String sql = "SELECT tenmo_user.username from account " +
         "JOIN tenmo_user ON account.user_id = tenmo_user.user_id " +
        "WHERE account_id = ?";
        return jdbcTemplate.queryForObject(sql,String.class,accountID);
    }

    private Account mapRowToAccount(SqlRowSet rs) {
        Account account = new Account();
        account.setAccountId(rs.getLong("account_id"));
        account.setUserId(rs.getLong("user_id"));
        account.setBalance(rs.getBigDecimal("balance"));
        return account;
    }

}
