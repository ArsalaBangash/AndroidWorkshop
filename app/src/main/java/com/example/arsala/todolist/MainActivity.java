package com.example.arsala.todolist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText todotext;
    private CardView todoCard;
    private FloatingActionButton addTodoButton;
    private ArrayList<String> todos;
    private BaseAdapter todoListAdapter;
    private ListView todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todotext = (EditText) findViewById(R.id.todo_text);
        addTodoButton = (FloatingActionButton) findViewById(R.id.add_todo_button);
        todoList = (ListView) findViewById(R.id.todo_list);
        todos = new ArrayList<String>();
        todoListAdapter = new ToDoListAdapter(this, todos);
        todoList.setAdapter(todoListAdapter);


        addTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todos.add(todotext.getText().toString());
                Toast.makeText(getBaseContext(), todotext.getText().toString(), Toast.LENGTH_SHORT).show();
                todoListAdapter.notifyDataSetChanged();
            }
        });
    }


}
