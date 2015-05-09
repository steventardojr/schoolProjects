# == Schema Information
#
# Table name: tasks
#
#  id                 :integer          not null, primary key
#  type_of_assignment :string(255)
#  name               :string(255)
#  due_date           :date
#  expected_grade     :float
#  actual_grade       :float
#  user_id            :integer
#  course_id          :integer
#  created_at         :datetime
#  updated_at         :datetime
#

class Task < ActiveRecord::Base
  belongs_to :course
  belongs_to :user
  has_many :work_logs, through: :tasks_work_logs
  
  def associated_course(course_id)
    course = Course.find(course_id)
  end
end
