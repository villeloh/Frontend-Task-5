'use strict';

// HTML contains element 'message'. This is used to show the server's response
// Select it and save it as a variable/object

// make function 'upload' which
// - prevents the form from sending
// - writes 'Upload in progress...' into 'message' element
// - selects the file input field
// - makes FormData -object and adds the file selected byt the user into the object
// - send the file to the same url as in task a by using fetch -method
// - when file upload is complete, writes server response to 'message' element
// function ends

// make an event listener which calls upload function when the form is submitted

const form = document.querySelector('form');

form.addEventListener("submit", function(evt) {
        evt.preventDefault();
        upload();
});

function upload() {
    
    const msg = document.querySelector('#message');
    const imageDiv = document.querySelector('#image');
    msg.innerHTML = "Upload in progress...";
    
    const inputField = document.querySelector('input[type="file"]');
    const data = new FormData();
    
    data.append('fileup', inputField.files[0]);

    const settings = { 
        method: 'POST',
        credentials: 'same-origin',
        body: data
    };
    
    fetch('http://10.114.32.109:8080/testUpload4/ServletB', settings).then((response) => {
        return response.json();
    }).then((myJson) => {
        
        const img = document.createElement('img');
        img.src = myJson.src;
        imageDiv.appendChild(img);    
        msg.innerHTML = "File uploaded (and displayed)! You're the man now, dog!";
    });  
} // end upload()
