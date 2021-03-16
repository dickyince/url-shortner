# model/storage.rb

class Storage
    def self.store_url(id, url)
        Url.create(url_id: id, url: url)
    end

    def self.get_url(id)
        Url.find_by url_id: id
    end

    def self.get_url_id
        Url.count + 1
    end

    def self.get_all_urls
        Url.all
    end
end