# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20140731073725) do

  create_table "courses", force: true do |t|
    t.string   "name"
    t.integer  "user_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "courses_students", id: false, force: true do |t|
    t.integer "student_id"
    t.integer "course_id"
  end

  add_index "courses_students", ["course_id", "student_id"], name: "index_courses_students_on_course_id_and_student_id", unique: true

  create_table "courses_tasks", force: true do |t|
    t.integer "course_id"
    t.integer "task_id"
  end

  add_index "courses_tasks", ["course_id", "task_id"], name: "index_courses_tasks_on_course_id_and_task_id", unique: true

  create_table "tasks", force: true do |t|
    t.integer  "course_id"
    t.string   "type_of_assignment"
    t.string   "name"
    t.date     "due_date"
    t.float    "expected_grade"
    t.float    "actual_grade"
    t.integer  "user_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "tasks_work_logs", force: true do |t|
    t.integer "task_id"
    t.integer "work_log_id"
  end

  add_index "tasks_work_logs", ["task_id", "work_log_id"], name: "index_tasks_work_logs_on_task_id_and_work_log_id", unique: true

  create_table "users", force: true do |t|
    t.string   "name"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.string   "email",                  default: "", null: false
    t.string   "encrypted_password",     default: "", null: false
    t.string   "reset_password_token"
    t.datetime "reset_password_sent_at"
    t.datetime "remember_created_at"
    t.integer  "sign_in_count",          default: 0,  null: false
    t.datetime "current_sign_in_at"
    t.datetime "last_sign_in_at"
    t.string   "current_sign_in_ip"
    t.string   "last_sign_in_ip"
  end

  add_index "users", ["email"], name: "index_users_on_email", unique: true
  add_index "users", ["reset_password_token"], name: "index_users_on_reset_password_token", unique: true

  create_table "users_courses", force: true do |t|
    t.integer "user_id"
    t.integer "course_id"
  end

  add_index "users_courses", ["user_id", "course_id"], name: "index_users_courses_on_user_id_and_course_id", unique: true

  create_table "work_logs", force: true do |t|
    t.integer  "task_id"
    t.date     "name"
    t.time     "start_time"
    t.time     "end_time"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

end
