package com.indstudy.nicholas.thegarage.HttpClasses;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.indstudy.nicholas.thegarage.LibraryObjects.Book;
import com.indstudy.nicholas.thegarage.LibraryObjects.FormatEnums.PrintFormat;
import com.indstudy.nicholas.thegarage.LibraryObjects.FormatEnums.VideoGameFormat;
import com.indstudy.nicholas.thegarage.LibraryObjects.VideoGame;
import com.indstudy.nicholas.thegarage.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddVideoGameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddVideoGameFragment extends Fragment implements Jsonable, AddItemActivity.OnSubmitButtonClickedListener {

    private AutoCompleteTextView mTitleTextView, mDeveloperTextView;
    private Spinner mFormatSpinner;
    private CheckBox mPlayed, mPlaying, mCompleted;
    private AddItemActivity parentActivity;

    public AddVideoGameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment AddVideoGameFragment.
     */
    public static AddVideoGameFragment newInstance() {
        AddVideoGameFragment fragment = new AddVideoGameFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parentActivity = (AddItemActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_video_game, container, false);
        mTitleTextView = (AutoCompleteTextView)view.findViewById(R.id.add_video_game_title);
        mDeveloperTextView = (AutoCompleteTextView)view.findViewById(R.id.add_video_game_developer);
        mFormatSpinner = (Spinner)view.findViewById(R.id.add_video_game_spinner);
        mFormatSpinner.setAdapter(new ArrayAdapter<>(view.getContext(),
                android.R.layout.simple_spinner_item, VideoGameFormat.values()));
        mPlayed = (CheckBox)view.findViewById(R.id.add_video_game_played_checkbox);
        mPlaying = (CheckBox)view.findViewById(R.id.add_video_game_playing_checkbox);
        mCompleted = (CheckBox)view.findViewById(R.id.add_video_game_completed_checkbox);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private VideoGame createVideoGame(){
        VideoGame videoGame = new VideoGame();
        videoGame.setUserEmail(parentActivity.mEmail);
        videoGame.setTitle(mTitleTextView.getText().toString());
        videoGame.setDeveloper(mDeveloperTextView.getText().toString());
        videoGame.setFormat((VideoGameFormat)mFormatSpinner.getSelectedItem());
        videoGame.setPlayed(mPlayed.isActivated());
        videoGame.setPlaying(mPlaying.isActivated());
        videoGame.setIsCompleted(mCompleted.isActivated());
        return videoGame;
    }

    @Override
    public String createJson(){
        Gson gson = new Gson();
        return gson.toJson(createVideoGame());
    }

    @Override
    public String onSubmitClicked() {
        return createJson();
    }
}
