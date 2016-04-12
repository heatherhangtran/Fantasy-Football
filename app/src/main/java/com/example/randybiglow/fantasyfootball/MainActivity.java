package com.example.randybiglow.fantasyfootball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    LinkedList<String> mStringList;
    ArrayAdapter<String> mAdapter;
    EditText mEditText;
    Button mAddButton;
    Button mRemoveButton;
    //Establishes the variables I want to use.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add the list.
        mStringList = new LinkedList<>();
        mStringList.add("Tom Brady");
        mStringList.add("Julian Edelman");
        mStringList.add("Rob Gronkowski");
        mStringList.add("Danny Amendola");
        mStringList.add("Stephen Gostkowski");

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mStringList);

        ListView listName = (ListView) (findViewById(R.id.listView));
        listName.setAdapter(mAdapter);
        mEditText = (EditText) (findViewById(R.id.editText));
        mAddButton = (Button) (findViewById(R.id.addTextButton));
        mRemoveButton = (Button) (findViewById(R.id.removeTextButton));

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = mEditText.getText().toString();
                if (input.length() > 0) {
                    mStringList.add(input);
                    mAdapter.notifyDataSetChanged();
                    mEditText.setText("");
                }
            }
        });

        mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStringList.remove(mStringList.size() - 1);
                mAdapter.notifyDataSetChanged();
            }
        });

    }
}
