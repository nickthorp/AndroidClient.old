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
import com.indstudy.nicholas.thegarage.LibraryObjects.Comic;
import com.indstudy.nicholas.thegarage.LibraryObjects.PrintFormat;
import com.indstudy.nicholas.thegarage.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddComicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddComicFragment extends Fragment implements Jsonable, AddItemActivity.OnSubmitButtonClickedListener {

    private AutoCompleteTextView mTitleTextView, mAuthorTextView,
            mArtistTextView, mPublisherTextView, mVolumeTextView;
    private Spinner mSpinner;
    private CheckBox mIsRead, mIsReading;

    public AddComicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AddComicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddComicFragment newInstance() {
        return new AddComicFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_comic, container, false);
        mTitleTextView = (AutoCompleteTextView)view.findViewById(R.id.add_comic_title);
        mAuthorTextView = (AutoCompleteTextView)view.findViewById(R.id.add_comic_author);
        mArtistTextView = (AutoCompleteTextView)view.findViewById(R.id.add_comic_artist);
        mPublisherTextView = (AutoCompleteTextView)view.findViewById(R.id.add_comic_publisher);
        mVolumeTextView = (AutoCompleteTextView)view.findViewById(R.id.add_comic_volume);
        mIsRead = (CheckBox)view.findViewById(R.id.add_comic_read_checkbox);
        mIsReading = (CheckBox)view.findViewById(R.id.add_comic_reading_checkbox);
        mSpinner = (Spinner)view.findViewById(R.id.add_comic_format_spinner);
        mSpinner.setAdapter(new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item, PrintFormat.values()));
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

    private Comic createComic(){
        Comic comic = new Comic();
        comic.setItemId(333);
        comic.setUserEmail("foo@example.com");
        comic.setTitle(mTitleTextView.getText().toString());
        comic.setAuthor(mAuthorTextView.getText().toString());
        comic.setPublisher(mPublisherTextView.getText().toString());
        comic.setArtist(mArtistTextView.getText().toString());
        comic.setVolume(mVolumeTextView.getText().toString());
        comic.setFormat((PrintFormat) mSpinner.getSelectedItem());
        comic.setIsRead(mIsRead.isActivated());
        comic.setIsReading(mIsReading.isActivated());
        return comic;
    }

    @Override
    public String createJson(){
        Gson gson = new Gson();
        return gson.toJson(createComic());
    }

    @Override
    public String onSubmitClicked() {
        return createJson();
    }
}
