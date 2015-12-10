package com.indstudy.nicholas.thegarage.HttpClasses;

import android.app.Activity;
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
import com.indstudy.nicholas.thegarage.LibraryObjects.Book;
import com.indstudy.nicholas.thegarage.LibraryObjects.FormatEnums.PrintFormat;
import com.indstudy.nicholas.thegarage.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link AddBookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddBookFragment extends Fragment implements Jsonable, AddItemActivity.OnSubmitButtonClickedListener {

    private AutoCompleteTextView mTitleTextView, mAuthorTextView;
    private AutoCompleteTextView mPublisherTextView, mIsbnTextView;
    private CheckBox mIsRead, mIsReading;
    private Spinner formatSpinner;
    private AddItemActivity parentActivity;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AddBookFragment.
     */
    public static AddBookFragment newInstance() {
        return new AddBookFragment();
    }

    public AddBookFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parentActivity = (AddItemActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_book, container, false);
        mTitleTextView = (AutoCompleteTextView) view.findViewById(R.id.add_book_title);
        mAuthorTextView = (AutoCompleteTextView) view.findViewById(R.id.add_book_author);
        mPublisherTextView = (AutoCompleteTextView) view.findViewById(R.id.add_book_publisher);
        mIsbnTextView = (AutoCompleteTextView) view.findViewById(R.id.add_book_isbn);
        mIsRead = (CheckBox) view.findViewById(R.id.add_book_read_checkbox);
        mIsReading = (CheckBox) view.findViewById(R.id.add_book_reading_checkbox);
        formatSpinner = (Spinner) view.findViewById(R.id.add_book_format_spinner);
        formatSpinner.setAdapter(new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item, PrintFormat.values()));
        return view;
    }

    private Book createBook() throws InputException {
        final int ISBN11_LENGTH = 11;
        final int ISBN13_LENGTH = 13;
        Book book = new Book();
        book.setUserEmail(parentActivity.mEmail);
        book.setTitle(mTitleTextView.getText().toString());
        book.setAuthor(mAuthorTextView.getText().toString());
        book.setPublisher(mPublisherTextView.getText().toString());
        book.setIsbn(mIsbnTextView.getText().toString());
        int len = book.getIsbn().length();
        if ( !(len == ISBN11_LENGTH || len == ISBN13_LENGTH) ) {
            throw new InputException("Please enter a valid 11 or 13 digit ISBN number.");
        }
        book.setFormat((PrintFormat) formatSpinner.getSelectedItem());
        book.setIsRead(mIsRead.isActivated());
        book.setIsReading(mIsReading.isActivated());
        return book;
    }

    @Override
    public String createJson() throws InputException {
        Gson gson = new Gson();
        return gson.toJson(createBook());
    }

    @Override
    public String onSubmitClicked() throws InputException {
        return createJson();
    }
}
