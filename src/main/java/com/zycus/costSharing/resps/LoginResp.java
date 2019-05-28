package com.zycus.costSharing.resps;

import com.zycus.costSharing.models.BaseResponse;

public class LoginResp extends BaseResponse {

    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}