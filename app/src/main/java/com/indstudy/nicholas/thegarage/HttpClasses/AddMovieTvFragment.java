package com.indstudy.nicholas.thegarage.HttpClasses;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.indstudy.nicholas.thegarage.LibraryObjects.Movie;
import com.indstudy.nicholas.thegarage.LibraryObjects.TelevisionSeries;
import com.indstudy.nicholas.thegarage.LibraryObjects.FormatEnums.VideoFormat;
import com.indstudy.nicholas.thegarage.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddMovieTvFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddMovieTvFragment extends Fragment implements Jsonable, AddItemActivity.OnSubmitButtonClickedListener {

    private AutoCompleteTextView mTitleTextView, mDirectorTextView;
    private AutoCompleteTextView mReleaseTextView, mSeasonTextView;
    private CheckBox mIsRead, mIsReading;
    private RadioGroup mRadioGroup;
    //TODO are these necessary?
    // private RadioButton mMovie, mTvSeries;
    private Spinner formatSpinner, tvFormatSpinner;
    private LinearLayout movieLayout, tvLayout;
    private AddItemActivity parentActivity;

    public AddMovieTvFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment AddMovieTvFragment.
     */
    public static AddMovieTvFragment newInstance() {
        return new AddMovieTvFragment();
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
        View view = inflater.inflate(R.layout.fragment_add_movie_tv, container, false);
        movieLayout = (LinearLayout)view.findViewById(R.id.add_movie_sub_layout);
        tvLayout = (LinearLayout)view.findViewById(R.id.add_tv_sub_layout);
        mRadioGroup = (RadioGroup)view.findViewById(R.id.add_movie_tv_radio_group);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.movie_radio_button){
                    tvLayout.setVisibility(View.GONE);
                    movieLayout.setVisibility(View.VISIBLE);
                } else if (checkedId == R.id.tv_radio_button){
                    movieLayout.setVisibility(View.GONE);
                    tvLayout.setVisibility(View.VISIBLE);
                }
            }
        });
        //TODO which would get rid of these too.
        // mMovie = (RadioButton)view.findViewById(R.id.movie_radio_button);
        // mTvSeries = (RadioButton)view.findViewById(R.id.tv_radio_button);
        mTitleTextView = (AutoCompleteTextView)view.findViewById(R.id.add_movie_tv_title);
        mDirectorTextView = (AutoCompleteTextView)view.findViewById(R.id.add_movie_tv_director);
        mReleaseTextView = (AutoCompleteTextView)view.findViewById(R.id.add_movie_tv_release_year);
        mSeasonTextView = (AutoCompleteTextView)view.findViewById(R.id.add_movie_tv_season);
        mIsRead = (CheckBox)view.findViewById(R.id.add_movie_tv_read_checkbox);
        mIsReading = (CheckBox)view.findViewById(R.id.add_movie_tv_reading_checkbox);
        formatSpinner = (Spinner)view.findViewById(R.id.add_movie_tv_format_spinner);
        formatSpinner.setAdapter(new ArrayAdapter<>(view.getContext(),
                android.R.layout.simple_spinner_item, VideoFormat.values()));
        tvFormatSpinner = (Spinner)view.findViewById(R.id.add_tv_format_spinner);
        tvFormatSpinner.setAdapter(new ArrayAdapter<>(view.getContext(),
                android.R.layout.simple_spinner_item, VideoFormat.values()));
        return view;
    }

    private Movie createMovie() throws NumberFormatException {
        Movie movie = new Movie();
        movie.setUserEmail(parentActivity.mEmail);
        movie.setTitle(mTitleTextView.getText().toString());
        movie.setDirector(mDirectorTextView.getText().toString());
        movie.setFormat((VideoFormat) formatSpinner.getSelectedItem());
        //TODO handle this release year input
        movie.setReleaseYear(Integer.parseInt(mReleaseTextView.getText().toString()));
        movie.setWatched(mIsRead.isActivated());
        movie.setWatching(mIsReading.isActivated());
        return movie;
    }

    private TelevisionSeries createTVSeries() throws NumberFormatException {
        TelevisionSeries televisionSeries = new TelevisionSeries();
        televisionSeries.setUserEmail(parentActivity.mEmail);
        televisionSeries.setTitle(mTitleTextView.getText().toString());
        televisionSeries.setDirector(mDirectorTextView.getText().toString());
        televisionSeries.setFormat((VideoFormat) tvFormatSpinner.getSelectedItem());
        //TODO check season input
        televisionSeries.setSeason( Integer.parseInt( mSeasonTextView.getText().toString() ) );
        //TODO check release year input
        televisionSeries.setReleaseYear(Integer.parseInt(mReleaseTextView.getText().toString()));
        televisionSeries.setWatched(mIsRead.isActivated());
        televisionSeries.setWatching(mIsReading.isActivated());
        return televisionSeries;
    }

    @Override
    public String createJson(){
        Gson gson = new Gson();
        if (mRadioGroup.getCheckedRadioButtonId() == R.id.movie_radio_button){
            return gson.toJson(createMovie());
        } else {
            return gson.toJson(createTVSeries());
        }
    }

    @Override
    public String onSubmitClicked() {
        return createJson();
    }
}
