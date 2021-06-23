/*
@author: Abhishek Pandey
@params: null
@returns: void
*/
function submit$onClickListener() {
  let fname = document.getElementById("fname").value; //var is same as let for local variables except strict typing and scope
  let subject = document.getElementById("subject").value;
  let email = document.getElementById("email").value;
  let checkFname = (fname = "") => {
      //=> is a lambda function. Shorter way of writing function (*parameters*) {...}
      //based on the idea of functional interfaces in java but with own unique implementation of js
      if (!fname.trim()) {
        let newFname = prompt(
          "Your first name can not be blank. Please enter it here"
        );
        fname = fname.value = newFname;
        if (!newFname.trim()) {
          checkFname();
        }
      }
      return true;
    },
    checkSubject = (subject = "") => {
      //if parameter is not passed during invocation, subject var will take "" as default value
      if (!subject.trim()) {
        //!subject checks if subject var is empty. trim() removes spaces from a string
        let newSubject = prompt(
          "The subject can not be blank. Please enter it here"
        );
        subject = subject.value = newSubject;
        if (!newSubject.trim()) {
          checkSubject();
        }
      }
      return true;
    },
    checkEmail = (email = "") => {
      let newEmail;
      if (!email.trim()) {
        newEmail = prompt(
          "Your email can not be blank because we need it for further contact. Please enter it here"
        );
        email = email.value = newEmail;
        if (!newEmail.trim()) {
          checkEmail();
        }
      } else {
        newEmail = email;
      }
      if (
        !newEmail.includes("@") ||
        !newEmail.includes(".com") ||
        newEmail.includes("@.com")
      ) {
        alert("Invalid email");
        checkEmail();
      }
      return true;
    };
  if (checkFname(fname) && checkEmail(email) && checkSubject(subject)) {
    alert("Your response has been sent via email. Thank you :)");
  }
}

let blogIndex = 0;

/*
@author: Abhishek Pandey
@params: null
@returns: void
*/
function getBlogText() {
  let main = "tech-effects-";
  let divBlog = [];
  for (var i = 0; i < 6; i++) {
    divBlog.push(main + i); //stack data structure
  }
  for (let i = 0; i < divBlog.length; i++) {
    let reqDiv = document.getElementById(divBlog[i]);
    if (i == blogIndex) {
      reqDiv.style.display = "block";
    } else {
      reqDiv.style.display = "none";
    }
  }
}

/*
@author: Abhishek Pandey
@params: null
@returns: void
*/
function blogIncrement() {
  if (blogIndex == 5) blogIndex = -1;
  blogIndex++; //increment blogIndex by 1
  getBlogText();
}

/*
@author: Abhishek Pandey
@params: null
@returns: void
*/
function blogDecrement() {
  if (blogIndex == 0) blogIndex = 6;
  blogIndex--; //decrement blogIndex by 1
  getBlogText();
}
