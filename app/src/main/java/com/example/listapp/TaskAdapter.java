package com.example.listapp;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.listapp.Task;
import com.example.listapp.R;

import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {
    public TaskAdapter(Context context, List<Task> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task task = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_task, parent, false);
        }

        TextView textViewTask = convertView.findViewById(R.id.textViewTask);
        textViewTask.setText(task.getTaskName());
        textViewTask.setTextSize(TypedValue.COMPLEX_UNIT_PT, 15);

        // Add a delete button
        Button btnDelete = convertView.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the delete button click here
                // You may want to show a confirmation dialog or directly delete the task
                deleteTask(position);
            }
        });

        return convertView;
    }

    // Method to delete a task
    private void deleteTask(int position) {
        remove(getItem(position));
        notifyDataSetChanged();
    }
}
