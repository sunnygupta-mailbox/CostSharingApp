package com.zycus.costSharing.resps;

import com.zycus.costSharing.models.BaseResponse;

import java.util.List;


public class ExpenseList extends BaseResponse {


    private List<ExpenseResp> txns_list;

    public List<ExpenseResp> getTxns_list() {
        return txns_list;
    }

    public void setTxns_list(List<ExpenseResp> txns_list) {
        this.txns_list = txns_list;
    }

}