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
import android.widget.Spinner;

import com.google.gson.Gson;
import com.indstudy.nicholas.thegarage.InputException;
import com.indstudy.nicholas.thegarage.LibraryObjects.Comic;
import com.indstudy.nicholas.thegarage.LibraryObjects.FormatEnums.PrintFormat;
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
    private AddItemActivity parentActivity;

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
        parentActivity = (AddItemActivity)getActivity();
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

    private Comic createComic() throws InputException {
        Comic comic = new Comic();
        comic.setUserEmail(parentActivity.mEmail);
        comic.setTitle(mTitleTextView.getText().toString());
        comic.setAuthor(mAuthorTextView.getText().toString());
        comic.setPublisher(mPublisherTextView.getText().toString());
        comic.setArtist(mArtistTextView.getText().toString());
        comic.setVolume(Integer.parseInt(mVolumeTextView.getText().toString()));
        if ( comic.getVolume() <= 0 )
            throw new InputException("Enter a valid volume number!");
        comic.setFormat((PrintFormat) mSpinner.getSelectedItem());
        comic.setIsRead(mIsRead.isActivated());
        comic.setIsReading(mIsReading.isActivated());
        return comic;
    }

    @Override
    public String createJson() throws InputException {
        Gson gson = new Gson();
        return gson.toJson(createComic());
    }

    @Override
    public String onSubmitClicked() throws InputException {
        return createJson();
    }
}
