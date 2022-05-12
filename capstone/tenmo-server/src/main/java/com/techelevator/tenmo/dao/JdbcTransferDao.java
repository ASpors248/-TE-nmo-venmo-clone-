package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferDTO;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcTransferDao (DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Autowired
    private JdbcAccountDao jdbcAccountDao;

    @Override
    public long createTransferFromCurrentUser(Long UserIdTo, Long UserIdFrom, BigDecimal amount) {
        String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount) "
                + "VALUES (2,2,?,?,?) RETURNING transfer_id";
        long accountTo = jdbcAccountDao.getAccountIdByUserId(UserIdTo);
        long accountFrom = jdbcAccountDao.getAccountIdByUserId(UserIdFrom);
        long transferId = jdbcTemplate.queryForObject(sql,long.class,accountFrom,accountTo,amount);
        return transferId;
    }

    @Override
    public long createTransferRequest(Long UserIdTo, Long UserIdFrom, BigDecimal amount) {
        String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount) "
                + "VALUES (1,1,?,?,?) RETURNING transfer_id";
        long accountTo = jdbcAccountDao.getAccountIdByUserId(UserIdTo);
        long accountFrom = jdbcAccountDao.getAccountIdByUserId(UserIdFrom);
        Transfer transfer = jdbcTemplate.queryForObject(sql,Transfer.class,accountFrom,accountTo,amount);
        return transfer.getTransferId();
    }

    @Override
    public String getTransferStatusByTransferID(long transferId) {
        String sql = "SELECT transfer_status_desc FROM transfer_status "
                + "JOIN transfer ON transfer_status.transfer_status_id "
                + "= transfer.transfer_status_id WHERE transfer_id = ?";
        String transferStatus = jdbcTemplate.queryForObject(sql,String.class,transferId);

        return transferStatus;
    }

    @Override
    public BigDecimal subtractFromAccount(Long UserId, BigDecimal amount) {
        String sql = "update account set balance = balance - ? where user_id = ? RETURNING balance";
        BigDecimal balance = jdbcTemplate.queryForObject(sql,BigDecimal.class,amount,UserId);
        return balance;
    }

    @Override
    public BigDecimal addToAccount(Long UserId, BigDecimal amount) {
        String sql = "update account set balance = balance + ? where user_id = ? RETURNING balance;";
        BigDecimal balance = jdbcTemplate.queryForObject(sql,BigDecimal.class,amount,UserId);
        return balance;
    }

    @Override
    public List<TransferDTO> seeAllTransfers(Long accountId, Principal principal) {
        String sql = "SELECT account_from, account_to, transfer_id, transfer_type.transfer_type_desc, tenmo_user.username, amount FROM transfer" +
        " JOIN account ON transfer.account_from = account.account_id "+
        " JOIN tenmo_user ON account.user_id = tenmo_user.user_id " + "JOIN transfer_type ON transfer.transfer_type_id = transfer_type.transfer_type_id " +
         " WHERE account_from = ? OR account_to = ?;";
        List<TransferDTO> transfers = new ArrayList<>();
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, accountId, accountId);
        while (results.next()) {
            transfers.add(mapRowToTransferDTO(results, principal));
        }


        return transfers;
    }

    @Override
    public TransferDTO seeATransfer(long transferId) {
        TransferDTO transferDTO = new TransferDTO();
        String sql = "SELECT transfer_id, transfer_type_desc, transfer_status_desc, account_to, amount, username FROM transfer " +
                "JOIN account ON account.account_id = transfer.account_from" +
                " JOIN tenmo_user ON account.user_id =tenmo_user.user_id" +
                " JOIN transfer_status ON transfer_status.transfer_status_id = transfer.transfer_status_id" +
                " JOIN transfer_type ON transfer_type.transfer_type_id = transfer.transfer_type_id" +
                " WHERE transfer_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,transferId);
            if (results.next()) {
                transferDTO.setTransferId(results.getLong("transfer_id"));
                transferDTO.setTransferType(results.getString("transfer_type_desc"));
                transferDTO.setTransferStatus(results.getString("transfer_status_desc"));
                transferDTO.setAmount(results.getBigDecimal("amount"));
                transferDTO.setAccountToId(results.getLong("account_to"));
                transferDTO.setUserName(jdbcAccountDao.getUsernameByAccountID(transferDTO.getAccountToId()));
                transferDTO.setUserName2(results.getString("username"));
            }
        return transferDTO;


    }

    private Transfer mapRowToTransfer(SqlRowSet rs) {
        Transfer transfer = new Transfer();
        transfer.setTransferId(rs.getLong("transfer_id"));
        transfer.setTransferTypeId(rs.getInt("transfer_type_id"));
        transfer.setTransferStatusId(rs.getInt("transfer_status_id"));
        transfer.setAccountFromId(rs.getLong("account_from"));
        transfer.setAccountToId(rs.getLong("account_to"));
        transfer.setTransferAmount(rs.getBigDecimal("amount"));
        return transfer;
    }

    private TransferDTO mapRowToTransferDTO(SqlRowSet rs,Principal principal) {
        TransferDTO transfer = new TransferDTO();
        transfer.setTransferId(rs.getLong("transfer_id"));
        transfer.setTransferType(rs.getString("transfer_type_desc"));
        transfer.setAmount(rs.getBigDecimal("amount"));
        transfer.setAccountFromId(rs.getLong("account_from"));
        transfer.setAccountToId(rs.getLong("account_to"));
        if (transfer.getAccountFromId().equals(jdbcAccountDao.getAccountIdByUserId(jdbcAccountDao.getUserIdByUserName(principal.getName())))) {
            transfer.setFromCurrentUser(true);
        }

        if (transfer.getFromCurrentUser()) {
            transfer.setUserName(jdbcAccountDao.getUsernameByAccountID(transfer.getAccountToId()));
        } else {
            transfer.setUserName(rs.getString("username"));
        }

        return transfer;
    }

}

