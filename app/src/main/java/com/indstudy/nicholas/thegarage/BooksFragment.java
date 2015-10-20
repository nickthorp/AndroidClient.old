package com.indstudy.nicholas.thegarage;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.indstudy.nicholas.thegarage.TablesObjects.Book;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BooksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BooksFragment extends Fragment {

    private List<Book> books;
    private ArrayAdapter<String> mListAdapter;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BooksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BooksFragment newInstance() {
        BooksFragment fragment = new BooksFragment();
        return fragment;
    }

    public BooksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        books.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkien"));
        books.add(new Book("The Martian Chronicles","Ray Bradbury"));
        books.add(new Book("Slaughter House-Five","Kurt Vonnegut"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_books, container, false);
        ListView listView = (ListView)view.findViewById(R.id.books_listView);
        mListAdapter = new ArrayAdapter<>(getContext(), R.layout.fragment_books);
        listView.setAdapter(mListAdapter);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity)activity).onSectionAttached(R.id.nav_books);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
