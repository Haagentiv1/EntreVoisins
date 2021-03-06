package com.openclassrooms.entrevoisins.ui.Profile_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileNeighbour extends AppCompatActivity {

    @BindView(R.id.Avatar)
    public ImageView mProfileNeighbourAvatar;
    @BindView(R.id.Name)
    public TextView mProfileNeighbourName;
    @BindView(R.id.BackMainActivityButton)
    public ImageButton mBackToMainActivity;
    @BindView(R.id.AboutMe)
    public TextView mAboutMe;
    @BindView(R.id.Name2)
    public TextView mNeighbourName2;
    @BindView(R.id.AddToFavorit)
    public FloatingActionButton mFavStar;
    @BindView(R.id.locationIcon)
    public ImageView mLocationIcon;
    @BindView(R.id.phoneIcon)
    public ImageView mPhoneIcon;
    @BindView(R.id.SocialIcon)
    public ImageView mSocialIcon;
    @BindView(R.id.locationID)
    public TextView mLocation;
    @BindView(R.id.phoneNumber)
    public TextView mPhoneNumber;
    @BindView(R.id.SocialMail)
    public TextView mFacebook;
    @BindView(R.id.AboutMeText)
    public TextView mAboutMeText;

    private NeighbourApiService mApiService;
    private Neighbour mNeighbour;

    private void getNeighbour() {
        Intent intent = getIntent();
        mNeighbour = intent.getParcelableExtra("Neighbour");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_details);
        mApiService = DI.getNeighbourApiService();
        ButterKnife.bind(this);
        getNeighbour();
        setLayoutDrawable();
        setFavStatus();
        mFavStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mNeighbour.isFavorites()) {
                    mApiService.addFavoritesOrRemove(mNeighbour);
                    mFavStar.setImageResource(R.drawable.ic_star_white_24dp);
                }else {
                    mApiService.addFavoritesOrRemove(mNeighbour);
                    mFavStar.setImageResource(R.drawable.ic_star_border_white_24dp);
                }
            }
        });

        mBackToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileNeighbour.this.finish();
            }
        });
    }

    private void setLayoutDrawable(){
        Glide.with(this).load(mNeighbour.getAvatarUrl()).into(mProfileNeighbourAvatar);
        mProfileNeighbourName.setText(mNeighbour.getName());
        mNeighbourName2.setText(mNeighbour.getName());
        mLocation.setText(mNeighbour.getUserLocation());
        mPhoneNumber.setText(mNeighbour.getPhoneNumber());
        mFacebook.setText(mNeighbour.getFacebookLink());
        mBackToMainActivity.setImageResource(R.drawable.ic_keyboard_backspace_24px);
        mLocationIcon.setImageResource(R.drawable.ic_room_24px);
        mPhoneIcon.setImageResource(R.drawable.ic_call_24px);
        mSocialIcon.setImageResource(R.drawable.ic_public_24px);
        mAboutMe.setText(R.string.title_about_me);
        mAboutMeText.setText(mNeighbour.getAboutMe());

    }
    public void setFavStatus() {
        if (!mNeighbour.isFavorites()) {
            mFavStar.setImageResource(R.drawable.ic_star_border_white_24dp);
        }else{
            mFavStar.setImageResource(R.drawable.ic_star_white_24dp);
        }
    }
}





