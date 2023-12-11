function newProgress(){
    let newValue = document.getElementById("completed").value;
    let workingProgressBar = document.getElementById("progressBar");
    let progression = Math.min(Math.max(parseInt(newValue), 0), 100);
    let titleStatus = document.getElementById("status");
    let newStoredProgress = 0;
    let medal50Opacity = document.getElementById("halfDoneTrophy");
    let medal100Opacity = document.getElementById("allDoneTrophy");


    workingProgressBar.style.width = progression + "%";
    workingProgressBar.innerHTML = progression + "%";




//    if(progression >= 100){
//        workingProgressBar.innerHTML = "Trail Complete!"
//        titleStatus.innerHTML = "Status: Completed!"
////        allDoneTrophy.style.opacity = 1;
//
//    }
//    if(progression <=99){
//        titleStatus.innerHTML = "Status: Incomplete"
//
//    }
//    if (progression <=50){
//    50trophy.style.opacity = 0;}
//
//
//}

    if (progression >= 100){
        workingProgressBar.innerHTML ="Complete"
        titleStatus.innerHTML = "Status: Complete!"
        allDoneTrophy.style.opacity = 1;
        allDoneText.innerHTML = "Unlocked!"
        halfDoneTrophy.style.opacity = 1;
        halfDoneText.innerHTML = "Unlocked!"


    }

    if (progression == 50){
        workingProgressBar.innerHTML ="50% Complete"
        titleStatus.innerHTML = "Status: 50% Complete!"
        halfDoneTrophy.style.opacity = 1;
        halfDoneText.innerHTML = "Unlocked!"
        allDoneTrophy.style.opacity = 0;
        allDoneText.innerHTML = "Locked trophy - 100%"
    }

    if (progression < 100){

        halfDoneTrophy.style.opacity = 1;
        halfDoneText.innerHTML = "Unlocked!"
        allDoneTrophy.style.opacity = 0;
        allDoneText.innerHTML = "Locked trophy - 100%"
    }

    if (progression <50){
    halfDoneTrophy.style.opacity = 0;
    halfDoneText.innerHTML = "Locked trophy - 50%"
    allDoneTrophy.style.opacity = 0;
    allDoneText.innerHTML = "Locked trophy - 100"
    }
}



function storedProgress(value){
    newStoredProgress = newValue;
    newProgress(newValue);
}

function completedTrail(){
    function completeTrailTitle(){


    }
}