# app.rb

require 'sinatra'
require 'sinatra/activerecord'
require 'uri'
require 'open-uri'

require_relative 'model/objects'
require_relative 'model/storage'

get '/' do
  erb :main
end

get '/show_all_urls' do
    @urls = Storage.get_all_urls
    erb :all
end

get '/:id' do |id|
    url = Storage.get_url(id)
    redirect url.url
end

post '/record_url' do
    url = params['url_to_shorten']
    if is_valid_url?(url)
        id = Storage.get_url_id
        @url = Storage.store_url(id, url)
        @base_route = request.base_url
    else
        @error = url + " is not a valid url"
    end
    erb :main
end

def is_valid_url?(url)
    uri = URI.parse(url)
    if uri.is_a?(URI::HTTP) && !uri.host.nil?
        URI.open(url)
    end
    rescue URI::InvalidURIError, SocketError
    false
end
