package com.example.arsala.todolist;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ToDoListAdapter extends BaseAdapter {

    private ArrayList<String> todos;
    private Context context;

    public ToDoListAdapter(Context context, ArrayList<String> todos) {
        this.context = context;
        this.todos = todos;
    }

    @Override
    public int getCount() {
        return this.todos.size();
    }

    @Override
    public Object getItem(int i) {
        return todos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View todoCardView = LayoutInflater.from(context).inflate(R.layout.todo_card, null);
        String currentTodo = todos.get(i);
        TextView todoCardText = (TextView) todoCardView.findViewById(R.id.todo_card_text);
        todoCardText.setText(currentTodo);
        return todoCardView;
    }
}
