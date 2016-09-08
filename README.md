To get started you should create an account on our staging environment, which can be found at: http://stage.0cs.io/
Note: All API requests should send JSON formatted bodies, with a matching “Content-Type: application/json” header. Once you have an access token, requests should contain the header “Authorization” with a value of “Token c66402654d935e0c9775d718bf34”.


The application should:

1) Authenticate a user with the API

a. Display login form to the user (email address, password)

b. Authenticate with the /email-auth/ endpoint, in which an access token will be returned – this will be required for subsequent requests. Endpoint: POST http://stage.0cs.io/api/2/email-auth/ Required fields: email (string), password (string), device (string), hash (string) Notes: Device should be the type of device, i.e. “iPhone”, hash should be some sort of unique device id – although for the purposes of this project you can send dummy content such as “1234” if you can’t easily access one. 

c. If an access token is returned you can assume the email address and password were a valid combination.


2) Consume the posts feed endpoint 

a. Display a feed of posts, which loads in the next page of content when reaching the bottom of each page from the /search/ endpoint. Endpoint: GET http://stage.0cs.io/api/2/search/? sort_by=recent&page=1 Notes: Page number should be changed via the page query string in the URL. If there is no content to be returned for a page number the returned array will be empty. It’s also worth noting that there is a 30 second cache on this endpoint – so if new posts don’t show up straight away this will be why.

b. Each post should be marked up similar to how we mark them up on the web. You are not required to implement create, like, bookmark, comment or share functionality. However the number of likes, number of comments would be useful.

c. Implementing a “pull to refresh” mechanism would also be nice to see.


3) Implement embedded content (bonus) 

a. Some posts will contain links to external resources, some of which are links to YouTube & Sound Cloud. On the web version of the site we show the HTML5 video player for both these link types. See if you can implement these to work with the native iOS/android video/ audio players.

b. A post with YouTube/Soundcloud will have “attached_link” and “embedded_content” fields. Non YouTube/Soundcloud links will also have these fields, but will not have embedded_content.html or embedded_content.resultSourceset set to “oembed” – this is the flag we use to tell if it’s going to display in a player (on the web this is easy, we just take the HTML provided to us in embedded_content.html).
