class CreateCoursesUser < ActiveRecord::Migration
  def change
  create_table :courses_students, :id => false do |t|
  t.integer :student_id
  t.integer :course_id 
  end
  add_index :courses_students, [:course_id, :student_id], :unique => true
  end
end
