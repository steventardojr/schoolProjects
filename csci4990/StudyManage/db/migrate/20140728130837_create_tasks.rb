class CreateTasks < ActiveRecord::Migration
  def change
    create_table :tasks do |t|
      t.belongs_to :course
      t.string :type
      t.string :name
      t.date :due_date
      t.float :expected_grade
      t.float :actual_grade
      t.integer :user_id
      t.integer :course_id

      t.timestamps
    end
  end
end
