const createHeader = function(){
    const header = document.createElement("header");    
    const navigation = document.createElement("nav");
    navigation.classList.add("nav");
    const navButtons = document.createElement("ul");
    navButtons.setAttribute("nav-btns");
    const homeBtn = document.createElement("button");
    homeBtn.innerText = "Home";
    const aboutBtn = document.createElement("button");
    aboutBtn.innerText = "About Us";
    const backBtn = document.createElement("button");
    backBtn.innerText = "Back";

    const title = document.createElement("div");
    title.classList.add("title");
    //  <!-- <img src="/frontend-spa/images/Logo.png" alt=""> -->
    title.innerHTML = '<h1>Welcome to Desert Island Jukebox</h1>'
    
    return header;
}
export {createHeader}



// <header>
//  <nav class="nav">
//         <ul id="nav-btns">
//             <button>Home</button>
//             <button>About Us</button> 
//             <button>Back Page</button>
//         </ul>
//  </nav>

//  <div class="title">       
//  <!-- <img src="/frontend-spa/images/Logo.png" alt=""> -->
//  <h1>Welcome to Desert Island Jukebox</h1>
//  </div>
// </header>
