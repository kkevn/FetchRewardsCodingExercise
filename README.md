# FetchRewardsCodingExercise
 A coding exercise requested by Fetch Rewards as part of the interview process. This challenge requires an Android application to display and sort a large list of items originally found in a JSON file.
 
For more information, refer to the original project instructions found at [this link](https://fetch-hiring.s3.amazonaws.com/mobile.html) or the downloaded copy in the `mobile.html` file found in this repository.

---

### Demonstration

<a href="http://www.youtube.com/watch?feature=player_embedded&v=UFNCal-mf3w
" target="_blank"><img src="http://img.youtube.com/vi/UFNCal-mf3w/0.jpg" 
alt="Fetch Rewards Coding Exercise Demo" width="640" height="360" border="10" /></a>

---

### Features

* App home page contains hyperlinks to original project instructions and this code repository
* Pressing the `START` button will change the activity to the actual coding challenge
    * JSON list is automatically read, loaded, validated, and sorted before displaying in RecyclerView
    * JSON parsing is done via Google's Gson library to store into an ArrayList
    * the JSON file is retrieved from `\assets\hiring.json`
    * Each entry in the JSON file becomes a single item in the RecyclerView
        * large number on the left is the `listId` value
        * top value in quotes is the `name`
        * value below the name is the `id` (prefixed with `ID=`)

---

### External Libraries

* [Gson](https://github.com/google/gson)
    * *Apache License 2.0*

---

### Specifications

* **Android/Java** for application development 
* built in Android Studio 4.1.3
* supports **ONLY** Android 11.0 (API 30), per project instructions of "supporting the current latest mobile OS"
