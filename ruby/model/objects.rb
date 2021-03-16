# model/objects.rb

class Url < ActiveRecord::Base
    self.table_name = 'urls'
    validates :url_id, :url, presence: true
end