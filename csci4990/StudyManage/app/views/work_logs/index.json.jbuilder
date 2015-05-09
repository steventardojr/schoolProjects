json.array!(@work_logs) do |work_log|
  json.extract! work_log, :id, :name, :start_time, :end_time
  json.url work_log_url(work_log, format: :json)
end
