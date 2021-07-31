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
    const albumArtistNotationElement = document.createElement("album-artist");
    albumArtistNotationElement.classList.add("album-artist-notation");
    albumArtistNotationElement.innerText = "Album Artist: ";
    const albumArtistElement = document.createElement("h4");
    albumArtistElement.innerText = album.artist;
    const recordLabelNotationElement = document.createElement("album-record-label");
    recordLabelNotationElement.classList.add("album-record-label-notation");
    recordLabelNotationElement.innerText = "Record Label: "
    const recordLabelElement = document.createElement("p");
    recordLabelElement.innerText = album.recordLabel;
    const albumDurationNotationElement = document.createElement("album-duration");
    albumDurationNotationElement.classList.add("album-duration-notation");
    albumDurationNotationElement.innerText = "Album Duration: "
    const albumDurationElement = document.createElement("p");
    albumDurationElement.innerText = album.duration;
    const albumRatingNotationElement = document.createElement("album-rating");
    albumRatingNotationElement.classList.add("album-rating-notation");
    albumRatingNotationElement.innerText = "Album Rating: ";
    const albumRatingElement = document.createElement("p");
    albumRatingElement.innerText = album.rating + "/5";
    const albumVideoElement = document.createElement("a");
    albumVideoElement.href = album.videoURL;

    albumElement.appendChild(albumTitleElement);
    albumElement.appendChild(albumImageElement);
    albumElement.appendChild(albumArtistNotationElement);
    albumElement.appendChild(albumArtistElement);
    albumElement.appendChild(recordLabelNotationElement);
    albumElement.appendChild(recordLabelElement);
    albumElement.appendChild(albumDurationNotationElement);
    albumElement.appendChild(albumDurationElement);
    albumElement.appendChild(albumRatingNotationElement);
    albumElement.appendChild(albumRatingElement);
    albumElement.appendChild(albumVideoElement);

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
            fetch("http://localhost:8080/api/lists/"+album.listId+"/albums/"+album.id+"/comments", {
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

    return mainElement;
}
export { displayAlbum }