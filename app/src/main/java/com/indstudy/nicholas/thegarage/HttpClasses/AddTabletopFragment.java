package com.indstudy.nicholas.thegarage.HttpClasses;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.indstudy.nicholas.thegarage.InputException;
import com.indstudy.nicholas.thegarage.LibraryObjects.FormatEnums.TableTopFormat;
import com.indstudy.nicholas.thegarage.LibraryObjects.TableTopGame;
import com.indstudy.nicholas.thegarage.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddTabletopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddTabletopFragment extends Fragment implements Jsonable, AddItemActivity.OnSubmitButtonClickedListener {

    private AutoCompleteTextView mTitleTextView;
    private Spinner mFormatSpinner;
    private AutoCompleteTextView mMinTextView, mMaxTextView;
    private AddItemActivity parentActivity;

    public AddTabletopFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AddTabletopFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddTabletopFragment newInstance() {
        return new AddTabletopFragment();
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
        View view = inflater.inflate(R.layout.fragment_add_tabletop, container, false);
        mTitleTextView = (AutoCompleteTextView)view.findViewById(R.id.add_table_top_title);
        mMinTextView = (AutoCompleteTextView)view.findViewById(R.id.add_table_top_min);
        mMaxTextView = (AutoCompleteTextView)view.findViewById(R.id.add_table_top_max);
        mFormatSpinner = (Spinner)view.findViewById(R.id.add_table_top_spinner);
        mFormatSpinner.setAdapter(new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item, TableTopFormat.values()));
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

    public TableTopGame createTableTop() throws InputException {
        TableTopGame tableTopGame = new TableTopGame();
        tableTopGame.setUserEmail(parentActivity.mEmail);
        tableTopGame.setGameTitle(mTitleTextView.getText().toString());
        //TODO set input logic for num players, including that max must be <= to min and < 0
        tableTopGame.setMinPlayers(Integer.parseInt(mMinTextView.getText().toString()));
        tableTopGame.setMaxPlayers(Integer.parseInt(mMaxTextView.getText().toString()));
        int min = tableTopGame.getMinPlayers(), max = tableTopGame.getMaxPlayers();
        if ((min <= 0 || max <= 0) || (max < min) )
            throw new InputException("Enter valid player numbers!");
        tableTopGame.setStyle((TableTopFormat)mFormatSpinner.getSelectedItem());
        return tableTopGame;
    }

    @Override
    public String createJson() throws InputException {
        Gson gson = new Gson();
        return gson.toJson(createTableTop());
    }

    @Override
    public String onSubmitClicked() throws InputException {
        return createJson();
    }
}