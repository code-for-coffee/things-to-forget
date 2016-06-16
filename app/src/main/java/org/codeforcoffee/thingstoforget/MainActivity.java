package org.codeforcoffee.thingstoforget;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LayoutInflater mInflater;
    private View.OnClickListener mListItemClickListener;
    private ArrayList<TodoList> mTodoLists;
    private TodoListAdapter mListArrayAdapter;
    private ListView mListView;
    private AlertDialog.Builder mAlertDialog;

    private boolean createList(String listName) {
        try {
            mTodoLists.add(new TodoList(listName));
            mListArrayAdapter.notifyDataSetChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
            // todo: err handling
        }
        return false;
    }

    private boolean deleteList(int index) {
        try {
            mTodoLists.remove(index);
            mListArrayAdapter.notifyDataSetChanged();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            // todo: err handling
        }
        return false;
    }

    private void displaySnackbar(String text) {
    }

    private boolean renderCreateListDialog() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTodoLists = new ArrayList<TodoList>();
        mListArrayAdapter = new TodoListAdapter(this, mTodoLists);
        mListView = (ListView) findViewById(R.id.listview_todolists);
        mListView.setAdapter(mListArrayAdapter);

        mAlertDialog = new AlertDialog.Builder(this);
        mInflater = this.getLayoutInflater();
        mAlertDialog.setView(R.layout.dialog_add_list);
        mAlertDialog.setPositiveButton(R.string.dialog_btn_create, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Dialog d = (Dialog) dialog;
                EditText editTxtName = (EditText) d.findViewById(R.id.dialog_list_name);
                createList(editTxtName.getText().toString());
            }
        });
        mAlertDialog.setNegativeButton(R.string.dialog_btn_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAlertDialog.show();
                Snackbar.make(view, R.string.snackbar_create_list, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
