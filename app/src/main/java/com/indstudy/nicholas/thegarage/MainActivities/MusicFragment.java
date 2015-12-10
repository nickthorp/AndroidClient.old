package com.indstudy.nicholas.thegarage.MainActivities;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.indstudy.nicholas.thegarage.LibraryObjects.Music;
import com.indstudy.nicholas.thegarage.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MusicFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MusicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicFragment extends Fragment {

    private ArrayList<Music> music;
    private ArrayAdapter mListAdapter;
    private TextView textViewTotal, textViewIP;
    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment MusicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MusicFragment newInstance() {
        return new MusicFragment();
    }

    public MusicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        music = new ArrayList<>();
        music.add(new Music("Trainwreck", "Boys Night Out"));
        music.add(new Music("Fortress", "Protest the Hero"));
        music.add(new Music("Unforgettable", "Nat King Cole"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        ListView listView = (ListView)view.findViewById(R.id.music_listView);
        mListAdapter = new ArrayAdapter<>(getActivity(), R.layout.simple_list_item, R.id.empty_textView, music);
        listView.setAdapter(mListAdapter);
        textViewTotal = (TextView) view.findViewById(R.id.music_total_text_view);
        textViewTotal.setText(Integer.toString(music.size()));
        textViewIP = (TextView) view.findViewById(R.id.music_IP_text_view);
        textViewIP.setText("");
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(R.id.nav_music);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
