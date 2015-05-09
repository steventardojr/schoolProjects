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

require 'test_helper'

class TaskTest < ActiveSupport::TestCase
  # test "the truth" do
  #   assert true
  # end
end
