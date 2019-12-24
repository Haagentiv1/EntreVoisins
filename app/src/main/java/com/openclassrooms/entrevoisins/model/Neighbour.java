package com.openclassrooms.entrevoisins.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
public class Neighbour implements Parcelable {


    /** Identifier */
    private Integer id;

    /** Full name */
    private String name;

    /** Avatar */
    private String avatarUrl;
    /** Favorites status */
    private boolean favorites;
    /** User Location */
    private String userLocation;
    /** User Phone Number */
    private String phoneNumber;
    /** Facebook Link*/
    private String facebookLink;

    /**
     * Constructor
     * @param id
     * @param name
     * @param avatarUrl
     * @param userLocation
     */
    public Neighbour(Integer id, String name, String avatarUrl, Boolean favorites, String userLocation,String phoneNumber, String facebookLink) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.favorites = favorites;
        this.userLocation = userLocation;
        this.phoneNumber = phoneNumber;
        this.facebookLink = facebookLink;
    }

    protected Neighbour(Parcel in) {
        id = in.readInt();
        name = in.readString();
        avatarUrl = in.readString();
        favorites = in.readByte() != 0;
        userLocation = in.readString();
        phoneNumber = in.readString();
        facebookLink = in.readString();
    }

    public static final Creator<Neighbour> CREATOR = new Creator<Neighbour>() {
        @Override
        public Neighbour createFromParcel(Parcel in) {

            return new Neighbour(in);
        }

        @Override
        public Neighbour[] newArray(int size) {
            return new Neighbour[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public boolean isFavorites() { return favorites; }



    public void setFavorites(boolean favorites) {
        this.favorites = favorites;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = (Neighbour) o;
        return Objects.equals(id, neighbour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(avatarUrl);
        dest.writeByte((byte) (favorites ? 1 : 0));
        dest.writeString(userLocation);
        dest.writeString(phoneNumber);
        dest.writeString(facebookLink);
    }



}
