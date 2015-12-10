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

import com.indstudy.nicholas.thegarage.LibraryObjects.Movie;
import com.indstudy.nicholas.thegarage.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MoviesTVFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MoviesTVFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoviesTVFragment extends Fragment {

    private ArrayList<Movie> movieTVList;
    private ArrayAdapter mListAdapter;
    private TextView textViewTotal, textViewIP;
    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MoviesTVFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoviesTVFragment newInstance() {
        return new MoviesTVFragment();
    }

    public MoviesTVFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieTVList = new ArrayList<>();
        Movie movie1, movie2;
        movie1 = new Movie(); movie2 = new Movie();
        movie1.setTitle("Star Wars VII: The Force Awakens"); movie1.setReleaseYear(2015);
        movie2.setTitle("Star Wars IV: A New Hope"); movie2.setReleaseYear(1975);
        movieTVList.add(movie1);
        movieTVList.add(movie2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies_tv, container, false);
        ListView listView = (ListView)view.findViewById(R.id.movie_tv_listView);
        mListAdapter = new ArrayAdapter<>(getActivity(), R.layout.simple_list_item, R.id.empty_textView, movieTVList);
        listView.setAdapter(mListAdapter);
        textViewTotal = (TextView) view.findViewById(R.id.movie_tv_total_text_view);
        textViewTotal.setText(Integer.toString(movieTVList.size()));
        textViewIP = (TextView) view.findViewById(R.id.movie_tv_IP_text_view);
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
        ((MainActivity) activity).onSectionAttached(R.id.nav_movies);
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
