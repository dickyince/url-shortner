class CreateUrlTable < ActiveRecord::Migration[6.1]
  def change
    create_table :urls do |t|
      t.string :url_id
      t.string :url

      t.timestamps
    end
  end
end
