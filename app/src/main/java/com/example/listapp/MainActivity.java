package com.example.listapp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Task> taskList;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskList = new ArrayList<>();
        taskAdapter = new TaskAdapter(this, taskList);

        ListView listViewTasks = findViewById(R.id.listViewTasks);
        listViewTasks.setAdapter(taskAdapter);

        EditText editTextTask = findViewById(R.id.editTextTask);
        Button btnAddTask = findViewById(R.id.btnAddTask);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = editTextTask.getText().toString().trim();
                if (!taskName.isEmpty()) {
                    Task newTask = new Task(taskName);
                    taskList.add(newTask);
                    taskAdapter.notifyDataSetChanged();
                    editTextTask.setText("");
                }
            }
        });
    }
}
