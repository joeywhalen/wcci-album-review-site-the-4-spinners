import { clearChildren } from "./displayHome.js";
import { displaySingleSong } from "./displaySingleSong.js"

const displayAlbum = function (album) {
    const mainElement = document.querySelector(".main-content");
    clearChildren(mainElement);
    const albumElement = document.createElement("div");
    albumElement.classList.add("album-content");
    const albumTitleElement = document.createElement("h3");
    albumTitleElement.innerText = album.title;
    const albumImageElement = document.createElement("img");
    albumImageElement.src = album.imageURL;
    const albumArtistElement = document.createElement("h4");
    albumArtistElement.classList.add("album-artist-notation");
    albumArtistElement.innerText = "Album Artist: " + album.artist; 
    const recordLabelElement = document.createElement("p");
    recordLabelElement.innerText = "Record Label: " + album.recordLabel;
    const albumDurationElement = document.createElement("p");
    albumDurationElement.classList.add("album-duration-notation");
    albumDurationElement.innerText = "Album Duration: " + album.duration;
    const albumRatingElement = document.createElement("p");
    albumRatingElement.innerText = "Album Rating: " + album.rating + "/5";
    const albumVideoElement = document.createElement("a");
    albumVideoElement.href = album.videoUrl;
    const albumSongsNotationElement = document.createElement("album-songs");
    albumSongsNotationElement.classList.add("album-songs-notation");
    albumSongsNotationElement.innerText = "Songs: ";
    const albumCommentsNotationelement = document.createElement("album-comments");
    albumCommentsNotationelement.classList.add("album-comments-notation");
    albumCommentsNotationelement.innerText = "Comments: ";

    const albumRetitleForm = document.createElement("form");
    albumRetitleForm.classList.add("change-album-title-form");
    const albumRetitleInput = document.createElement("input");
    albumRetitleInput.classList.add("new-album-title");
    albumRetitleInput.setAttribute("type", "text");
    albumRetitleInput.setAttribute("placeholder", "Retitle your album...");

    const submitRetitleAlbumButton = document.createElement("button");
    submitRetitleAlbumButton.classList.add("submit-album-retitle");
    submitRetitleAlbumButton.innerText = "Submit New Album Title";

    submitRetitleAlbumButton.addEventListener("click", (clickEvent) => {
        clickEvent.preventDefault();
        clearChildren(albumElement);
        const retitleJson = {
            "title": albumRetitleInput.value
        }
        fetch("http://localhost:8080/api/lists/" + album.listId + "/albums/" + album.id + "/albumName", {
            method: "PATCH",
            body: JSON.stringify(retitleJson)
        })
            .then(response => response.json())
            .then(album => displayAlbum(album))
            .catch(error => console.log(error));
    })

    albumRetitleForm.appendChild(albumRetitleInput);
    albumRetitleForm.appendChild(submitRetitleAlbumButton);

    albumElement.appendChild(albumTitleElement);
    albumElement.appendChild(albumRetitleForm);
    albumElement.appendChild(albumImageElement);
    albumElement.appendChild(albumArtistElement);
    albumElement.appendChild(recordLabelElement);
    albumElement.appendChild(albumDurationElement);
    albumElement.appendChild(albumRatingElement);
    albumElement.appendChild(albumVideoElement);
    albumElement.appendChild(albumSongsNotationElement);

    album.songs.forEach((song) => {
        let songElement = document.createElement("section");
        songElement.classList.add("song-btn-section");
        let songNameElement = document.createElement("h5");
        songNameElement.innerText = song.songTitle;
        songNameElement.addEventListener("click", (clickEvent) => {
            displaySingleSong(song)
        });
        songElement.appendChild(songNameElement);
        albumElement.appendChild(songElement);
    });

    albumElement.appendChild(albumCommentsNotationelement);

    const form = document.createElement("form");
    form.classList.add("new-song-form");
    const songTitleInput = document.createElement("input");
    songTitleInput.classList.add("new-song-title");
    songTitleInput.setAttribute("type", "text");
    songTitleInput.setAttribute("placeholder", "Title of Song...");
    const lengthInput = document.createElement("input");
    lengthInput.classList.add("new-song-length");
    lengthInput.setAttribute("type", "text");
    lengthInput.setAttribute("placeholder", "Song Length...");
    const starRatingInput = document.createElement("input");
    starRatingInput.classList.add("new-song-star-rating");
    starRatingInput.setAttribute("type", "integer");
    starRatingInput.setAttribute("placeholder", "Song Star Rating...");
    const commentsInput = document.createElement("input");
    commentsInput.classList.add("new-song-comments");
    commentsInput.setAttribute("type", "text");
    commentsInput.setAttribute("placeholder", "Song Comment...");

    const submitNewSongButton = document.createElement("button");
    submitNewSongButton.classList.add("submit-new-song");
    submitNewSongButton.innerText = "Submit New Song";
    const formattingElement = document.createElement('div');
    formattingElement.innerHTML = "<br><hr><br>";

    submitNewSongButton.addEventListener("click", (clickEvent) => {
        clickEvent.preventDefault();
        const albumElement = document.querySelector(".album-content");
        clearChildren(albumElement);
        const songJson = {
            "songTitle": songTitleInput.value,
            "length": lengthInput.value,
            "starRating": starRatingInput.value,
            "comments": [commentsInput.value]
        }
        console.log(album.list);
        fetch("http://localhost:8080/api/lists/" + album.listId + "/albums/" + album.id + "/songs", {
            method: "PATCH",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(songJson)
        })
            .then(response => response.json())
            .then(album => displayAlbum(album))
            .catch(error => console.log(error));
    })

    form.appendChild(songTitleInput);
    form.appendChild(lengthInput);
    form.appendChild(starRatingInput);
    form.appendChild(commentsInput);
    form.appendChild(submitNewSongButton);
    form.appendChild(formattingElement);

    if (album.comments !== null && album.comments.length !== 0) {
        album.comments.forEach((comment) => {
            let commentsElement = document.createElement("section");
            commentsElement.classList.add("comments-section");
            let singleCommentElement = document.createElement("p");
            singleCommentElement.innerText = comment;
            commentsElement.appendChild(singleCommentElement);
            albumElement.appendChild(commentsElement);
        });
    }
    const commentForm = document.createElement("form");
    commentForm.classList.add("new-comment-form");
    const commentInput = document.createElement("input");
    commentInput.classList.add("new-comment");
    commentInput.setAttribute("type", "text");
    commentInput.setAttribute("placeholder", "Enter your comment...");
    const submitCommentButton = document.createElement("button");
    submitCommentButton.classList.add("comment-button");
    submitCommentButton.innerText = "Submit a comment";

    commentForm.appendChild(commentInput);
    commentForm.appendChild(submitCommentButton);
    albumElement.appendChild(commentForm);

    submitCommentButton.addEventListener("click", (clickEvent) => {
        clickEvent.preventDefault();
        const albumElement = document.querySelector(".album-content");
        clearChildren(albumElement);
        if(commentInput.value !== ""){
            const json = JSON.stringify(commentInput.value);
            const unqoutedJson = json.replace(/\"/g,"");
            fetch("http://localhost:8080/api/lists/" + album.listId + "/albums/" + album.id + "/comments", {
                method: "PATCH",
                headers: {
                    'Content-Type' : 'application/json'
                },
                body: unqoutedJson
            })
            .then(response => response.json())
            .then(album => displayAlbum(album))
            .catch(error => console.log(error));
        }
    })

    mainElement.appendChild(form);
    mainElement.appendChild(albumElement);

    if (album.userRatings !== null && album.userRatings.length !== 0) {
        let userRatingHeading = document.createElement("h3");
        userRatingHeading.innerText = "User Ratings:";
        albumElement.appendChild(userRatingHeading);
        let total = 0; 
        album.userRatings.forEach((userRating) => {
            let userRatingsElement = document.createElement("section");
            userRatingsElement.classList.add("userRatings-section");
            let singleUserRatingElement = document.createElement("p");
            singleUserRatingElement.innerText = userRating;
            total += userRating;
            userRatingsElement.appendChild(singleUserRatingElement);
            albumElement.appendChild(userRatingsElement);
        });
        let average = Math.round((total / album.userRatings.length) * 10) / 10;
        let averageRatingElement = document.createElement("h4");
        averageRatingElement.innerText = "Average User Rating: " + average;
        albumElement.appendChild(averageRatingElement);
    }
    const userRatingForm = document.createElement("form");
    userRatingForm.classList.add("new-user-rating-form");
    const userRatingInput = document.createElement("input");
    userRatingInput.classList.add("new-user-rating");
    userRatingInput.setAttribute("type", "integer");
    userRatingInput.setAttribute("placeholder", "Enter a rating (1 - 5)...");
    const submitUserRatingButton = document.createElement("button");
    submitUserRatingButton.classList.add("user-rating-button");
    submitUserRatingButton.innerText = "Submit a rating";

    userRatingForm.appendChild(userRatingInput);
    userRatingForm.appendChild(submitUserRatingButton);
    albumElement.appendChild(userRatingForm);

    submitUserRatingButton.addEventListener("click", (clickEvent) => {
        clickEvent.preventDefault();
        const albumElement = document.querySelector(".album-content");
        clearChildren(albumElement);
        if (userRatingInput.value !== "") {
            fetch("http://localhost:8080/api/lists/" + album.listId + "/albums/" + album.id + "/userRatings", {
                method: "PATCH",
                headers: {
                    'Content-Type' : 'application/json'
                },
                body: userRatingInput.value
            })
                .then(response => response.json())
                .then(album => displayAlbum(album))
                .catch(error => console.log(error));
        }
    })

    mainElement.appendChild(form);
    mainElement.appendChild(albumElement);

    return mainElement;
}
export { displayAlbum }