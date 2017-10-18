package com.example.arsala.todolist;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * This class allows us to conveniently bind out model (in this case an array of strings) to the
 * listview by overriding some methods inherited from the BaseAdapter class.
 *
 * These methods define how the adapter should react to changes in the model and how it should pass
 * those changes on to the view...which in this case is our listview of cards.
 */
public class ToDoListAdapter extends BaseAdapter {

    private ArrayList<String> todos;
    private Context context;

    //The constructor needs to context so that it can inflate the views for each row
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
        //Creates a card view from the layout resource file.
        View todoCardView = LayoutInflater.from(context).inflate(R.layout.todo_card, null);

        /*
        The int i refers to the position index within the listview that we want to render.
        We use this to also index our model so that we know which item within the todos model we
        want to pass into the TextView of the ToDoCard
         */
        String currentTodo = todos.get(i);
        TextView todoCardText = (TextView) todoCardView.findViewById(R.id.todo_card_text);
        todoCardText.setText(currentTodo);
        return todoCardView;
    }
}
