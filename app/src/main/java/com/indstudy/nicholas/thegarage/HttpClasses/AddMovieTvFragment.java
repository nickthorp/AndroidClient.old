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
import com.indstudy.nicholas.thegarage.LibraryObjects.VideoFormat;
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
    private RadioButton mMovie, mTvSeries;
    private Spinner formatSpinner;
    private LinearLayout movieLayout, tvLayout;

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
        mMovie = (RadioButton)view.findViewById(R.id.movie_radio_button);
        mTvSeries = (RadioButton)view.findViewById(R.id.tv_radio_button);
        mTitleTextView = (AutoCompleteTextView)view.findViewById(R.id.add_movie_tv_title);
        mDirectorTextView = (AutoCompleteTextView)view.findViewById(R.id.add_movie_tv_director);
        mReleaseTextView = (AutoCompleteTextView)view.findViewById(R.id.add_movie_tv_release_year);
        mSeasonTextView = (AutoCompleteTextView)view.findViewById(R.id.add_movie_tv_season);
        mIsRead = (CheckBox)view.findViewById(R.id.add_movie_tv_read_checkbox);
        mIsReading = (CheckBox)view.findViewById(R.id.add_movie_tv_reading_checkbox);
        formatSpinner = (Spinner)view.findViewById(R.id.add_movie_tv_format_spinner);
        formatSpinner.setAdapter(new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item, VideoFormat.values()));
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

    private Movie createMovie(){
        Movie movie = new Movie();
        movie.setUserEmail("foo@example.com"); //TODO: Fix userEmail setting logic
        movie.setTitle(mTitleTextView.getText().toString());
        movie.setDirector(mDirectorTextView.getText().toString());
        movie.setFormat((VideoFormat) formatSpinner.getSelectedItem());
        movie.setReleaseYear(Integer.parseInt(mReleaseTextView.getText().toString()));
        movie.setWatched(mIsRead.isActivated());
        movie.setWatching(mIsReading.isActivated());
        return movie;
    }

    private TelevisionSeries createTVSeries(){
        TelevisionSeries televisionSeries = new TelevisionSeries();
        televisionSeries.setUserEmail("foo@example.com"); //TODO: Fix userEmail setting logic
        televisionSeries.setTitle(mTitleTextView.getText().toString());
        televisionSeries.setDirector(mDirectorTextView.getText().toString());
        televisionSeries.setFormat((VideoFormat) formatSpinner.getSelectedItem());
        televisionSeries.setSeason( Integer.parseInt( mSeasonTextView.getText().toString() ) );
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
