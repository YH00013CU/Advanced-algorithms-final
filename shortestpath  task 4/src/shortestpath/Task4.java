package shortestpath;

import java.util.*;

public class Task4 {
    // Define a Task class that holds the priority and duration of a task
    static class Task {
    	
    	
    	
    	
        int taskPriority;
        
        int taskDuration;
        
        
        

        public Task(int taskPriority, int taskDuration) {
            this.taskPriority = taskPriority;
            this.taskDuration = taskDuration;
        }
    }

    public static void main(String[] args) {
        // Create a list of tasks to be executed
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(2, 5)); // Task 1 with priority 2 and duration 5
        tasks.add(new Task(1, 2)); // Task 2 with priority 1 and duration 2
        tasks.add(new Task(3, 1)); // Task 3 with priority 3 and duration 1
        tasks.add(new Task(4, 4)); // Task 4 with priority 4 and duration 4

        // Simulate task scheduling using FCFS, HPF, and SRTF algorithms
        int systemTime = 0;
        while (!tasks.isEmpty()) {
            // FCFS algorithm
            Task currentTask = tasks.get(0);
            tasks.remove(0);

            // HPF algorithm
            for (Task task : tasks) {
                if (task.taskPriority > currentTask.taskPriority) {
                    currentTask = task;
                }
            }
            tasks.remove(currentTask);

            // SRTF algorithm
            for (Task task : tasks) {
                if (task.taskDuration < currentTask.taskDuration) {
                    currentTask = task;
                }
            }
            tasks.remove(currentTask);

            // Execute the current task and display the system time and task name
            for (int i = 0; i < currentTask.taskDuration; i++) {
                System.out.println("System time [" + systemTime + "] - task " + currentTask.taskPriority + " is running.");
                systemTime++;
            }
        }
    }
}
