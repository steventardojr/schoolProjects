json.array!(@tasks) do |task|
  json.extract! task, :id, :type_of_assignment, :name, :due_date, :expected_grade, :actual_grade
  json.url task_url(task, format: :json)
end
