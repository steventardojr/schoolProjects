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

require 'test_helper'

class WorkLogTest < ActiveSupport::TestCase
  # test "the truth" do
  #   assert true
  # end
end
