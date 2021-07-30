import { clearChildren } from "./displayHome";

const displaySingleSong = function (song){
    const mainElement = document.querySelector(".main-content");
    clearChildren(mainElement);
    const songElement = document.createElement("div");
    const songTitleElement = document.createElement("h3");
    songTitleElement.innerText = song.songTitle;
    const songLengthElement = document.createElement("p");
    songLengthElement.innerText = song.length;
    const songStarRatingElement = document.createElement("p");
    songStarRatingElement.innerText = song.starRating + "/5";

    songElement.appendChild(songTitleElement);
    songElement.appendChild(songLengthElement);
    songElement.appendChild(songStarRatingElement);

    song.comments.forEach((comment) => {
        let commentsElement = document.createElement("section");
        commentsElement.classList.add("comments-section");
        let singleCommentElement = document.createElement("p");
        singleCommentElement.innerText = comment;
        commentsElement.appendChild(singleCommentElement);
        songElement.appendChild(commentsElement);
    });

    mainElement.appendChild(songElement);
    return mainElement;
}
export {displaySingleSong}