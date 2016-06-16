package org.codeforcoffee.thingstoforget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by codeforcoffee on 6/16/16.
 */
public class TodoListAdapter extends ArrayAdapter<TodoList> {
    public TodoListAdapter(Context ctx, ArrayList<TodoList> todoLists) {
        super(ctx, 0, todoLists);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        TodoList list = getItem(position);
        view = LayoutInflater.from(getContext()).inflate(R.layout.listview_item_row, parent, false);
        TextView txtListName = (TextView) view.findViewById(R.id.list_name);
        txtListName.setText(list.getName());
        return view;
    }
}
