package shugal.com.msanjeevani;

/**
 * Created by Deepinder on 10/24/2015.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Friend {
    private int avatar;
    private String nickname;
    private int background;
    private String address;
    private String phone;

    public Friend(int avatar, String nickname, int background, String address, String phone) {
        this.avatar = avatar;
        this.nickname = nickname;
        this.address = address;
        this.phone = phone;
        this.background = background;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAddress() {

        return address;
    }


    public String getPhone() {
        return phone;
    }


    public int getBackground() {
        return background;
    }

}