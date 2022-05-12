package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferDTO;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

public interface TransferDao {

    public BigDecimal subtractFromAccount(Long UserId, BigDecimal amount);
    public BigDecimal addToAccount(Long UserId, BigDecimal amount);
    public List<TransferDTO> seeAllTransfers(Long accountId, Principal principal);
    public TransferDTO seeATransfer(long transferId);
    public long createTransferFromCurrentUser(Long UserIdTo, Long UserIdFrom, BigDecimal amount);
    public long createTransferRequest(Long UserIdTo, Long UserIdFrom, BigDecimal amount);
    public String getTransferStatusByTransferID(long transferId);



}
