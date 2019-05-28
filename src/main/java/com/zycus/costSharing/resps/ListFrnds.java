package com.zycus.costSharing.resps;

import com.zycus.costSharing.models.BaseResponse;

import java.util.List;

public class ListFrnds extends BaseResponse {

    private List<FindFrnds> friends;

    public List<FindFrnds> getFriends() {
        return friends;
    }

    public void setFriends(List<FindFrnds> friends) {
        this.friends = friends;
    }

}