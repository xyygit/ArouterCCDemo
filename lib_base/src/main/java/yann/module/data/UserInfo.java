package yann.module.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yayun.xia on 2018/11/9
 */
public class UserInfo implements Parcelable {

    public String username;
    public String bindPhone;
    public String sex;
    public String avatar;

    public UserInfo() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.username);
        dest.writeString(this.bindPhone);
        dest.writeString(this.sex);
        dest.writeString(this.avatar);
    }

    protected UserInfo(Parcel in) {
        this.username = in.readString();
        this.bindPhone = in.readString();
        this.sex = in.readString();
        this.avatar = in.readString();
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
}
