# == Schema Information
#
# Table name: work_logs
#
#  id         :integer          not null, primary key
#  task_id    :integer
#  name       :date
#  start_time :time
#  end_time   :time
#  created_at :datetime
#  updated_at :datetime
#

class WorkLog < ActiveRecord::Base
  belongs_to :task
  
  def associated_task
    task = Task.find(task_id)
  end
end
