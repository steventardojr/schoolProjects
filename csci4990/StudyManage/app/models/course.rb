# == Schema Information
#
# Table name: courses
#
#  id         :integer          not null, primary key
#  name       :string(255)
#  user_id    :integer
#  created_at :datetime
#  updated_at :datetime
#

class Course < ActiveRecord::Base
  has_and_belongs_to_many :users, :join_table => "users_courses"
  has_many :tasks, through: :courses_tasks

  def self.courses_for_user(user)
    user.courses
  end
end

