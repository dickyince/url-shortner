# app.rb

require 'sinatra'
require 'sinatra/activerecord'

require_relative 'model/objects'
require_relative 'model/storage'

get '/' do
  erb :main
end

get '/:id' do |id|
    url = Storage.get_url(id)
    redirect url.url
end

post '/record_url' do
    url = params['url_to_shorten']
    id = get_url_id
    @url = Storage.store_url(id, url)
    @base_route = request.base_url
    erb :main
end

def get_url_id
    Url.count + 1
end
