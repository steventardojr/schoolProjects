class AddCoursesTasks < ActiveRecord::Migration
  def change
  create_table :courses_tasks do |t|
  t.integer :course_id
  t.integer :task_id
  end
  add_index :courses_tasks, [:course_id, :task_id], :unique => true
  end
end
