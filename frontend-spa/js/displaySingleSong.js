import {
    displayAlbum
} from "./displayAlbum.js";
import {
    clearChildren
} from "./displayHome.js";

const displaySingleSong = function(song) {
    const mainElement = document.querySelector(".main-content");
    clearChildren(mainElement);
    const songElement = document.createElement("div");
    songElement.classList.add("song-content");
    const songTitleElement = document.createElement("h3");
    songTitleElement.innerText = song.songTitle;
    const songLengthElement = document.createElement("p");
    songLengthElement.innerText = song.length;
    const songStarRatingElement = document.createElement("p");
    songStarRatingElement.innerText = song.starRating + "/5";

    songElement.appendChild(songTitleElement);
    songElement.appendChild(songLengthElement);
    songElement.appendChild(songStarRatingElement);

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
        const commentJson = {
            "comments": [commentInput.value]
        }
        fetch("http://localhost:8080/api/lists/" + song.listId + "/albums/" + song.albumId + "/songs/" + song.id + "/comments", {
                method: "PATCH",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(commentJson)
            })
            .then(response => response.json())
            .then(song => displaySingleSong(song))
            .catch(error => console.log(error));
    })

    mainElement.appendChild(songElement);
    return mainElement;
}
export {
    displaySingleSong
}