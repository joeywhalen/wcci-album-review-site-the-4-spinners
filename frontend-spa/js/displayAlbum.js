import { clearChildren } from "./displayHome.js";
import {displaySingleSong} from "./displaySingleSong.js"

const displayAlbum = function (album){
    const mainElement = document.querySelector(".main-content");
    clearChildren(mainElement);
    const albumElement = document.createElement("div");
    albumElement.classList.add("album-content");
    const albumTitleElement = document.createElement("h3");
    albumTitleElement.innerText = album.title;
    const albumImageElement = document.createElement("img");
    albumImageElement.src = album.imageURL;
    const albumArtistElement = document.createElement("h4");
    albumArtistElement.innerText = album.artist;
    const recordLabelElement = document.createElement("p");
    recordLabelElement.innerText = album.recordLabel;
    const albumDurationElement = document.createElement("p");
    albumDurationElement.innerText = album.duration;
    const albumRatingElement = document.createElement("p");
    albumRatingElement.innerText = album.rating + "/5";
    const albumVideoElement = document.createElement("a");
    albumVideoElement.href = album.videoURL;

    albumElement.appendChild(albumTitleElement);
    albumElement.appendChild(albumImageElement);
    albumElement.appendChild(albumArtistElement);
    albumElement.appendChild(recordLabelElement);
    albumElement.appendChild(albumDurationElement);
    albumElement.appendChild(albumRatingElement);
    albumElement.appendChild(albumVideoElement);    
    
    album.songs.forEach((song)=>{
        let songElement = document.createElement("section");
        songElement.classList.add("song-btn-section");
        let songNameElement= document.createElement("h5");
        songNameElement.innerText = song.songTitle;        
        songNameElement.addEventListener("click", (clickEvent) => {
            displaySingleSong(song)
        });
        songElement.appendChild(songNameElement);
        albumElement.appendChild(songElement);
    });

    const form = document.createElement("form");
    form.classList.add("new-song-form");
    // const albumTitleInput = document.createElement("input");
    // albumTitleInput.classList.add("attach-album-name");
    // albumTitleInput.setAttribute("type", "text");
    // albumTitleInput.setAttribute("placeholder", "Which Album?...");
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
            // "title": albumTitleInput.value,
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

    // form.appendChild(albumTitleInput);
    form.appendChild(songTitleInput);
    form.appendChild(lengthInput);
    form.appendChild(starRatingInput);
    form.appendChild(commentsInput);
    form.appendChild(submitNewSongButton);
    form.appendChild(formattingElement);

    album.comments.forEach((comment) => {
        let commentsElement = document.createElement("section");
        commentsElement.classList.add("comments-section");
        let singleCommentElement = document.createElement("p");
        singleCommentElement.innerText = comment;
        commentsElement.appendChild(singleCommentElement);
        albumElement.appendChild(commentsElement);
    });
    
    mainElement.appendChild(form);
    mainElement.appendChild(albumElement);

    return mainElement;
}
export{displayAlbum}