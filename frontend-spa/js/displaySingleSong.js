import {
    displayAlbum
} from "./displayAlbum.js";
import {
    clearChildren
} from "./displayHome.js";

const displaySingleSong = function (song) {
    const mainElement = document.querySelector(".main-content");
    clearChildren(mainElement);
    const songElement = document.createElement("div");
    songElement.classList.add("song-content");
    const songTitleElement = document.createElement("h3");
    songTitleElement.innerText = "Song Title: " + song.songTitle;
    const songLengthElement = document.createElement("p");
    songLengthElement.innerText = "Song Length: " + song.length;
    const songStarRatingElement = document.createElement("p");
    songStarRatingElement.innerText = "Song Rating: " + song.starRating + "/5";
    const songCommentsNotationelement = document.createElement("song-comments");
    songCommentsNotationelement.classList.add("song-comments-notation");
    songCommentsNotationelement.innerText = "Comments: ";

    const songRetitleForm = document.createElement("form");
    songRetitleForm.classList.add("change-song-title-form");
    const songRetitleInput = document.createElement("input");
    songRetitleInput.classList.add("new-song-title");
    songRetitleInput.setAttribute("type", "text");
    songRetitleInput.setAttribute("placeholder", "Retitle the song...");

    const submitRetitleSongButton = document.createElement("button");
    submitRetitleSongButton.classList.add("submit-song-retitle");
    submitRetitleSongButton.innerText = "Submit New Song Title";

    submitRetitleSongButton.addEventListener("click", (clickEvent) => {
        clickEvent.preventDefault();
        clearChildren(songElement);
        const retitleSongJson = JSON.stringify(songRetitleInput.value);
        const unquotedSongJson = retitleSongJson.replace(/\"/g, "");
        fetch("http://localhost:8080/api/lists/" + song.listId + "/albums/" + song.albumId + "/songs/" + song.id + "/songTitle", {
            method: "PATCH",
            body: unquotedSongJson
        })
            .then(response => response.json())
            .then(song => displaySingleSong(song))
            .catch(error => console.log(error));
    })

    songRetitleForm.appendChild(songRetitleInput);
    songRetitleForm.appendChild(submitRetitleSongButton);

    const deleteSongButton = document.createElement("button");
    deleteSongButton.classList.add("delete-song");
    deleteSongButton.innerText = "Delete this Song";

    deleteSongButton.addEventListener("click", (clickEvent) => {
        clickEvent.preventDefault();
        fetch("http://localhost:8080/api/lists/" + song.listId + "/albums/" + song.albumId + "/songs/" + song.id, {
            method: "DELETE",
        })
            .then(response => response.json())
            .then(album => displayAlbum(album))
            .catch(error => console.log(error));
    })

    const backButtonElement = document.createElement("button")
    backButtonElement.innerText = "back";

    backButtonElement.addEventListener("click", (clickEvent) => {
        fetch("http://api/lists/" + song.listId + "/albums/" + song.albumId, {
            method: "GET",
        })
            .then(response => response.json())
            .then(album => displayAlbum(album))
            .catch(error => console.log(error));
    })


    songElement.appendChild(songTitleElement);
    songElement.appendChild(songRetitleForm);
    songElement.appendChild(deleteSongButton);
    songElement.appendChild(backButtonElement);
    songElement.appendChild(songLengthElement);
    songElement.appendChild(songStarRatingElement);
    songElement.appendChild(songCommentsNotationelement);

    if (song.comments !== null && song.comments.length !== 0) {
        song.comments.forEach((comment) => {
            let commentsElement = document.createElement("section");
            commentsElement.classList.add("comments-section");
            let singleCommentElement = document.createElement("p");
            singleCommentElement.innerText = comment;
            commentsElement.appendChild(singleCommentElement);
            songElement.appendChild(commentsElement);
        });
    }

    const form = document.createElement("form");
    form.classList.add("new-comment-form");
    const commentInput = document.createElement("input");
    commentInput.classList.add("new-comment");
    commentInput.setAttribute("type", "text");
    commentInput.setAttribute("placeholder", "Enter your comment...");
    const submitCommentButton = document.createElement("button");
    submitCommentButton.classList.add("comment-button");
    submitCommentButton.innerText = "Submit a comment";

    form.appendChild(commentInput);
    form.appendChild(submitCommentButton);
    songElement.appendChild(form);

    submitCommentButton.addEventListener("click", (clickEvent) => {
        clickEvent.preventDefault();
        const songElement = document.querySelector(".song-content");
        clearChildren(songElement);
        if (commentInput.value !== "") {

            const json = JSON.stringify(commentInput.value);
            const unqoutedJson = json.replace(/\"/g, "");//this removes qoutes from the stringify
            fetch("http://localhost:8080/api/lists/" + song.listId + "/albums/" + song.albumId + "/songs/" + song.id + "/comments", {
                method: "PATCH",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: unqoutedJson
            })
                .then(response => response.json())
                .then(song => displaySingleSong(song))
                .catch(error => console.log(error));
        }
    })

    // mainElement.appendChild(form);
    mainElement.appendChild(songElement);

    if (song.songUserRatings !== null && song.songUserRatings.length !== 0) {
        let songUserRatingHeading = document.createElement("h3");
        songUserRatingHeading.innerText = "User Ratings: ";
        songElement.appendChild(songUserRatingHeading);
        let total = 0;
        song.songUserRatings.forEach((songUserRating) => {
            let songUserRatingsElement = document.createElement("section");
            songUserRatingsElement.classList.add("song-userRatings-section");
            let singleSongUserRatingElement = document.createElement("p");
            singleSongUserRatingElement.innerText = songUserRating;
            total += songUserRating;
            songUserRatingsElement.appendChild(singleSongUserRatingElement);
            songElement.appendChild(songUserRatingsElement);
        });

        let average = Math.round((total / song.songUserRatings.length) * 10) / 10;
        let averageRatingElement = document.createElement("h4");
        averageRatingElement.innerText = "Average User Rating: " + average;
        songElement.appendChild(averageRatingElement);
    }
    const songUserRatingForm = document.createElement("form");
    songUserRatingForm.classList.add("new-user-rating-form");
    const songUserRatingInput = document.createElement("input");
    songUserRatingInput.classList.add("new-user-rating");
    songUserRatingInput.setAttribute("type", "integer");
    songUserRatingInput.setAttribute("placeholder", "Enter a rating (1 - 5)...");
    const submitSongUserRatingButton = document.createElement("button");
    submitSongUserRatingButton.classList.add("user-rating-button");
    submitSongUserRatingButton.innerText = "Submit a rating";

    songUserRatingForm.appendChild(songUserRatingInput);
    songUserRatingForm.appendChild(submitSongUserRatingButton);
    songElement.appendChild(songUserRatingForm);

    submitSongUserRatingButton.addEventListener("click", (clickEvent) => {
        clickEvent.preventDefault();
        const songElement = document.querySelector(".song-content");
        clearChildren(songElement);
        if (songUserRatingInput.vaule !== "") {
            fetch("http://localhost:8080/api/lists/" + song.listId + "/albums/" + song.albumId + "/songs/" + song.id + "/songUserRatings", {
                method: "PATCH",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: songUserRatingInput.value
            })
                .then(response => response.json())
                .then(song => displaySingleSong(song))
                .catch(error => console.log(error));
        }
    })

    mainElement.appendChild(form);
    mainElement.appendChild(songElement);


    return mainElement;
}
export {
    displaySingleSong
}