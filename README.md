# The Price is Right
Using computer vision to identify products in real time -- guess the price of things you interact with every day!

## Inspiration
Like Trivia HQ did for trivia game shows, we're bringing price-guessing game shows to the everyday user. 

## What it does
The Price is Right is a novel, social-based augmented reality mobile platform and game to establish an interface between the real world and the every day needs of consumers. Simply take a picture of any sort of item, and using eBay's advanced convolutional neural network-based image search, we will scour the web for a close fit. Then, put on your thinking cap, and guess the price of the closest product found. Share your results with others, views the daily challenge, and see other people's relevant, funny, and interesting photos! Although centered around a game, this application has serious potential to drive people to easily find and purchase items in a fun way, and establish large data sets to further machine learning models.

## How we built it
First, we developed a mobile application using Android Studio, utilizing many different Views, Activities, and Styles to design an elegant yet simple user interface and handle basic logic. Next, we used Google's Camera API to allow the user to take a photo of objects which were then turned into Base64 Strings to be later used in the application. Our core product rests on our novel use of eBay's Browse API; we used this interface to search for the photos that the user took, matching them to the closest product sold on eBay, which we in turn pulled the data for. Finally, we allowed the user to guess and compare the price of the object, and used Google Cloud's real time Firebase to store the photos and results in a custom backend database. This then allowed us to do things such as show the most recent product lookups and price guesses of other users, allow users to upvote searches and guesses they like, and to store past user searches (perhaps to construct a tailored advertisement profile).   

## Challenges we ran into
For example, we wrote a short function called bitmapToBase64 that allowed us to conver a bitmap to a base 64 string that was necessary for using the browse eBay API. This involved compressing the bitmap and using a byte array output strema to encode the bitmap in base 64. Another challenge was using eBay's APIs to match photos to similar products and return relevant information. One of our greatest challenges was integrating disparate tools like Firebase and eBay APIs into a seamless, cohesive app that uses their strengths effectively.

## Accomplishments that we're proud of
We designed a cohesive, visually striking app that successively incorporates a number of challenging components. The Price is Right integrates camera features, eBay's Browse API, Firebase, and computer vision into a mobile app. 

## What we learned
We learned to use Firebase and eBay APIs in Android app development. We also learned about image processing and computer vision. 

## What's next for The Price is Right
Next steps include incentivizing the app for both buyers and sellers. For the users, we would give out "tokens" for each correct guess (within some percentage range), and the tokens could be used in a wheel of fortune or raffle to win a percentage off the purchase price. For the sellers on eBay, they would get free advertising space in exchange for offering a discount to the winners in the previous instance. There will also be a "Game of the Day," where a correct guess may correspond to, say, five tokens, and leaderboards to compare your scores and correct guess streaks to other users. 
