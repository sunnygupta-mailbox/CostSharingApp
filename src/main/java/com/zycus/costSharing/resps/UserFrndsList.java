package com.zycus.costSharing.resps;

import com.zycus.costSharing.models.BaseResponse;

import java.util.List;

public class UserFrndsList extends BaseResponse {

    private List<String> FriendsList;

    public List<String> getFriendsList() {
        return FriendsList;
    }

    public void setFriendsList(List<String> friendsList) {
        FriendsList = friendsList;
    }
}
