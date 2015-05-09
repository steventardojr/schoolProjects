class CreateWorkLogs < ActiveRecord::Migration
  def change
    create_table :work_logs do |t|
      t.belongs_to :task
      t.date :name
      t.time :start_time
      t.time :end_time
      t.integer :task_id

      t.timestamps
    end
  end
end
