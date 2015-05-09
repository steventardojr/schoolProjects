class AddTasksWorkLogs < ActiveRecord::Migration
  def change
  create_table :tasks_work_logs do |t|
  t.integer :task_id
  t.integer :work_log_id
  end
  add_index :tasks_work_logs, [:task_id, :work_log_id], :unique => true
  end
end
