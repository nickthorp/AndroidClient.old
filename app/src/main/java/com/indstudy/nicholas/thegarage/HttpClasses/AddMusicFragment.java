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
import com.indstudy.nicholas.thegarage.LibraryObjects.FormatEnums.AudioFormat;
import com.indstudy.nicholas.thegarage.LibraryObjects.Music;
import com.indstudy.nicholas.thegarage.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddMusicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddMusicFragment extends Fragment implements Jsonable, AddItemActivity.OnSubmitButtonClickedListener {

    private AutoCompleteTextView mAlbumTitleTextView, mArtistTextView;
    private Spinner mFormatSpinner;
    private CheckBox mListeningCheckbox;

    public AddMusicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AddMusicFragment.
     */
    public static AddMusicFragment newInstance() {
        return new AddMusicFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_music, container, false);
        mAlbumTitleTextView = (AutoCompleteTextView)view.findViewById(R.id.add_music_album_title);
        mArtistTextView = (AutoCompleteTextView)view.findViewById(R.id.add_music_artist);
        mListeningCheckbox = (CheckBox)view.findViewById(R.id.add_music_checkbox);
        mFormatSpinner = (Spinner)view.findViewById(R.id.add_music_format_spinner);
        mFormatSpinner.setAdapter(new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item, AudioFormat.values()));
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

    private Music createMusic(){
        Music music = new Music();
        music.setAlbumTitle(mAlbumTitleTextView.getText().toString());
        music.setArtistName(mArtistTextView.getText().toString());
        music.setIsListening(mListeningCheckbox.isActivated());
        music.setFormat((AudioFormat)mFormatSpinner.getSelectedItem());
        return music;
    }

    @Override
    public String createJson(){
        Gson gson = new Gson();
        return gson.toJson(createMusic());
    }

    @Override
    public String onSubmitClicked() {
        return createJson();
    }
}
