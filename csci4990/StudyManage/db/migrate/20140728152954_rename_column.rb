class RenameColumn < ActiveRecord::Migration
  def change
    change_table :tasks do |t|
      t.rename :type, :type_of_assignment
  end
end
end
